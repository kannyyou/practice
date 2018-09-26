package com.changhun.leetcode.for201to300;

import java.util.Arrays;

/**
 * Given an array nums of n integers where n > 1,  
 * return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? 
(The output array does not count as extra space for the purpose of space complexity analysis.)
 * @author changhun
 *
 */
public class L238_Product_of_Array_Except_Self {
	public static class Solution1 {
		public static int[] productExceptSelf(int[] nums) {
		    int[] result = new int[nums.length];
		    for (int i = 0, tmp = 1; i < nums.length; i++) {
		        result[i] = tmp;
		        tmp *= nums[i];
		        
		        System.out.println(i + " " + tmp + " " + result[i]);
		    }
		    
		    System.out.println(Arrays.toString(result));
		    for (int i = nums.length - 1, tmp = 1; i >= 0; i--) {
		        System.out.println("a " + i + " " + tmp + " " + result[i]);

		        result[i] *= tmp;
		        tmp *= nums[i];
		        
		        System.out.println("b " + i + " " + tmp + " " + result[i]);

		    }
		    return result;
		}
	}
	
	public static class Solution2 {
		public static int[] productExceptSelf(int[] nums) {
		    int[] result = new int[nums.length];
			for (int i=0; i< nums.length; i++) {
				result[i] = 1;
				for (int j=0; j< nums.length; j++) {
					if (i != j) {
						result[i] *= nums[j];
					}
				} 
			}
		    return result;
		}
	}
	
	public static void main(String[] args) {
		int [] nums = {1,2,3,4};
		
		System.out.println(Arrays.toString(Solution1.productExceptSelf(nums)));
		System.out.println(Arrays.toString(Solution2.productExceptSelf(nums)));

	}
}
