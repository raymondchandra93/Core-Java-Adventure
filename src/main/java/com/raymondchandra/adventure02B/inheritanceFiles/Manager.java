package com.raymondchandra.adventure02B.inheritanceFiles;

import java.util.List;

public class Manager extends Employee {
	private List<Employee> team;
	
	public Manager() {
		super();
	}
	
	// Slide 10
	public Manager(String name, String jobTitle, int salary) {
		super(name, jobTitle, salary);
	}

	public void manage() {
		System.out.println("I am managing");
		
		// Slide 12
		super.work();
	}
}
