package com.raymondchandra.adventure04.exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

// --- 2B --- The same as TryWithFinallyExceptionDemo.java
public class CheckedExceptionDemo {

	public static void main(String[] args) {
		
		FileReader myFile = null;
		try {
			myFile = new FileReader(
					"C:\\Users\\Raymond.Chandra\\eclipse-workspace"
					+ "\\OOD2_Master\\src\\com\\fdmgroup\\exceptiondemo"
					+ "\\mytext.txt");
					
			// Reading the file - IOException
			int i;
			while ((i = myFile.read()) != -1) {
				System.out.print((char) i);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Helo1");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Helo2");
			e.printStackTrace();
		}
	}
}
