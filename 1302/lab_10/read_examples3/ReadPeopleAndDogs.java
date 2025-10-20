package read_examples3;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class ReadPeopleAndDogs {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();
        File inFile = new File( "src/read_examples3/peopleAndDogs.txt" );

        try {
            Scanner input = new Scanner( inFile );
            while( input.hasNext() ) {
                String name = input.next();
                Person p = new Person(name);
                int numDogs = input.nextInt();
                for(int i=0; i<numDogs; i++){
                    String dogName = input.next();
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

