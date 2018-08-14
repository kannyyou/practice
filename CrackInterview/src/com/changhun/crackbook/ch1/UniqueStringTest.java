package com.changhun.crackbook.ch1;

import java.math.BigInteger;

public class UniqueStringTest {
	public static boolean isUniqueString(String str) {
		if (str.length() > 128) return false;
		
		boolean [] char_set = new boolean[128];
		
		for (int i=0; i<str.length(); i++) {
			int val = str.charAt(i);
			
			if (char_set[val]) {
				return false;
			}
			char_set[val] = true;
		}
		return true;
	}
	
	public static boolean isExtendUniqueString(String str) {
		int checker = 0;
		for (int i=0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0) {
				return false;
			}
			checker |= (1 << val);
			System.out.println(str.charAt(i) + " " + checker);
		}
		return true;
	}
	 
	public static void main(String[] args) {
		
		System.out.println(Integer.toBinaryString(1 << 'a'));
		
		System.out.println(isUniqueString("AAAA"));
		System.out.println(isUniqueString("ABCDEFG"));

		System.out.println(isExtendUniqueString("AAAA"));
		System.out.println(isExtendUniqueString("ABCDEFG"));
		
		BigInteger bigInteger = BigInteger.TEN;
		bigInteger.flipBit(1);
		
		System.out.println(bigInteger);
		System.out.println(bigInteger.flipBit(1));
		
		
	}	
}
