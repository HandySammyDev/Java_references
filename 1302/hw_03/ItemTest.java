package prob1;

public class ItemTest {

	public static void main(String[] args) {
		testConstructor();
		testItemCost();
		testToString();
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
		String actual = "name=" + name + ", weight=" + weight;

		System.out.println(expected + "\n" + actual);
	}

	/**
	 * Verify that the cost method works correctly.
	 */
	public static void testItemCost() {
		System.out.println("-->testItemCost"); 
		System.out.println("NOT IMPLEMENTED"); 
	}

	/**
	 * Verify that the toString method produces a string exactly
	 * as specified in the assignment document. 
	 */
	public static void testToString() {
		System.out.println("-->testToString"); 
		System.out.println("NOT IMPLEMENTED"); 
	}

}
