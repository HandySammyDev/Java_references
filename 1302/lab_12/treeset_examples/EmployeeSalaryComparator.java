package treeset_examples;

import java.util.Comparator;

public class EmployeeSalaryComparator implements Comparator<Employee> {
    public int compare( Employee e1, Employee e2 ) {
        double diff = e1.getSalary() - e2.getSalary();
        if( diff < 0.0 ) return -1;
        else if( diff > 0.0 ) return 1;
        else return 0;

    }
}