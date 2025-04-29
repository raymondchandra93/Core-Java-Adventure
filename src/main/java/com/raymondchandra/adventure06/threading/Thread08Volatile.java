/**
 * 
 * In Java, the volatile keyword is used to indicate that a variable's value 
 * will be modified by multiple threads. 
 * 
 * It ensures that any read or write operation on that variable is done directly 
 * from and to the main memory, rather than being cached 
 * in a thread's local memory (also known as a CPU cache). 
 * 
 * This helps to avoid problems where one thread might not see the updated value 
 * of the variable because of caching.
 * 
 * Here’s what volatile guarantees:
 * - Visibility: When a variable is marked as volatile, all threads will immediately see 
 * the most up-to-date value of the variable. If one thread updates a volatile variable, 
 * that change will be visible to all other threads that access it.
 * - Atomicity of Reads/Writes: A volatile variable ensures that reads and writes 
 * to the variable are atomic, meaning they cannot be interrupted or partially completed. 
 * This applies to primitive types like int, boolean, etc.
 * 
 * However, volatile does not ensure atomicity for complex operations 
 * (such as incrementing a variable or checking and updating its value).
 * E.g. incrementing/decrementing an int variable
 * 
 * You would need additional synchronization mechanisms, 
 * like synchronized or java.util.concurrent.atomic classes, 
 * for such compound actions.
 * 
 */

package com.raymondchandra.adventure06.threading;

public class Thread08Volatile {
	private volatile boolean flag = false;

	public void toggleFlag() {
		flag = !flag;
		// System.out.println(flag);
	}

	public boolean getFlag() {
		return flag;
	}

	public static void main(String[] args) throws InterruptedException {
		Thread08Volatile example = new Thread08Volatile();

		// Thread to toggle flag
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				System.out.println("Toggling");
				example.toggleFlag();
			}
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
			}
		});

		// Thread to read flag
		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				if (example.getFlag()) {
					System.out.println("Flag is true");
				} else {
					System.out.println("Flag is false");
				}
			}
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
			}
		});

		t1.start();
		t2.start();

		t1.join();
		t2.join();
	}
}
