package geekbrains.hw7;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> fruits;

    public Box () {
        fruits = new ArrayList<>();
    }

    public void add(T fruit) {
        this.fruits.add(fruit);
    }

    public float getWeight() {
        float sum = 0;
        for (T fruit : fruits) {
            sum += fruit.getWeight();
        }
        return sum;
    }

    public boolean compare(Box<?> box){
        return this.getWeight() == box.getWeight();
    }

    public void clear() {
        this.fruits.clear();
    }

    public void move(Box<T> box) {
        box.getFruits().addAll(this.getFruits());
        this.clear();
    }

    public ArrayList<T> getFruits() {
        return fruits;
    }
}
