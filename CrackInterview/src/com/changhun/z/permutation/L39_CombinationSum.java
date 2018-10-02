package com.changhun.z.permutation;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), 
find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]

LinkedIn

Medium
 * @author changhun
 *
 */
public class L39_CombinationSum {
	public static List<List<Integer>> combinationSum(int[] nums, int target) {
		List<List<Integer>> list = new ArrayList<>();	
//		Arrays.sort(nums); // not necessary
		backtrack(list, new ArrayList<>(), nums, target, 0);
		return list;
	}
	
	private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
	    if(remain < 0) return;
	    else if (remain == 0) {
//			System.out.println(" add");
			list.add(new ArrayList<>(tempList));
		} else{
			for(int i = start; i < nums.length; i++){ 
//				System.out.println(i);
				tempList.add(nums[i]);	//add each element
//				System.out.println(tempList);
				backtrack(list, tempList, nums, remain - nums[i], i);	//check this is target sum ?, we may reuse!!!
//				System.out.println(" remove");

				tempList.remove(tempList.size() - 1);	//otherwise, remove
			}
		}
	} 
	
	
	public static class Solution1 {
		public static List<List<Integer>> combinationSum(int[] nums, int target) {
			List<List<Integer>> list = new ArrayList<>();
			backtrack(list, new ArrayList<>(), nums, target, 0);
			return list;
		}
		
		public static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start) {
			if (remain < 0)
				return;
			else if (remain == 0) {
				list.add(new ArrayList<>(tempList));
			} else {
				for (int i= start; i < nums.length; i++) {
					tempList.add(nums[i]);
					backtrack(list, tempList, nums, remain - nums[i], i);
					tempList.remove(tempList.size() - 1);
				}
			}
				
		}
	}
	
    public static void main(String[] args) {
    	int [] nums = {2,6,3,7};
    	List<List<Integer>> out1 = combinationSum(nums, 7);
    	System.out.println(out1.toString());

    	int [] nums2 = {2,5,3};
    	List<List<Integer>> out2 = combinationSum(nums2, 8);
    	System.out.println(out2.toString());

	}
}
