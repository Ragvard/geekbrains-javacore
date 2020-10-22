package geekbrains.hw5.contestants;

public abstract class Contestant {
    protected String name;
    protected double fatigue;

    public String getName() {
        return name;
    }

    public void rest() {fatigue = 1;} ;
}
