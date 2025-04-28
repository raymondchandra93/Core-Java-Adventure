package com.raymondchandra.adventure02C.interfaceFiles;

public class Runner {
	
	public static void main(String[] args) {	
		Tablet t1 = new Tablet();
		Speaker sp1 = new Speaker();
		
		t1.charge(1);
		sp1.charge(1);
		
		UsbCharger uc1 = new UsbCharger();
		uc1.supplyPower(t1);
		uc1.supplyPower(sp1);
		
		t1.displayApp();
		t1.produceLight();
	}
}
