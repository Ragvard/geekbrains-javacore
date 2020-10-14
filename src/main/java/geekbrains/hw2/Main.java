package geekbrains.hw2;

public class Main {

    /* Написать программу, которая выводит
    на экран равнобедренный треугольник из звездочек.
    Ширина основания - любое нечетное число. Начинать вывод с вершины. */
    // Основание - b, высота - h
    // Рисует что-то похожее на треугольник при любом положительном вводе
    // Но на большинстве вводов, очевидно, треугольник выходит ступенчатый
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


    public static void main(String[] args) {
        // 1 Задание
        printtriangle(9, 4); // Нормальный ввод
        printtriangle(9, 9);
        printtriangle(10, 9);
    }
}
