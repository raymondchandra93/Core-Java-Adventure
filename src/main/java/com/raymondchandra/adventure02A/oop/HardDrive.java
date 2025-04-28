package com.raymondchandra.adventure02A.oop;

public class HardDrive {
	private final String MODEL;
	private final double CAPACITY;
	private double usedSpace;
	
	
	public HardDrive(String model, double capacity) {
		this.MODEL = model;
		this.CAPACITY = capacity;
	}
	public String readData(String file) {
		return ("data from " + file);
	}
	
	public void writeData(String data, String file) {
		System.out.println("Write data : " + data + " " + file);
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
	
	@Override
	public String toString() {
		return "HardDrive [MODEL=" + MODEL + ", CAPACITY=" + CAPACITY + ", usedSpace=" + usedSpace + "]";
	}
}
