package com.changhun.z.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
Given a collection of candidate numbers (candidates) and a target number (target), 
find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]
LinkedIn

Medium
 * @author changhun
 *
 */
public class L40_CombinationSum2 {
	public static List<List<Integer>> combinationSum(int[] nums, int target) {
		List<List<Integer>> list = new ArrayList<>();	
		Arrays.sort(nums); // not necessary
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
	            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
//				System.out.println(i);
				tempList.add(nums[i]);	//add each element
//				System.out.println(tempList);
				backtrack(list, tempList, nums, remain - nums[i], i+1);	
//				System.out.println(" remove");

				tempList.remove(tempList.size() - 1);	//otherwise, remove
			}
		}
	} 
	
	
    public static void main(String[] args) {
    	int [] nums = {10,1,2,7,6,1,5};
    	List<List<Integer>> out1 = combinationSum(nums, 8);
    	System.out.println(out1.toString());

    	int [] nums2 = {2,5,2,1,2};
    	List<List<Integer>> out2 = combinationSum(nums2, 5);
    	System.out.println(out2.toString());

	}
}
