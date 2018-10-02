package com.changhun.z.string;

/**
Write a function that takes a string as input and returns the string reversed.

Example 1:

Input: "hello"
Output: "olleh"
Example 2:

Input: "A man, a plan, a canal: Panama"
Output: "amanaP :lanac a ,nalp a ,nam A"

Intuit 
easy

 * @author changhun
 *
 */
public class L344_ReverseString {
	/**
	 * Time O(n) one loop for n character
	 * Space (On) for char[] word
	 * @author changhun
	 *
	 */
	public static class Solution1 {
	    public static String reverseString(String s) {
	    	char[] word = s.toCharArray();
	    	int start = 0;
	    	int last = s.length()-1;
	    	
	    	while (start < last) {
	    		char temp = word[start];
	    		word[start] = word[last];
	    		word[last] = temp;
	    		start ++;
	    		last --;
	    	}
	    	return new String(word);
	    }
	}
	
	public static void main(String[] args) {
		System.out.println(Solution1.reverseString("hello"));
		System.out.println(Solution1.reverseString("A man, a plan, a canal: Panama"));

	}
}
