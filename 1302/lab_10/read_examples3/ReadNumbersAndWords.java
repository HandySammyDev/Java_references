package read_examples3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadNumbersAndWords {
    public static void main(String[] args){
        ArrayList<Integer> ints = new ArrayList<>();
        ArrayList<String> words = new ArrayList<>();
        File inFile = new File( "src/read_examples3/numbersAndWords.txt" );

        try {
            Scanner input = new Scanner( inFile );
            while( input.hasNext() ) {
                String token = input.next();
                if(token.matches("\\d+")) {
                    int x = Integer.parseInt(token);
                    ints.add(x);
                }
                else {
                    words.add(token);
                }
            }
            input.close();
        }
        catch( IOException e ) {
            System.out.println(e);
        }

        System.out.println(" ints: " + ints);
        System.out.println("words: " + words);

    }

    public static boolean isAnInteger(String strNum) {
        if (strNum==null) {
            return false;
        }
        try {
            int val = Integer.parseInt(strNum);
            return true;
        }
        catch (NumberFormatException nfe) {
            return false;
        }
    }
}
