package com.changhun.leetcode.for001to100;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:


{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

pinterest
medium


 * @author changhun
 *
 */
public class L17_Letter_Combinations_of_Phone_Number {
	
	/**
	 * O(4^n)
	 * space O(N)
	 * @param digits
	 * @return
	 */
	public static List<String> letterCombinations(String digits) {
		LinkedList<String> ans = new LinkedList<String>();
		
		if(digits.isEmpty()) return ans;
		
		String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		
		ans.add("");
		
		for(int i = 0; i<digits.length();i++){
			int x = Character.getNumericValue(digits.charAt(i));
			while(ans.peek().length()==i){
				String t = ans.remove();
				for(char s : mapping[x].toCharArray())
					ans.add(t+s);
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		System.out.println(letterCombinations("23").toString());
	}
}
