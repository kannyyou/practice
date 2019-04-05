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
//			System.out.println(i + " " + j);
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isPalindromic2(String s) {
		for(int i = 0;  i < s.length(); i++) {		
			if (s.charAt(i) != s.charAt(s.length() - i -1)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(isPalindromic("abcba"));
		System.out.println(isPalindromic("abcbb"));

		
		System.out.println(isPalindromic2("abcba"));
		System.out.println(isPalindromic2("abcbb"));
	}
}
