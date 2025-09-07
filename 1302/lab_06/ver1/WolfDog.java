package hw_06.ver1;

public class WolfDog extends Dog {

    private int toughness;

    public WolfDog(String name, int toughness) {
        super(name);
        this.toughness = toughness;
    }

    public int getToughness(){
        return toughness;
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