package write_examples;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReadWriteIntegers {

    public static void main(String[] args) {
        File inFile = new File( "src/write_examples/numbers2.txt" );
        File outFile = new File( "src/write_examples/bigNumbers.txt" );

        try {
            Scanner input = new Scanner(inFile);
            PrintWriter writer = new PrintWriter(outFile);
            while( input.hasNext() ) {
                int val = input.nextInt();
                if(val > 99) {
                    writer.print(val + " ");
                }
            }
            input.close();
            writer.close();
            System.out.println("Program completed successfully");
        }
        catch( IOException e ) {
            System.out.println(e);
        }
    }
}