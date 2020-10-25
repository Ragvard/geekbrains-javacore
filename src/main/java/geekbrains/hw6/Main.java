package geekbrains.hw6;

public class Main {

    public static int sumOfArray(String[][] arr) throws MyArrayDataException, MyArraySizeException {
        if (arr.length != 4) throw new MyArraySizeException(arr.length);
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            if (arr[i].length != 4) throw new MyArraySizeException(i, arr[i].length);
            for (int j = 0; j < 4; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                }
                catch(NumberFormatException e){
                    throw new MyArrayDataException(i, j, arr[i][j]);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        String[][] arr = new String[4][];
        for (int i = 0; i < 4; i++) {
            arr[i] = new String[] {"1", "2", "3", "4"};
        }

        String[][] arr2 = new String[4][];
        for (int i = 0; i < 4; i++) {
            arr2[i] = new String[] {"1", "2", "3", "4"};
        }
        arr2[2] = new String[] {"1", "2", "3", "4", "5"};

        String[][] arr3 = new String[5][];
        for (int i = 0; i < 5; i++) {
            arr3[i] = new String[] {"1", "2", "3", "4"};
        }

        String[][] arr4 = new String[4][];
        for (int i = 0; i < 4; i++) {
            arr4[i] = new String[] {"1", "2", "3", "4"};
        }
        arr4[3][2] = "not-a-number";

        try {
            System.out.println(sumOfArray(arr));
        }
        catch (MyArraySizeException ex) {
            System.out.println("Поймано исключение MyArraySizeException: \n" + ex.getMessage());
        }
        catch (MyArrayDataException ex) {
            System.out.println("Поймано исключение MyArrayDataException: \n" + ex.getMessage());
        }
        catch (Exception ex) {
            System.out.println("Поймано исключение Exception: \n" + ex.getMessage());
        }

        System.out.println("----------------------------------------------");

        try {
            System.out.println(sumOfArray(arr2));
        }
        catch (MyArraySizeException ex) {
            System.out.println("Поймано исключение MyArraySizeException: \n" + ex.getMessage());
        }
        catch (MyArrayDataException ex) {
            System.out.println("Поймано исключение MyArrayDataException: \n" + ex.getMessage());
        }
        catch (Exception ex) {
            System.out.println("Поймано исключение Exception: \n" + ex.getMessage());
        }

        System.out.println("----------------------------------------------");

        try {
            System.out.println(sumOfArray(arr3));
        }
        catch (MyArraySizeException ex) {
            System.out.println("Поймано исключение MyArraySizeException: \n" + ex.getMessage());
        }
        catch (MyArrayDataException ex) {
            System.out.println("Поймано исключение MyArrayDataException: \n" + ex.getMessage());
        }
        catch (Exception ex) {
            System.out.println("Поймано исключение Exception: \n" + ex.getMessage());
        }

        System.out.println("----------------------------------------------");

        try {
            System.out.println(sumOfArray(arr4));
        }
        catch (MyArraySizeException ex) {
            System.out.println("Поймано исключение MyArraySizeException: \n" + ex.getMessage());
        }
        catch (MyArrayDataException ex) {
            System.out.println("Поймано исключение MyArrayDataException: \n" + ex.getMessage());
        }
        catch (Exception ex) {
            System.out.println("Поймано исключение Exception: \n" + ex.getMessage());
        }


    }
}
