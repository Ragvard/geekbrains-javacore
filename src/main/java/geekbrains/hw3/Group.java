package geekbrains.hw3;

import java.util.Arrays;
/*
Создайте класс Группа, включающий в себя название группы и массив из максимум 10 сотрудников
*/

public class Group {

    // Fields

    String name;
    Employee[] employees;

    // Constructors

    public Group() {
        employees = new Employee[10];
    }

    public Group(String name){
        this();
        this.name = name;
    }

    // Methods

    /*Реализуйте возможность добавлять сотрудников в этот массив, удалять их из него по индексу, и удалять всех разом;*/
    // Методы возвращают успешность выполнения операции

    public boolean addEmployee(Employee emp) {
        for (int i = 0; i < 10; i++) {
            if (employees[i] == null) {
                employees[i] = emp;
                return true;
            }
        }
        return false;
    }

    public boolean deleteEmployee(int ind) {
        if (ind >= 10 || ind < 0) return false;
        if (employees[ind] != null) {
            employees[ind] = null;
            return true;
        }
        return false;
    }

    public Employee getEmployee(int ind) {
        if (ind >= 10 || ind < 0) return null;
        return employees[ind];
    }

    public void clearAll() {
        employees = new Employee[10];
    }

    /*В классе Группа должен быть метод, позволяющий отпечатать информацию обо всех сотрудниках, входящих в эту группу;*/

    public void printAll() {
        System.out.println(this.toString());
    }

    // Idea ругается на конкатенацию строк в цикле, и предлагает использовать StringBuilder. Почему?
    @Override
    public String toString() {
        StringBuilder list = new StringBuilder();
        for (int i = 0; i < 10; i++){
            if (employees[i] != null) {
                list.append("\n").append(employees[i].toString());
            }
        }
        return "Группа \"" + name + "\". Сотрудники:" + list;
    }

    // Getters&Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee[] getEmployees() {
        return employees;
    }
}
