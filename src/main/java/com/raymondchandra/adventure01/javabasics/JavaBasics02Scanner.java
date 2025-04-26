package com.raymondchandra.adventure01.javabasics;

import java.util.Scanner;

public class JavaBasics02Scanner {

	public static void main(String[] args) {
        // Create a Scanner object
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for input
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();  // Read a string input from the user

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();  		// Read an integer input from the user

        // Display the user's input
        System.out.println("Hello, " + name + "! You are " + age + " years old.");

        // Close the scanner to prevent resource leak
        scanner.close();
	}

}
