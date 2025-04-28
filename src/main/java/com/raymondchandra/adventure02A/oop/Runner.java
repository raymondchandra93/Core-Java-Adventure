package com.raymondchandra.adventure02A.oop;

//1.2 - 1
public class Runner {

	public static void main(String[] args) {
		HardDrive hd1 = new HardDrive("Seagate", 2048);
		HardDrive hd2 = new HardDrive("Dell", 3072);
		hd2.setUsedSpace(500.0);
		
		Memory m1 = new Memory("Kingston", 4, 1600);
		Memory m2 = new Memory("Corsair", 8, 1333);
		
		Processor p1 = new Processor("Intel Xeon", 2.93, 6);
		Processor p2 = new Processor("Intel Celeron", 2.9, 2);
		
		System.out.println(hd1.toString());
		System.out.println(hd2.toString());
		System.out.println(m1.toString());
		System.out.println(m2.toString());
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		
		hd1.setUsedSpace(50);
		
		System.out.println(hd1.getUsedSpace());
	}

}
