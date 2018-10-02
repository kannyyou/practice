package com.changhun.z.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.

pinterest
medium

 * @author changhun
 *
 */
public class L49_Group_Anagrams {
	
	/**
	Approach 1: Categorize by Sorted String
Intuition

Two strings are anagrams if and only if their sorted strings are equal.

Algorithm

Maintain a map ans : {String -> List} where each key \text{K}K is a sorted string, 
and each value is the list of strings from the initial input that when sorted, are equal to K.

In Java, we will store the key as a string, eg. code. In Python, we will store the key as a hashable tuple, eg. ('c', 'o', 'd', 'e').

Time Complexity: O(NKlogK), where N is the length of strs, 
and K is the maximum length of a string in strs. 
The outer loop has complexity O(N) as we iterate through each string. 
Then, we sort each string in O(KlogK) time.

Space Complexity: O(NK), the total information content stored in ans. 

	 * @author changhun
	 *
	 */
	public static class Solution1 {
	    public static List<List<String>> groupAnagrams(String[] strs) {
	        if (strs.length == 0) return new ArrayList<>();
	        Map<String, List<String>> ans = new HashMap<String, List<String>>();
	        for (String s : strs) {
	            char[] ca = s.toCharArray();
	            Arrays.sort(ca);
	            String key = String.valueOf(ca);
	            if (!ans.containsKey(key)) 
	            	ans.put(key, new ArrayList<String>());
	            ans.get(key).add(s);
	        }
	        return new ArrayList(ans.values());
	    }
	}
	
	public static class Solution2 {
	    public static List<List<String>> groupAnagrams(String[] strs) {
	        if (strs.length == 0) return new ArrayList();
	        Map<String, List<String>> ans = new HashMap<String, List<String>>();
	        int[] count = new int[26];
	        for (String s : strs) {
	            Arrays.fill(count, 0);
	            for (char c : s.toCharArray()) count[c - 'a']++;

	            StringBuilder sb = new StringBuilder("");
	            for (int i = 0; i < 26; i++) {
	                sb.append('#');
	                sb.append(count[i]);
	            }
	            String key = sb.toString();
	            if (!ans.containsKey(key)) 
	            	ans.put(key, new ArrayList());
	            ans.get(key).add(s);
	        }
	        return new ArrayList(ans.values());
	    }
	}
	
	public static void main(String[] args) {
		String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
		
		System.out.println(Solution1.groupAnagrams(input));
		System.out.println(Solution2.groupAnagrams(input));

	}
}
