package lab07.array_list;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class ArrayListExamples2 {
    public static void main(String[] args){
        System.out.println("\n-->Illustrate Arrays.asList:");
        String[] citiesAry = {"Boston", "Philly", "Norfolk"};
        ArrayList<String> cities = new ArrayList<>(Arrays.asList(citiesAry));
        System.out.println(cities);

        System.out.println("\n-->Illustrate Arrays.asList, again");
        ArrayList<String> cities2 = new ArrayList<>(Arrays.asList("SF", "KC", "NYC"));
        System.out.println(cities2);

        System.out.println("\n-->Illustrate Collections methods:");
        System.out.println("before sort: " + cities);
        Collections.sort(cities);
        System.out.println("after sort : " + cities);
        System.out.println("'min' city: " + Collections.min(cities));
        System.out.println("'max' city: " + Collections.max(cities));

    }
}
