package com.changhun.crackbook.ch16;

import java.util.HashMap;

public class WordFreq {
	public static HashMap<String, Integer> setupDictinoary(String [] book) {
		HashMap<String, Integer> table = new HashMap<String, Integer>();
		
		for (String word: book) {
			word = word.trim().toLowerCase();
			if (word != "") {
				Integer vol = table.get(word);		
				vol = (vol == null) ? 0 : vol;
				table.put(word, vol + 1);
			}
		}
		return table;
	}
	
	public static int getFrequency(HashMap<String, Integer> table, String word) {
		if (table == null || word == null) return -1;
		Integer vol = table.get(word);
		
		return (vol == null) ? -1 : vol;
	}
	
	public static void main(String[] args) {
		String [] book = {"Book", "book", "apple","apple","apple","apple","egg","egg","egg"};
		
		HashMap<String, Integer> table  = setupDictinoary(book);
		System.out.println(table.toString());
		System.out.println("apple : " + getFrequency(table, "apple"));
	}
}
