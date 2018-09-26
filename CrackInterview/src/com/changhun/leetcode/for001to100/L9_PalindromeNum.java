package com.changhun.leetcode.for001to100;

/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true
Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
Follow up:

Coud you solve it without converting the integer to a string?
å
 * @author changhun
 *
 */
public class L9_PalindromeNum {
	public static boolean isPalindrome(int x) {
		
		if (x < 0) return false;
		
		int p = x;
		int q = 0;
		
		while (p >= 10) {			
			q *= 10;
			q += p%10;
			p /= 10;		
		}
		System.out.println(p + " " + q);

		return q == x/10 && p == x % 10;
	}
	
	public static void main(String[] args) {
		
		System.out.println(isPalindrome(12321));

	} 
}
