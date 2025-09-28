package comparable_examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Examples1 {

    public static void main(String[] args){
        compareStrings();
        sortBoxes();
        sortPersons();
    }

    public static void compareStrings(){
        String x = "Atlanta";
        String y = "Denver";
        String z = new String("Atlanta");

        System.out.println("x=" + ", y=" + ", z= " + z);
        int diff1 = x.compareTo(y);
        System.out.println("x.compareTo(y)=" + diff1);
        int diff2 = y.compareTo(z);
        System.out.println("y.compareTo(z)=" + diff2);
        int diff3 = x.compareTo(z);
        System.out.println("x.compareTo(z)=" + diff3);
    }

    public static void sortBoxes(){
        System.out.println("\nSort Boxes");
        ArrayList<Box> boxes = new ArrayList<>(Arrays.asList(
                new Box(5,5,5), new Box(2,2,5), new Box(3,3,3)
        ));
        Collections.sort(boxes);
        Box min = Collections.min(boxes);
        Box max = Collections.max(boxes);

        System.out.println("smallest box: " + min);
        System.out.println("largest box: " + max);
        System.out.println("sorted boxes: " + boxes);
    }

    public static void sortPersons(){
        System.out.println("\nSort Persons");
        ArrayList<Person> persons = new ArrayList<>(Arrays.asList(
                new Person("Xav"), new Person("Ana"), new Person("Mimi")
        ));
        Collections.sort(persons);
        Person min = Collections.min(persons);
        Person max = Collections.max(persons);

        System.out.println("smallest person: " + min);
        System.out.println("largest person: " + max);
        System.out.println("sorted persons: " + persons);
    }
}
