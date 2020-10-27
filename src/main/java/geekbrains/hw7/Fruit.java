package geekbrains.hw7;

public abstract class Fruit {
    protected float weight;

    public Fruit() {
        this.weight = 1;
    }

    public Fruit(float weight) {
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
