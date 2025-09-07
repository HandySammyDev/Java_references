package Learning;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueues {
    public static void main(String[] args){
        // Priority Queue = A FIFO data structure that serves elements
        //                  With the highest priorities first
        //                  Before elements with lower priority
        //                  A - Z
        //                  1 - 100

        Queue<String> queue = new PriorityQueue<>(Collections.reverseOrder());

        queue.offer("B");
        queue.offer("C");
        queue.offer("A");
        queue.offer("F");
        queue.offer("D");
        queue.offer("L");

        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
