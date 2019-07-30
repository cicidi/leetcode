package algorithm.core_java;

import java.util.concurrent.PriorityBlockingQueue;


class Solution {
    public static void main(String[] args) {
    }
}

public class ThreadPool {

    PriorityBlockingQueue<Task> waitingQueue = new PriorityBlockingQueue<>();  //waiting list

    PriorityBlockingQueue<Task> runningQueue = new PriorityBlockingQueue<>();  // To run list

    // TBD
    PriorityBlockingQueue<Resource> resourceQueue = new PriorityBlockingQueue<>();

    boolean isJoin = false;

    public ThreadPool(int capacity) {
        //add  4 resource to resource q
        for (int i = 0; i < capacity; i++) {
            resourceQueue.add(new Resource(i));
        }
    }

    public synchronized void addTask(Task task) {
        task.setThreadPool(this);
        if (isJoin) {
            waitingQueue.add(task);
        } else {
            runningQueue.add(task);
        }
    }

    public void notifyThead() {
        while (!resourceQueue.isEmpty()) {
            if (!runningQueue.isEmpty()) {
                Resource resource = resourceQueue.poll();
                Task task = this.runningQueue.poll();
                task.accept(resource);
            }
        }
    }

    public synchronized void returnResource(Resource r) {
        resourceQueue.add(r);
        notify();
    }

    public void start() {
        while (!waitingQueue.isEmpty()) {
            runningQueue.add(waitingQueue.poll());
        }
        notifyThead();
    }

    public void join() {
        isJoin = true;
    }
}

class Task {
    ThreadPool pool;
    Resource resource;

    public Task() {

    }

    public void accept(Resource r) {
        this.resource = resource;
        run(resource);
    }

    public void run(Resource resource) {
        // doing
        returnResource(resource);
    }

    public void returnResource(Resource r) {
        pool.returnResource(r);
    }

    public void setThreadPool(ThreadPool pool) {
        this.pool = pool;
    }
}

class Resource {
    int id;

    public Resource(int id) {
        this.id = id;
    }
}

/*
Your previous Go content is preserved below:



type ThreadPool interface {
    AddTask(func())
    Start()
    Join()
}


func main() {
  tp := NewThreadPool(4) // 4 indicates the size of the thread-pool

  tp.AddTask(calculate)
  tp.AddTask(calculate)
  tp.AddTask(calculate)
  tp.AddTask(calculate)
  ...
  ... x 1000
  ...
  ...

  tp.Start() // non-blocking (starts processing all enqueued tasks)

  // while the thread pool is working, no more than 4 tasks should be running at the same time 

  tp.Join() // blocking (blocks until all tasks are completed)
}

 */