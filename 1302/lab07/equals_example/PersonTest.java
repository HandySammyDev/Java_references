package lab07.equals_example;

import java.util.ArrayList;
import java.util.Arrays;

public class PersonTest {

    public static void main(String[] args){
        testEquals();
        testContains();
    }

    public static void testEquals(){
        System.out.println("-->testEquals()");
        Person p1 = new Person("Shay", 123);
        Person p2 = new Person("Shay", 456);
        Person p3 = new Person("Julie", 123);

        System.out.println(p1.equals(p2)); //false
        System.out.println(p1.equals(p3)); //true

        // Remember that "==" return true when two
        // objects occupy the same place in memory.
        // Thus p1 and p3 are "logically" equal even
        // though they occupy different places in memory.

        System.out.println(p1==p3); //false
    }
    public static void testContains(){
        System.out.println("\n-->testContains()");
        ArrayList<Person> people = new ArrayList<>(Arrays.asList(
                new Person("Shay",  811),
                new Person("Xavier", 456),
                new Person("Layla", 123),
                new Person("Malik", 224)
        ));

        // Suppose we know a person's SSN and we want
        // to see if they are in the list. We can create
        // a "dummy" person object:

        Person p1 = new Person("Unknown", 123);

        // Then pass the dummy person to the contains method.
        // Remember that the contains method is relying on the
        // equals method to decide if the person is in the list,
        // and that the equals method is only looking at the
        // SSN, so that the name doesn't matter.

        if(people.contains(p1)){
            int loc = people.indexOf(p1);
            Person pFound = people.get(loc);
            System.out.println(pFound);
        }

        Person p2 = new Person("Unknown", 999);

        if(people.contains(p2)){
            System.out.println(p2 + " - found");
        }
        else {
            System.out.println(p2 + " - not found");
        }
    }
}
