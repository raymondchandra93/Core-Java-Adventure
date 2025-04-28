package com.raymondchandra.adventure02B.inheritanceFiles;

// Slide 8
public class SalaryManager {
	public void increaseSalary(Employee employee, double percent) {
		employee.setSalary( (int) (employee.getSalary() + (employee.getSalary()*percent)) );
	}
}
