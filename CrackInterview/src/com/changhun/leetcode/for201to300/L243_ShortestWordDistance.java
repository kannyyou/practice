package com.changhun.leetcode.for201to300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

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
public class L243_ShortestWordDistance {
	private static Map<String, List<Integer>> map;


	/**
	 * Brute Force "
	 * A naive solution to this problem is to go through the entire array looking for the first word. 
	 * Every time we find an occurrence of the first word, we search the entire array for the closest occurrence of the second word.
	 Time O(n^2) Space O(1)

	 * @param word1
	 * @param word2
	 * @return
	 */
	public static int shortetBF(String [] words, String word1, String word2) {
	    int minDist = words.length;
	    for(int i = 0; i < words.length; i++) {
	        if (words[i].equals(word1)) {
		        for(int j = 0; j < words.length; j++) {
	                if (words[j].equals(word2)) {
	                	
	    				System.out.println(word1 + " " + word2 + " " + i + " " + j);

			            minDist = Math.min(minDist, Math.abs(i - j));

	                }
		        }
	        }
	    }
	    return minDist;		
	}
	
	/**
	 * We can greatly improve on the brute-force approach by keeping two indices i1 and i2 
	 * where we store the most recent locations of word1 and word2. 
	 * Each time we find a new occurrence of one of the words, 
	 * we do not need to search the entire array for the other word, 
	 * since we already have the index of its most recent occurrence.
	 * 
	 * @param words
	 * @param word1
	 * @param word2
	 * @return
	 */
	public static int shortetOnePass(String [] words, String word1, String word2) {
		int i1 = -1;
		int i2 = -1;
		int minDist = words.length;
		for (int i=0; i<words.length; i++) {
			
			if (words[i].equals(word1)) i1 = i;
			else if (words[i].equals(word2)) i2 = i; 
			
			/// else is no.. for equal case.
			
			
//			if (word1 != word2) {
//				if (words[i].equals(word1)) i1 = i;
//				else if (words[i].equals(word2)) i2 = i; 
//			} else {
//				if (words[i].equals(word1)) {
//					i1 = i;
//					i2 = i;
//				}
//
//			}

			if (i1 != -1 && i2 != -1) {

				System.out.println(word1 + " " + word2 + " " + i1 + " " + i2);
				minDist = Math.min(minDist, Math.abs(i1 -i2));

			}
		}
		
		return minDist;
	
	}

	
	
	public static void main(String[] args) {
		String [] words = {"practice", "makes", "perfect", "coding", "makes"};
		
		System.out.println(shortetBF(words, "practice", "coding"));
		System.out.println(shortetBF(words, "practice", "makes"));
//		System.out.println(shortetBF(words, "makes", "makes"));	//impossible
		
		System.out.println("******************");
		System.out.println(shortetOnePass(words, "practice", "coding"));
		System.out.println(shortetOnePass(words, "practice", "makes"));
//		System.out.println(shortetOnePass(words, "makes", "makes"));


	}
}
