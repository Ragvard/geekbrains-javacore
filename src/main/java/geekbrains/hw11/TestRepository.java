package geekbrains.hw11;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class TestRepository {

    public static void print(Repository<User> userRepository) throws SQLException {
        List<User> all = userRepository.findAll();
        if (all.isEmpty()) {
            System.out.println("Table is empty.");
            return;
        }
        for (User user : all) {
            System.out.println(user.getId() + " - " + user.getUsername() + ":" + user.getPassword());
        }
    }

    public static void print(User user){
        if (user == null) {
            System.out.println("No such user.");
            return;
        }
        System.out.println(user.getId() + " - " + user.getUsername() + ":" + user.getPassword());
    }

    public static void insert(Repository<User> userRepository, String name, String password) throws SQLException {
        userRepository.insert(new User(null, name, password));
    }

    public static void delete(Repository<User> userRepository, long ID) throws SQLException {
        userRepository.delete(ID);
    }

    public static void clear(Repository<User> userRepository) throws SQLException {
        userRepository.deleteAll();
    }

    public static void update(Repository<User> userRepository, String name, String password, long ID) throws SQLException {
        if (userRepository.findById(ID) == null) {
            System.out.println("No such user to update");
            return;
        }
        userRepository.update(new User(ID, name, password));
    }

    public static long getId(Repository<User> userRepository, int pos) throws SQLException {
        return userRepository.findAll().get(pos).getId();
    }

    public static void main(String[] args){
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/vtb_jdbc_lesson?createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true&useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC",
                "admin", "1234")) {
            Repository<User> userRepository = new Repository<>(User.class, connection);

            clear(userRepository);

            insert(userRepository,"Ivan", "1234");
            insert(userRepository,"Dmitry", "qwerty");
            insert(userRepository,"Grisha", "nfv7$fa~GA9KF4bvd");
            insert(userRepository,"Alexander", "NULL");
            insert(userRepository,"Alexey", "password");

            print(userRepository);

            System.out.println("----------------------------------------------------");

            print(userRepository.findById(getId(userRepository, 3)));

            System.out.println("----------------------------------------------------");

            delete(userRepository, getId(userRepository, 0));
            delete(userRepository, getId(userRepository, 0));

            update(userRepository, "Alexey", "new_password", getId(userRepository, 2));

            print(userRepository);
        } catch (SQLException ex) {
            System.out.println("Something went wrong!");
            ex.printStackTrace();
        }
    }

}