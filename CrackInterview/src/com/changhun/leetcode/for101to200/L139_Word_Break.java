package com.changhun.leetcode.for101to200;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false


 * @author changhun
 *
 */
public class L139_Word_Break {
	/**
The naive approach to solve this problem is to use recursion and backtracking. 
For finding the solution, we check every possible prefix of that string in the dictionary of words, 
if it is found in the dictionary, then the recursive function is called for the remaining portion of that string. 
And, if in some function call it is found that the complete string is in dictionary, then it will return true.

Time O(n^n)
Space O(n)

	 * @author changhun
	 *
	 */
	public static class Solution1 {
	    public static boolean wordBreak(String s, List<String> wordDict) {
	        return word_Break(s, new HashSet(wordDict), 0);
	    }
	    public static boolean word_Break(String s, Set<String> wordDict, int start) {
	        if (start == s.length()) {
	            return true;
	        }
	        for (int end = start + 1; end <= s.length(); end++) {
	            if (wordDict.contains(s.substring(start, end)) && word_Break(s, wordDict, end)) {
	                return true;
	            }
	        }
	        return false;
	    }
	}
	
	public static class Solution2 {
	    public static boolean wordBreak(String s, List<String> wordDict) {
	        return word_Break(s, new HashSet(wordDict), 0, new Boolean[s.length()]);
	    }
	    public static boolean word_Break(String s, Set<String> wordDict, int start, Boolean[] memo) {
	        if (start == s.length()) {
	            return true;
	        }
	        if (memo[start] != null) {
	            return memo[start];
	        }
	        for (int end = start + 1; end <= s.length(); end++) {
	            if (wordDict.contains(s.substring(start, end)) && word_Break(s, wordDict, end, memo)) {
	                return memo[start] = true;
	            }
	        }
	        return memo[start] = false;
	    }
	}
	
	/**
Time complexity : O(n^2). For every starting index, the search can continue till the end of the given string.

Space complexity : O(n). Queue of atmost n size is needed. 

	 * @author changhun
	 *
	 */
	public static class Solution3 {
	    public static boolean wordBreak(String s, List<String> wordDict) {
	        Set<String> wordDictSet = new HashSet(wordDict);
	        Queue<Integer> queue = new LinkedList<>();
	        int[] visited = new int[s.length()];
	        queue.add(0);
	        while (!queue.isEmpty()) {
	            int start = queue.remove();
	            if (visited[start] == 0) {
	                for (int end = start + 1; end <= s.length(); end++) {
	                    if (wordDictSet.contains(s.substring(start, end))) {
	                        queue.add(end);
	                        if (end == s.length()) {
	                            return true;
	                        }
	                    }
	                }
	                visited[start] = 1;
	            }
	        }
	        return false;
	    }
	}
	
	public static class Solution4 {
	    public static boolean wordBreak(String s, List<String> wordDict) {
	        Set<String> wordDictSet=new HashSet(wordDict);
	        boolean[] dp = new boolean[s.length() + 1];
	        dp[0] = true;
	        for (int i = 1; i <= s.length(); i++) {
	            for (int j = 0; j < i; j++) {
	                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
	                    dp[i] = true;
	                    break;
	                }
	            }
	        }
	        return dp[s.length()];
	    }
	}
	
	public static void main(String[] args) {
		
		List<String> list1 = new ArrayList<String>();
		list1.add("apple");
		list1.add("dog");
		
		System.out.println(Solution1.wordBreak("appledog", list1));
		System.out.println(Solution2.wordBreak("appledog", list1));
		System.out.println(Solution3.wordBreak("appledog", list1));
		System.out.println(Solution4.wordBreak("appledog", list1));

	}
}
