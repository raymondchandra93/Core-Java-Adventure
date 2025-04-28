package com.raymondchandra.adventure05.fileio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CountCharactersWordsLines {
	public static void main(String[] args) throws FileNotFoundException, IOException {

		FileReader reader = new FileReader("src/main/resources/source.txt");
		BufferedReader breader = new BufferedReader(reader);

		int characterCounts = 0;
		int wordCounts = 0;
		int lineCounts = 0;

		String line;
		while ((line = breader.readLine()) != null) {

			// Count the line
			lineCounts++;
			
			// Count the words
			String[] words = line.split(" ");
			wordCounts += words.length;
			
			// Count the characters
			characterCounts += line.length();
		}

		System.out.println("Line counts: " + lineCounts);
		System.out.println("Word counts: " + wordCounts);
		System.out.println("Character counts: " + characterCounts);
		
		breader.close();
	}
}
