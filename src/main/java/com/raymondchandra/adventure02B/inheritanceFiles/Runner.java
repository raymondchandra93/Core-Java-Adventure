package com.raymondchandra.adventure02B.inheritanceFiles;

import java.util.ArrayList;
import java.util.List;

public class Runner {

	public static void main(String[] args) {
		
		// Slide 8
		SalaryManager sm1 = new SalaryManager();
		
		Employee e1 = new Employee();
		
		Manager m1 = new Manager();
		m1.setSalary(1000);
		System.out.println("Manager before salary: " + m1.getSalary());
		
		sm1.increaseSalary(m1, 0.5);
		System.out.println("Manager after salary: " + m1.getSalary());
		
		m1.manage();
		
		// Slide 17
		// Vehicle v1 = new Vehicle();					// cannot do this as vehicle is abstract
		Car car1 = new Car();
		Vehicle car2 = new Car();
		
		car1.accelerate();
		car1.carAccelerate();
		
		car2.accelerate();
		// car2.carAccelerate();						// cannot do this as car2 reference is Vehicle
	}

}
