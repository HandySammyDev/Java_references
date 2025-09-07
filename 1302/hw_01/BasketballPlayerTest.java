package prob1;

public class BasketballPlayerTest {

	public static void main(String[] args) {
		testShootFreeThrows();
		testShootTwoPointers();
		testShootThreePointers();
		testGetTotalPoints_OnlyFreeThrows();
		testGetTotalPoints_OnlyTwoPointers();
		testGetTotalPoints_OnlyThreePointers();
		testGetTotalPoints();
		testToString();
	}

	private static void testShootFreeThrows() {
		System.out.println("-->testShootFreeThrows()");
		BasketballPlayer p = new BasketballPlayer("Paul");
		p.shootFreeThrow(true);
		p.shootFreeThrow(true);
		p.shootFreeThrow(false);
		p.shootFreeThrow(true);
		p.shootFreeThrow(false);
		int numMade = p.getFreeThrowsMade();
		int numAtt = p.getFreeThrowsAttempted();
		double percent = p.getFreeThrowPercent();
		String msgExpected = String.format("Expected: made=%d, attempted=%d, percent=%.1f%%", 3, 5, 60.0);
		String msgActual =   String.format("  Actual: made=%d, attempted=%d, percent=%.1f%%", numMade, numAtt, percent);
		System.out.println(msgExpected);
		System.out.println(msgActual);
	}

	private static void testShootTwoPointers() {
		System.out.println("\n-->testShootTwoPointers()");
		BasketballPlayer p = new BasketballPlayer("Paul");
		p.shootTwoPointer(false);
		p.shootTwoPointer(true);
		p.shootTwoPointer(false);
		p.shootTwoPointer(true);
		p.shootTwoPointer(false);
		int numMade = p.getTwoPointersMade();
		int numAtt = p.getTwoPointersAttempted();
		double percent = p.getTwoPointerPercent();
		String msgExpected = String.format("Expected: made=%d, attempted=%d, percent=%.1f%%", 2, 5, 40.0);
		String msgActual =   String.format("  Actual: made=%d, attempted=%d, percent=%.1f%%", numMade, numAtt, percent);
		System.out.println(msgExpected);
		System.out.println(msgActual);
	}

	private static void testShootThreePointers() {
		System.out.println("\n-->testShootThreePointers()");
		BasketballPlayer p = new BasketballPlayer("Paul");
		p.shootThreePointer(false);
		p.shootThreePointer(true);
		p.shootThreePointer(false);
		p.shootThreePointer(true);
		p.shootThreePointer(false);
		int numMade = p.getThreePointersMade();
		int numAtt = p.getThreePointersAttempted();
		double percent = p.getThreePointerPercent();
		String msgExpected = String.format("Expected: made=%d, attempted=%d, percent=%.1f%%", 2, 5, 40.0);
		String msgActual =   String.format("  Actual: made=%d, attempted=%d, percent=%.1f%%", numMade, numAtt, percent);
		System.out.println(msgExpected);
		System.out.println(msgActual);
	}

	private static void testGetTotalPoints_OnlyFreeThrows() {
		System.out.println("\n-->testGetTotalPoints_OnlyFreeThrows()");
		BasketballPlayer p = new BasketballPlayer("Paul");
		p.shootFreeThrow(true);
		p.shootFreeThrow(true);
		p.shootFreeThrow(false);
		int numPoints = p.getTotalPoints();
		String msgExpected = String.format("Expected: points=%d", 2);
		String msgActual =   String.format("  Actual: points=%d", numPoints);
		System.out.println(msgExpected);
		System.out.println(msgActual);
	}

	private static void testGetTotalPoints_OnlyTwoPointers() {
		System.out.println("\n-->testGetTotalPoints_OnlyTwoPointers()");
		BasketballPlayer p = new BasketballPlayer("Paul");
		p.shootTwoPointer(true);
		p.shootTwoPointer(false);
		p.shootTwoPointer(true);
		int numPoints = p.getTotalPoints();
		String msgExpected = String.format("Expected: points=%d", 4);
		String msgActual =   String.format("  Actual: points=%d", numPoints);
		System.out.println(msgExpected);
		System.out.println(msgActual);
	}

	private static void testGetTotalPoints_OnlyThreePointers() {
		System.out.println("\n-->testGetTotalPoints_OnlyThreePointers()");
		BasketballPlayer p = new BasketballPlayer("Paul");
		p.shootThreePointer(true);
		p.shootThreePointer(true);
		p.shootThreePointer(false);
		int numPoints = p.getTotalPoints();
		String msgExpected = String.format("Expected: points=%d", 6);
		String msgActual =   String.format("  Actual: points=%d", numPoints);
		System.out.println(msgExpected);
		System.out.println(msgActual);
	}

	private static void testGetTotalPoints() {
		System.out.println("\n-->testGetTotalPoints()");
		BasketballPlayer p = new BasketballPlayer("Paul");
		p.shootThreePointer(false);
		p.shootTwoPointer(false);
		p.shootFreeThrow(true);
		p.shootFreeThrow(true);
		p.shootTwoPointer(true);
		p.shootThreePointer(false);
		p.shootThreePointer(true);
		p.shootFreeThrow(false);
		p.shootTwoPointer(true);
		p.shootThreePointer(false);
		p.shootThreePointer(true);

		int numPoints = p.getTotalPoints();
		String msgExpected = String.format("Expected: points=%d", 12);
		String msgActual =   String.format("  Actual: points=%d", numPoints);
		System.out.println(msgExpected);
		System.out.println(msgActual);
	}

	private static void testToString() {
		System.out.println("\n-->testToString()");
		BasketballPlayer p = new BasketballPlayer("Paul");
		p.shootThreePointer(false);
		p.shootTwoPointer(false);
		p.shootFreeThrow(true);
		p.shootFreeThrow(true);
		p.shootTwoPointer(true);
		p.shootThreePointer(false);
		p.shootThreePointer(true);
		p.shootFreeThrow(false);
		p.shootTwoPointer(true);
		p.shootThreePointer(false);
		p.shootThreePointer(true);

		System.out.println(p);
	}
}
