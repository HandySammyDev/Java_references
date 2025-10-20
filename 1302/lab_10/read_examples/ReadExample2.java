package read_examples;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ReadExample2 {

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
                    String token = input.nextLine(); //Read the whole line
                    System.out.print(token + " ");
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
