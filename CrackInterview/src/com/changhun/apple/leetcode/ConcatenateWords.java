package com.changhun.apple.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Given a list of words (without duplicates), please write a program that returns 
 * all concatenated words in the given list of words.
 * A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given array.
 *
 * Input: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"] 
 * Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
 * 
 * Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats";  
 *  "dogcatsdog" can be concatenated by "dog", "cats" and "dog"; 
 *  "ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
 * 
 * 
 * 
 * Do you still remember how did you solve this problem? https://leetcode.com/problems/word-break/
 * 
 * If you do know one optimized solution for above question is using DP, 
 * this problem is just one more step further. 
 * We iterate through each word and see if it can be formed by using other words.
 * 
 * Of course it is also obvious that a word can only be formed by words shorter than it. 
 * So we can first sort the input by length of each word, and only try to form one word by using words in front of it.

 * @author changhun
 *
 */
public class ConcatenateWords {
	   public static List<String> findAllConcatenatedWordsInADict(String[] words) {
	        List<String> result = new ArrayList<>();
	        Set<String> preWords = new HashSet<>();
	        Arrays.sort(words, new Comparator<String>() {
	            public int compare (String s1, String s2) {
	                return s1.length() - s2.length();
	            }
	        });
	        
            System.out.println(Arrays.toString(words));

	        for (int i = 0; i < words.length; i++) {
	            if (canForm(words[i], preWords)) {
	                result.add(words[i]);
	            }
	            preWords.add(words[i]);
	            
//	            System.out.println(preWords);
	        }
	        
	        return result;
	    }
		
	    private static boolean canForm(String word, Set<String> dict) {
	        System.out.println(word + " " + dict.toString());

	        if (dict.isEmpty()) return false;
	        boolean[] dp = new boolean[word.length() + 1];
	        dp[0] = true;
	        for (int i = 1; i <= word.length(); i++) {
	        	for (int j = 0; j < i; j++) {
	        		if (!dp[j]) continue;
	        		if (dict.contains(word.substring(j, i))) {
	        			dp[i] = true;
	        			break;
	        		}
	        	}
	        }
	        System.out.println(Arrays.toString(dp));
	        return dp[word.length()];
	    }
	    
	    public static void main(String[] args) {
			String [] array = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
			
			List<String> out = findAllConcatenatedWordsInADict(array);
			System.out.println(out.toString());
		}
}
