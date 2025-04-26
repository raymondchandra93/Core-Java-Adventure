package com.raymondchandra.adventure03.collections;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Collections04Map {
	public static void main(String[] args) throws InterruptedException {
		// --- HashMap ---
		// Create a new HashMap
		Map<String, Integer> map = new HashMap<>();

		// Add key-value pairs to the map
		map.put("Apple", 1);
		map.put("Banana", 2);
		map.put("Orange", 3);

		// Get a value by key
		System.out.println("Value for key 'Apple': " + map.get("Apple")); // Output: 1

		// Check if a key exists
		System.out.println("Contains 'Banana' key? " + map.containsKey("Banana")); // Output: true

		// Remove a key-value pair
		map.remove("Orange");

		// Display the size of the map
		System.out.println("Size of the map: " + map.size()); // Output: 2

		// Display all key-value pairs
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}

		// --- TreeMap ---
		Map<String, Integer> map2 = new TreeMap<>();

		map2.put("Banana", 1);
		map2.put("Apple", 2);
		map2.put("Orange", 3);

		System.out.println("Value for 'Apple': " + map2.get("Apple"));
		System.out.println("Sorted map: " + map2);

		// --- LinkedHashMap ---
		Map<String, Integer> map3 = new LinkedHashMap<>();

		map3.put("Apple", 1);
		map3.put("Banana", 2);
		map3.put("Orange", 3);

		System.out.println("Insertion order: " + map3);

		// --- HashTable ---
		Map<String, Integer> map4 = new Hashtable<>();

		map4.put("Apple", 1);
		map4.put("Banana", 2);
		map4.put("Orange", 3);

		System.out.println("Value for 'Apple': " + map4.get("Apple"));
		System.out.println("Contains 'Banana': " + map4.containsKey("Banana"));
	}
}
