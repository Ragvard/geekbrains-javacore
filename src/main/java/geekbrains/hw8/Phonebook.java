package geekbrains.hw8;

import geekbrains.hw6.MyArrayDataException;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Phonebook {

    // TreeMap чтобы было отсортировано по ключу
    private TreeMap<String, ArrayList<String>> phonebook;

    public Phonebook() {
        this.phonebook = new TreeMap<>();
    }

    public void add(String name, String phone) {
        try {
            Long.parseLong(phone);
        }
        catch(NumberFormatException e){
            throw new IllegalArgumentException("Телефонный номер должен состоять из цифр");
        }

        if (this.phonebook.containsKey(name)) {
            this.phonebook.get(name).add(phone);
        }
        else {
            ArrayList<String> list = new ArrayList<>();
            list.add(phone);
            this.phonebook.put(name, list);
        }
    }

    public ArrayList<String> get(String name) {
        return this.phonebook.get(name);
    }

    public void print(String name) {
        System.out.println(name + ":");
        for (String phone : this.get(name)) {
            System.out.println("\t" + phone);
        }
    }

    public void printall() {
        for (Map.Entry<String, ArrayList<String>> entry : this.phonebook.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (String phone : entry.getValue()) {
                System.out.println("\t" + phone);
            }
        }

    }

    public boolean delete(String name, String phone) {
        if (this.phonebook.containsKey(name)) {
            return this.phonebook.get(name).remove(phone);
        }
        return false;
    }

    // Геттеров и сеттеров для мапы не предусмотрено, взаимодействие с полем через add и remove
}
