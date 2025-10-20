package read_examples;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadExample3 {

    public static void main(String[] args){
        String fileName = "src/read_examples/numbers1.txt";
        System.out.println("Trying to read: " + "\"" + fileName + "\"");
        File inFile = new File(fileName);
        boolean doesExist = inFile.exists();
        System.out.println("Does " + "\"" + fileName + "\"" + " exist?" + doesExist);
        if(doesExist){
            System.out.println("Contents of file:");
            try {
                Scanner input = new Scanner(inFile);
                while(input.hasNext()){
                    try {
                        int val = input.nextInt();
                        System.out.print(val + " ");
                    }
                    catch(InputMismatchException ie) {
                        // Read the token as a string. Note, since, nextInt, which
                        // cause the exception, didn't actually read a value, the marker (cursor)
                        // for where to begin reading has not been advanced. Thus, the call to next
                        // will read the value.
                        String badValue = input.next();
                        System.out.print("Skipped:" + badValue + " ");
                    }
                }
            } catch (IOException e) {
                System.out.println("Error reading file");
            }
        }
        else {
            System.out.println("Can't find file");
        }

    }
}
