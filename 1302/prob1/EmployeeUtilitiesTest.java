package prob1;

import java.util.Arrays;

public class EmployeeUtilitiesTest {

	public static void main(String[] args) {
		testGetTotalPay();
		testGetEmployeeWithMostHours();
		testGetHoursArray();
	}

	public static void testGetTotalPay() {
		System.out.println("-->testGetTotalPay()");

		EmployeeUtilities empUtils = new EmployeeUtilities();
		Employee[] emps = buildEmployeesArray();

		double totalPay = empUtils.getTotalPay(emps);

		String report1 = String.format("Expected: Total Pay of all Employees=$%,.2f\n", 3277.0);
		String report2 = String.format("  Actual: Total Pay of all Employees=$%,.2f", totalPay);

		System.out.println(report1 + report2);
	}

	public static void testGetEmployeeWithMostHours() {
		System.out.println("\n-->testGetEmployeeWithMostHours()");

		EmployeeUtilities empUtils = new EmployeeUtilities();
		Employee[] emps = buildEmployeesArray();

		Employee e = empUtils.getEmployeeWithMostHours(emps);

		System.out.println("Expected: name of emp with max total hours=Gibson");
		System.out.println("  Actual: name of emp with max total hours=" + e.getName());
		System.out.println("Expected: max total hours=43.0");
		System.out.println("  Actual: max total hours=" + e.getTotalHours());
	}

	public static void testGetHoursArray() {
		System.out.println("\n-->testGetHoursArray()");

		EmployeeUtilities empUtils = new EmployeeUtilities();
		Employee[] emps = buildEmployeesArray();

		double[] hours = empUtils.getHoursArray(emps);

		System.out.println("Expected: [25.0, 22.0, 43.0]");
		System.out.println("  Actual: " + Arrays.toString(hours));
	}

//	/*
//	 * Private helper methods below
//	 */
	private static Employee[] buildEmployeesArray() {
		String[] names = {"Maverick", "John", "Gibson"};
		double[] payRates = {25, 16, 40};

		Employee[] emps = new Employee[names.length];
		for (int i = 0; i < emps.length; i++) {
			emps[i] = new Employee (names[i], payRates[i]);
		}

		emps[0].setHours(0,1);
		emps[0].setHours(1,5);
		emps[0].setHours(2,6);
		emps[0].setHours(3,7);
		emps[0].setHours(4,4);
		emps[0].setHours(5,2);
		emps[0].setHours(6,0);

		emps[1].setHours(0,4);
		emps[1].setHours(1,8);
		emps[1].setHours(2,7);
		emps[1].setHours(3,1);
		emps[1].setHours(4,2);
		emps[1].setHours(5,0);
		emps[1].setHours(6,0);

		emps[2].setHours(0,6);
		emps[2].setHours(1,10);
		emps[2].setHours(2,5);
		emps[2].setHours(3,2);
		emps[2].setHours(4,8);
		emps[2].setHours(5,10);
		emps[2].setHours(6,2);

		return emps;
	}
}
