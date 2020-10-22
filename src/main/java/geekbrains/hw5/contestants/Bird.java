package geekbrains.hw5.contestants;

public class Bird extends Contestant implements Flyer {
    private int flyDistance;

    public Bird(String name, int flyDistance) {
        this.name = name;
        this.flyDistance = flyDistance;
        this.fatigue = 1;
    }

    @Override
    public boolean fly(int distance) {
        if (distance <= fatigue * flyDistance) {
            fatigue -= (double)distance / flyDistance;
            System.out.printf("%s успешно пролетел дистанцию в %d м.\n", name, distance);
            return true;
        }
        fatigue = 0;
        System.out.printf("%s не смог пролететь дистанцию в %d м.\n", name, distance);
        return false;
    }

    public int getFlyDistance() {
        return flyDistance;
    }

    public void setFlyDistance(int flyDistance) {
        this.flyDistance = flyDistance;
    }
}
