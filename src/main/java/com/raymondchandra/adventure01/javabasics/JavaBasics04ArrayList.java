package com.raymondchandra.adventure01.javabasics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class JavaBasics04ArrayList {

	public static void main(String[] args) {
		// ArrayList
		// -- Create
		List<String> names = new ArrayList<>();
		
		// -- Add
		names.add("student1");
		names.add("student2");
		names.add("student3");
		names.add("student4");
		names.add("student5");
		
		// -- Remove
		// remove by index
		names.remove(0);
		
		// removing using Iterator
		Iterator<String> namesItr = names.iterator();
		while(namesItr.hasNext()) {
			namesItr.next();	
			if(namesItr.next().equals("student3")) {
				namesItr.remove();
			}
		}
		
		// -- Edit
		names.set(0, "student6");
		
		// -- Read
		System.out.println("First student: " + names.get(0));
		
		// -- Read All
		System.out.println("Student names:");
		for (String name : names) {
			System.out.println(name);
		}
	}

}
