package com.raymondchandra.adventure05.fileio;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CopyContentScanner {
	public static void main(String[] args) throws IOException {

		FileReader source = new FileReader("src/main/resources/source.txt");
		FileWriter destination = new FileWriter("src/main/resources/destination.txt");
		
		Scanner scanner = new Scanner(source);

		while (scanner.hasNext()) {
			destination.append(scanner.next()).append(" ");
		}

		source.close();
		destination.close();

		System.out.println("File copied!");
	}
}
