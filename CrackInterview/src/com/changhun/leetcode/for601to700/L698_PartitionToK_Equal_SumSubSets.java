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
public class L698_PartitionToK_Equal_SumSubSets {
//	public static enum Result { TRUE, FALSE }
//    public static boolean canPartitionKSubsets(int[] nums, int k) {
//        int sum = Arrays.stream(nums).sum();
//        System.out.println(sum + " " + (sum % k));
//
//        if (sum % k > 0) return false;
//
//        Result[] memo = new Result[1 << nums.length];
//        memo[(1 << nums.length) - 1] = Result.TRUE;
//
//    	return search(0, sum, memo, nums, sum / k);
//    }
//    
//    public static boolean search(int used)
//    
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num: nums) 
        	sum += num;
        if (sum % k != 0) return false;
                       
        int[] visited = new int[nums.length];
        
        return canPartition(nums, visited, 0, k, 0, sum/k);
    }
    
    /**
     * start_index : index of nums 
     * @param nums
     * @param visited
     * @param start_index
     * @param k
     * @param cur_sum
     * @param cur_num
     * @param target
     * @return
     */
    public static boolean canPartition(int[] nums, int[] visited, int start_index, int k, int cur_sum, int target){
        System.out.println(Arrays.toString(nums) + " " + Arrays.toString(visited) + " start_index " + start_index + " k " + k + " cur_sum " + cur_sum + " target " + target);

        if (k==1) {
        	System.out.println("k == 1");	

        	return true;       
        }
        
        if (cur_sum == target) {
        	//find 1st partition
        	System.out.println("cur_sum == target");	
        	return canPartition(nums, visited, 0, k-1, 0, target);	//try next partition.
        }
                
        for(int i = start_index; i<nums.length; i++){
            System.out.println(i);

            if(visited[i] == 0){
                visited[i] = 1;
                if (canPartition(nums, visited, i+1, k, cur_sum + nums[i], target) ) return true;
                
                System.out.println("false " + i);

                visited[i] = 0;
            }
        }
        return false;
    }
    
	
	
	public static void main(String[] args) {
		int [] nums = {4, 3, 2, 3, 5, 2, 1};
		
		System.out.println(canPartitionKSubsets(nums, 4));
		

	}
}
