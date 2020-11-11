package geekbrains.hw11;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.*;

public class Repository<T> {

    private static final Map<Class<?>, String> typesMap = Map.of(
            Integer.class, "INT",
            Long.class, "BIGINT",
            String.class, "NVARCHAR(1024)"
    );

    private final Class<T> repositoryClass;

    private final Connection connection;

    private final String tableName;

    private final List<ColumnInfo> columns;

    private final PreparedStatement findAllStatement;

    private final PreparedStatement selectByIdStatement;

    private final PreparedStatement insertStatement;

    private final PreparedStatement deleteStatement;

    private final PreparedStatement deleteAllStatement;

    private final PreparedStatement updateStatement;

    public Repository(Class<T> repositoryClass, Connection connection) throws SQLException {
        this.repositoryClass = repositoryClass;
        this.connection = connection;

        DbTable dbTable = repositoryClass.getAnnotation(DbTable.class);
        if (dbTable == null) {
            throw new IllegalStateException("No dbTable annotation");
        }
        this.tableName = dbTable.tableName();

        DbId dbId = null;
        this.columns = new ArrayList<>();
        for (Field field : repositoryClass.getDeclaredFields()) {
            field.setAccessible(true);
            int type = field.getAnnotation(DbId.class) != null ? 0 : field.getAnnotation(DbColumn.class) != null ? 1 : 2;
            switch (type) {
                case 0: {
                    if (dbId != null) throw new IllegalStateException("More then one field with @DbId in class " + repositoryClass.getSimpleName());
                    dbId = field.getAnnotation(DbId.class);
                    ColumnInfo columnInfo = new ColumnInfo(field.getName(), field.getName(), field.getType(), true);
                    columns.add(columnInfo);
                    break;
                }

                case 1: {
                    DbColumn dbColumn = field.getAnnotation(DbColumn.class);
                    ColumnInfo columnInfo = new ColumnInfo(field.getName(), dbColumn.columnName(), field.getType(), false);
                    columns.add(columnInfo);
                    break;
                }

                case 2:
                    throw new IllegalStateException("More then one field with @DbId in class " + repositoryClass.getSimpleName());
            }
        }
        createTableIfNotExists();

        this.findAllStatement = buildFindAllStatement();
        this.selectByIdStatement = buildSelectByIdStatement();
        this.insertStatement = buildInsertStatement();
        this.deleteStatement = buildDeleteStatement();
        this.deleteAllStatement = buildDeleteAllStatement();
        this.updateStatement = buildUpdateStatement();
    }

    public List<T> findAll() throws SQLException {
        List<T> result = new ArrayList<>();
        ResultSet resultSet = findAllStatement.executeQuery();
        while (resultSet.next()) {
            result.add(createEntityByResultSet(resultSet));
        }
        return result;
    }

    public T findById(Long id) throws SQLException {
        selectByIdStatement.setLong(1, id);
        ResultSet rs = selectByIdStatement.executeQuery();
        T result = null;
        while (rs.next()) {
            if (result != null) {
                throw new IllegalStateException("More then one record for primary key value " + id);
            }
            result = createEntityByResultSet(rs);
        }
        return result;
    }

    public void insert(T entity) throws SQLException {
        for (int i=1; i<columns.size(); i++) {
            insertStatement.setObject(i, invokeGetter(columns.get(i).fieldName, entity));
        }
        insertStatement.execute();
    }

    public void update(T entity) throws SQLException {
        for (int i = 1; i < columns.size(); i++) {
            updateStatement.setObject(i, invokeGetter(columns.get(i).fieldName, entity));
        }
        updateStatement.setObject(3, invokeGetter(columns.get(0).fieldName, entity));
        updateStatement.execute();

    }

    public void delete(Long id) throws SQLException {
        deleteStatement.setLong(1, id);
        deleteStatement.execute();
    }

    public void deleteAll() throws SQLException {
        deleteAllStatement.execute();
    }

    private T createEntityByResultSet(ResultSet rs) throws SQLException {
        T entity = newInstance();
        for (ColumnInfo columnInfo : columns) {
            invokeSetter(columnInfo.fieldName,
                    rs.getObject(columnInfo.columnName, columnInfo.type),
                    columnInfo.type,
                    entity);
        }
        return entity;
    }

    private T newInstance() {
        try {
            return repositoryClass.getDeclaredConstructor().newInstance();
        } catch (Exception ex) {
            throw new IllegalStateException(ex);
        }
    }

    private <R> void invokeSetter(String fieldName, R value, Class<?> type, T entity) {
        try {
            Method setter = repositoryClass.getMethod(buildSetterName(fieldName), type);
            setter.invoke(entity, value);
        } catch (Exception ex) {
            throw new IllegalStateException(ex);
        }
    }

