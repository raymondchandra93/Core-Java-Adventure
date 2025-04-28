package com.raymondchandra.adventure02A.oop;

public class Processor {
	private final String MODEL;
	private final double SPEED;
	private final int NUMBER_OF_CORES;
	
	public Processor(String model, double speed, int number_of_cores) {
		this.MODEL = model;
		this.SPEED = speed;
		this.NUMBER_OF_CORES = number_of_cores;
	}
	
	public void processData(String data) {
		System.out.println("Process Data: " + data);
	}

	@Override
	public String toString() {
		return "Processor [MODEL=" + MODEL + ", SPEED=" + SPEED + ", NUMBER_OF_CORES=" + NUMBER_OF_CORES + "]";
	}
}
