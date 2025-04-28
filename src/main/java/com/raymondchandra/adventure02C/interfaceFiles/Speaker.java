package com.raymondchandra.adventure02C.interfaceFiles;

public class Speaker implements Chargeable {

	@Override
	public void charge(double amps) {
		int speed = 1;
		System.out.println("Charging speed: " + (speed * amps));
	}

	@Override
	public void printRunnable() {
		System.out.println("Running the speaker");
	}
}
