package prob1;

public class EmployeeTest {

	public static void main(String[] args) {
		testGetNumDaysWorked();
		testGetTotalHours();
		testGetWeekdayHours();
		testGetWeekendHours();
		testNewWeek();
		testMergeEmployee();
		testGetPay_0_weekday_0_weekend();
		testGetPay_lessthan40_weekday_0_weekend();
//		testGetPay_lessthan40_weekday_greaterthan0_weekend();
//		testGetPay_equalto40_weekday_0_weekend();
//		testGetPay_greaterthan40_weekday_0_weekend();
//		testGetPay_greaterthan40_weekday_greaterthan0_weekend();
//		testGetPay_lessthan40_weekday_greaterthan0_weekend_7_days();
//		testGetPay_greaterthan40_weekday_greaterthan0_weekend_7_days();
//		testToString();
	}

	public static void testGetNumDaysWorked() {
		System.out.println("-->testGetNumDaysWorked()");

		Employee e = buildEmployee1();
		System.out.println("Expected: num days worked=4");
		System.out.println("  Actual: num days worked=" + e.getNumDaysWorked());
	}

	public static void testGetTotalHours() {
		System.out.println("\n-->testGetTotalHours()");

		Employee e = buildEmployee1();
		System.out.println("Expected: total hours=20.0");
		System.out.println("  Actual: total hours=" + e.getTotalHours());
	}

	public static void testGetWeekdayHours() {
		System.out.println("\n-->testGetWeekdayHours()");

		Employee e = buildEmployee1();
		System.out.println("Expected: total weekday hours=12.0");
		System.out.println("  Actual: total weekday hours=" + e.getWeekdayHours());
	}

	public static void testGetWeekendHours() {
		System.out.println("\n-->testGetWeekendHours()");

		Employee e = buildEmployee1();
		System.out.println("Expected: total weekend hours=8.0");
		System.out.println("  Actual: total weekend hours=" + e.getWeekendHours());
	}

	public static void testNewWeek() {
		System.out.println("\n-->testNewWeek()");

		Employee e = buildEmployee1();
		e.newWeek();
		System.out.println("Expected: num days worked=0");
		System.out.println("  Actual: num days worked=" + e.getNumDaysWorked());
		System.out.println("Expected: total hours=0.0");
		System.out.println("  Actual: total hours=" + e.getTotalHours());

	}

	public static void testMergeEmployee() {
		System.out.println("\n-->testMergeEmployee()");

		Employee e1 = buildEmployee1();
		Employee e2 = buildEmployee2();
		e1.mergeEmployee(e2);

		System.out.println("Expected: num days worked=5");
		System.out.println("  Actual: num days worked=" + e1.getNumDaysWorked());
		System.out.println("Expected: total hours=26.0");
		System.out.println("  Actual: total hours=" + e1.getTotalHours());
		System.out.println("Expected: total weekday hours=16.0");
		System.out.println("  Actual: total weekday hours=" + e1.getWeekdayHours());
		System.out.println("Expected: total weekend hours=10.0");
		System.out.println("  Actual: total weekend hours=" + e1.getWeekendHours());

	}

	public static void testGetPay_0_weekday_0_weekend() {
		System.out.println("\n-->testGetPay_0_weekday_0_weekend()");
		Employee e;
		e = new Employee("Waldo", 25.0);
		String report =  String.format("Expected: getPay()=$%,.2f\n", 0.0);
		       report += String.format("  Actual: getPay()=$%,.2f", e.getPay());
		System.out.println(report);
	}

