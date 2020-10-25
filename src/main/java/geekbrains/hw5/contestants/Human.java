package geekbrains.hw5.contestants;

public class Human extends Contestant implements Runner, Swimmer, Jumper {

    private int runDistance;
    private int jumpHeight;
    private int swimDistance;

    public Human(String name, int jumpHeight, int runDistance, int swimDistance) {
        this.name = name;
        this.runDistance = runDistance;
        this.jumpHeight = jumpHeight;
        this.swimDistance = swimDistance;
        this.fatigue = 1;
    }

    @Override
    public boolean jump(int height) {
        if (height <= jumpHeight) {
            System.out.printf("%s успешно перепрыгнул препятствие в %d см.\n", name, height);
            return true;
        }
        else {
            System.out.printf("%s не смог перепрыгнуть препятствие в %d см.\n", name, height);
            return false;
        }
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

    public int getRunDistance() {
        return runDistance;
    }

    public void setRunDistance(int runDistance) {
        this.runDistance = runDistance;
    }

    public int getJumpHeight() {
        return jumpHeight;
    }

    public void setJumpHeight(int jumpHeight) {
        this.jumpHeight = jumpHeight;
    }

    public int getSwimDistance() {
        return swimDistance;
    }

    public void setSwimDistance(int swimDistance) {
        this.swimDistance = swimDistance;
    }
}
