package com.changhun.leetcode.for001to100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

LinkedIn
pinterest
Intuit

easy

 * @author changhun
 *
 */
public class L1_TwoSum {
	public static int[] twoSum(int[] nums, int target) {
	    Map<Integer, Integer> map = new HashMap<>();
	    for (int i = 0; i < nums.length; i++) {
	        int complement = target - nums[i];
	        if (map.containsKey(complement)) {
	            return new int[] { map.get(complement), nums[i] };
	        }
	        map.put(nums[i], i);
	    }
	    throw new IllegalArgumentException("No two sum solution");
	}
	
	public static int[] twoSumSet(int[] nums, int target) {
		HashSet<Integer> set = new HashSet<Integer>();
		
		for (int num: nums)  {

			int complement = target - num;
			
			if (set.contains(complement)) {
				return new int[] {complement, num};
			}
			set.add(num);
			
		}
	    throw new IllegalArgumentException("No two sum solution");

	}
	
	
	public static void main(String[] args) {
		int[] nums = new int[] {0, 1, 3, 5, -1, -2, -3};
		
		
		int[] ret = twoSum(nums, 0);
		
		for (int num : ret) {
			System.out.print(num + " ");

		}
		System.out.println();
		
		int[] rets = twoSumSet(nums, 0);
		
		for (int num : rets) {
			System.out.print(num + " ");

		}
				
	}
}
