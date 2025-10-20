package exception_examples1;

import java.util.ArrayList;

public class Example4 {

    public static void main(String[] args) {
        //ArrayList<Integer> ints = new ArrayList<>(Arrays.asList(4,6,0,3,5));
        ArrayList<Integer> ints = null;
        int x, y;
        //x=1; y=3;  // No exception thrown
        x=1; y=2;  // Arithmetic exception thrown
        //x=1; y=20; // Index out of bounds exception thrown
        try {
            System.out.println( divide(ints, x, y));
        }
        catch(RuntimeException e) {
            System.out.println("Exception Caught:");
            System.out.println(e);
        }
        finally {
            System.out.println("finally block executed");
        }
        System.out.println("all done!");
    }

    public static double divide(ArrayList<Integer> ints, int x, int y) {
        return ints.get(x)/ints.get(y);
    }
}
