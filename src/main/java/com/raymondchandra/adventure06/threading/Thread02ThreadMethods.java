package com.raymondchandra.adventure06.threading;

public class Thread02ThreadMethods {
	public static void main(String[] args) throws InterruptedException {
		// Creating threads on the fly
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("Thread1: " + i);
					
					// putting sleep to slow down
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		Thread thread2 = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("Thread2: " + i);
			}
		});
		
		// Sysout at the start
		System.out.println("Main thread STARTS!");
		
		// Run the thread
		thread1.start();
		thread2.start();
		
		// Join the thread
		thread1.join();
		thread2.join();
		
		// Sysout at the end - join will make this thread to wait
		System.out.println("Main thread FINISHED!");
	}
}
