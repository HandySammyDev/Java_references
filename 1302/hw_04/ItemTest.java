package prob1;

public class ItemTest {

	public static void main(String[] args) {
		testConstructor();
		testItemCost();
		testToString();
		testEqualsReturnsTrue();
		testEqualsReturnsFalse();
	}
	
	/**
	 * Verify that the name & weight are initialized with the constructor.
	 */
	public static void testConstructor() {
		System.out.println("-->testConstructor");

		Item i = new Item("Cookie", 1.50);
		String name = i.getName();
		double weight = i.getWeight();
		String expected = "name=Cookie, weight=1.50";
		String actual = String.format("name=%s, weight=%.2f", name, weight);

		System.out.println(expected + "\n" + actual);
	}

	/**
	 * Verify that the cost method works correctly.
	 */
	public static void testItemCost() {
		System.out.println("-->testItemCost");
		Item i = new Item("Cookie", 2.50);
		double cost = i.cost();
		String expected = "cost=5.0";
		String actual = "cost=" + cost;

		System.out.println(expected + "\n" + actual);
	}

	/**
	 * Verify that the toString method produces a string exactly
	 * as specified in the assignment document.
	 */
	public static void testToString() {
		System.out.println("-->testToString");

		Item i = new Item("Apple", .50);
		String expected = "name=Apple, cost=$1.00, weight=0.50";
		String actual = i.toString();

		System.out.println(expected + "\n" + actual);
	}

	public static void testEqualsReturnsTrue(){
		System.out.println("-->testEqualsReturnsTrue");
		Item i1 = new Item("Cookie", 2.50);
		Item i2 = new Item("Cookie", 3.50);
		String expected = "Expected: true";
		String actual = "Actual: " + i1.equals(i2);

		System.out.println(expected + "\n" + actual);
	}

	public static void testEqualsReturnsFalse(){
		System.out.println("-->testEqualsReturnsFalse");
		Item i1 = new Item("Cookie", 2.50);
		Item i2 = new Item("Cake", 3.50);
		String expected = "Expected: false";
		String actual = "Actual: " + i1.equals(i2);

		System.out.println(expected + "\n" + actual);
	}
}
