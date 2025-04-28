package com.raymondchandra.adventure02C.interfaceFiles;

public class Tablet extends Computer implements Chargeable, Lightable {

	@Override
	public void charge(double amps) {
		int speed = 2;
		System.out.println("Charging speed: " + (speed * amps));
	}

	@Override
	public void produceLight() {
		System.out.println("Turning on my light");
	}

	@Override
	public void printRunnable() {
		System.out.println("Running the tablet");
	}
}
