package Learning;

public class FactorialRecursiveMethod {
    // Recursive = when a thing is defined in terms of itself.
    //             Apply the result of a procedure, to a procedure.
    //             A recursive method calls itself. Can be a substitute for iteration.
    //             Divide a problem into sub-problems of the same type as the original.
    //             Commonly used with advanced sorting algorithms and navigating trees

    //             Advantages
    //             -----------
    //             easier to read/write
    //             easier to debug

    //             Disadvantage
    //             ------------
    //             sometimes slower
    //             uses more memory
    
    public static void main(String[] args){
        System.out.println(factorial(7));
    }
    private static int factorial(int num){ // Taking a recursive approach
        if(num < 1) return 1; // Base case
        return num * factorial(num - 1); //recursive
    }
}
