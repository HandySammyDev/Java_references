package list_examples;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExamples {

    public static void main(String[] args) {
        System.out.println("ArrayList Examples\n");
        example1();
        example2();
    }

    // Illustrates addAll, retainAll, removeAll methods
    private static void example1() {
        System.out.println("example1()-illustrates addAll, retainAll, removeAll methods)");
        System.out.println("------------------------------------------------------------");
        ArrayList<String> cities = new ArrayList<String>();
        cities.add("New York");
        cities.add("San Francisco");
        System.out.println("cities: " + cities);

        // Create another ArrayList of cities
        ArrayList<String> cities2 = new ArrayList<>();
        cities2.add("Charlotte");
        cities2.add("Atlanta");
        System.out.println("cities2: " + cities2);

        // addAll() - Adds all the elements of "cites2" to "cities1".
        // This is the union of two lists.
        cities.addAll(cities2);
        System.out.println("cities after cities.addAll(cities2): " + cities);

        // Create another ArrayList of cities
        ArrayList<String> cities3 = new ArrayList<>();
        cities3.add("Charlotte");
        cities3.add("Durango");
        cities3.add("New York");
        System.out.println("\ncities: " + cities);
        System.out.println("cities3: " + cities3);

        // retainAll() - This method takes the intersection of the two lists
        // and stores the result in "cities".
        cities.retainAll(cities3);
        System.out.println("cities after cities.retainAll(cities3):" + cities);

        // Add a few more cities to "cities"
        cities.add("Rock Hill");
        cities.add("Little Rock");
        System.out.println("\ncities: " + cities);
        // Create another ArrayList of cities
        ArrayList<String> cities4 = new ArrayList<>();
        cities4.add("Charlotte");
        cities4.add("Seattle");
        cities4.add("Little Rock");
        System.out.println("cities4: " + cities4);

        // removeAll() - Removes from "cities" any cities that are also in "cities4".
        // This is set subtraction.
        cities.removeAll(cities4);
        System.out.println("cities after cities.removeAll(cities4): " + cities);
    }

    // Illustrates subList method and alternate constructor
    private static void example2() {
        System.out.println("\nexample2()-illustrates subList method and alternate constructor)");
        System.out.println("-----------------------------------------------------------------");
        ArrayList<String> cities = new ArrayList<String>();
        cities.add("New York");
        cities.add("San Francisco");
        cities.add("Charlotte");
        cities.add("Atlanta");
        cities.add("Durango");

        System.out.println("cities: " + cities);

        // Returns a List, not an ArrayList
        List<String> cities2 = cities.subList(2, 4);

        System.out.println("List<String> cities2 = cities.subList(2,4): " + cities2);

        // Can create an ArrayList from any Collection (List, ArrayList, etc)
        ArrayList<String> cities3 = new ArrayList<>(cities2);
        System.out.println("ArrayList<String> cities3: " + cities3);
        // Add a duplicate city to cities3
        cities3.add("Charlotte");
        System.out.println("\ncities3: " + cities3);

        cities3.remove("Charlotte");
        System.out.println("cities3 after cities3.remove('Charlotte'): " + cities3);
    }
}

