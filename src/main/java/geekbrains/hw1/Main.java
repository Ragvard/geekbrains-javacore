package geekbrains.hw1;

import java.util.Arrays;
import java.util.Random;

public class Main {

    /* Написать метод, принимающий на вход два целых числа и проверяющий,
    что их сумма лежит в пределах от 10 до 20 (включительно),
    если да – вернуть true, в противном случае – false. */
    // Посчитал, что включительно относится к обеим гранциам
    public static boolean checksum(int first, int second) {
        int sum = first + second;
        return sum >= 10 & sum <= 20;
    }

    /* Написать метод, которому в качестве параметра передается целое число,
    метод должен напечатать в консоль, положительное ли число передали или
    отрицательное. Замечание: ноль считаем положительным числом. */
    public static void checksign(int number){
        System.out.println(number < 0 ? "Отрицательное" : "Положительное");
    }

    /* Написать метод, которому в качестве параметра передается целое число.
    Метод должен вернуть true, если число отрицательное. */
    public static boolean checknegative(int number){
        return number < 0;
    }

    /* Написать метод, которому в качестве параметра передается строка,
    обозначающая имя. Метод должен вывести в консоль сообщение
    «Привет, указанное_имя!».*/
    public static void hello(String name){
        System.out.println("Привет, " + name + "!");
    }

    /* Задать целочисленный массив, состоящий из элементов 0 и 1.
    Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    С помощью цикла и условия заменить 0 на 1, 1 на 0; */
    // Массив подается на вход, пример в методе Main
    public static int[] invertbinarray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] == 1 ? 0 : 1;
        }
        return arr;
    }

    /* Задать пустой целочисленный массив размером 8.
    С помощью цикла заполнить его значениями 2 5 8 11 14 17 20 23; */
    // Массив подается на вход, пример в методе Main
    public static int[] fillarray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (i + 1) * 3 - 1;
        }
        return arr;
    }

    /* Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
    пройти по нему циклом, и числа меньшие 6 умножить на 2;*/
    // Массив подается на вход, пример в методе Main
    public static int[] multarray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] < 6 ? arr[i] * 2 : arr[i];
        }
        return arr;
    }

    /* Создать квадратный двумерный целочисленный массив
    (количество строк и столбцов одинаковое), и с помощью
    цикла(-ов) заполнить его диагональные элементы единицами; */
    // На вход подается размер матрицы, заполняются обе диагонали
    public static int[][] creatematrix(int size){
        int[][] arr = new int[size][size];
        for (int i = 0; i < size; i++) {
            arr[i][i] = 1;
            arr[i][size - i - 1] = 1;
        }
        return arr;
    }

    /* Задать одномерный массив и найти в нем минимальный
    и максимальный элементы; */
    // Массив подается на вход, пример в методе Main
    public static int[] findminmax(int[] arr){
        int[] result = new int[] {Integer.MIN_VALUE, Integer.MAX_VALUE};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < result[1]) result[1] = arr[i];
            if (arr[i] > result[0]) result[0] = arr[i];
        }
        return result;
    }

    /* Написать метод, который определяет, является ли год високосным,
    и выводит сообщение в консоль. Каждый 4-й год является високосным,
    кроме каждого 100-го, при этом каждый 400-й – високосный. */
    public static void checkleap(int year){
        if (year % 4 == 0 & year % 100 != 0) System.out.println("Это високосный год");
        else System.out.println("Это не високосный год");
    }

    /*  Написать метод, в который передается не пустой одномерный целочисленный
    массив, метод должен вернуть true, если в массиве есть место, в котором сумма
    левой и правой части массива равны. Примеры:
    checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
    checkBalance([1, 1, 1, || 2, 1]) → true,
    граница показана символами ||, эти символы в массив не входят. */
    public static boolean checkperfectmedian(int[] arr){
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }
        // Если сумма всех значений нечетная, то поделить массив ровно пополам нельзя
        if (total % 2 == 1) return false;
        total /= 2;
        int current = 0;
        for (int i = 0; i < arr.length; i++) {
            current += arr[i];
            // Если дошли до ровной половины - возвращаем true, если перешли за медиану - возвращаем false
            if (current == total) return true;
            else if (current > total) break;
        }
        return false;
    }

    public static void main(String[] args) {
        // Далее следуют примеры работы реализованных методов, с генерацией
        // параметров, если того требует задание

        // 1 Задание
        System.out.println("Задание 1:");
        System.out.println("Входные данные: 6 и 2. Результат: " + checksum(6, 2));
        System.out.println("Входные данные: 8 и 6. Результат: " + checksum(8, 6));
        System.out.println("Входные данные: 15 и 10. Результат: " + checksum(15, 10));

        // 2 Задание
        System.out.println("\nЗадание 2:");
        System.out.print("Входные данные: 6. Результат: ");
        checksign(6);
        System.out.print("Входные данные: -25. Результат: ");
        checksign(-25);

        // 3 Задание
        System.out.println("\nЗадание 3:");
        System.out.println("Входные данные: 6. Результат: " + checknegative(6));
        System.out.println("Входные данные: -5. Результат: " + checknegative(-5));

        // 4 Задание
        System.out.println("\nЗадание 4:");
        System.out.print("Входные данные: Имя_Фамилия. \nРезультат: ");
        hello("Имя_Фамилия");

        // 5 Задание
        int[] arr = new int[8];
        Random rand = new Random(2);
        // Заполнение 0 и 1
        for (int i = 0; i < 8; i++) {arr[i] = rand.nextInt(2);}
        System.out.println("\n\nЗадание 5:");
        System.out.print("Входные данные: " + Arrays.toString(arr) + ". \nРезультат: " + Arrays.toString(invertbinarray(arr)));

        // 6 Задание
        arr = new int[8];
        System.out.println("\n\nЗадание 6:");
        System.out.print("Входные данные: " + Arrays.toString(arr) + ". \nРезультат: " + Arrays.toString(fillarray(arr)));

        // 7 Задание
        arr =  new int[] {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        System.out.println("\n\nЗадание 7:");
        System.out.print("Входные данные: " + Arrays.toString(arr) + ". \nРезультат: " + Arrays.toString(multarray(arr)));

        // 8 Задание
        System.out.println("\n\nЗадание 8:");
        System.out.println("Входные данные: 5. Результат: ");
        int[][] arr2 = creatematrix(5);
        for (int i = 0; i < 5; i++) {
            System.out.println(Arrays.toString(arr2[i]));
        }

        // 9 Задание
        System.out.println("\nЗадание 9:");
        for (int i = 0; i < 8; i++) {arr[i] = rand.nextInt(50);}
        int[] res = multarray(arr);
        System.out.println("Входные данные: " + Arrays.toString(arr) + ". \nРезультат: Минимальное: "
                + res[1] + "; Максимальное: " + res[0]);

        // 10 Задание
        System.out.println("\nЗадание 10:");
        System.out.print("Входные данные: 1996. Результат: ");
        checkleap(1996);
        System.out.print("Входные данные: 2000. Результат: ");
        checkleap(2000);
        System.out.print("Входные данные: 2001. Результат: ");
        checkleap(2001);

        // 11 Задание
        arr =  new int[] {1, 2, 3, 3, 2, 1};
        System.out.println("\nЗадание 11:");
        System.out.println("Входные данные: " + Arrays.toString(arr) + ". Результат: " + checkperfectmedian(arr));
        arr =  new int[] {1, 2, 3, 4, 3, 2, 1};
        System.out.println("Входные данные: " + Arrays.toString(arr) + ". Результат: " + checkperfectmedian(arr));
    }
}
