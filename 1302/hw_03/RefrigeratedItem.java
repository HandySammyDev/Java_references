package prob1;

public class RefrigeratedItem extends Item {

    private double temperature;

    public double getTemperature() {
        return temperature;
    }

    public RefrigeratedItem(String name, double weight, double temperature) {
        super(name, weight);
        this.temperature = temperature;
    }

    public RefrigeratedItem(double temperature, Item item) {
        this(item.getName(), item.getWeight(), temperature);
        RefrigeratedItem refrigeratedItem = (RefrigeratedItem) item;
    }

    @Override
    public double cost(){
        return (getWeight() * 2) + (100-temperature)*0.1;
    }
    public String toString(){
        return String.format
                ("name=%s, cost=$%.2f, weight=%.2f, temp=%.2f degrees",
                getName(), cost(), getWeight(), getTemperature());
    }
}