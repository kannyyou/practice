package com.changhun.crackbook.ch1;

import java.util.Arrays;

public class PermutationTest {
	
	public static String sortString(String str) {
		char[] strings = str.toCharArray();
		Arrays.sort(strings);
		return new String(strings);
	}
	
	public static boolean isPermutation(String str1, String str2) {
		if (str1.length() != str2.length()) return false;
		
		str1 = sortString(str1);
		str2 = sortString(str2);
		
		return str1.equals(str2);
	}
	
	public static boolean isPermutation2(String str1, String str2) {
		if (str1.length() != str2.length()) return false;

		int[] letters = new int[128]; //ASCII only
		
		for (int i = 0; i<str1.length(); i++) {
			letters[str1.charAt(i)]++;
		}
		
		for (int i = 0; i<str1.length(); i++) {
			letters[str2.charAt(i)]--; 
			
			if (letters[str2.charAt(i)] < 0) {//means more or less count of charAt[i] in str2.
				return false;
			}
		}
		
		return true;
	}
	public static void main(String[] args) {
		
		System.out.println(isPermutation("God", "dog"));
		System.out.println(isPermutation("god", "dog"));

		System.out.println(isPermutation2("God", "dog"));
		System.out.println(isPermutation2("god", "dog"));
	}
}
