package com.changhun.leetcode.for601to700;

import java.util.Arrays;

/**
 * Given an array of integers nums and a positive integer k, 
 * find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.

Example 1:
Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
Output: True
Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
Note:

1 <= k <= len(nums) <= 16.
0 < nums[i] < 10000.


LinkedIn Hard

 * @author changhun
 *
 */
public class L698_PartitionToK_Equal_SumSubSets3 {
	public static enum Result { TRUE, FALSE }

    public static boolean search(int used, int todo, Result[] memo, int[] nums, int target) {
    	System.out.println(used + " " + todo + " " + Arrays.toString(memo) + " " + Arrays.toString(nums) + " " + target);
        if (memo[used] == null) {
            memo[used] = Result.FALSE;
            int targ = (todo - 1) % target + 1;
            for (int i = 0; i < nums.length; i++) {
                if ((((used >> i) & 1) == 0) && nums[i] <= targ) {
                    if (search(used | (1<<i), todo - nums[i], memo, nums, target)) {
                        memo[used] = Result.TRUE;
                        break;
                    }
                }
            }
        }
        return memo[used] == Result.TRUE;
    }
    public static  boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k > 0) return false;

        Result[] memo = new Result[1 << nums.length];
        memo[(1 << nums.length) - 1] = Result.TRUE;
        return search(0, sum, memo, nums, sum / k);
    }
	
	
	public static void main(String[] args) {
		int [] nums = {4, 3, 2, 3, 5, 2, 1};
		
		System.out.println(canPartitionKSubsets(nums, 4));
		

	}
}
