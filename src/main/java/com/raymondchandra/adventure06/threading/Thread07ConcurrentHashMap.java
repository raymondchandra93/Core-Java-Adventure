/**
 * 
 * Concurrent HashMap
 * -------------------
 * 
 * A ConcurrentHashMap is a special type of Map in Java that is thread-safe 
 * — meaning multiple threads can access and modify it at the same time 
 * without corrupting the data
 * 
 * Why use ConcurrentHashMap?
 * - When you have multiple threads reading and writing to a map.
 * - When performance matters and you can't afford the cost of synchronizing an entire map.
 * - When you need safe concurrent access without writing complicated locking code yourself.
 */

package com.raymondchandra.adventure06.threading;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Thread07ConcurrentHashMap {
	public static void main(String[] args) throws InterruptedException {

		Map<String, Integer> map = new ConcurrentHashMap<>();

		// 1st writer thread
		Thread writer1 = new Thread(() -> {
			int i = 1;
			while (true) {

				map.put("Key" + i, i);
				i++;
				
				if (i == 6)
					break;
				
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		});

		// 2nd writer thread
		Thread writer2 = new Thread(() -> {
			int i = 6;
			while (true) {

				map.put("Key" + i, i);
				i++;
				
				if (i == 11)
					break;
				
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		});

		// Reader thread
		Thread reader = new Thread(() -> {
			int i = 1;
			while (true) {
				System.out.println("Reader sees: " + map.getOrDefault("Key" + i, 0));
				i++;

				if (i == 11)
					break;

				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		});

		writer1.start();
		writer2.start();
		reader.start();

		writer1.join();
		writer2.join();
		reader.join();

		System.out.println("Final map: " + map);
		System.out.println("Length map: " + map.size());
		System.out.println("Thread is finished!");
	}
}
