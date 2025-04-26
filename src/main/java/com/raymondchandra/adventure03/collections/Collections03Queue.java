package com.raymondchandra.adventure03.collections;

import java.util.PriorityQueue;
import java.util.concurrent.ArrayBlockingQueue;

public class Collections03Queue {
	public static void main(String[] args) throws InterruptedException {
		
		// --- Priority Queue ---
		// Create a priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add elements
        pq.add(20);
        pq.add(10);
        pq.add(30);
        pq.add(15);

        // The elements are ordered by their natural ordering (ascending order)
        System.out.println("PriorityQueue: " + pq);		// [10, 15, 30, 20]

        // Remove elements from the queue (smallest element first)
        while (!pq.isEmpty()) {
            System.out.println("Removed from PriorityQueue: " + pq.poll());
        }
        
        // --- Array Blocking Queue ---
        // Create a blocking queue with a capacity of 2
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(2);

        // Producer thread
        Thread producer = new Thread(() -> {
            try {
                queue.put("Item 1");
                System.out.println("Produced Item 1");
                queue.put("Item 2");
                System.out.println("Produced Item 2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Consumer thread
        Thread consumer = new Thread(() -> {
            try {
                String item1 = queue.take();
                System.out.println("Consumed " + item1);
                String item2 = queue.take();
                System.out.println("Consumed " + item2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Start the threads
        producer.start();
        consumer.start();

        // Wait for the threads to finish
        producer.join();
        consumer.join();
	}
}
