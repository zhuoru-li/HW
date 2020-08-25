package homework1;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class MyThreadPool {
    private final int nThreads;
    private final PoolWorker[] threads;
    private final BlockingDeque queue;

    public MyThreadPool(int nThreads) {
        this.nThreads = nThreads;
        queue = new LinkedBlockingDeque();
        threads = new PoolWorker[nThreads];

        for (int i = 0; i < nThreads; i++) {
            threads[i] = new PoolWorker(queue);
            threads[i].start();
        }
    }

    public void execute(Runnable task) {
        synchronized (queue) {
            queue.add(task);
            queue.notify();
        }
    }

    public static void main(String[] args) {
        MyThreadPool mt = new MyThreadPool(5);
        for (int i = 0; i < 50; i++) {
            mt.execute(new Thread(() -> {
                System.out.println(Thread.currentThread().getName());
            }));
        }
    }
}

class PoolWorker extends Thread {
    BlockingDeque queue;
    public PoolWorker(BlockingDeque queue) {
        this.queue = queue;
    }

    public void run() {
        Runnable task;

        while (true) {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    try{
                        queue.wait();
                    } catch(InterruptedException e) {
                        System.out.println("Exception");
                    }
                }
                task = (Runnable) queue.poll();
            }

            try {
                task.run();
            } catch (RuntimeException e) {
                System.out.println("Exception");
            }
        }
    }
}