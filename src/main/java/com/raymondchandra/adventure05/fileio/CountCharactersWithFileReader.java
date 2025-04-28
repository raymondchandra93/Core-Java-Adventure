package com.raymondchandra.adventure05.fileio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CountCharactersWithFileReader {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		FileReader reader = new FileReader("src/main/resources/source.txt");
		
		int character = reader.read();
		int characterCount = 0;
		
		while(character != -1) {
			
			// Increase the character counter
			if (character != 10) {				
				characterCount++;
			}
			// System.out.println(character);
			
			// Reading the next character
			character = reader.read();
		}
		
		System.out.println("Character counts: " + characterCount);
		
		reader.close();
	}
}
