package comparator_examples;

public class Employee {
    private String name;
    private int ssNum;
    private double salary;

    public Employee(String name, int ssNum, double salary) {
        this.name = name;
        this.ssNum = ssNum;
        this.salary = salary;
    }

    public String getName() { return name; }
    public int getSSNum() { return ssNum; }
    public double getSalary() { return salary; }

    public String toString() {
        return String.format("Name: %-8s - SSN: %d\tSalary: $%.2f", getName(),
                getSSNum(), getSalary() );
    }
}
