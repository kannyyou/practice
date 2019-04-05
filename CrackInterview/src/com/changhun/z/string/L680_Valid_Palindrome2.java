package com.changhun.z.string;


/**
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True
Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
Note:
The string will only contain lowercase characters a-z. The maximum length of the string is 50000.

 * @author changhun
 *
 */
public class L680_Valid_Palindrome2 {
	/**
	 * For each index i in the given string, let's remove that character, then check if the resulting string is a palindrome. 
	 * If it is, (or if the original string was a palindrome), then we'll return true
	 * @author changhun
	 *
	 */
	public static class Solution1 {
	    public static boolean isPalindrome(CharSequence s) {
	        for (int i = 0; i < s.length() / 2; i++) {
	            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
	                return false;
	            }
	        }
	        return true;
	    }
	    public static boolean validPalindrome(String s) {
	        StringBuilder sb = new StringBuilder(s);
	        for (int i = 0; i < s.length(); i++) {
	            char c = sb.charAt(i);
	            sb.deleteCharAt(i);
	            if (isPalindrome(sb)) return true;
	            sb.insert(i, c);
	        }
	        return isPalindrome(s);
	    }
	}
	
	
	public static class Solution2 {
	    public static boolean isPalindromeRange(String s, int i, int j) {
	        for (int k = i; k <= i + (j - i) / 2; k++) {
	            if (s.charAt(k) != s.charAt(j - k + i)) return false;
	        }
	        return true;
	    }
	    
	    public static boolean validPalindrome(String s) {
	        for (int i = 0; i < s.length() / 2; i++) {
	            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
	            	System.out.println(s.charAt(s.length()-1-i));
	                int j = s.length() - 1 - i;
	                return (isPalindromeRange(s, i+1, j) ||
	                        isPalindromeRange(s, i, j-1));
	            }
	        }
	        return true;
	    	
	    }
	}
	
	public static void main(String[] args) {
		System.out.println(Solution1.validPalindrome("aba"));
		System.out.println(Solution1.validPalindrome("abca"));
		System.out.println(Solution1.validPalindrome("abcda"));

		System.out.println(Solution2.validPalindrome("aba"));
		System.out.println(Solution2.validPalindrome("abca"));
		System.out.println(Solution2.validPalindrome("abcda"));

		
		
	}
}
