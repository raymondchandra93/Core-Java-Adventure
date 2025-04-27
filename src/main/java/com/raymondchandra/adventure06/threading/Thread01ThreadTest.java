package com.raymondchandra.adventure06.threading;

// Implement Runnable - recommended
class Thread1 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Thread1: " + i);
		}
	}	
}

// Extends Thread
class Thread2 extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Thread2: " + i);
		}
	}	
}

public class Thread01ThreadTest {
	public static void main(String[] args) {
		// Creating the threads
		Thread thread1 = new Thread(new Thread1());
		Thread2 thread2 = new Thread2();
		
		// Run the thread
		thread1.start();
		thread2.start();
	}
}
