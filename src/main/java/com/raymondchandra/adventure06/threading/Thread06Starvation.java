package com.raymondchandra.adventure06.threading;

/**
 * Starvation happens when 1 thread is NEVER GIVEN access to the CPU
 * 
 * In this example
 * Since we give maximum priority to T0, T1 will not be able to use 'balance'
 * Yet, there is a starvation with T1
 */

class BankAccount2 {
	int balance = 10000;

	synchronized void withdraw(int amount) {

		if (balance >= amount) {
			balance -= amount;
		}
	}
}

public class Thread06Starvation {
	public static void main(String[] args) throws InterruptedException {
		BankAccount2 account = new BankAccount2();

		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 10000; i++) {
				try {
					account.withdraw(1);
					Thread.sleep(1000);
					System.out.println(Thread.currentThread().getName());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t1.setPriority(Thread.MAX_PRIORITY);

		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 10000; i++) {
				account.withdraw(1);
				System.out.println(Thread.currentThread().getName());
			}
		});
		t2.setPriority(Thread.MIN_PRIORITY);
		
		// Start the thread
		t1.start();
		t2.start();
		
		// Join the thread
		t1.join();
		t2.join();

		System.out.println("Final balance: " + account.balance);
	}
}
