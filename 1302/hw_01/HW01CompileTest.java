package prob1;

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
public class HW01CompileTest {
	public static void main(String[] args) {
		testCompileBasketballPlayer();
		testCompileCar();
		testCompileEmployee();
		testCompileEmployeeUtilities();
		testCompileProduct();
		System.out.println("All methods have correct signature");
	}

	private static void testCompileBasketballPlayer() {
		BasketballPlayer p = new BasketballPlayer("Paul");
		String name = p.getName();
		p.shootFreeThrow(true);
		int numMade = p.getFreeThrowsMade();
		int numAtt = p.getFreeThrowsAttempted();
		double percent = p.getFreeThrowPercent();
		p.shootTwoPointer(false);
		numMade = p.getTwoPointersMade();
		numAtt = p.getTwoPointersAttempted();
		percent = p.getTwoPointerPercent();
		p.shootThreePointer(true);
		numMade = p.getThreePointersMade();
		numAtt = p.getThreePointersAttempted();
		percent = p.getThreePointerPercent();
		int numPoints = p.getTotalPoints();
		String msg = p.toString();
	}

	public static void testCompileCar() {
		Car c = new Car(15.0, 20.0, 10.0);
		c = new Car(15.0, 20.0);
		double val = c.getFuelCapacity();
		val = c.getFuelEfficiency();
		val = c.getFuelLevel();
		val = c.getTotalDistance();
		c.fillUp(10.0);
		c.drive(2.0, 70.0);
		String msg = c.toString();
	}

	public static void testCompileEmployee() {
		Employee e;
		e = new Employee("Janice", 40.0);
		double val = e.getHours(3);
		e.setHours(0, 2);
		String data = e.getName();
		val = e.getPayRate();
		int num = e.getNumDaysWorked();
		val = e.getTotalHours();
		val = e.getWeekdayHours();
		val = e.getWeekendHours();
		val = e.getPay();
		Employee e2 = new Employee("Sal", 80.0);
		e.mergeEmployee(e2);
		e.newWeek();
		String msg = e.toString();
	}

	public static void testCompileEmployeeUtilities() {
		System.out.println("-->testGetTotalPay()");

		EmployeeUtilities empUtils = new EmployeeUtilities();
		Employee[] emps = buildEmployeesArray();
		double totalPay = empUtils.getTotalPay(emps);
		Employee e = empUtils.getEmployeeWithMostHours(emps);
		double[] hours = empUtils.getHoursArray(emps);
	}

	public static void testCompileProduct() {
		Product p = new Product("VLD0404193682");
		boolean isAfter = p.isAfter2000();
		boolean isMon = p.isMonthEqual(3);
		String data = p.getCode();
		data = p.getDate();
		int batch = p.getBatch();
		data = p.getPlant();
		data = p.getCode();
		data = p.toString();
	}


	/*
	 * Private helper methods below
	 */
	private static Employee[] buildEmployeesArray() {
		String[] names = {"Maverick", "Arthele", "Branford"};
		double[] payRates = {25, 16, 40};

		Employee[] emps = new Employee[names.length];
		for (int i = 0; i < emps.length; i++) {
			emps[i] = new Employee (names[i], payRates[i]);
		}
		emps[0].setHours(0,1); emps[0].setHours(1,5);
		emps[1].setHours(0,4); emps[1].setHours(1,8);
		emps[2].setHours(0,6); emps[2].setHours(1,10);
		return emps;
	}
}
