package com.changhun.leetcode.for001to100;


public class L7_ReverseInteger {
	/*
	 * Given a 32-bit signed integer, reverse digits of an integer.

	 * Reverse digits of an integer.
		Example1: x = 123, return 321
		Example2: x = -123, return -321
	 */
	public static int reverse(int x) {
		
		long retInt = 0;		
		while (x != 0) {			
			int digit = x % 10;
			
			retInt = retInt * 10 + digit;
			
			x = (x/10);
			
            if( retInt > Integer.MAX_VALUE || retInt < Integer.MIN_VALUE) {
            	return 0;
            }
		}
		
		return (int) retInt;
	}
	
	public static void main(String[] args) {
		
		System.out.println(reverse(-123));
		
		System.out.println(reverse(123));
		System.out.println(reverse(Integer.MAX_VALUE));

	}
}
