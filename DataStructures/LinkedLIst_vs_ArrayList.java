package PracticeBroCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class LinkedLIst_vs_ArrayList {
    public static void main(String[] a){
        LinkedList<Integer> linkedList = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        long startTime;
        long endTime;
        long elapsedTime;

        for(int i=0; i<1000000; i++){
            linkedList.add(i);
            arrayList.add(i);
        }

        //-------------------LinkedList-----------------------
        startTime = System.nanoTime();

        //linkedList.get(0);            //Faster to get the start and end since it's a doubly linked-list
        //linkedList.get(500000);       //It starts from the head and tail so the most middle item will be super slow to get
        //linkedList.get(999999);       // *** Accessing and item in a linked-list is slower since we go through the list***

        //linkedList.remove(0);
        //linkedList.remove(500000);     // Slower bc we still had to navigate to the middle
        linkedList.remove(999999); // Bit slow but the fast bc its at the end

        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("LinkedList:\t" + elapsedTime + " ns");

        //-------------------ArrayList-----------------------
        startTime = System.nanoTime();

        //arrayList.get(0);
        //arrayList.get(500000);
        //arrayList.get(999999);        // *** Accessing and item in an array-list is faster since we can randomly pick where ***

        //arrayList.remove(0);          // The reason this takes so long is bc we have to shift all the elements
        //arrayList.remove(500000);     // Faster bc less elements to shift
        arrayList.remove(999999); // Faster bc no items are shifted

        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("ArrayList:\t" + elapsedTime + " ns");

        /*                              Summary:
        In most cases an arraylist is better and faster when accessing random indexes.
        But if you have to do a lot of inserting or deleting, especially in a large data set,
        than a linked-list is better.
         */
    }
}
