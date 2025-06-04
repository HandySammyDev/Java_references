package Learning;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.SynchronousQueue;

public class Queues {
    public static void main(String[] args){
        //Queue = FIFO data structure. First-In First-Out (ex. A line of people)
        //        A collection designed for holding elements prior to processing
        //        Linear data structure

        //        add = enqueue, offer()
        //        remove = dequeue, poll()

        Queue<String> queue = new LinkedList<>();

        queue.offer("Karen");
        queue.offer("Chad");
        queue.offer("Steve" );
        queue.offer("Harold");

        System.out.println("Is empty: " + queue.isEmpty());
        System.out.println("Size: " + queue.size());
        System.out.println(queue.contains("Harold"));
        System.out.println(queue.peek());

        queue.poll();
        System.out.println(queue);
        queue.poll();
        System.out.println(queue);

        // Useful:
        // 1. Keyboard Buffer (Letters should appear on screen in the order they're pressed, FIFO)
        // 2. Printer Queue (Print jobs should be completed in order)
        // 3. Used in LinkedLists, PriorityQueues, Breadth-first search
    }
}