	public static void testGetPay_lessthan40_weekday_0_weekend() {
		System.out.println("\n-->testGetPay_lessthan40_weekday_0_weekend()");
		Employee e;
		e = new Employee("Waldo", 25.0);
		e.setHours(0, 8);
		e.setHours(1, 8);
		e.setHours(2, 8);

		String report =  String.format("Expected: getPay()=$%,.2f\n", 600.0);
		       report += String.format("  Actual: getPay()=$%,.2f", e.getPay());
		System.out.println(report);
	}

//	public static void testGetPay_lessthan40_weekday_greaterthan0_weekend() {
//		System.out.println("\n-->testGetPay_lessthan40_weekday_greaterthan0_weekend()");
//		Employee e;
//		e = new Employee("Waldo", 25.0);
//		e.setHours(0, 8);
//		e.setHours(1, 8);
//		e.setHours(2, 8);
//		e.setHours(6, 8);
//
//		String report =  String.format("Expected: getPay()=$%,.2f\n", 1000.0);
//		       report += String.format("  Actual: getPay()=$%,.2f", e.getPay());
//		System.out.println(report);
//	}
//
//	public static void testGetPay_equalto40_weekday_0_weekend() {
//		System.out.println("\n-->testGetPay_equalto40_weekday_0_weekend()");
//		Employee e;
//		e = new Employee("Salvatore", 25.0);
//		e.setHours(0, 8);
//		e.setHours(1, 8);
//		e.setHours(2, 8);
//		e.setHours(3, 8);
//		e.setHours(4, 8);
//
//		String report =  String.format("Expected: getPay()=$%,.2f\n", 1000.0);
//		       report += String.format("  Actual: getPay()=$%,.2f", e.getPay());
//		System.out.println(report);
//	}
//
//	public static void testGetPay_greaterthan40_weekday_0_weekend() {
//		System.out.println("\n-->testGetPay_greaterthan40_weekday_0_weekend()");
//		Employee e;
//		e = new Employee("Delia", 25.0);
//		e.setHours(0, 8);
//		e.setHours(1, 8);
//		e.setHours(2, 8);
//		e.setHours(3, 8);
//		e.setHours(4, 10);
//
//		String report =  String.format("Expected: getPay()=$%,.2f\n", 1075.0);
//		       report += String.format("  Actual: getPay()=$%,.2f", e.getPay());
//		System.out.println(report);
//	}
//
//	public static void testGetPay_greaterthan40_weekday_greaterthan0_weekend() {
//		System.out.println("\n-->testGetPay_greaterthan40_weekday_0_weekend()");
//		Employee e;
//		e = new Employee("Nate", 25.0);
//		e.setHours(0, 8);
//		e.setHours(1, 8);
//		e.setHours(2, 8);
//		e.setHours(3, 8);
//		e.setHours(4, 10);
//		e.setHours(5, 2);
//
//		String report =  String.format("Expected: getPay()=$%,.2f\n", 1175.0);
//		       report += String.format("  Actual: getPay()=$%,.2f", e.getPay());
//		System.out.println(report);
//	}
//
//	public static void testGetPay_lessthan40_weekday_greaterthan0_weekend_7_days() {
//		System.out.println("\n-->testGetPay_lessthan40_weekday_greaterthan0_weekend_7_days()");
//		Employee e;
//		e = new Employee("Bisley", 25.0);
//		e = new Employee("Orin", 25.0);
//		e.setHours(0, 4);
//		e.setHours(1, 4);
//		e.setHours(2, 4);
//		e.setHours(3, 4);
//		e.setHours(4, 4);
//		e.setHours(5, 2);
//		e.setHours(6, 2);
//
//		String report =  String.format("Expected: getPay()=$%,.2f\n", 750.0);
//		       report += String.format("  Actual: getPay()=$%,.2f", e.getPay());
//		System.out.println(report);
//	}
//
//	public static void testGetPay_greaterthan40_weekday_greaterthan0_weekend_7_days() {
//		System.out.println("\n-->testGetPay_greaterthan40_weekday_greaterthan0_weekend_7_days()");
//		Employee e;
//		e = new Employee("Bisley", 25.0);
//		e.setHours(0, 10);
//		e.setHours(1, 8);
//		e.setHours(2, 8);
//		e.setHours(3, 8);
//		e.setHours(4, 8);
//		e.setHours(5, 2);
//		e.setHours(6, 2);
//
//		String report =  String.format("Expected: getPay()=$%,.2f\n", 1325.0);
//		       report += String.format("  Actual: getPay()=$%,.2f", e.getPay());
//		System.out.println(report);
//	}
//
//	public static void testToString() {
//		System.out.println("\n-->testToString()");
//		Employee e;
//		e = new Employee("Bisley", 25.0);
//		e.setHours(0, 10);
//		e.setHours(1, 8);
//		e.setHours(2, 8);
//		e.setHours(3, 8);
//		e.setHours(4, 8);
//		e.setHours(5, 2);
//		e.setHours(6, 2);
//
//		System.out.println(e);
//	}
//
//
//	/*
//	 * Private helper methods below
//	 */
	private static Employee buildEmployee1() {
		Employee e;
		e = new Employee("Janice", 40.0);
		e.setHours(0, 2);
		e.setHours(1, 4);
		e.setHours(2, 6);
		e.setHours(6, 8);
		return e;
	}

	private static Employee buildEmployee2() {
		Employee e;
		e = new Employee("Janice", 40.0);
		e.setHours(2, 4);
		e.setHours(5, 2);
		return e;
	}
}
