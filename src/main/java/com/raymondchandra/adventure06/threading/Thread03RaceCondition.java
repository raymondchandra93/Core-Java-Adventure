package com.raymondchandra.adventure06.threading;

/**
 * Race Condition happens when 2 threads are sharing resources together
 * 
 * 
 * To solve it, you need to:
 * 1. Synchronized - the synchronized method will protect the resource
 */

class BankAccount {
	int balance = 10000;

	synchronized void withdraw(int amount) {
		if (balance >= amount) {
			balance -= amount;
		}
	}
}

public class Thread03RaceCondition {
	public static void main(String[] args) throws InterruptedException {
		BankAccount account = new BankAccount();

		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 10000; i++) {
				account.withdraw(1);
			}
		});

		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 10000; i++) {
				account.withdraw(1);
			}
		});

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		System.out.println("Final balance: " + account.balance);
	}
}
