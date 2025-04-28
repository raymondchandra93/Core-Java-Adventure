package com.raymondchandra.adventure05.fileio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountGroupOfWords {
	public static void main(String[] args) throws FileNotFoundException, IOException {

		FileReader reader = new FileReader("src/main/resources/source.txt");
		Scanner scanner = new Scanner(reader);
		
		Map<String, Integer> wordOcc = new HashMap<>();

		String line;
		while (scanner.hasNext()) {
			
			String word = scanner.next();
			if(wordOcc.containsKey(word)) {
				wordOcc.put(word, wordOcc.get(word)+1);
			} else {
				wordOcc.put(word, 1);
			}
		}

		for(Map.Entry<String, Integer> map : wordOcc.entrySet()) {
			System.out.println("Word: " + map.getKey() + ", Value: " + map.getValue());
		}
		
		scanner.close();
	}
}
