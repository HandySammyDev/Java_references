package Learning;

public class FactorialRecursiveMethod {
    public static void main(String[] args){
        System.out.println(factorial(7));
    }
    private static int factorial(int num){ // Taking a recursive approach
        if(num < 1) return 1; // Base case
        return num * factorial(num - 1); //recursive
    }
}
