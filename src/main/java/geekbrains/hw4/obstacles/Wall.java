package geekbrains.hw4.obstacles;

public class Wall implements Obstacle{
    private int height;

    public Wall() {
        this.height = 50;
    }

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public int getSize() {
        return this.height;
    }

    @Override
    public String toString() {
        return "Барьер " + height + "см.";
    }

    public void setSize(int height) {
        this.height = height;
    }
}
