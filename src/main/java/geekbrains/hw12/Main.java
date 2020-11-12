package geekbrains.hw12;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

public class Main {

    public static String read(String path) {
        File file = new File(path);
        StringBuilder result = new StringBuilder();
        if (!file.isFile()) throw new IllegalArgumentException("No such file");
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String str;
            while ((str = in.readLine()) != null) {
                result.append(str);
            }
            in.close();
        } catch (FileNotFoundException ex) {
            throw new IllegalArgumentException("No such file");
        } catch (IOException e) {
            throw new IllegalArgumentException("Unable to read file");
        }
        return result.toString();
    }

    public static String getLongWords(String str) {
        return Stream.of(str.split("[, \n!?.:;-] *+"))
                .filter(word -> word.length() > 5)
                .collect(Collectors.joining(" "))
                .toLowerCase();
    }

    public static List<String> getUniqueWords(String[][] arr) {
        return Arrays.stream(arr)
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
    }

    public static int sumEven(int a, int b) {
        return Stream.iterate(a, number -> number <= b, prev -> prev + 2)
                .reduce(0, Integer::sum);
    }

    public static int sumOfLenghts(String[] arr) {
        return Arrays.stream(arr)
                .map(String::length)
                .reduce(0, Integer::sum);
    }

    public static String getFirstWords(String[] arr, int lim) {
        return Arrays.stream(arr)
                .sorted()
                .limit(lim)
                .collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {

        // Взять строку, состоящую из 100 слов разделенных пробелом
        // (Я беру просто текстовый файл, и убираю разделители - пробелы, знаки препинания и пр.)
        // получить список слов длиннее 5 символов, и склеить их в одну строку с пробелом в качестве разделителя;

        String str = read("src/main/java/geekbrains/hw12/words.txt");

        System.out.println(getLongWords(str));

        System.out.println("--------------------------------------------------------------");

        // Найти список уникальных слов в двумерном массиве размером 5х5;
        String[][] arr = {
                {"a", "b", "c", "d", "e"},
                {"f", "g", "h", "i", "j"},
                {"k", "l", "m", "n", "o"},
                {"a", "b", "c", "d", "e"},
                {"f", "g", "h", "i", "j"}};

        System.out.println(getUniqueWords(arr));

        System.out.println("--------------------------------------------------------------");

        // Посчитать сумму четных чисел в пределах от 100 до 200 (включительно);

        System.out.println(sumEven(100, 200));

        System.out.println("--------------------------------------------------------------");

        // Посчитать суммарную длину строк в одномерном массиве;

        String[] arr2 = str.toLowerCase().split("[, \n!?.:;-] *+");

        System.out.println(sumOfLenghts(arr2));

        System.out.println("--------------------------------------------------------------");

        // Из массива слов получить первые три слова в алфавитном порядке;

        System.out.println(getFirstWords(arr2, 3));

    }
}
