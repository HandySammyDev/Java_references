package treeset_examples;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class EmployeeDriver {

    public static void main(String[] args)
    {
        TreeSet<Employee> tsEmps = new TreeSet<>(new EmployeeSalaryComparator());

        tsEmps.add(new Employee("Orville", 553572246, 22.32));
        tsEmps.add(new Employee("Boggs", 716533892, 12.57));
        tsEmps.add(new Employee("Lyton", 476227851, 77.88));
        tsEmps.add(new Employee("Dern", 243558673, 23.44));
        tsEmps.add(new Employee("Abscome", 994334662, 55.23));

        System.out.println("Original List");
        printList(tsEmps);

        // Get employees with Salary 30 or higher. First, create "dummy" employee.
        Employee emp = new Employee("unknown", 0, 30.0);
        SortedSet<Employee> sSet = tsEmps.tailSet(emp);
        System.out.println("\nEmployees with Salary >= 30: ");
        printList(sSet);

        // Get employee with largest Salary <= 30. Use "dummy" employee from above.
        Employee eSal30 = tsEmps.floor(emp);
        System.out.println("\nEmployee with largest Salary <= 30: " + eSal30);
    }

    private static void printList(Set<Employee> emps) {
        for(Employee e : emps) {
            System.out.println("   " + e);
        }
    }
}