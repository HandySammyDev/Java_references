package lab07.array_list;

import java.util.ArrayList;

public class ArrayListExamples {
    public static void main(String[] args){

        ArrayList<String> cities = new ArrayList<>();

        cities.add("New York");
        cities.add("Chicago");
        cities.add("Atlanta");

        String city = cities.get(1);
        System.out.println("-->Illustrate get(i) method:");
        System.out.println(city);

        int size = cities.size();
        System.out.println("\n-->Illustrate size() method:");
        System.out.println(size);

        System.out.println("\n-->Illustrate enhanced for loop:");
        for(String c : cities){
            System.out.println(c + " ");
        }
        System.out.println();

        System.out.println("\n-->Illustrate indexed for loop:");
        for(int i=0; i<cities.size(); i++){
            System.out.println(cities.get(i) + " ");
        }
        System.out.println();

        System.out.println("\n-->Illustrate indexed for loop:");
        for(int i=0; i<cities.size(); i++){
            System.out.println(cities.get(i) + " ");
        }
        System.out.println();

        System.out.println("\n-->Illustrate add(index,object) method:");
        cities.add(1, "Memphis");
        for(String c : cities){
            System.out.println(c + " ");
        }
        System.out.println();

        System.out.println("\n-->Illustrate toString method:");
        System.out.println(cities.toString());

        System.out.println("\n-->Illustrate contains(object) method:");
        System.out.println("Is Memphis in list? " + cities.contains("Memphis"));
        System.out.println("Is Seattle in list? " + cities.contains("Seattle"));

        System.out.println("\n-->Illustrate indexOf(object) method:");
        System.out.println("What is location of Chicago in list? " +
                cities.indexOf("Chicago"));
        System.out.println("What is location of Detroit in list? " +
                cities.indexOf("Detroit"));

        System.out.println("\n-->Illustrate remove(index) method:");
        System.out.println("list before remove: ");
        System.out.println(cities.toString());
        String cRemoved = cities.remove(2);
        System.out.print("list after remove : ");
        System.out.println(cities.toString());
        System.out.println("city removed: " + cRemoved);

        System.out.println("\n-->Illustrate remove(object) method:");
        System.out.print("list before remove: ");
        System.out.println(cities.toString());
        cities.remove("Memphis");
        System.out.println("list after remove : ");
        System.out.println(cities.toString());

        System.out.println("\n-->Illustrate addAll(list) method:");
        // Create a new list of cities
        ArrayList<String> cities2 = new ArrayList<>();
        cities2.add("Oakland");
        cities2.add("Portland");

        System.out.print("cities: ");
        System.out.println(cities);
        System.out.print("cities2: ");
        System.out.println(cities2);

        // Add new list to original list
        cities.addAll(cities2);
        System.out.print("cities after addAll: ");
        System.out.println(cities);

        System.out.println("\n-->Illustrate constructor that accepts another list:");
        ArrayList<String> cities3 = new ArrayList<>(cities);
        System.out.print("cities : ");
        System.out.println(cities);
        System.out.print("cities3: ");
        System.out.println(cities3);

        System.out.println("\n-->Illustrate isEmpty & clear methods:");
        System.out.println("is cities empty? " + cities.isEmpty() + ", size=" + cities.size());
        cities.clear();
        System.out.println("is cities empty? " + cities.isEmpty() + ", size=" + cities.size());
    }
}
