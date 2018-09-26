package com.changhun.leetcode.for101to200;

import java.util.ArrayList;
import java.util.List;

/**

Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example:

Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]

LinkedIn
Medium

 * @author changhun
 *
 */
public class L131_PalindromePartitioning {
	public static List<List<String>> partition(String s) {
		List<List<String>> list = new ArrayList<>();
		backtrack(list, new ArrayList<>(), s, 0);
		return list;
	}
	
	private static void backtrack(List<List<String>> list, List<String> tempList, String s, int start) {
//		System.out.println("start=" + start);

		if (start == s.length()) {//there is no way to go further.
		      list.add(new ArrayList<>(tempList));
//		      System.out.println("add" + tempList.toString());

		} else {
			for (int i = start; i < s.length(); i++) {
				if (isPalindrome(s, start, i)) {
//					System.out.println("start=" + start + " i=" + i + " " + s.substring(start, i+1));
					tempList.add(s.substring(start, i + 1));
		            backtrack(list, tempList, s, i + 1);
		            tempList.remove(tempList.size() - 1);
				}
			}
		}
	}
	
	public static boolean isPalindrome(String s, int low, int high){
		while(low < high)
			if(s.charAt(low++) != s.charAt(high--)) return false;
		return true;
	} 
	
	public static void main(String[] args) {
		System.out.println(partition("aab"));
	}

}
