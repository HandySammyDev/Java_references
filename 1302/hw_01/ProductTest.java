package prob1;

public class ProductTest {

//	/***
//	 * YOU SHOULD WRITE THESE TEST METHODS.
//	 *
//	 */
	public static void main(String[] args) {
		testProductConstructor_Plant_3chars_Batch_2chars();
		testProductConstructor_Plant_3chars_Batch_1chars();
		testProductConstructor_Plant_2chars_Batch_2chars();
		testProductConstructor_Plant_2chars_Batch_1chars();
		testIsAfter2000Test_True_Year2019();
		testIsAfter2000Test_True_Year2000();
		testIsAfter2000Test_False_Year1994();
		testIsMonthEqual_True();
		testIsMonthEqual_False();
	}

//	/***
//	 * Construct a product where the plant has 3 characters, and the batch has 2.
//	 * Should show that code, plant, date, and batch are correct.
//	 */
	public static void testProductConstructor_Plant_3chars_Batch_2chars() {
		System.out.println("-->testProductConstructor_Plant_3chars_Batch_2chars()");

		Product p = new Product("DCF0514201223");
		System.out.println("Expected: code=DCF0514201223, plant=DCF, date=05/14/2012, batch=23");
		System.out.println("  Actual: " + p);
	}

//	/***
//	 * Construct a product where the plant has 3 characters, and the batch has 1.
//	 * Should show that code, plant, date, and batch are correct.
//	 */
	public static void testProductConstructor_Plant_3chars_Batch_1chars() {
		System.out.println("\n-->testProductConstructor_Plant_3chars_Batch_1chars()");

		Product p = new Product("EFD120220034");
		System.out.println("Expected: code=EFD120220034, plant=EFD, date=12/02/2003, batch=4");
		System.out.println("  Actual: " + p);
	}

//	/***
//	 * Construct a product where the plant has 2 characters, and the batch has 2.
//	 * Should show that code, plant, date, and batch are correct.
//	 */
	public static void testProductConstructor_Plant_2chars_Batch_2chars() {
		System.out.println("\n-->testProductConstructor_Plant_2chars_Batch_2chars()");

		Product p = new Product("DS0210202321");
		System.out.println("Expected: code=DS0210202321, plant=DS, date=02/10/2023, batch=21");
		System.out.println("  Actual: " + p);
	}

//	/***
//	 * Construct a product where the plant has 2 characters, and the batch has 1.
//	 * Should show that code, plant, date, and batch are correct.
//	 */
	public static void testProductConstructor_Plant_2chars_Batch_1chars() {
		System.out.println("\n-->testProductConstructor_Plant_2chars_Batch_1chars()");

		Product p = new Product("GF021320011");
		System.out.println("Expected: code=GF021320011, plant=GF, date=02/13/2001, batch=1");
		System.out.println("  Actual: " + p);
	}

//	/***
//	 * Construct a product where the year is 2019 and then call isAfter2000() which should return true.
//	 * Show values to illustrate that return is correct.
//	 */
	public static void testIsAfter2000Test_True_Year2019() {
		System.out.println("\n-->testIsAfter2000Test_True_Year2019()");

		Product p = new Product("DS021920191");
		System.out.println("Expected: true");
		System.out.println("  Actual: " + p.isAfter2000());
		System.out.println(p);
	}

//	/***
//	 * Construct a product where the year is 2000 and then call isAfter2000() which should return true.
//	 * Show values to illustrate that return is correct.
//	 */
	public static void testIsAfter2000Test_True_Year2000() {
		System.out.println("\n-->testIsAfter2000Test_True_Year2000()");

		Product p = new Product("DS021920001");
		System.out.println("Expected: true");
		System.out.println("  Actual: " + p.isAfter2000());
		System.out.println(p);
	}

//	/***
//	 * Construct a product where the year is 1994 and then call isAfter2000() which should return false.
//	 * Show values to illustrate that return is correct.
//	 */
	public static void testIsAfter2000Test_False_Year1994() {
		System.out.println("\n-->testIsAfter2000Test_False_Year1994()");

		Product p = new Product("DS0219199412");
		System.out.println("Expected: false");
		System.out.println("  Actual: " + p.isAfter2000());
		System.out.println(p);
	}
//
//	/***
//	 * Construct a product where the month is say, Feb, and then call isMonthEqual(2) which should return true.
//	 * Show values to illustrate that return is correct.
//	 */
	public static void testIsMonthEqual_True() {
		System.out.println("\n-->testIsMonthEqual_True()");

		Product p = new Product("DS0219199412");
		System.out.println("Expected: true");
		System.out.println("  Actual: " + p.isMonthEqual(2));
		System.out.println(p);
	}

//	/***
//	 * Construct a product where the month is say, Feb, and then call isMonthEqual(3) which should return false.
//	 * Show values to illustrate that return is correct.
//	 */
	public static void testIsMonthEqual_False() {
		System.out.println("\n-->testIsMonthEqual_False()");

		Product p = new Product("DS0219199412");
		System.out.println("Expected: false");
		System.out.println("  Actual: " + p.isMonthEqual(3));
		System.out.println(p);
	}
}
