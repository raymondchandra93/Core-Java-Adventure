package com.raymondchandra.adventure02A.oop;

public class Memory {
	private final String MODEL;
	private final double CAPACITY;
	private double usedSpace;
	private final double SPEED;
	
	public Memory(String model, double capacity, double speed) {
		this.MODEL = model;
		this.CAPACITY = capacity;
		this.SPEED = speed;
	}
	
	public void storeData(String data) {
		System.out.println("Store data : " + data);
	}

	public double getUsedSpace() {
		return usedSpace;
	}

	public void setUsedSpace(double usedSpace) {
		this.usedSpace = usedSpace;
	}

	public String getMODEL() {
		return MODEL;
	}

	public double getCAPACITY() {
		return CAPACITY;
	}

	public double getSPEED() {
		return SPEED;
	}

	@Override
	public String toString() {
		return "Memory [MODEL=" + MODEL + ", CAPACITY=" + CAPACITY + ", usedSpace=" + usedSpace + ", SPEED=" + SPEED
				+ "]";
	}
}
