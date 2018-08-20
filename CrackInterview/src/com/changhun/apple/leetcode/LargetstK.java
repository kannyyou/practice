package com.changhun.apple.leetcode;

import java.util.Arrays;

public class LargetstK {		
	public static int largestK(int[] array, int k) {
		if (k <= 0 || k > array.length) {
			throw new IllegalArgumentException();
		}
		
		/* Sort array. */
		Arrays.sort(array);
		
		
		/* Copy first k elements. */

		return array[array.length-k];
	}

	public static void main(String[] args) {
		int[] array = {1, 5, 2, 9, 1, 11, 6, 13, 15};
		System.out.println(largestK(array, 1));
	}
	
	
}
