package com.raymondchandra.adventure02B.inheritanceFiles;

public class Car extends Vehicle {

	@Override
	public void accelerate() {
		System.out.println("Accelerating");
	}
	
	public void carAccelerate() {
		System.out.println("Vroom vroom");
	}
}
