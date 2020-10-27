package geekbrains.hw6;

public class MyArrayDataException extends Exception {
    public MyArrayDataException(String msg) {
        super(msg);
    }

    public MyArrayDataException(int index, int index2, String string) {
        super(String.format("Невозможно извлечь цифру из элемента \"%s\" по индексу %d:%d", string, index, index2));
    }
}
