package geekbrains.hw4;
import geekbrains.hw4.contestants.*;
import geekbrains.hw4.obstacles.*;

import java.util.Random;

public class Main {


    public static void main(String[] args) {
        Contestant[] contestants = new Contestant[]{
                new Human(90, 2500, "Алексей"),
                new Human(80, 3000, "Борис"),
                new Human(105, 2000, "Вова"),
                new Human(95, 2800, "Григорий"),

                new Cat(200, 300, "Дымок"),
                new Cat(210, 350, "Ежевика"),
                new Cat(120, 100, "Жирок"),
                new Cat(230, 500, "Заря"),

                new Robot(7, 450000, "ВАЗ 2107"),
                new Robot(25, 10000, "Жестянка")
        };
        Obstacle[] obstacles = new Obstacle[] {
                new Track(50),
                new Wall(10),
                new Track(100),
                new Wall(30),
                new Track(100),
                new Wall(50),
                new Track(200),
                new Wall(70),
                new Track(400),
                new Wall(75),
                new Track(600),
                new Wall(80),
                new Track(800),
                new Wall(85),
        };

        for (int i = 0; i < contestants.length; i++) {
            System.out.println("Участник " + i + " начинает проходить перпятствия:");
            int j = 0;
            for (; j < obstacles.length; j++) {
                if (!Attempt(contestants[i], obstacles[j])) {
                    break;
                }
            }
            if (j < obstacles.length) {
                System.out.println("Участник сошел с дистанции на препятствии: " + obstacles[j].toString() + "\n");
            }
            else {
                System.out.println("Участник прошел дистанцию.\n");
            }
        }
    }

    private static boolean Attempt(Contestant c, Obstacle o) {
        if (o.getClass() == Wall.class) {
            return c.Jump(o.getSize());
        }
        else if (o.getClass() == Track.class) {
            return c.Run(o.getSize());
        }
        return false;
    }
}
