package write_examples;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteArray {

    public static void main(String[] args) {
        int[] nums = {33, 44, 55, 66, 12, 33, 55, 66, 77, 22};

        File outFile = new File( "src/write_examples/numbers.txt" );

        try {
            PrintWriter writer = new PrintWriter( outFile );
            for( int i=0; i<nums.length; i++ ) {
                writer.print( nums[i] + " " );
            }
            writer.close();
            System.out.println( "File written" );
        }
        catch (IOException ioe) {
            System.out.println("Problem creating file or writing");
        }
    }
}

