package geekbrains.hw7;


public class Main {

    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        Box<Orange> secondOrangeBox = new Box<>();

        for(int i = 0; i < 10; i++) {
            appleBox.add(new Apple());
            appleBox.add(new Apple());
            appleBox.add(new Apple());
            orangeBox.add(new Orange());
            secondOrangeBox.add(new Orange());
        }

        write(appleBox, orangeBox, secondOrangeBox);

        orangeBox.move(secondOrangeBox);
        System.out.println("Переложил апельсины из первой коробки во вторую");

        write(appleBox, orangeBox, secondOrangeBox);
    }

    private static void write(Box<Apple> appleBox, Box<Orange> orangeBox, Box<Orange> secondOrangeBox) {
        System.out.printf("Веса коробок:\nС яблоками: %.2f\nС апельсинами: %.2f\nВторая с апельсинами: %.2f\n",
                appleBox.getWeight(), orangeBox.getWeight(), secondOrangeBox.getWeight());

        System.out.println("-----------------------------------------------------------");

        if (appleBox.compare(orangeBox)) {
            System.out.println("Коробка с яблоками весит как первая коробка с апельсинами");
        }
        else {
            System.out.println("Коробка с яблоками НЕ весит как первая коробка с апельсинами");
        }

        if (appleBox.compare(secondOrangeBox)) {
            System.out.println("Коробка с яблоками весит как вторая коробка с апельсинами");
        }
        else {
            System.out.println("Коробка с яблоками НЕ весит как вторая коробка с апельсинами");
        }

        if (orangeBox.compare(secondOrangeBox)) {
            System.out.println("Первая коробка с апельсинами весит как вторая коробка с апельсинами");
        }
        else {
            System.out.println("Первая коробка с апельсинами НЕ весит как вторая коробка с апельсинами");
        }

        System.out.println("-----------------------------------------------------------");
    }
}
