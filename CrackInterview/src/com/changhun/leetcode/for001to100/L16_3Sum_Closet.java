package com.changhun.leetcode.for001to100;

import java.util.Arrays;


/**
Given an array nums of n integers and an integer target, 
find three integers in nums such that the sum is closest to target. Return the sum of the three integers. 
You may assume that each input would have exactly one solution.

Example:

Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

 * @author changhun
 *
 */
public class L16_3Sum_Closet {
	public static class Solution {
	    public static int threeSumClosest(int[] num, int target) {
	        int result = num[0] + num[1] + num[num.length - 1];
	        Arrays.sort(num);
	        for (int i = 0; i < num.length - 2; i++) {
	            int start = i + 1;
	            int end = num.length - 1;
	            while (start < end) {
	                int sum = num[i] + num[start] + num[end];
	                if (sum > target) {
	                    end--;
	                } else {
	                    start++;
	                }
	                if (Math.abs(sum - target) < Math.abs(result - target)) {
	                    result = sum;
	                }
	            }
	        }
	        return result;
	    }
	}
	
	public static void main(String[] args) {
		int [] nums = {-1, 2, 1, -4};
		System.out.println(Solution.threeSumClosest(nums, 1));
	}
}
