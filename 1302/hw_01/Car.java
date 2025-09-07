package prob1;

public class Car {

    private double fuelCapacity;
    private double fuelEfficiency;
    private double fuelLevel;
    private double totalDistance;

    public Car(double fuelCapacity, double fuelEfficiency){

        this.fuelCapacity = fuelCapacity;
        this.fuelEfficiency = fuelEfficiency;
        fuelLevel = 0;
        totalDistance = 0;
    }
    public Car(double fuelCapacity, double fuelEfficiency, double fuelLevel){

        this.fuelCapacity = fuelCapacity;
        this.fuelEfficiency = fuelEfficiency;
        this.fuelLevel = fuelLevel;
        totalDistance = 0;
    }

    public void drive(double time, double rate){

        fuelLevel -= (rate * time)/fuelEfficiency;
        totalDistance += rate * time;

        if(fuelLevel < 0) {
            totalDistance += (fuelLevel * fuelEfficiency);
            fuelLevel = 0;
        }
    }
    public void fillUp(double amount){

        fuelLevel += amount;
        if(fuelLevel > fuelCapacity){
            fuelLevel = fuelCapacity;
        }
    }

    public double getFuelCapacity(){
        return fuelCapacity;
    }
    public double getFuelEfficiency(){
        return fuelEfficiency;
    }
    public double getFuelLevel(){
        return fuelLevel;
    }
    public double getTotalDistance(){
        return totalDistance;
    }

    @Override
    public String toString(){
        return String.format("fuelLevel=%.3f, totalDistance=%.3f, fuelCapacity=%.3f, fuelEfficiency=%.3f",
                              getFuelLevel(), getTotalDistance(), getFuelCapacity(), getFuelEfficiency());
    }
}
