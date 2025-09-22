package prob1;

public class RefrigeratedItemTest {

	public static void main(String[] args) {
		testConstructorMain();
		testConstructorAcceptsItem();
		testItemCost();
		testToString();
	}
	
	/**
	 * Verify that the name, weight, & temp are initialized with the main constructor.
	 */
	public static void testConstructorMain() {
		System.out.println("-->testConstructorMain");

		RefrigeratedItem ri = new RefrigeratedItem("Ice Cream", 1.50, 3.2);
		String name = ri.getName();
		double weight = ri.getWeight();
		double temperature = ri.getTemp();
		String expected = "name=Ice Cream, weight=1.50, temperature=3.2";
		String actual = String.format("name=%s, weight=%.2f, temperature=%.1f", name, weight, temperature);

		System.out.println(expected);
		System.out.println(actual);
	}

	/**
	 * Verify that the name, weight, & temp are initialized with the second constructor.
	 */
	public static void testConstructorAcceptsItem() {
		System.out.println("-->testConstructorAcceptsItem");

		Item i = new Item("Cookie", 1.50);
		RefrigeratedItem ri = new RefrigeratedItem(i, 3.2);
		String name = ri.getName();
		double weight = ri.getWeight();
		double temperature = ri.getTemp();
		String expected = "name=Cookie, weight=1.50, temperature=3.2";
		String actual = String.format("name=%s, weight=%.2f, temperature=%.1f", name, weight, temperature);

		System.out.println(expected);
		System.out.println(actual);
	}

	/**
	 * Verify that the cost method works correctly.
	 */
	public static void testItemCost() {
		System.out.println("-->testItemCost");

		Item i = new Item("Cookie", 1.50);
		RefrigeratedItem ri = new RefrigeratedItem(i, 3.2);
		double cost = ri.cost();
		String expected = "cost=12.68";
		String actual = String.format("cost=%.2f", cost);

		System.out.println(expected);
		System.out.println(actual);
	}

	/**
	 * Verify that the toString method produces a string exactly
	 * as specified in the assignment document. 
	 */
	public static void testToString() {
		System.out.println("-->testToString");

		Item i = new Item("Cookie", 1.50);
		RefrigeratedItem ri = new RefrigeratedItem(i, 3.2);
		String name = ri.getName();
		double weight = ri.getWeight();
		double temperature = ri.getTemp();
		double cost = ri.cost();
		String expected = ri.toString();
		String actual = String.format("name=%s, cost=$%.2f, weight=%.2f, temp=%.2f degrees",
										name, cost, weight, temperature);;

		System.out.println(expected);
		System.out.println(actual);
	}

}
