package com.changhun.z.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/**
 * Write a program that takes an array A of n numbers, and rearranges A's elements to get a new array B having
 * the property that B[0] <= B[1] >= B[2] <= B[3] >= B[4] <= B[5] >= ...
 * 
 * 1. Sort and interleave...
 * => no need to sort
 * 
 * +> just simply rearrange the elements 
 * 
 * @author changhun
 *
 */
public class EP5_8_Computing_Alternation {
	public static void rarrange(List<Integer> nums) {
		for (int i = 1; i < nums.size(); i++) {
			System.out.print(i);
			if (((i % 2) == 0 && nums.get(i-1) < nums.get(i)) ||
					((i % 2) != 0 && nums.get(i-1) > nums.get(i))) {
				Collections.swap(nums, i-1, i);
				System.out.print(" swap ");
			}
			System.out.println();
		}

	}
	
	public static void main(String[] args) {
		List<Integer> numList = Arrays.asList(0,1,2,3,4,5,6);
		rarrange(numList);
		System.out.println(numList.toString());
	}
}
