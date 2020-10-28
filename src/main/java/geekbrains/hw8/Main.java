package geekbrains.hw8;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся)
        String[] arr = new String[] {
                "ogres", "are", "like", "onions",
                "they stink",
                "yes", "no",
                "oh", "they", "make", "you", "cry",
                "no",
                "oh", "you", "leave", "em", "out", "in", "the", "sun", "they", "get", "all", "brown", "start", "sproutin", "little", "white", "hairs",
                "no", "layers", "onions", "have", "layers", "ogres", "have", "layers", "onions", "have", "layers", "you", "get", "it", "we", "both", "have", "layers",
                "oh", "you" ,"both", "have", "layers", "oh", "you", "know", "not", "everybody", "like", "onions"
        };
        HashMap<String, Integer> map = new HashMap<>();

        // Посчитать, сколько раз встречается каждое слово.
        for (String word : arr) {
            map.put(word, map.containsKey(word) ? map.get(word) + 1 : 1);
        }

        // Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        //----------------------------------------------------


        Phonebook phonebook = new Phonebook();
        phonebook.add("Иванов", "11111111111");
        phonebook.add("Иванов", "12345678900");
        phonebook.add("Смирнов", "19345191325");
        phonebook.add("Павлов", "45756709824");
        phonebook.add("Павлов", "10348681545");
        phonebook.add("Кузнецов", "13675856789");
        phonebook.add("Попов", "35685367654");
        phonebook.add("Васильев", "86538256268");

        phonebook.print("Иванов");
        phonebook.print("Попов");
        System.out.println("-------------------------------------------------------------------------");
        phonebook.printall();
    }
}
