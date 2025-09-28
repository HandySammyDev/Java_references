package animals2;

public class Duck implements Flyer, Swimmer {
    @Override
    public String fly() {
        return "duck flying";
    }

    @Override
    public String swim() {
        return "duck swimming";
    }

    @Override
    public String dive() {
        return "duck diving";
    }
}
