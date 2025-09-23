package prob1;

// “This homework represents my own work.
// I understand that I may receive help, but I did not copy any portion of this assignment from anywhere.
// I understand that a violation of this will result in a Report of Academic Dishonesty.— Samuel Perez-Hernandez”
public class WarehouseTest {

	public static void main(String[] args) {
		testAddItem(); 						
		testAddItem_Multiple();
		testAddItem_Multiple_11();
		testGetItem_WithIndex();
		testGetItem_WithInvalidIndex();
		testGetItem_WithName();
		testGetItem_WithInvalidName();
		testGetAverageTemp();
		testGetRefrigeratedItems();
		testGetTotalCost();
		testGetTotalCostRefrigerated();
		testRemoveItem_WithIndex();
		testRemoveItem_WithIndex_invalid();
		testRemoveItem_WithName();
		testRemoveItem_WithoutName();
		testToString();

		//My test methods
		//testRemoveItem_WithIndex9();
	}
	
	/**
	 * Add one item and check the number of items to verify.
	 */
	public static void testAddItem() {
		System.out.println("-->testAddItem"); 

		Item item = new Item("Cookie", 1.5);
		Warehouse w = new Warehouse();
		int numItemsBefore = w.getNumItems();
		w.addItem(item);
		int numItemsAfter = w.getNumItems();
		String expected = "Before=0, After=1";
		String actual = String.format("Before=%d, After=%d", numItemsBefore, numItemsAfter);

		System.out.println(expected);
		System.out.println(actual);
	}
	
	/**
	 * Add three items and check the number of items to verify. At least one should be a refrigerated item.
	 */
	public static void testAddItem_Multiple() {
		System.out.println("-->testAddItem_Multiple");

		Item item1 = new Item("Cookie", 1.5);
		Item refrigeratedItem1 = new RefrigeratedItem("Chicken", 2.00, 32.2);
		Item item2 = new Item("Apple", 1.2);

		Warehouse w = new Warehouse();
		int numItemsBefore = w.getNumItems();
		w.addItem(item1);
		w.addItem(refrigeratedItem1);
		w.addItem(item2);
		int numItemsAfter = w.getNumItems();
		String expected = "Before=0, After=3";
		String actual = String.format("Before=%d, After=%d", numItemsBefore, numItemsAfter);

		System.out.println(expected);
		System.out.println(actual);
	}
	
	/**
	 * Add eleven items and check the number of items to verify. This goes over the max number of items, and therefore
	 * shouldn't increase after 10 At least one should be a refrigerated item.
	 */
	public static void testAddItem_Multiple_11() {
		System.out.println("-->testAddItem_Multiple_11");

		Item item1 = new Item("Cookie", 1.5);
		Item item2 = new Item("Apple", 1.2);
		Item item3 = new Item("Banana", 1.5);
		Item item4 = new Item("PopTart", 1.2);
		Item item5 = new Item("Bread", 1.5);
		Item item6 = new Item("Grapes", 1.2);
		Item item7 = new Item("Orange", 1.5);
		Item item8 = new Item("Chocolate", 1.2);
		Item refrigeratedItem1 = new RefrigeratedItem("Chicken", 2.00, 32.2);
		Item refrigeratedItem2 = new RefrigeratedItem("Beef", 2.00, 32.2);
		Item refrigeratedItem3 = new RefrigeratedItem("Yogurt", 2.00, 32.2);

		Warehouse w = new Warehouse();
		int numItemsBefore = w.getNumItems();
		w.addItem(item1);
		w.addItem(refrigeratedItem1);
		w.addItem(item2);
		w.addItem(item3);
		w.addItem(refrigeratedItem2);
		w.addItem(item4);
		w.addItem(item5);
		w.addItem(refrigeratedItem3);
		w.addItem(item6);
		w.addItem(item7);
		w.addItem(item8);
		int numItemsAfter = w.getNumItems();
		String expected = "Before=0, After=10";
		String actual = String.format("Before=%d, After=%d", numItemsBefore, numItemsAfter);

		System.out.println(expected);
		System.out.println(actual);
	}

	/**
	 * Add three items and retrieve the one at index 1.
	 */
	public static void testGetItem_WithIndex() {
		System.out.println("-->testGetItem_WithIndex");

		Warehouse w = createThreeItems();
		Item item = w.getItem(1);
		String name = item.getName();
		String expected = "Expected name=Chicken";
		String actual = "Actual name=" + name;

		System.out.println(expected);
		System.out.println(actual + "\n");
	}

	/**
	 * Add three items and retrieve the one at index -3.
	 */
	public static void testGetItem_WithInvalidIndex() {
		System.out.println("-->testGetItem_WithInvalidIndex");

		Warehouse w = createThreeItems();
		Item item = w.getItem(-3);
		String msg = "";
		if(item == null){
			msg = "null";
		}
		else{
			msg = item.getName();
		}
		String expected = "Expected name=null";
		String actual = "Actual name=" + msg;

		System.out.println(expected);
		System.out.println(actual + "\n");
	}

