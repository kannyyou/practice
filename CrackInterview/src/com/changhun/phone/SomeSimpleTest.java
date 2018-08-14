package com.changhun.phone;

// Write function to print the odd numbers from 1 to 99.
public class SomeSimpleTest {
	
	public static void prinOddNum() {
		for (int i=1; i<100; i+=2) {
			System.out.print(i + " ");
		}
	}
	
	public static int getMax(int[] nums) {
		int max = Integer.MIN_VALUE;
		for (int cur: nums) {
			if (cur > max) {
				max =cur;
			}
		}
		return max;
	}
	
	public static String formatRGB ( int r, int g, int b ) {
		return ("#" + toHex(r) + toHex(g) + toHex(b)).toUpperCase();
	}

	public static String toHex ( int c ) {
		String s = Integer.toHexString ( c );
		return ( s.length() == 1 ) ? "0" + s : s;
	}
	
	
	public static void main(String[] args) {
		int[] nums ={ 1,5,2,10,-1000,3, 2};
		System.out.println(getMax(nums));
		
		System.out.println(Integer.toHexString(16));
		
		
		System.out.println(toHex(255));

		System.out.println(formatRGB(255,255,255));
		
	}
}
