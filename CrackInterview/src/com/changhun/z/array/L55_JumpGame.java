package com.changhun.z.array;
/**
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:

Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.


 * @author changhun
 *
 */

/**
Naming
We call a position in the array a "good index" if starting at that position, 
we can reach the last index. Otherwise, that index is called a "bad index". 
The problem then reduces to whether or not index 0 is a "good index".
Solution
This is a dynamic programming[1] question. Usually, solving and fully understanding a dynamic programming problem is a 4 step process:

1. Start with the recursive backtracking solution
2. Optimize by using a memoization table (top-down[3] dynamic programming)
3. Remove the need for recursion (bottom-up dynamic programming)
4. Apply final tricks to reduce the time / memory complexity
All solutions presented below produce the correct result, but they differ in run time and memory requirements. 


 *
 */
public class L55_JumpGame {
	//Time O(2^n)
	//space O(n) recursive 
	public static class Solution1 {
	    public static boolean canJumpFromPosition(int position, int[] nums) {
	        if (position == nums.length - 1) {
	            return true;
	        }

	        int furthestJump = Math.min(position + nums[position], nums.length - 1);
	        //the above one of both possible.
//	        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
	      	for (int nextPosition = furthestJump; nextPosition > position; nextPosition--) {	
	            if (canJumpFromPosition(nextPosition, nums)) {
	                return true;
	            }
	        }

	        return false;
	    }

	    public static boolean canJump(int[] nums) {
	        return canJumpFromPosition(0, nums);
	    }
	}
	
	public static enum Index {
	    GOOD, BAD, UNKNOWN
	}

	/**
	 *  Dynamic Programming Top-down
	 *  	 * 	//Time O(2^n)
	//space O(n) recursive 
	 * @author changhun
	 *
	 */
	public static class Solution2 {
	    static Index[] memo;

	    public static boolean canJumpFromPosition(int position, int[] nums) {
	        if (memo[position] != Index.UNKNOWN) {
	            return memo[position] == Index.GOOD ? true : false;
	        }

	        int furthestJump = Math.min(position + nums[position], nums.length - 1);
	        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
	            if (canJumpFromPosition(nextPosition, nums)) {
	                memo[position] = Index.GOOD;
	                return true;
	            }
	        }

	        memo[position] = Index.BAD;
	        return false;
	    }

	    public static boolean canJump(int[] nums) {
	        memo = new Index[nums.length];
	        for (int i = 0; i < memo.length; i++) {
	            memo[i] = Index.UNKNOWN;
	        }
	        memo[memo.length - 1] = Index.GOOD;
	        return canJumpFromPosition(0, nums);
	    }
	}
	
	/**
	 * 	//Time O(2^n)
	//space O(n) recursive 
	 * 
	 * Dynamic Programming Bottom-up
	 * Top-down to bottom-up conversion is done by eliminating recursion. 
	 * In practice, this achieves better performance as we no longer have the method stack overhead 
	 * and might even benefit from some caching. More importantly, 
	 * this step opens up possibilities for future optimization. 
	 * The recursion is usually eliminated by trying to reverse the order of the steps from the top-down approach.

The observation to make here is that we only ever jump to the right. 
This means that if we start from the right of the array, every time we will query a position to our right, 
that position has already be determined as being GOOD or BAD. 
This means we don't need to recurse anymore, as we will always hit the memo table.

	 * @author changhun
	 *
	 */
	public static class Solution3 {
	    public static boolean canJump(int[] nums) {
	        Index[] memo = new Index[nums.length];
	        for (int i = 0; i < memo.length; i++) {
	            memo[i] = Index.UNKNOWN;
	        }
	        memo[memo.length - 1] = Index.GOOD;

	        for (int i = nums.length - 2; i >= 0; i--) {
	            int furthestJump = Math.min(i + nums[i], nums.length - 1);
	            for (int j = i + 1; j <= furthestJump; j++) {
	                if (memo[j] == Index.GOOD) {
	                    memo[i] = Index.GOOD;
	                    break;
	                }
	            }
	        }

	        return memo[0] == Index.GOOD;
	    }
	}
	
	/**
	 * 	 * 	//Time O(n)
	//space O(1) 
	 * @author changhun
	 *
	 */
	public static class Solution4 {
	    public static boolean canJump(int[] nums) {
	        int lastPos = nums.length - 1;
	        for (int i = nums.length - 1; i >= 0; i--) {
	            if (i + nums[i] >= lastPos) {
	                lastPos = i;

	            }
	        	System.out.println(i + " " + lastPos);

	        }
	        return lastPos == 0;
	    }
	}
	
	public static void main(String[] args) {
//		int [] num1 = {2,3,1,1,4};
		int [] num1 = {9, 4, 2, 1, 0, 2, 0};
		System.out.println(Solution1.canJump(num1));
		System.out.println(Solution2.canJump(num1));
		System.out.println(Solution3.canJump(num1));
		System.out.println(Solution4.canJump(num1));


	}
}
