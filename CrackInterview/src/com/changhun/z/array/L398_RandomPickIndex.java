package com.changhun.z.array;

import java.util.Random;

public class L398_RandomPickIndex {
	/*
	 * Given an array of integers with possible duplicates, randomly output the index of a given target number. 
	 * You can assume that the given target number must exist in the array.
	 * Note:
	 * The array size can be very large. Solution that uses too much extra space will not pass the judge.
	 * int[] nums = new int[] {1,2,3,3,3};
	 * Solution solution = new Solution(nums);
	 * 
	 * // pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
	 * solution.pick(3);
	 * 
	 * // pick(1) should return 0. Since in the array only nums[0] is equal to 1.
	 * solution.pick(1);
	 */

	public static class Solution {
		int[] nums;
		Random rand;
		
		public Solution(int[] nums) {
			this.nums = nums;
			this.rand = new Random();
			
		}
		
		public int pick(int target) {
			int total = 0;
			int res = -1;
			for (int i=0; i<nums.length; i++) {

				if (nums[i] == target) {
					// randomly select an int from 0 to the nums of target. 
					// If x equals 0, set the res as the current index. 
					// The probability is always 1/nums for the latest appeared number. 
					// For example, 1 for 1st num, 
					// 1/2 for 2nd num, 1/3 for 3nd num (1/2 * 2/3 for each of the first 2 nums).
	                total++;
					int x = rand.nextInt(total); 
					//This line just add probablilty to pick which one of same number of index.
	                res = (x == 0 ? i : res);

				}
			}
			return res;
		}
	}

	public static void main(String[] args) {
		int[] nums = new int[] {1,2,3,3,3};
		Solution solution = new Solution(nums);
		
		System.out.println(solution.pick(3));
	}
	
}