	/**
	 * Add three items and try to find one with a name that exists.
	 */
	public static void testGetItem_WithName() {
		System.out.println("-->testGetItem_WithName");

		Warehouse w = createThreeItems();
		Item item = w.getItem("Apple");
		String msg = "";
		if(item == null){
			msg = "null";
		}
		else{
			msg = item.getName();
		}
		String expected = "Expected name=Apple";
		String actual = "Actual name=" + msg;

		System.out.println(expected);
		System.out.println(actual + "\n");
	}

	/**
	 * Add three items and try to find one with a name that does not exist.
	 */
	public static void testGetItem_WithInvalidName() {
		System.out.println("-->testGetItem_WithInvalidName");

		Warehouse w = createThreeItems();
		Item item = w.getItem("Ben");
		String msg = "";
		if(item == null){
			msg = "null";
		}
		else{
			msg = item.getName();
		}
		String expected = "Expected name=null";
		String actual = "Actual name=" + msg;

		System.out.println(expected);
		System.out.println(actual + "\n");
	}

	/**
	 * Add 5 items, 3 of which are refrigerated. Verify the average temperature.
	 */
	public static void testGetAverageTemp() {
		System.out.println("-->testGetAverageTemp");

		Warehouse w = createFiveItems();
		double averageTemp = w.getAverageTemp();
		String expected = "Expected=27.31";
		String actual = String.format("Actual=%.2f", averageTemp);

		System.out.println(expected);
		System.out.println(actual + "\n");
	}
	
	/**
	 * Add 5 items, 3 of which are refrigerated. Verify that the 3 are returned in array.
	 */
	public static void testGetRefrigeratedItems() {
		System.out.println("-->testGetRefrigeratedItems");

		Warehouse w = createFiveItems();
		RefrigeratedItem[] r = w.getRefrigeratedItems();
		String expected = "Expected names=Chicken, Beef, Yogurt";
		String actual = String.format("Actual names=%s, %s, %s",
				r[0].getName(), r[1].getName(), r[2].getName());

		System.out.println(expected);
		System.out.println(actual + "\n");
	}
	
	/**
	 * Add 5 items, 3 of which are refrigerated. Verify the total cost.
	 */
	public static void testGetTotalCost() {
		System.out.println("-->testGetTotalCostRefrigerated");

		Warehouse w = createFiveItems();
		String expected = "Expected cost=39.21";
		String actual = String.format("Actual cost=%.2f", w.getTotalCost());

		System.out.println(expected);
		System.out.println(actual + "\n");
	}

	/**
	 * Add 5 items, 3 of which are refrigerated. Verify the total cost of the 3 refrigerated items
	 */
	public static void testGetTotalCostRefrigerated() {
		System.out.println("-->testGetTotalCostRefrigerated");

		Warehouse w = createFiveItems();
		String expected = "Expected cost=33.81";
		String actual = String.format("Actual cost=%.2f", w.getTotalCostRefrigerated());

		System.out.println(expected);
		System.out.println(actual + "\n");
	}

	/**
	 * Add 5 items, 3 of which are refrigerated. Remove the one at position 2 and 
	 * verify: the item is returned, and the number of items is decremented.
	 */
	public static void testRemoveItem_WithIndex() {
		System.out.println("-->testRemoveItem_WithIndex");

		Warehouse w = createFiveItems();
		int numItemsBefore = w.getNumItems();
		Item removedItem = w.removeItem(2);
		int numItemsAfter = w.getNumItems();
		String expected = "Expected name=Chicken, Before numItems=5, After numItems=4";
		String actual = String.format("Actual name=%s, Before numItems=%d, After numItems=%d",
										removedItem.getName(), numItemsBefore, numItemsAfter);
		System.out.println(expected);
		System.out.println(actual + "\n");
	}
	
	/**
	 * Add 5 items, 3 of which are refrigerated. Remove the one at position -2 and 
	 * verify: the item is not returned, and the number of items is not decremented.
	 */
	public static void testRemoveItem_WithIndex_invalid() {
		System.out.println("-->testRemoveItem_WithIndex_invalid");

		Warehouse w = createFiveItems();
		int numItemsBefore = w.getNumItems();
		Item removedItem = w.removeItem(-2);
		int numItemsAfter = w.getNumItems();
		String msg = "";

		if(removedItem == null){
			msg = "null";
		}
		else{
			msg = removedItem.getName();
		}

		String expected = "Expected name=null, Before numItems=5, After numItems=5";
		String actual = String.format("Actual name=%s, Before numItems=%d, After numItems=%d",
				msg, numItemsBefore, numItemsAfter);
		System.out.println(expected);
		System.out.println(actual + "\n");
	}

	/**
	 * Add 5 items, 3 of which are refrigerated. Remove one with a name that exists and 
	 * verify: the item is returned, and the number of items is decremented.
	 */
	public static void testRemoveItem_WithName() {
		System.out.println("-->testRemoveItem_WithName");

		Warehouse w = createFiveItems();
		int numItemsBefore = w.getNumItems();
		Item removedItem = w.removeItem("Chicken");
		int numItemsAfter = w.getNumItems();
		String expected = "Expected name=Chicken, Before numItems=5, After numItems=4";
		String actual = String.format("Actual name=%s, Before numItems=%d, After numItems=%d",
				removedItem.getName(), numItemsBefore, numItemsAfter);

		System.out.println(expected);
		System.out.println(actual + "\n");
	}

