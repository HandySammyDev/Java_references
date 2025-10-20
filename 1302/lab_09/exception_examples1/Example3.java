package exception_examples1;

public class Example3 {

    public static void main(String[] args) {
        int x=0;
        try {
            System.out.println(inverse(x));

        }
        catch(ArithmeticException e) {
            System.out.println("exception caught");
        }
        finally {
            System.out.println("finally block executed");
        }
        System.out.println("all done");
    }

    public static double inverse(int x) {
        return 1/x;
    }
}
