package com.raymondchandra.adventure06.threading;

import java.util.concurrent.locks.ReentrantLock;

class Counter {
    private int count = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public void increment() {
        lock.lock(); // acquire the lock
        try {
            count++;
        } finally {
            lock.unlock(); // always release the lock in a finally block
        }
    }

    public int getCount() {
        return count;
    }
}

public class Thread10ReentrantLock {

	public static void main(String[] args) throws InterruptedException {
		Counter counter = new Counter();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
                System.out.println(Thread.currentThread().getName() + " incremented count to " + counter.getCount());
            }
        };

        Thread t1 = new Thread(task, "Thread-A");
        Thread t2 = new Thread(task, "Thread-B");
        
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final count: " + counter.getCount()); // Should be 2000
	}

}
