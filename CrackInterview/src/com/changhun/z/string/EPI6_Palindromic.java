package com.changhun.z.string;

public class EPI6_Palindromic {
	/**
	 * time O(n)
	 * space O(1)
	 * @param s
	 * @return
	 */
	public static boolean isPalindromic(String s) {
		for(int i = 0, j = s.length() - 1; i<j; i++, j--) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(isPalindromic("abcba"));
		System.out.println(isPalindromic("abcbb"));

	}
}
