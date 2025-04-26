package com.raymondchandra.adventure04.exceptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Collections01Set {
	public static void main(String[] args) {
		// --- HashSet ---
		Set<String> fruits = new HashSet<>();
		fruits.add("Apple");
		fruits.add("Orange");
		fruits.add("Banana");
		fruits.add("Melon");
		fruits.add("Melon");
		
		System.out.println("HashSet size: " + fruits.size());
		System.out.println("HashSet fruits: " + fruits);
		for (String fruit : fruits) {
			System.out.println(fruit);
		}
		
		// --- LinkedHashSet ---
		List<String> vegies = new ArrayList<>();
		vegies.add("Cucumber");
		vegies.add("Spinach");
		vegies.add("Potato");
		vegies.add("Potato");
		
		// convert to LinkedHashSet
		Set<String> setVegies = new LinkedHashSet<>(vegies);
		System.out.println("LinkedHashSet size: " + setVegies.size());
		System.out.println("LinkedHashSet fruits: " + setVegies);
		
		// --- TreeSet ---
		Set<String> treeFruits = new TreeSet<>(Arrays.asList("Apple", "Orange", "Banana"));
		
		System.out.println("TreeSet size: " + treeFruits.size());
		System.out.println("TreeSet fruits: " + treeFruits);
		 
	}
}
