package com.changhun.leetcode.for501to600;

import java.util.Arrays;

/**
Given an array consists of non-negative integers, your task is to count the number of triplets chosen 
from the array that can make triangles if we take them as side lengths of a triangle.
Example 1:
Input: [2,2,3,4]
Output: 3
Explanation:
Valid combinations are: 
2,3,4 (using the first 2)
2,3,4 (using the second 2)
2,2,3

 * @author changhun
 *
 */
public class L611_ValidTriangleNumber {
	public static class Solution1 {
	    public static int triangleNumber(int[] nums) {
	        int result = 0;
	        if (nums.length < 3) return result;
	        
	        Arrays.sort(nums);

	        for (int i = 2; i < nums.length; i++) {
	            int left = 0, right = i - 1;
	            while (left < right) {
	                if (nums[left] + nums[right] > nums[i]) {
	                    result += (right - left);		//?
	                    right--;
	                }
	                else {
	                    left++;
	                }
	            }
	        }
	        
	        return result;
	    }
	}
	
	public static void main(String[] args) {
		int [] nums = {2, 2, 3, 4};
		System.out.println(Solution1.triangleNumber(nums));
	}
}