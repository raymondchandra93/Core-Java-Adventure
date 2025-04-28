package com.raymondchandra.adventure02C.interfaceFiles;

public class UsbCharger {
	public void supplyPower(Chargeable chargeable) {
		System.out.println("Charging with USB Charger:");
		chargeable.charge(2);
	}
}
