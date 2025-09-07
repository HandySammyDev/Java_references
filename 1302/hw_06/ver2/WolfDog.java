package hw_06.ver2;

public class WolfDog extends Dog {

    public WolfDog(String name) {
        super(name);
    }

    @Override
    public String bark() {
        return name + " says: BARK";
    }

    @Override
    public String toString() {
        return "WolfDog named " + getName();
    }
}