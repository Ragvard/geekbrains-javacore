package geekbrains.hw3;

public class Main {
    public static void main(String[] args) {
        Employee em = new Employee("Сотрудник №8", "email#7@gmail.com", "Руководитель", 30);
        em.printInfo();
        System.out.println("-----------------------------------------");
        Group gr = new Group("Тестовая группа");
        for (int i = 0; i < 7; i++) {
            gr.addEmployee(new Employee(
                    "Сотрудник №" + (i + 1),
                    "email#" + i + "@gmail.com",
                    "Сотрудник",
                    20 + i));
        }
        gr.addEmployee(em);
        gr.printAll();
        System.out.println("-----------------------------------------");
        gr.deleteEmployee(4);
        gr.printAll();
        System.out.println("-----------------------------------------");
        gr.clearAll();
        gr.printAll();
    }
}
