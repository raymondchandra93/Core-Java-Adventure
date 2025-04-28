package com.raymondchandra.adventure02B.inheritanceFiles;

// Slide 14
// public final class Employee {

// Slide 4
public class Employee {

	protected String name; 
	private String jobTitle; 
	private int salary;
	
	public Employee() {
		name = "No name";
		jobTitle= "No job";
		salary = 100;
	}
	
	public Employee(String name, String jobTitle, int salary) {
		this.name = name;
		this.jobTitle= jobTitle;
		this.salary = salary;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getJobTitle() {
		return jobTitle;
	}
	
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	} 
	
	// Slide 12
	protected void work() {
		System.out.println("I am working");
	}
}
