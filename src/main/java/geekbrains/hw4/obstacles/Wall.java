package geekbrains.hw4.obstacles;

public class Wall {
    private int height;

    public Wall() {
        this.height = 50;
    }

    public Wall(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
