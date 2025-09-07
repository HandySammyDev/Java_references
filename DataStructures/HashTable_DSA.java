package PracticeBroCode; //Delete this line

import java.util.Hashtable;

public class HashTable_DSA {

    // Hashtable = A data structure that stores unique keys to values ex.<Integer, String>
    //             Each key/value pair is known as an Entry
    //             FAST insertion, look up, deletion of key/value pairs
    //             Not ideal for small data sets, great with large data sets

    // hashing = takes a key and computes an integer (formula will vary based on key & data type)
    //           In a Hashtable, we use the hash % capacity to calculate an index number

    //           key.hashCode() % capacity = index

    // bucket = an indexed storage location for one or more Entries
    //          can store multiple Entries in case of a collision (linked similarly a LinkedList)

    // collision = hash function generates the same index for more than one key
    //             less collisions = more efficiency

    // Runtime complexity: Best Case O(1);
    //                     Worst Case O(n)

    public static void main(String[] args){

        //Have an initial capacity of (11) and load factor (0.75)
        Hashtable<Integer, String> table = new Hashtable<>(10);

        table.put(100, "SpongeBob");
        table.put(123, "Patrick");
        table.put(321, "Sandy");
        table.put(555, "Squidward");
        table.put(777, "Gary");

        //table.remove(777);

        //Module 10 can access the index in the list (hashtable)
        for(Integer key : table.keySet()){
            System.out.println((key.hashCode() % 10) + "\t" + key + "\t" + table.get(key));
        }
    }
}
