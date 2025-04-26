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

        System.out.println(animals); // [Cow, Dog, Cat, Horse, Sheep]
		
        // -- Vector --
		Vector<String> colors = new Vector<>();
		colors.add("Red");
		colors.add("Green");
		colors.add("Blue");

		System.out.println(colors.get(1)); // Green
		
		// -- Stack --
		Stack<String> colors2 = new Stack<>();
		colors2.push("Red");
		colors2.push("Green");
		colors2.push("Blue");

		System.out.println(colors2.pop()); // Blue
		System.out.println(colors2.peek()); // Green
	}
}
