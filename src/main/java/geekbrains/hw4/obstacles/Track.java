package geekbrains.hw4.obstacles;

public class Track implements Obstacle {
    private int length;

    public Track() {
        this.length = 800;
    }

    public Track(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
