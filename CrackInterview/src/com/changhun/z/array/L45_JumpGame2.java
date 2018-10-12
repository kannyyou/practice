package com.changhun.z.array;

import com.changhun.z.array.L55_JumpGame.Solution1;
import com.changhun.z.array.L55_JumpGame.Solution2;
import com.changhun.z.array.L55_JumpGame.Solution3;
import com.changhun.z.array.L55_JumpGame.Solution4;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

Example:

Input: [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2.
    Jump 1 step from index 0 to 1, then 3 steps to the last index.


 * @author changhun
 *
 */
public class L45_JumpGame2 {
	public static class Solution1 {
		// need to use bfs 11 ms very fast and neat
		public static int jumpBfs(int[] nums) {
		    int low = 0, high = 0;
		    for (int k = 0; k < nums.length; k ++) {
		        if (low > high) break;
		        int farthest = 0;
		        for (int i = low; i < high + 1; i++) {
		            if (nums[i] + i >= nums.length -1) return k + 1;
		            farthest = Math.max(farthest, nums[i] + i);
		        }
		        low = high +1;
		        high = farthest;
		    }
		    throw new java.lang.RuntimeException("No such path!");
		}
	}
	public static class Solution2 {
		public static int jump(int[] A) {
		    int currentStep = 0;
		    int next = 0;
		    int currentFurthest = 0;
		    for(int i=0; i<A.length-1; i++) {
		        currentFurthest = Math.max(currentFurthest, i+A[i]);
		        if( i == next ) {
		        	currentStep ++;
		            next = currentFurthest;
		        } 
		    }
		    return currentStep;
		}
	}

	
	public static void main(String[] args) {
		int [] num1 = {2,3,1,1,4};
//		int [] num1 = {9, 4, 2, 1, 0, 2, 0};
		System.out.println(Solution1.jumpBfs(num1));
		System.out.println(Solution2.jump(num1));
//		System.out.println(Solution3.canJump(num1));
//		System.out.println(Solution4.canJump(num1));


	}
}
