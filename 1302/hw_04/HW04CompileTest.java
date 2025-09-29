package prob1;

import java.util.ArrayList;

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
public class HW04CompileTest {
	public static void main(String[] args) {
		testCompileItem();
		testCompileRefrigeratedItem();
		testCompileWarehouse();
		System.out.println("All methods have correct signature");
	}

	private static void testCompileItem() {
		Item b = new Item("Book", 5.00);
		double cost = b.cost();
		String name = b.getName();
		double wt = b.getWeight();
		String msg = b.toString();
	}

	public static void testCompileRefrigeratedItem() {
		RefrigeratedItem b = new RefrigeratedItem("Coke", 5.00, 7.00);
		double cost = b.cost();
		String name = b.getName();
		double wt = b.getWeight();
		double temp = b.getTemp();
		String msg = b.toString();
		Item e1 = new Item("Coke", 23.0);
		RefrigeratedItem b2 = new RefrigeratedItem(e1, 7.00);

	}

	public static void testCompileWarehouse() {
		Warehouse w = new Warehouse();
		Item e1 = new Item("Coke", 23.0);
		int num = w.getNumItems();
		boolean isAdded = w.addItem(e1);
		Item i = w.getItem(0);
		Item i2 = w.getItem("Coke");
		double cost = w.getTotalCost();
		double temp = w.getAverageTemp();
		double cost2 = w.getTotalCostRefrigerated();
		ArrayList<RefrigeratedItem> refs = w.getRefrigeratedItems();
		boolean isPresent = w.hasItem("bread");
		ArrayList<Item> items = w.getItemsWithName("br");
	}
}