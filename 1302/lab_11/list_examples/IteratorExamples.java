package list_examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class IteratorExamples {
    public static void main(String[] args) {
        iterateWithIterator();
        //removeWithForeachLoopIncorrect();
        removeWithLoopIncorrect();
        removeWithIterator();
    }
    public static void iterateWithIterator() {
        System.out.println("iterateWithIterator()\n");
        ArrayList<String> cities = new ArrayList<>(Arrays.asList("Dallas",
                "New York", "San Fransico", "Madison"));

        System.out.println("Iterator:");
        Iterator<String> iter = cities.iterator();
        while(iter.hasNext()) {
            String city = iter.next();
            System.out.println(city);
        }
        System.out.println();

    }
    public static void removeWithForeachLoopIncorrect() {
        System.out.println("\nRemove with foreach loop, incorrect");

        // Notice that there are 2 "New Yorks" in list
        ArrayList<String> cities = new ArrayList<>(Arrays.asList("Dallas",
                "New York", "San Fransico", "Madison"));

        // Remove cities whose name is "New York"
        for(String city : cities) {
            if(city.equals("New York")) {
                cities.remove(city);
            }
        }
    }
    public static void removeWithLoopIncorrect() {
        System.out.println("\nRemove with loop, incorrect");

        // Notice that there are 2 "New Yorks" in list
        ArrayList<String> cities = new ArrayList<>(Arrays.asList("Dallas",
                "New York", "New York", "San Fransico", "Madison"));

        System.out.println("\nBefore removing New York");
        System.out.println(cities);

        // loop approach
        for(int i=0; i<cities.size(); i++) {
            if(cities.get(i).equals("New York")) {
                cities.remove(i);
            }
        }
        System.out.println("\nAfter removing New York");
        System.out.println(cities);
    }
    public static void removeWithIterator() {
        // Notice that there are 2 "New Yorks" in list
        ArrayList<String> cities = new ArrayList<>(Arrays.asList("Dallas",
                "New York", "New York", "San Fransico", "Madison"));

        System.out.println("\nRemove with iterator");

        System.out.println("\nBefore removing New York");
        System.out.println(cities);

        // iterator()
        Iterator<String> iter = cities.iterator();
        while( iter.hasNext() ) {
            String city = iter.next();
            if(city.equals("New York")) {
                iter.remove();
            }
        }
        System.out.println("\nAfter removing New York");
        System.out.println(cities);

    }

}

