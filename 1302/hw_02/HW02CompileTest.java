package prob1;

import emps.Employee;

/**
 * 1.  This class should compile before turning in your assignment. 
 * 
 * 2.  Any compile error in this code means that the signature (spelling of method, return type, parameters) 
 *     of the method YOU wrote is incorrect. Fix your code.
 *      
 * 3.  If you didn't implement a method, then add a "stub" so that this class compiles and to make the grading
 *     process go more smoothly on my end. Some example stubs for various methods:
 * 
 *       public void mergeEmployee(Employee e){
 *       }
 *
 *	     public Employee getEmployeeWithMostHours (Employee[] emps) {
 *		     return null;	
 *	     }
 *
 *       public double getPay() {
 *		     return Double.MIN_VALUE;
 *	     }
 *
 * 4.  If you need to correct the spelling of a method, be sure and use: Refactor/Rename, which changes all
 *     occurrences in all files. See Lab 2 if needed. 
 */ 
public class HW02CompileTest {
	public static void main(String[] args) {
		testCompileStore();
		System.out.println("--> All methods have correct signature");
	}
	
	private static void testCompileStore() {
		Store s = new Store();
		Employee e1 = new Employee("Will", 23.0);
		e1.setHours(1, 10);
		s.addEmployee(e1);
		Employee e2 = new Employee("Shay", 55.0);
		s.addEmployee(e2);
		int num = s.getNumEmployees();
		Employee e3 = s.getEmployee(0);
		Employee e4 = s.getEmployeeWithName("Shay");
		double totalHours = s.getTotalHours();
		double totalPay = s.getTotalPay();
		Employee e = s.removeEmployee(1);
		String searchFor = "Ben";
		System.out.println(s);
	}
}
