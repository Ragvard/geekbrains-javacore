package geekbrains.hw5.obstacles;

import geekbrains.hw5.contestants.Contestant;
import geekbrains.hw5.contestants.Flyer;
import geekbrains.hw5.contestants.Jumper;

public class Wall implements Obstacle {
    int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean attempt(Contestant contestant) {
        if (contestant instanceof Jumper) {
            return ((Jumper) contestant).jump(height);
        }
        else if (contestant instanceof Flyer) {
            System.out.printf("%s перелетел через препятствие.\n", contestant.getName());
            return true;
        }
        System.out.printf("%s не способен преодолеть препятствие.\n", contestant.getName());
        return false;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
