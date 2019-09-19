package com.changhun.linkedin.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


/**
 * Given two words (beginWord and endWord), and a dictionary's word list, 
 * find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.

 * @author changhun
 *
 */
public class L127_WordLadder {
	public static class Pair {
		private String key;
		private Integer value;
		public Pair(String key, Integer value) {
			this.key = key;
			this.value = value;
		}
		
		public String getKey() {
			return key;
		}
		
		public Integer getValue() {
			return value;
		}
		
		@Override
		public int hashCode() {
			return key.hashCode() + value;
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null) return false;
			if (this.getClass() != o.getClass()) return false;
			Pair that = (Pair) o;
			return this.getKey() == that.getKey() && this.getValue() == that.getValue() ? true : false;
		}
		
	}
	
	public static class Solution {
		public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
			//Assume all words are of same length;
			int wordLength = beginWord.length();
			
			//Dictionary to contains all combination of words that can be formed,
			//from any given words. By changing one letter at a time.
			// FYI !!! not List inside Map
			Map<String, ArrayList<String>> allComboDict = new HashMap<String, ArrayList<String>>();
			
			
			wordList.forEach(
				word-> {
					for (int i = 0; i<wordLength; i++) {
						//Key is generic word
						//value is a list of words which have the same intermediate generic word.
						String comboWord = word.substring(0, i) + "*" + word.substring(i+1, wordLength);
						ArrayList<String> transformations = allComboDict.getOrDefault(comboWord, new ArrayList<String>());
						transformations.add(word);
						allComboDict.put(comboWord, transformations);
												
					}
			});
			
			System.out.println(allComboDict.toString());
			
			// Queue for BFS
			Queue<Pair> queue = new LinkedList<Pair>();
			queue.add(new Pair(beginWord, 1));
			
			// Visited to make sure we don't repeat processing same word.
			Map<String, Boolean> visited = new HashMap<String, Boolean>();
			visited.put(beginWord, true);
			
			while(!queue.isEmpty()) {
				Pair node = queue.remove();
				
				String curWord = node.getKey();
				int level = node.getValue();

				System.out.println(curWord + " " + level);
				
				for (int i = 0; i < wordLength; i++) {
					//Intermediate words for current word
					String newWord = curWord.substring(0,i) + "*" + curWord.substring(i+1, wordLength);
					System.out.println("\t" + newWord);

					//Next states are all the words which share the same intermediate state;
					
					for (String adjacentWord: allComboDict.getOrDefault(newWord,  new ArrayList<String>())) {
						//If at any point if we find what we are looking for
						//i.e., the end words - we can return with the answer.
						if (adjacentWord.equals(endWord)) {
							return level + 1;
						}
						
						//Otherwise, add it to the BFS queue. Also mark it visited.
						if (!visited.containsKey(adjacentWord)) {
							visited.put(adjacentWord, true);
							queue.add(new Pair(adjacentWord, level+1));
						}
					}
				}
			}
			
			return 0;
		}
	}
	
	public static void main(String[] args) {
	     List<String> wordList = new ArrayList<String>(
	    	Arrays.asList("hot","dot","dog","lot","log","cog")
	     );
	     //hit - hot - dot - dog - cog
	     String beginWord = "hit";
	     String endWord = "cog";
	     
	     
	     int level = Solution.ladderLength(beginWord, endWord, wordList);
	     
	     System.out.println("out " + level);
	}
}
