package prob1;

public class RefrigeratedItem extends Item {

    private double temperature;

    public double getTemp() {
        return temperature;
    }

    public RefrigeratedItem(String name, double weight, double temperature) {
        super(name, weight);
        this.temperature = temperature;
    }

    public RefrigeratedItem(Item item, double temperature) {
        this(item.getName(), item.getWeight(), temperature);
    }

    @Override
    public double cost(){
        return (getWeight() * 2) + (100-temperature)*0.1;
    }
    public String toString(){
        return String.format
                ("name=%s, cost=$%.2f, weight=%.2f, temp=%.2f degrees",
                getName(), cost(), getWeight(), getTemp());
    }
}