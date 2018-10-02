package com.changhun.z.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3, 4]
Output:
[
 {1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 4} , {3, 4}
]

LinkedIn
Apple
Medium
 * @author changhun
 *
 */
public class L46_Permute_with_size {		
	public static List<List<Integer>> permute(int[] nums, int k) {
		List<List<Integer>> list = new ArrayList<>();	
		Arrays.sort(nums); // not necessary
		int n = nums.length;
		backtrack(list, new ArrayList<>(), nums, 0, k, k);
		return list;
	}
	
	private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int start, int k, int ck){
//		System.out.println("call");

		if (tempList.size() == k){
//			System.out.println(" add");

			list.add(new ArrayList<>(tempList));
		} else{
			for(int i = start; i < nums.length; i++){ 
//				System.out.println(i);
				if(tempList.contains(nums[i])) continue; // element already exists, skip
				tempList.add(nums[i]);	//add each element
//				System.out.println(tempList);
				backtrack(list, tempList, nums, i+1, k, ck-1);	//check this is the same size
//				System.out.println(" remove");

				tempList.remove(tempList.size() - 1);	//otherwise, remove
			}
		}
	} 
	
	/**
	 * 				combine(combs, comb, i+1, n, k-1);	// go to next location k-1
				System.out.println("remove");
				comb.remove(comb.size()-1);	//remove current location to add next one.
	 * @param args
	 */
	
	public static class Solution1 {
		public static List<List<Integer>> premute(int[] nums, int k) {
			List<List<Integer>> list = new ArrayList<>();
			backtrack(list, new ArrayList<>(), nums, 0, k, k);
			return list;
		}
		
		public static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start, int k, int ck) {
			if (tempList.size() == k) {
				list.add(new ArrayList<>(tempList));
			} else {
				for (int i = start; i < nums.length; i++) {
					if (tempList.contains(nums[i])) continue;
					tempList.add(nums[i]);
					backtrack(list, tempList, nums, i+1, k, ck-1);
					tempList.remove(tempList.size()-1);
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		int [] nums = {1,2,3, 4};
		System.out.println(permute(nums, 2).toString());
		System.out.println(permute(nums, 3).toString());
		System.out.println(permute(nums, 1).toString());

	}
		
		
}	
