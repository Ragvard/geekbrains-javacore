package geekbrains.hw2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Main {

/*   Написать программу, которая выводит
     на экран равнобедренный треугольник из звездочек.
     Ширина основания - любое нечетное число. Начинать вывод с вершины.
     Основание - b, высота - h
     Рисует что-то похожее на треугольник при любом положительном вводе
     Но на большинстве вводов, очевидно, треугольник выходит ступенчатый*/
    public static void printtriangle(int b, int h){
        if (b <= 0 || h <= 0) {
            System.out.println("Высота и основание должны быть больше 0");
            return;
        }
        // Середина треугольника
        int mid = b / 2;
        // Сдвиг в сторону от середины
        double space;
        // Костыль для нормальной обработки треугольников с четным основанием
        int shift = (b + 1) % 2;
        // Выводим вершину из одной *, если основание нечетное
        if (shift == 0) System.out.println(mult(mid, ' ') + '*');
        // Рисуем "тело" треугольника, в случае с четным основанием - еще и вершину из двух *
        for (double i = 1; i < h + shift; i++){
            // Вычисляем, насколько надо сдвинуть *
            space = mid * (i / (h + 1));
            // Пачка вспомогательных переменных с ужасными названиями
            int a = (int)(mid - space);
            int c = mid - a;
            // Выводим тело треугольника
            System.out.println(mult(a, ' ') + '*' + mult((c - 1) * 2 + (1 - shift), ' ') + '*');
        }
        // Основание треугольника
        System.out.println(mult(b, '*'));
    }

    // Вспомогательный метод для первого задания - умножение строки
    public static String mult(int l, char c){
        // StringBuilder вместо колхозного String += ' ' просто чтобы idea не ругалась
        StringBuilder res = new StringBuilder();
        for (; l > 0; l--) { res.append(c); }
        return res.toString();
    }

    /* Написать реализацию алгоритма сортировки массива методом выбора (selection sort).*/
    // Ничего не возвращает, так как я не копирую массив а роюсь в существующем
    public static void selectionsort(int[] arr){
        int min; // Минимальное значение
        int minid; // Индекс минимального значения
        for (int i = 0; i < arr.length - 1; i++){
            min = arr[i];
            minid = i;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] < min) {
                    min = arr[j];
                    minid = j;
                }
            }
            int swap = arr[i];
            arr[i] = arr[minid];
            arr[minid] = swap;
        }
    }

    /*3 Написать метод, который в качестве параметра получает
    число секунд в виде целого числа и преобразует его в строку
    вида чч:мм:сс, где чч - кол-во часов, мм - количество минут,
    сс - количество секунд в исходном значении. Подсказка - использовать
    операцию деления (/) и остатка от деления (%).
    Примеры 62 - "00:01:02", 130 - "00:02:10", 3750 - "01:02:30"*/
    // Наверняка есть какое-то красивое решение, но зачем искать его,
    // если можно понатыкать тернарок?
    public static String convertTime(int s){
        if (s >= 86400) return "Число секунд должно быть меньше чем в 24 часах";
        String result = String.valueOf(s % 60 > 9 ? s % 60 : "0" + s % 60);
        s /= 60;
        result =  s % 60 > 9 ? s % 60 + ":" + result : "0" + s % 60 + ":" + result;
        s /= 60;
        return s > 9 ? s + ":" + result : "0" + s + ":" + result;
    }

    /*Написать метод, который переворачивает содержимое
    массива так, что на первом месте оказывается последний элемент и т.д.*/
    // Как и в другом задании, ничего не возвращаю, так как массив по ссылке
    // Хотел сделать чтобы принимался на ввод любой тип массива,
    // словил флешбеки с дженериков, свернулся в калачик и заплакал
    public static void flipArray(int[] arr){
        int swap;
        for (int i = 0; i < arr.length / 2; i++){
            swap = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = swap;
        }
    }

    /* Написать метод, которая получает на вход массив
    и перемешивает его элементы случайным образом.*/
    // Алгоритм Фишера — Йетса
    // ...который я тупо скатал со стаковерфлоу
    public static void shuffleArray(int[] arr){
        Random rand = new Random();
        for (int i = arr.length - 1; i > 1; i--)
        {
            int index = rand.nextInt(i + 1);
            int a = arr[index];
            arr[index] = arr[i];
            arr[i] = a;
        }
    }

    public static void main(String[] args) {
        // 1 Задание
        printtriangle(9, 4); // Нормальный ввод
        printtriangle(9, 9);
        printtriangle(10, 9);

        System.out.println(mult(30, '-'));

        // 2 Задание
        Random rand = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) arr[i] = rand.nextInt(21);
        System.out.println("До   : " + Arrays.toString(arr));
        selectionsort(arr);
        System.out.println("После: " + Arrays.toString(arr));

        System.out.println(mult(30, '-'));

        // 3 Задание
        System.out.println(convertTime(3750));
        System.out.println(convertTime(62));
        System.out.println(convertTime(86400));

        System.out.println(mult(30, '-'));

        // 4 Задание
        arr = new int[]{11, 12, 13, 14, 5, 26, 27, 28, 29};
        System.out.println("До   : " + Arrays.toString(arr));
        flipArray(arr);
        System.out.println("После: " + Arrays.toString(arr));

        System.out.println(mult(30, '-'));

        // 5 Задание
        arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("До   : " + Arrays.toString(arr));
        shuffleArray(arr);
        System.out.println("После: " + Arrays.toString(arr));
    }
}