	/**
	 * Add 5 items, 3 of which are refrigerated. Remove one with a name that does not exist and
	 * verify: the item returns null, and the number of items is not decremented.
	 */
	public static void testRemoveItem_WithoutName() {
		System.out.println("-->testRemoveItem_WithoutName");

		Warehouse w = createFiveItems();
		int numItemsBefore = w.getNumItems();
		Item removedItem = w.removeItem("ben");
		int numItemsAfter = w.getNumItems();
		String msg = "";

		if(removedItem == null){
			msg = "null";
		}
		else{
			msg = removedItem.getName();
		}

		String expected = "Expected name=null, Before numItems=5, After numItems=5";
		String actual = String.format("Actual name=%s, Before numItems=%d, After numItems=%d",
				msg, numItemsBefore, numItemsAfter);
		System.out.println(expected);
		System.out.println(actual + "\n");
	}

	/**
	 * Verify that the toString method produces a string exactly
	 * as specified in the assignment document. 
	 */
	public static void testToString() {
		System.out.println("-->testToString");

		Warehouse w = createFiveItems();
		String expected =
				"name=Cookie, cost=$3.00, weight=1.50\n" +
				"name=Apple, cost=$2.40, weight=1.20\n" +
				"name=Chicken, cost=$10.78, weight=2.00, temp=32.20 degrees\n" +
				"name=Beef, cost=$12.47, weight=2.00, temp=15.30 degrees\n" +
				"name=Yogurt, cost=$10.56, weight=2.00, temp=34.43 degrees\n";
		String actual = w.toString();

		System.out.println("Expected=\n" + expected);
		System.out.println("Actual=\n" + actual);
	}

	// Helper Methods
	private static Warehouse createThreeItems(){
		Item item1 = new Item("Cookie", 1.5);
		Item refrigeratedItem1 = new RefrigeratedItem("Chicken", 2.00, 32.2);
		Item item2 = new Item("Apple", 1.2);

		Warehouse w = new Warehouse();
		w.addItem(item1);
		w.addItem(refrigeratedItem1);
		w.addItem(item2);

		return w;
	}

	private static Warehouse createFiveItems(){
		Item item1 = new Item("Cookie", 1.5);
		Item item2 = new Item("Apple", 1.2);
		Item refrigeratedItem1 = new RefrigeratedItem("Chicken", 2.00, 32.2);
		Item refrigeratedItem2 = new RefrigeratedItem("Beef", 2.00, 15.3);
		Item refrigeratedItem3 = new RefrigeratedItem("Yogurt", 2.00, 34.43);

		Warehouse w = new Warehouse();
		w.addItem(item1);
		w.addItem(item2);
		w.addItem(refrigeratedItem1);
		w.addItem(refrigeratedItem2);
		w.addItem(refrigeratedItem3);

		return w;
	}

	private static Warehouse createTenItems(){
		Item item1 = new Item("Cookie", 1.5);
		Item item2 = new Item("Apple", 1.2);
		Item item3 = new Item("Banana", 1.5);
		Item item4 = new Item("PopTart", 1.2);
		Item item5 = new Item("Bread", 1.5);
		Item item6 = new Item("Grapes", 1.2);
		Item item7 = new Item("Orange", 1.5);
		Item refrigeratedItem8 = new RefrigeratedItem("Chicken", 2.00, 32.2);
		Item refrigeratedItem9 = new RefrigeratedItem("Beef", 2.00, 32.2);
		Item refrigeratedItem10 = new RefrigeratedItem("Yogurt", 2.00, 32.2);

		Warehouse w = new Warehouse();
		w.addItem(item1);
		w.addItem(item2);
		w.addItem(item3);
		w.addItem(item4);
		w.addItem(item5);
		w.addItem(item6);
		w.addItem(item7);
		w.addItem(refrigeratedItem8);
		w.addItem(refrigeratedItem9);
		w.addItem(refrigeratedItem10);

		return w;
	}

	//My test methods
	/**
	 * Add 10 items, 3 of which are refrigerated. Remove the 10th item (index 9) and
	 * verify: the item is returned, and the number of items is decremented.
	 */
	public static void testRemoveItem_WithIndex9() {
		System.out.println("-->testRemoveItem_WithIndex");

		Warehouse w = createTenItems();
		int numItemsBefore = w.getNumItems();
		Item removedItem = w.removeItem(9);
		int numItemsAfter = w.getNumItems();
		String expected = "Expected name=Chicken, Before numItems=10, After numItems=9";
		String actual = String.format("Actual name=%s, Before numItems=%d, After numItems=%d",
				removedItem.getName(), numItemsBefore, numItemsAfter);
		System.out.println(expected);
		System.out.println(actual + "\n");

		System.out.println("toString=\n");
		System.out.println(w.toString());
	}
}
