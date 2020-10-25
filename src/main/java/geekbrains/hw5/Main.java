package geekbrains.hw5;
import geekbrains.hw5.contestants.*;
import geekbrains.hw5.obstacles.*;

public class Main {
    public static void main(String[] args) {
        Contestant[] contestants = new Contestant[]{
                new Human("Алексей", 90, 2500, 300),
                new Human("Борис", 80, 3000, 400),
                new Human("Вова", 105, 2000, 500),
                new Human("Григорий", 95, 2800, 400),

                new Cat("Дымок", 200, 300),
                new Cat("Ежевика", 210, 350),
                new Cat("Жирок", 120, 100),
                new Cat("Заря", 230, 500),

                new Robot("ВАЗ 2107", 450000),
                new Robot("Жестянка", 10000),

                new Fish("Окунь", 2000),
                new Fish("Карась", 1000),

                new Bird("Синица", 1000),
                new Bird("Лебедь", 5000)
        };

        Obstacle[][] obstacles = new Obstacle[4][];
        obstacles[0] = new Obstacle[] {
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

        obstacles[1] = new Obstacle[] {
                new Track(100),
                new Pool(100),
                new Track(200),
                new Pool(300),
                new Track(500)
        };

        obstacles[2] = new Obstacle[] {
                new Track(100),
                new Chasm(300),
                new Track(1000)
        };

        obstacles[3] = new Obstacle[] {
                new Track(100),
                new Pool(100),
                new Track(100),
                new Wall(80),
                new Track(50),
                new Wall(90),
                new Track(500)
        };

        for (int i = 0; i < obstacles.length; i++) {
            System.out.printf("%d-й список препятствий:\n", i);
            for (int k = 0; k < contestants.length; k++) {
                System.out.printf("%s начинает:\n", contestants[k].getName());
                boolean result = true;
                for (int j = 0; j < obstacles[i].length; j++) {
                    if (!obstacles[i][j].attempt(contestants[k])){
                        result = false;
                        break;
                    }
                }
                if (!result) {
                    System.out.println("Участник сошел с дистанции.\n");
                }
                else {
                    System.out.println("Участник преодолел дистанцию.\n");
                }
                contestants[k].rest();
            }
        }
    }
}
