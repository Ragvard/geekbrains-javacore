package geekbrains.hw6;

public class MyArraySizeException extends Exception {
    public MyArraySizeException(String msg) {
        super(msg);
    }

    public MyArraySizeException(int size) {
        super(String.format("Размер внешнего массива не равен 4; Полученный размер: %d", size));
    }

    public MyArraySizeException(int index, int size) {
        super(String.format("Размер внутреннего массива по индексу %d не равен 4; Полученный размер: %d", index, size));
    }
}
