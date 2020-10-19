package geekbrains.hw4.obstacles;

public class Track implements Obstacle {
    private int length;

    public Track() {
        this.length = 800;
    }

    public Track(int length) {
        this.length = length;
    }

    @Override
    public int getSize() {
        return this.length;
    }

    @Override
    public String toString() {
        return "Дорожка " + this.length + "м.";
    }

    public void setSize(int length) {
        this.length = length;
    }
}
