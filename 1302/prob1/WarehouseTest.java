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
	}
	
	/**
	 * Add one item and check the number of items to verify.
	 */
	public static void testAddItem() {
		System.out.println("-->testAddItem"); 
		System.out.println("NOT IMPLEMENTED"); 
	}
	
	/**
	 * Add three items and check the number of items to verify. At least one should be a refrigerated item.
	 */
	public static void testAddItem_Multiple() {
		System.out.println("-->testAddItem_Multiple"); 
		System.out.println("NOT IMPLEMENTED"); 
	}
	
	/**
	 * Add eleven items and check the number of items to verify. This goes over the max number of items, and therefore
	 * shouldn't increase after 10 At least one should be a refrigerated item.
	 */
	public static void testAddItem_Multiple_11() {
		System.out.println("-->testAddItem_Multiple_11"); 
		System.out.println("NOT IMPLEMENTED"); 
	}

	/**
	 * Add three items and retrieve the one at index 1.
	 */
	public static void testGetItem_WithIndex() {
		System.out.println("-->testGetItem_WithIndex"); 
		System.out.println("NOT IMPLEMENTED"); 
	}

	/**
	 * Add three items and retrieve the one at index -3.
	 */
	public static void testGetItem_WithInvalidIndex() {
		System.out.println("-->testGetItem_WithInvalidIndex"); 
		System.out.println("NOT IMPLEMENTED"); 
	}

	/**
	 * Add three items and try to find one with a name that exists.
	 */
	public static void testGetItem_WithName() {
		System.out.println("-->testGetItem_WithName"); 
		System.out.println("NOT IMPLEMENTED"); 
	}

	/**
	 * Add three items and try to find one with a name that does not exist.
	 */
	public static void testGetItem_WithInvalidName() {
		System.out.println("-->testGetItem_WithInvalidName"); 
		System.out.println("NOT IMPLEMENTED"); 
	}

	/**
	 * Add 5 items, 3 of which are refrigerated. Verify the average temperature.
	 */
	public static void testGetAverageTemp() {
		System.out.println("-->testGetAverageTemp"); 
		System.out.println("NOT IMPLEMENTED"); 
	}
	
	/**
	 * Add 5 items, 3 of which are refrigerated. Verify that the 3 are returned in array.
	 */
	public static void testGetRefrigeratedItems() {
		System.out.println("-->testGetRefrigeratedItems"); 
		System.out.println("NOT IMPLEMENTED"); 
	}
	
	/**
	 * Add 5 items, 3 of which are refrigerated. Verify the total cost.
	 */
	public static void testGetTotalCost() {
		System.out.println("-->testGetTotalCostRefrigerated"); 
		System.out.println("NOT IMPLEMENTED"); 
	}

	/**
	 * Add 5 items, 3 of which are refrigerated. Verify the total cost of the 3 refrigerated items
	 */
	public static void testGetTotalCostRefrigerated() {
		System.out.println("-->testGetTotalCostRefrigerated"); 
		System.out.println("NOT IMPLEMENTED"); 
	}

	/**
	 * Add 5 items, 3 of which are refrigerated. Remove the one at position 2 and 
	 * verify: the item is returned, and the number of items is decremented.
	 */
	public static void testRemoveItem_WithIndex() {
		System.out.println("-->testRemoveItem_WithIndex"); 
		System.out.println("NOT IMPLEMENTED"); 
	}
	
	/**
	 * Add 5 items, 3 of which are refrigerated. Remove the one at position -2 and 
	 * verify: the item is not returned, and the number of items is not decremented.
	 */
	public static void testRemoveItem_WithIndex_invalid() {
		System.out.println("-->testRemoveItem_WithIndex_invalid"); 
		System.out.println("NOT IMPLEMENTED"); 
	}

	/**
	 * Add 5 items, 3 of which are refrigerated. Remove one with a name that exists and 
	 * verify: the item is returned, and the number of items is decremented.
	 */
	public static void testRemoveItem_WithName() {
		System.out.println("-->testRemoveItem_WithName"); 
		System.out.println("NOT IMPLEMENTED"); 
	}

	/**
	 * Add 5 items, 3 of which are refrigerated. Remove one with a name that does not exist and
	 * verify: the item returns null, and the number of items is not decremented.
	 */
	public static void testRemoveItem_WithoutName() {
		System.out.println("-->testRemoveItem_WithoutName"); 
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
