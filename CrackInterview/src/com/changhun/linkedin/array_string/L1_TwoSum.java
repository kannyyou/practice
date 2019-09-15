package com.changhun.linkedin.array_string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
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
	/**
	 * brute force 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSumBF(int[] nums, int target) {
	    for (int i = 0; i < nums.length; i++) {
	        for (int j = i + 1; j < nums.length; j++) {
	            if (nums[j] == target - nums[i]) {
	                return new int[] { i, j };
	            }
	        }
	    }
	    throw new IllegalArgumentException("No two sum solution");
	}	
	/**
	 * Utilize hash map : key : value, value : index of value
	 * @param nums
	 * @param target
	 * @return
	 */
	
	public static int[] twoSum(int[] nums, int target) {
	    Map<Integer, Integer> map = new HashMap<>();	//key os complement (target - val) and value is index of val.
	    for (int i = 0; i < nums.length; i++) {
	        int complement = target - nums[i];
			// complement is in set ?
	        if (map.containsKey(complement)) {
	            return new int[] { map.get(complement), i};
	        }
	        map.put(nums[i], i);
	    }
	    throw new IllegalArgumentException("No two sum solution");
	}
	
	/**
	 * Something different, it return value, no index
	 * utilize hashSet : to contain value that is a candidate complement. 
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] twoSumSet(int[] nums, int target) {
		Set<Integer> set = new HashSet<Integer>();
		
		for (int num: nums)  {
			int complement = target - num;	
			// complement is in set ?
			if (set.contains(complement)) {
				return new int[] {complement, num};
			}
			set.add(num);
			
		}
	    throw new IllegalArgumentException("No two sum solution");

	}
	
	
	public static void main(String[] args) {
		int[] nums = new int[] {2,7,11,15};
		
		
		int[] ret = twoSum(nums, 9);
		
		for (int num : ret) {
			System.out.print(num + " ");

		}
		System.out.println();
		
		int[] rets = twoSumSet(nums, 9);
		
		for (int num : rets) {
			System.out.print(num + " ");

		}
				
	}
}
