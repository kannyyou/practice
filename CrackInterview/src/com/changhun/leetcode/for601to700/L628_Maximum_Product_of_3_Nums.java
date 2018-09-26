package com.changhun.leetcode.for601to700;

import java.util.Arrays;

/**
Given an integer array, find three numbers whose product is maximum and output the maximum product.

Example 1:
Input: [1,2,3]
Output: 6
Example 2:
Input: [1,2,3,4]
Output: 24
Note:
The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.


 * @author changhun
 *
 */
public class L628_Maximum_Product_of_3_Nums {
	/**
	 * Brute force
	 * 
	 * Time : O(O^3)
	 * Space : O(1)
	 * @author changhun
	 *
	 */
	public static class Solution1 {
	    public static int maximumProduct(int[] nums) {
	    	int maxProduct = Integer.MIN_VALUE;
			for (int i = 0; i < nums.length-2; i++) {
				for (int j = i + 1; j < nums.length-1; j++) {
					for (int k = j + 1; k < nums.length; k++) {
						int product = nums[i] * nums[j] * nums[k];
						if (maxProduct < product) 
							maxProduct = product;
					}
				}
			}
			return maxProduct;
	    }
	}
	
	/**
	 Using Sorting
	 - or + so.. first 3 or last 3
	 Time : O(nlogn)
	 Space : O(logn)
	 
	 * @author changhun
	 *
	 */
	public static class Solution2 {
		public static int maximumProduct(int[] nums) {
	        Arrays.sort(nums);//sort O(nlogn)
	        return Math.max(nums[0] * nums[1] * nums[nums.length - 1], 
	        		nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
	    }
	}
	
	/**
	 * 
We need not necessarily sort the given numsnums array to find the maximum product. 
Instead, we can only find the required 2 smallest values(min1 and min2) 
and the three largest values(max1, max2, max3, max1,max2,max3) in the numsnums array, 
by iterating over the numsnums array only once.

At the end, again we can find out the larger value out of min1 x min2 x max1 and max1 x max2 x max3 
to find the required maximum product.

Time complexity : O(n). Only one iteration over the nums array of length n is required.

Space complexity : O(1). Constant extra space is used.

	 * @author changhun
	 *
	 */
	public static class Solution3 {
	    public static int maximumProduct(int[] nums) {
	        int min1 = Integer.MAX_VALUE;
	        int min2 = Integer.MAX_VALUE;
	        
	        int max1 = Integer.MIN_VALUE;
	        int max2 = Integer.MIN_VALUE;
	        int max3 = Integer.MIN_VALUE;
	        
	        for (int n: nums) {
	            if (n <= min1) {
	                min2 = min1;
	                min1 = n;
	            } else if (n <= min2) {     // n lies between min1 and min2
	                min2 = n;
	            }
	            
	            if (n >= max1) {            // n is greater than max1, max2 and max3
	                max3 = max2;
	                max2 = max1;
	                max1 = n;
	            } else if (n >= max2) {     // n lies betweeen max1 and max2
	                max3 = max2;
	                max2 = n;
	            } else if (n >= max3) {     // n lies betwen max2 and max3
	                max3 = n;
	            }
	        }
	        return Math.max(min1 * min2 * max1, max1 * max2 * max3);

	    }       
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		
		System.out.println(Solution1.maximumProduct(nums));
		System.out.println(Solution2.maximumProduct(nums));
		System.out.println(Solution3.maximumProduct(nums));

	}
}
