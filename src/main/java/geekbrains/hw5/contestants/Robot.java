package geekbrains.hw5.contestants;

public class Robot extends Contestant implements Runner {
    private int runDistance;


    public Robot(String name, int runDistance) {
        this.name = name;
        this.runDistance = runDistance;
        this.fatigue = 1;
    }

    @Override
    public boolean run(int distance) {
        if (distance <= fatigue * runDistance) {
            fatigue -= (double)distance / runDistance;
            System.out.printf("%s успешно пробежал дистанцию в %d м.\n", name, distance);
            return true;
        }
        fatigue = 0;
        System.out.printf("%s не смог пробежать дистанцию в %d м.\n", name, distance);
        return false;
    }

    public int getRunDistance() {
        return runDistance;
    }

    public void setRunDistance(int runDistance) {
        this.runDistance = runDistance;
    }
}
