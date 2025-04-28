package com.raymondchandra.adventure02B.inheritanceFiles;

public abstract class Vehicle {
	private int maxSpeed;

	public abstract void accelerate();

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
}
