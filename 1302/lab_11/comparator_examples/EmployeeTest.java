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

        EmployeeSalaryComparator salaryComp = new EmployeeSalaryComparator();
        Collections.sort(employees, salaryComp);
        System.out.println("\nSorted on Salary");
        printList(employees);

        // Get employee with largest and smallest SSN
        Employee eMax = Collections.max(employees, ssnComp);
        Employee eMin = Collections.min(employees, ssnComp);
        System.out.println("\nEmployee with largest  SSN: " + eMax);
        System.out.println(  "Employee with smallest SSN: " + eMin);

        // Get employee with largest and smallest name
        eMax = Collections.max(employees, nameComp);
        eMin = Collections.min(employees, nameComp);
        System.out.println("\nEmployee with 'largest'  Name: " + eMax);
        System.out.println(  "Employee with 'smallest' Name: " + eMin);

        // Binary Search example
        Collections.sort(employees, ssnComp);
        System.out.println("Current List");
        printList(employees);
        Employee eKey = new Employee("don't know", 243558673, -9999.0);

        int pos = Collections.binarySearch(employees, eKey, ssnComp);

        System.out.println("\nEmployee Key searched for: " + eKey);
        if(pos >= 0) {
            Employee e = employees.get(pos);
            System.out.println(  "Employee found           : " + e);
        }
        else{
            System.out.println("*** Employee Not Found ***, pos=" + pos);
        }

        eKey = new Employee("don't know", 666666666, -9999.0);

        pos = Collections.binarySearch(employees, eKey, ssnComp);
        if(pos < 0) {
            System.out.println("\nEmployee Key searched for: " + eKey);
            System.out.println("*** Employee Not Found ***, pos=" + pos);
        }
    }

    private static void printList(List<Employee> emps) {
        for(Employee e : emps) {
            System.out.println("   " + e);
        }
    }
}