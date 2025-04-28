package com.raymondchandra.adventure05.fileio;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyContent {
	public static void main(String[] args) throws IOException {
		
		FileReader reader = new FileReader("src/main/resources/source.txt");
		FileWriter writer = new FileWriter("src/main/resources/destination.txt");
		
		int character = reader.read();
		while(character != -1) {
			
			// Write the character into the new file	
			writer.write(character);
			
			// Reading the next character
			character = reader.read();
		}
		
		System.out.println("File is successfully copied!");
		
		writer.close();
		reader.close();
	}
}
