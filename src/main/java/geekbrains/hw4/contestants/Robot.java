package geekbrains.hw4.contestants;

public class Robot implements Contestant {
    private int maxHeight;
    private int maxLength;
    private String name;
    private int fatigue;

    public Robot() {
        this.maxHeight = 30;
        this.maxLength = 10000;
        this.name = "Робот";
    }

    public Robot(int maxHeight, int maxLength) {
        this.maxHeight = maxHeight;
        this.maxLength = maxLength;
        this.name = "Робот";
    }

    public Robot(int maxHeight, int maxLength, String name) {
        this.maxHeight = maxHeight;
        this.maxLength = maxLength;
        this.name = name;
    }

    @Override
    public boolean Jump(int height) {
        if (height <= maxHeight) {
            System.out.println(this.name + " успешно перепрыгнул барьер.");
            return true;
        }
        System.out.println(this.name + " не смог перепрыгнуть барьер.");
        return false;
    }

    @Override
    public boolean Run(int length) {
        if (length <= (maxLength - fatigue)) {
            System.out.println(this.name + " успешно пробежал дистанцию.");
            fatigue += length;
            return true;
        }
        System.out.println(this.name + " не смог пробежать дистанцию.");
        fatigue = maxLength;
        return false;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFatigue() {
        return fatigue;
    }

    public void setFatigue(int fatigue) {
        this.fatigue = fatigue;
    }
}

