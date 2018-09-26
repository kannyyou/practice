package com.changhun.leetcode.for001to100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
             
             
 * @author changhun
 *
 */
public class L3_Longest_Substring_Without_Repeating_Char {
	/**
	 * O(n^3)
	 * 
	 * @author changhun
	 *
	 */
	public static class Solution1 {
	    public int lengthOfLongestSubstring(String s) {
	        int n = s.length();
	        int ans = 0;
	        for (int i = 0; i < n; i++)
	            for (int j = i + 1; j <= n; j++)
	                if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
	        return ans;
	    }

	    public static boolean allUnique(String s, int start, int end) {
	        Set<Character> set = new HashSet<>();
	        for (int i = start; i < end; i++) {
	            Character ch = s.charAt(i);
	            if (set.contains(ch)) return false;
	            set.add(ch);
	        }
	        return true;
	    }
	}
	
	/**
	 * sliding window
	 * 
	 * time O(2n) = O(n)
	 * Space O(min(m,n))
	 * 
	 * @author changhun
	 *
	 */
	public static  class Solution2 {
	    public static int lengthOfLongestSubstring(String s) {
	        int n = s.length();
	        Set<Character> set = new HashSet<>();
	        int ans = 0, i = 0, j = 0;
	        while (i < n && j < n) {
	            // try to extend the range [i, j]
	            if (!set.contains(s.charAt(j))){
	                set.add(s.charAt(j++));
	                ans = Math.max(ans, j - i);
	            }
	            else {
	                set.remove(s.charAt(i++));
	            }
	        }
	        return ans;
	    }
	}
	
	
	public static class Solution3 {
	    public static int lengthOfLongestSubstring(String s) {
	        int n = s.length(), ans = 0;
	        Map<Character, Integer> map = new HashMap<>(); // current index of character
	        // try to extend the range [i, j]
	        for (int j = 0, i = 0; j < n; j++) {
	            if (map.containsKey(s.charAt(j))) {
	                i = Math.max(map.get(s.charAt(j)), i);
	            }
	            ans = Math.max(ans, j - i + 1);
	            map.put(s.charAt(j), j + 1);
	            System.out.println(ans + " " + map.toString());
	        }
	        
	        return ans;
	    }
	}
	
	public static class Solution4 {
	    public static int lengthOfLongestSubstring(String s) {
	        int n = s.length(), ans = 0;
	        int[] index = new int[128]; // current index of character
	        // try to extend the range [i, j]
	        for (int j = 0, i = 0; j < n; j++) {
	            i = Math.max(index[s.charAt(j)], i);
	            ans = Math.max(ans, j - i + 1);
	            index[s.charAt(j)] = j + 1;
	        }
	        return ans;
	    }
	}
	
	public static void main(String[] args) {
		System.out.println(Solution2.lengthOfLongestSubstring("pwwkew"));
		System.out.println(Solution3.lengthOfLongestSubstring("pwwkew"));

	}
}
