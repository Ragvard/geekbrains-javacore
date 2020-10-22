package geekbrains.hw5.contestants;

public class Fish extends Contestant implements Swimmer {

    private int swimDistance;

    public Fish(String name, int swimDistance) {
        this.name = name;
        this.swimDistance = swimDistance;
        this.fatigue = 1;
    }

    @Override
    public boolean swim(int distance) {
        if (distance <= fatigue * swimDistance) {
            fatigue -= (double)distance / swimDistance;
            System.out.printf("%s успешно проплыл дистанцию в %d м.\n", name, distance);
            return true;
        }
        fatigue = 0;
        System.out.printf("%s не смог проплыть дистанцию в %d м.\n", name, distance);
        return false;
    }

    public Fish(int swimDistance) {
        this.swimDistance = swimDistance;
    }
}
