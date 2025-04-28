package com.raymondchandra.adventure04.exceptions;

// --- 1 ---
// StackOverflowError
public class ErrorDemo {
	public static void recursiveDemo(int i) {
		while (i != 10000000) {
			// System.out.println(i);
			i++;
			recursiveDemo(i);
		}
	}
	
	public static void main(String args[]) {
		recursiveDemo(10);
	}

}