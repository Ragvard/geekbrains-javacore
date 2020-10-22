package geekbrains.hw5.obstacles;

import geekbrains.hw5.contestants.Contestant;
import geekbrains.hw5.contestants.Flyer;

public class Chasm implements Obstacle{
    int length;

    public Chasm(int length) {
        this.length = length;
    }

    @Override
    public boolean attempt(Contestant contestant) {
        if (contestant instanceof Flyer) {
            return ((Flyer) contestant).fly(length);
        }
        else if (contestant instanceof Flyer) {
            return ((Flyer) contestant).fly(length);
        }
        System.out.printf("%s не способен преодолеть препятствие.\n", contestant.getName());
        return false;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
