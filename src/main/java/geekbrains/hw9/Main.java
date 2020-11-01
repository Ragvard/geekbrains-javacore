package geekbrains.hw9;

import java.io.*;

public class Main {
    public static void writeFile(String path) {
        File file = new File(path);
        if (!file.isFile()) throw new IllegalArgumentException("No such file");
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String str;
            while ((str = in.readLine()) != null) {
                System.out.println(str);
            }
            in.close();
        }
        catch (FileNotFoundException ex) { // Я же проверяю на существование файла выше?
            throw new IllegalArgumentException("No such file");
        }
        catch (IOException e) {
            throw new IllegalArgumentException("Unable to read file");
        }
    }

    public static int checkSubstring(String str, String target, int i) {
        for (int j = 0; j < target.length(); j++) {
            if (str.charAt(i + j) != target.charAt(j)) return 0;
        }
        return 1;
    }

    public static int countSubstring(String path, String target) {
        File file = new File(path);
        int sum = 0;
        if (!file.isFile()) throw new IllegalArgumentException("No such file");
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String str;
            int l = target.length();
            int current = 0;
            while ((str = in.readLine()) != null) {
                for (int i = 0; i < str.length() - l + 1; i++) {
                    sum += checkSubstring(str, target, i);
                }
            }
            in.close();
        }
        catch (FileNotFoundException ex) { // Я же проверяю на существование файла выше?
            throw new IllegalArgumentException("No such file");
        }
        catch (IOException e) {
            throw new IllegalArgumentException("Unable to read file");
        }
        return sum;
    }

    public static String merge(String path) {
        File dir = new File(path);
        if (!dir.isDirectory()) throw new IllegalArgumentException("No such directory");
        File[] files = dir.listFiles();
        File result = new File(path + "\\result.txt");
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(result));
            for (File file : files) {
                if (!file.isFile()) continue;
                BufferedReader in = new BufferedReader(new FileReader(file));
                String str;
                while ((str = in.readLine()) != null) {
                    out.write(str);
                    out.newLine();
                }
                in.close();
            }
            out.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return (path + "\\result.txt");
    }

    // Вспомогательный метод для создания тестовой директории, чтобы каждый раз не делать это вручную
    static public void create(String path) {
        File dir = new File(path);
        File file = new File(path + "\\file.txt");
        File dir2 = new File(path + "\\innerPackage");
        File file2 = new File(path + "\\innerPackage\\file.txt");

        try {
            dir.mkdir();
            file.createNewFile();
            dir2.mkdir();
            file2.createNewFile();
        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }

    static public void deleteDir(String path) {
        File dir = new File(path);

        if (!dir.exists() || !dir.isDirectory()) throw new IllegalArgumentException("No such directory");
        File[] files = dir.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                files[i].delete();
            }
            if (files[i].isDirectory()) {
                deleteDir(files[i].getAbsolutePath());
            }
        }
        dir.delete();
    }

    public static void main(String[] args) {
        String path;

        path = "src\\main\\java\\geekbrains\\hw9\\test1.txt";
        writeFile(path);
        System.out.println("is");
        System.out.println(countSubstring(path, "is"));

        path = "src\\main\\java\\geekbrains\\hw9\\test2.txt";
        writeFile(path);
        System.out.println("aAa");
        System.out.println(countSubstring(path, "aAa"));

        path = "src\\main\\java\\geekbrains\\hw9\\test3.txt";
        // writeFile(path);
        System.out.println("star");
        System.out.println(countSubstring(path, "star"));

        System.out.println("----------------------------------------------------------------");

        path = merge("src\\main\\java\\geekbrains\\hw9\\test");
        writeFile(path);

        System.out.println("----------------------------------------------------------------");

        path = "src\\main\\java\\geekbrains\\hw9\\forDelete";
        //create(path);
        deleteDir(path);
    }
}
