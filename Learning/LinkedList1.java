package Learning;

import java.util.LinkedList;

public class LinkedList1 {
    public static void main(String[] args){
        //LinkedList = stores Nodes in 2 parts (data + address)
        /*             Nodes are in non-consecutive memory locations (Each node can be anywhere in comp. memory)
                       Elements are linked using pointers.

                                   Single LinkedList
                   Node                 Node                    Node
            [data | address]  ->   [data | address]   ->   [data | address]

                                   Double LinkedList
                        Node                            Node
            [address | data | address]  <->  [address | data | address]

            advantages?
            1. Dynamic data structure (allocates needed memory while running)
            2. Insertion and deletion of Nodes is easy. O(1)
            3. No/Low memory waste

            disadvantages?
            1. Greater memory usage (additional pointer)
            2. No random access of elements (no index[i])
            3. Accessing/searching elements is more time consuming. O(n)

            Uses?
            1. implements Stacks/Queues
            2. Gps navigation (Starting position -> Ending position. Each stop is a Node and if you need to change routes
                , you can easily change or delete a node)
            3. Music playlist
        */


        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.offer("A");
        linkedList.offer("B");
        linkedList.offer("C");
        linkedList.offer("D");
        linkedList.offer("F");

        //linkedList.pop();
        //linkedList.push();

        linkedList.add(4, "E");
        linkedList.remove("E");
        System.out.println(linkedList.indexOf("F"));

        System.out.println(linkedList.peekFirst());
        System.out.println(linkedList.peekLast());
        linkedList.addFirst("0");
        linkedList.addLast("G");

        System.out.println(linkedList);
    }
}
