package comparator_examples;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class EmployeeTest {

    public static void main(String[] args)
    {
        // Create list of employees
        List<Employee> employees = new LinkedList<>();

        // Put employees in list
        employees.add(new Employee("Boggs", 716533892, 12.57));
        employees.add(new Employee("Lyton", 476227851, 77.88));
        employees.add(new Employee("Orville", 553572246, 22.32));
        employees.add(new Employee("Dern", 243558673, 23.44));
        System.out.println("Original List");
        printList(employees);

        // Create comparator
        EmployeeSSNComparator ssnComp = new EmployeeSSNComparator();
        // Sort list based on SSN
        Collections.sort(employees, ssnComp);
        System.out.println("\nSorted on SSN");
        printList(employees);

        EmployeeNameComparator nameComp = new EmployeeNameComparator();
        Collections.sort(employees, nameComp);
        System.out.println("\nSorted on Name");
        printList(employees);
    }

    private static void printList(List<Employee> emps) {
        for(Employee e : emps) {
            System.out.println("   " + e);
        }
    }
}