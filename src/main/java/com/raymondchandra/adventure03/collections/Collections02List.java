package com.raymondchandra.adventure03.collections;

import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;

public class Collections02List {
	public static void main(String[] args) {
		
		// -- Linked List --
		LinkedList<String> animals = new LinkedList<>();
        animals.add("Dog");
        animals.add("Cat");
        animals.add("Horse");

        animals.addFirst("Cow");
        animals.addLast("Sheep");

        System.out.println(animals); 				// [Cow, Dog, Cat, Horse, Sheep]
        System.out.println(animals.getFirst());		// [Cow]
        System.out.println(animals.getLast());		// [Sheep]
        
        // queue methods
        System.out.println("LL Poll: " + animals.poll()); 	// [Cow]
        System.out.println("LL Peek: " + animals.peek()); 	// [Dog]
        
        animals.offer("Chicken");
        animals.offer("Fish");

        // Display the queue again
        System.out.println("LL after adding more elements: " + animals);
        
		
        // -- Vector --
		Vector<String> colors = new Vector<>();
		colors.add("Red");
		colors.add("Green");
		colors.add("Blue");

		System.out.println("Vector get 2nd element: " + colors.get(1)); // Green
		
		// -- Stack --
		Stack<String> colors2 = new Stack<>();
		colors2.push("Red");
		colors2.push("Green");
		colors2.push("Blue");

		System.out.println("Stack Pop: " + colors2.pop()); 		// Blue
		System.out.println("Stack Peek: " + colors2.peek()); 	// Green
	}
}
