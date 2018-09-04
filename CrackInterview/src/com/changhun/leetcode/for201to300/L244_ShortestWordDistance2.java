package com.changhun.leetcode.for201to300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Design a class which receives a list of words in the constructor, and 
 * implements a method that takes two words word1 and word2
 *  and return the shortest distance between these two words in the list. 
 *  
 *  Your method will be called repeatedly many times with different parameters. 

Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = “coding”, word2 = “practice”
Output: 3
Input: word1 = "makes", word2 = "coding"
Output: 1
Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.


LinkedIn
 * @author changhun
 *
 */
public class L244_ShortestWordDistance2 {
	private static Map<String, List<Integer>> map;

	/**
	 * compute index of all words and save to Map	
	 * @param words
	 */
	public static void getAllWordDistance(String[] words) {
	    map = new HashMap<String, List<Integer>>();
	    for(int i = 0; i < words.length; i++) {
	        String w = words[i];
	        
	        List<Integer> list = map.get(w);
	        if (list == null) {
	        	list = new ArrayList<Integer>();
	            map.put(w, list);
	        }
            list.add(i);
	    }
	}
	
	/**
	 * For compare |word1's index - word2's index|
	 * It might be issue if we have too many duplicates.
	 * @param word1
	 * @param word2
	 * @return
	 */
	public static int shortest(String word1, String word2) {
	    int min = Integer.MAX_VALUE;
	    for(Integer num1: map.get(word1)) {
	        for(Integer num2: map.get(word2)) {
	            min = Math.min(min, Math.abs(num1 - num2));
	        }
	    }
	    return min;		
	}
	
	
	public static void main(String[] args) {
		String [] words = {"practice", "makes", "perfect", "coding", "makes"};
		
		getAllWordDistance(words);
		System.out.println(map.toString());
		System.out.println(shortest("practice", "coding"));
		System.out.println(shortest("makes", "coding"));
		System.out.println(shortest("makes", "makes"));


	}
}
