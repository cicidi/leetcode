package algorithm.core_java;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueImpl<T> {
    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>((x, y) -> x - y);
        queue.add(5);
        queue.add(1);
        queue.add(3);
        queue.add(2);
        queue.add(4);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
    }

}