    private <R> R invokeGetter(String fieldName, T entity) {
        try {
            Method setter = repositoryClass.getMethod(buildGetterName(fieldName));
            return (R) setter.invoke(entity);
        } catch (Exception ex) {
            throw new IllegalStateException(ex);
        }
    }

    private String buildSetterName(String fieldName) {
        return "set" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
    }

    private String buildGetterName(String fieldName) {
        return "get" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
    }

    private void createTableIfNotExists() throws SQLException {
        StringBuilder query = new StringBuilder();
        query.append("create table if not exists ");
        query.append(tableName);
        query.append("( ");
        for (ColumnInfo columnInfo : columns) {
            query.append(columnInfo.columnName);
            query.append(" ");
            query.append(typesMap.get(columnInfo.type));
            if (columnInfo.isId) {
                query.append(" auto_increment primary key");
            }
            query.append(",");
        }
        query.deleteCharAt(query.length() - 1);
        query.append(");");
        try (Statement stmt = connection.createStatement()) {
            System.out.println(query.toString());
            stmt.execute(query.toString());
        }
    }

    private PreparedStatement buildFindAllStatement() throws SQLException {
        StringBuilder query = new StringBuilder();
        query.append("select" + " ");
        query.append("*" + " ");
        query.append("from" + " ");
        query.append(tableName);
        query.append(";");
        System.out.println("Find All statement: " + query);
        return connection.prepareStatement(query.toString());
    }

    private PreparedStatement buildSelectByIdStatement() throws SQLException {
        StringBuilder query = new StringBuilder();
        query.append("select ");
        for (ColumnInfo columnInfo : columns) {
            query.append(columnInfo.columnName);
            query.append(",");
        }
        query.deleteCharAt(query.length() - 1);
        query.append(" from ");
        query.append(tableName);
        query.append(" where ");
        query.append(" id = ?");
        query.append(";");
        System.out.println("Select by id statement: " + query);
        return connection.prepareStatement(query.toString());
    }

    private PreparedStatement buildInsertStatement() throws SQLException {
        StringBuilder query = new StringBuilder();
        query.append("insert into ");
        query.append(tableName);
        query.append("(");
        for (ColumnInfo columnInfo : columns) {
            if (!columnInfo.isId) {
                query.append(columnInfo.columnName);
                query.append(",");
            }
        }
        query.deleteCharAt(query.length() - 1);
        query.append(") ");
        query.append("values (");
        query.append("?,".repeat(columns.size() - 1));
        query.deleteCharAt(query.length() - 1);
        query.append(");");
        System.out.println("Insert statement: " + query);
        return connection.prepareStatement(query.toString());
    }

    private PreparedStatement buildDeleteStatement() throws SQLException {
        StringBuilder query = new StringBuilder();
        query.append("delete" + " ");
        query.append("from" + " ");
        query.append(tableName).append(" ");
        query.append("where" + " ");
        query.append("id =" + " ");
        query.append("?");
        query.append(";");
        System.out.println("Delete statement: " + query);
        return connection.prepareStatement(query.toString());
    }

    private PreparedStatement buildDeleteAllStatement() throws SQLException {
        StringBuilder query = new StringBuilder();
        query.append("delete" + " ");
        query.append("from" + " ");
        query.append(tableName);
        query.append(";");
        System.out.println("Delete All statement: " + query);
        return connection.prepareStatement(query.toString());
    }

    private PreparedStatement buildUpdateStatement() throws SQLException {
        StringBuilder query = new StringBuilder();
        query.append("update" + " ");
        query.append(tableName).append(" ");
        query.append("set" + " ");
        for (ColumnInfo columnInfo : columns) {
            if (!columnInfo.isId) {
                query.append(columnInfo.columnName).append(" ");
                query.append("=" + " ");
                query.append("?");
                query.append("," + " ");
            }
        }
        query.deleteCharAt(query.length() - 1);
        query.deleteCharAt(query.length() - 1);
        query.append(" ");
        query.append("where" + " ");
        query.append("id =" + " ");
        query.append("?");
        query.append(";");

        System.out.println("Update statement: " + query);
        return connection.prepareStatement(query.toString());
    }

    private static class ColumnInfo {

        private final String fieldName;

        private final String columnName;

        private final Class<?> type;

        private final boolean isId;

        public ColumnInfo(String fieldName, String columnName, Class<?> type, boolean isId) {
            this.fieldName = fieldName;
            this.columnName = columnName;
            this.type = type;
            this.isId = isId;
        }
    }


}
