package geekbrains.hw5.obstacles;

import geekbrains.hw5.contestants.Contestant;

public interface Obstacle {
    boolean attempt(Contestant contestant);
}
