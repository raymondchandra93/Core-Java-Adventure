/**
 * 
 * Atomic variables are thread-safe variables that support atomic (indivisible) operations 
 * on single variables without using synchronized blocks.
 * 
 * These classes are part of the java.util.concurrent.atomic package and 
 * are heavily used in concurrent programming.
 * 
 * 🧰 Common Atomic Classes
 * 
 * Class				Type				Example Methods
 * AtomicBoolean		boolean				get(), set(), compareAndSet()
 * AtomicInteger		int					incrementAndGet(), addAndGet()
 * AtomicLong			long				Similar to AtomicInteger
 * AtomicReference<T>	Object reference	get(), set(), compareAndSet()
 * 
 * ✅ When to Use Atomic
 * Use when:
 * - You're working with a single shared variable (e.g., counter, flag, reference).
 * - Performance is important (low overhead).
 * - You're avoiding locking altogether.
 * 
 * ✅ When to Use synchronized
 * Use when:
 * - You need to update multiple variables together (atomic group).
 * - You have a complex critical section (multiple steps).
 * - You want to enforce structured locking with clear entry/exit.
 * 
 * Atomic operations are often 2–10x faster than synchronized under low contention.
 * 
 * But under high contention, atomic performance may degrade due to repeated retries (CAS failures), 
 * while synchronized scales better in some cases.
 * 
 */

package com.raymondchandra.adventure06.threading;

import java.util.concurrent.atomic.AtomicBoolean;

public class Thread09AtomicVariable {
	// private volatile boolean flag = false;
	private AtomicBoolean flag = new AtomicBoolean(false);

	public void toggleFlag() {
		flag.set(!flag.get());
		// System.out.println(flag);
	}

	public boolean getFlag() {
		return flag.get();
	}

	public static void main(String[] args) throws InterruptedException {
		Thread09AtomicVariable example = new Thread09AtomicVariable();

		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				example.toggleFlag();
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
				}
			}
		});

		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				if (example.getFlag()) {
					System.out.println("Flag is true");
				} else {
					System.out.println("Flag is false");
				}
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
				}
			}
		});

		t1.start();
		t2.start();

		t1.join();
		t2.join();
	}
}
