//package prob1;
//
//public class CarTest {
//
//	public static void main(String[] args) {
//		testConstructorWith3Parameters();
//		testConstructorWith2Parameters();
//		testFillUp_AmountLessThanRemainingCapacity();
//		testFillUp_AmountEqualToRemainingCapacity();
//		testFillUp_AmountMoreThanRemainingCapacity();
//		testDrive_OneDrive_EnoughFuel();
//		testDrive_TwoDrives_EnoughFuel();
//		testDrive_OneDrive_NotEnoughFuel();
//		testDrive_DriveFillUpDrive_EnoughFuel();
//		testDrive_DriveFillUpDrive_EnoughFuel();
//	}
//
//	public static void testConstructorWith3Parameters() {
//		System.out.println("-->testConstructorWith3Parameters()");
//		Car c = new Car(15.0, 20.0, 10.0);
//		System.out.println(c);
//	}
//
//	public static void testConstructorWith2Parameters() {
//		System.out.println("\n-->testConstructorWith2Parameters()");
//		Car c = new Car(15.0, 20.0);
//		System.out.println(c);
//	}
//
//	public static void testFillUp_AmountLessThanRemainingCapacity() {
//		System.out.println("\n-->testFillUp_AmountLessThanRemainingCapacity()");
//		Car c = new Car(15.0, 20.0);
//		c.fillUp(10.0);
//		String msgExpected = String.format("Expected: fuelLevel=%.1f", 10.0);
//		String msgActual =   String.format("  Actual: fuelLevel=%.1f", c.getFuelLevel());
//		System.out.println(msgExpected);
//		System.out.println(msgActual);
//	}
//
//	public static void testFillUp_AmountEqualToRemainingCapacity() {
//		System.out.println("\n-->testFillUp_AmountEqualToRemainingCapacity()");
//		Car c = new Car(15.0, 20.0, 10.0);
//		c.fillUp(5.0);
//		String msgExpected = String.format("Expected: fuelLevel=%.1f", 15.0);
//		String msgActual =   String.format("  Actual: fuelLevel=%.1f", c.getFuelLevel());
//		System.out.println(msgExpected);
//		System.out.println(msgActual);
//	}
//
//	public static void testFillUp_AmountMoreThanRemainingCapacity() {
//		System.out.println("\n-->testFillUp_AmountMoreThanRemainingCapacity()");
//		Car c = new Car(15.0, 20.0, 10.0);
//		c.fillUp(10.0);
//		String msgExpected = String.format("Expected: fuelLevel=%.1f", 15.0);
//		String msgActual =   String.format("  Actual: fuelLevel=%.1f", c.getFuelLevel());
//		System.out.println(msgExpected);
//		System.out.println(msgActual);
//	}
//
//	public static void testDrive_OneDrive_EnoughFuel() {
//		System.out.println("\n-->testDrive_OneDrive_EnoughFuel()");
//		Car c = new Car(15.0, 20.0, 10.0);
//		c.drive(2.0, 70.0);
//		String msgExpected = String.format("Expected: fuelLevel=%.1f, totalDistance=%.1f", 3.0, 140.0);
//		String msgActual =   String.format("  Actual: fuelLevel=%.1f, totalDistance=%.1f",
//				c.getFuelLevel(), c.getTotalDistance());
//		System.out.println(msgExpected);
//		System.out.println(msgActual);
//	}
//
//	public static void testDrive_TwoDrives_EnoughFuel() {
//		System.out.println("\n-->testDrive_TwoDrives_EnoughFuel()");
//		Car c = new Car(15.0, 20.0, 10.0);
//		c.drive(1.0, 60.0);
//		c.drive(2.0, 40.0 );
//		String msgExpected = String.format("Expected: fuelLevel=%.1f, totalDistance=%.1f", 3.0, 140.0);
//		String msgActual =   String.format("  Actual: fuelLevel=%.1f, totalDistance=%.1f",
//				c.getFuelLevel(), c.getTotalDistance());
//		System.out.println(msgExpected);
//		System.out.println(msgActual);
//	}
//
//	public static void testDrive_OneDrive_NotEnoughFuel() {
//		System.out.println("\n-->testDrive_OneDrive_NotEnoughFuel()");
//		Car c = new Car(15.0, 20.0, 5.0);
//		c.drive(3.0, 60.0);
//		String msgExpected = String.format("Expected: fuelLevel=%.1f, totalDistance=%.1f", 0.0, 100.0);
//		String msgActual =   String.format("  Actual: fuelLevel=%.1f, totalDistance=%.1f",
//				c.getFuelLevel(), c.getTotalDistance());
//		System.out.println(msgExpected);
//		System.out.println(msgActual);
//	}
//
//	public static void testDrive_DriveFillUpDrive_EnoughFuel() {
//		System.out.println("\n-->testDrive_DriveFillUpDrive_EnoughFuel()");
//		Car c = new Car(15.0, 20.0, 5.0);
//		c.drive(0.5, 60.0);
//		c.fillUp(6.5);
//		c.drive(2.0, 30.0);
//		String msgExpected = String.format("Expected: fuelLevel=%.1f, totalDistance=%.1f", 7.0, 90.0);
//		String msgActual =   String.format("  Actual: fuelLevel=%.1f, totalDistance=%.1f",
//				c.getFuelLevel(), c.getTotalDistance());
//		System.out.println(msgExpected);
//		System.out.println(msgActual);
//	}
//
//}
