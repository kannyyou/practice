package com.changhun.z.string;

/***
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false

 * @author changhun
 *
 */
public class L125_Valid_Palindrome {
	public static boolean isPalindrome(String s) {
		if (s.isEmpty()) return true;
		
		int head = 0, tail = s.length() - 1;
		char cHead, cTail;
		
		while(head <= tail) {
			cHead = s.charAt(head);
			cTail = s.charAt(tail);
			
			if (!Character.isLetterOrDigit(cHead)) {
				head ++;
			} else if (!Character.isLetterOrDigit(cTail)) {
				tail --;
			} else {
				// compare here
				if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
					return false;
				} 
				head ++;
				tail --;
			}
		}
		return true;
		
	}
	
	public static boolean isPalindrome2(String s) {
		int head = 0;
		int tail = s.length() - 1;
		
		while (head <= tail) {
			while (head <= tail && !Character.isLetterOrDigit(s.charAt(head))) {
				head ++;
			}
			while (head <= tail && !Character.isLetterOrDigit(s.charAt(tail))) {
				tail --;
			}
			
            if( head <= tail && Character.toLowerCase(s.charAt(head)) != Character.toLowerCase(s.charAt(tail))) {
                return false;
            }
            head++;
            tail--;
		}
		return true;
	}
 
	
	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome("race a car"));

		System.out.println(isPalindrome2("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome2("race a car"));
	}
}
