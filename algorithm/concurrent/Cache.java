package concurrent;

import java.util.concurrent.*;

/**
 * @author walter chen on 2019-12-04
 */

// The solution to high concurrency problem is to store high volumes of request in a message queue(BlockingQueue, Kafka, Database).
// and use multithreading to consume the message queue.
// in the real production we might use
//      1. CQRS pattern,
//      2. Kafka,
//      3. Akka cluster
//  to handle high concurrency
//
// Reference to this project
// https://juejin.im/entry/5acecbaf5188255580029d1c
// https://www.baeldung.com/java-blocking-queue
// https://dzone.com/articles/java-8-concurrenthashmap-atomic-updates
public class Cache {

    // Use the blocking queue to store all `add` request
    private BlockingQueue<Integer[]> queue = new LinkedBlockingQueue<>();
    // No. of consumer equal to No. of CPU core
    private int N_CONSUMERS = Runtime.getRuntime().availableProcessors();
    // key and value cache
    private ConcurrentHashMap<Integer, Integer> kvMap = new ConcurrentHashMap<>();

    public Cache() {
        for (int j = 0; j < N_CONSUMERS; j++) {
            new Thread(new Consumer(queue, kvMap)).start();
        }
    }

    public void add(int k, int v) throws InterruptedException {
        // put() –inserts the specified element into a queue, waiting for a free slot if necessary
        queue.put(new Integer[]{k, v});
    }

    public int get(int k) {
        return kvMap.getOrDefault(k, 0);
    }


    // test case
    public static void main(String[] args) throws InterruptedException {
        Cache cache = new Cache();
        for (int i = 1; i <= 1000; i++) {
            cache.add(1, i);
            cache.add(2, i * 2);
            cache.add(3, i * 3);

        }
        ExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.submit(new Thread(() -> {
            try {
                // sleep 1000 milliseconds, make sure compute is down in the back end
                // if you change this value to 1 millisecond , the value might not be accurate, because calculation not done.

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(cache.get(1)); // should return 500500
            System.out.println(cache.get(2)); // should return 1001000
            System.out.println(cache.get(3)); // should return 1501500
        }));
    }
}

class Consumer implements Runnable {
    // the queue can be shared between threads
    private BlockingQueue<Integer[]> queue;
    private ConcurrentHashMap<Integer, Integer> concurrentHashMap;

    public Consumer(BlockingQueue<Integer[]> blockingQueue, ConcurrentHashMap<Integer, Integer> concurrentHashMap) {
        this.queue = blockingQueue;
        this.concurrentHashMap = concurrentHashMap;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // since `add()` method is for streaming , I assume this library request ongoing calculation,
                // total count is keep updating. So use take() method here

                // BlockingQueue.take()
                // Retrieves and removes the head of this queue, waiting if necessary
                // until an element becomes available.
                Integer[] entry = queue.take();

                // ConcurrentHashMap.compute(): If the value is not threadsafe and must be updated inside the method with a remapping
                // function to ensure the entire operation is atomic. This gives you the most control over the
                // computation, but also the responsibility to handle the possibility that there is no existing
                // value inside your remapping function.
                concurrentHashMap.compute(entry[0], (key, value) -> {
                    value = (value == null ? 0 : value);
                    return value + entry[1];
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

