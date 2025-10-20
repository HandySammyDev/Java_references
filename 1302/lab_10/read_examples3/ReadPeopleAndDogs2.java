package read_examples3;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class ReadPeopleAndDogs2 {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();
        File inFile = new File( "src/read_examples3/peopleAndDogs2.txt" );

        try {
            Scanner input = new Scanner(inFile);
            while(input.hasNext()) {

                String line = input.nextLine();
                String[] tokens = line.split("\\s");
                String name = tokens[0];
                Person p = new Person(name);
                for(int i=1; i<tokens.length; i++){
                    String dogName = tokens[i];
                    Dog dog = new Dog(dogName);
                    p.addDog(dog);
                }
                people.add(p);
            }
            input.close();
        }
        catch( IOException e ) {
            System.out.println(e);
        }

        for(Person p : people) {
            System.out.println(p);
        }
    }

}
