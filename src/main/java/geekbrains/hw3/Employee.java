package geekbrains.hw3;

/* Создайте класс Сотрудник, с полями:
имя, email, возраст, должность. */

public class Employee {

    // Fields

    String name;
    String email;
    String position;
    int age;

    // Constructors

    public Employee() {
        name = "";
        email = "";
        position = "";
        age = -1;
    }

    public Employee(String name, String email, String position, int age) {
        this.name = name;
        this.email = email;
        this.position = position;
        this.age = age;
    }

    // Methods

    /* Сотрудник должен уметь отпечатать в консоль информацию о себе;*/

    public void printInfo() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return name + ":" + email + ", " + age + ". " + position + ".";
    }

    // Getters&Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
