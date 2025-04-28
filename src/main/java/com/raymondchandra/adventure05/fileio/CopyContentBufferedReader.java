package com.raymondchandra.adventure05.fileio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyContentBufferedReader {
	public static void main(String[] args) throws IOException {
		
		FileReader reader = new FileReader("src/main/resources/source.txt");
		BufferedReader breader = new BufferedReader(reader);
				
		FileWriter writer = new FileWriter("src/main/resources/destination.txt");
		BufferedWriter bwriter = new BufferedWriter(writer);
		
		String line;
		
		while ((line = breader.readLine()) != null) {
			
			// Write the character into the new file	
			bwriter.write(line);
			bwriter.newLine();
		}
		
		System.out.println("File is successfully copied!");
				
		breader.close();
		bwriter.close();
	}
}
