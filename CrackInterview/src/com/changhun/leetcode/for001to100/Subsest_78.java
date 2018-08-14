package com.changhun.leetcode.for001to100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsest_78 {
	/*Given a set of distinct integers, nums, return all possible subsets.
	Note: The solution set must not contain duplicate subsets.
	For example,
	If nums = [1,2,3], a solution is:
	   	[3],
  		[1],
  		[2],
  		[1,2,3],
  		[1,3],
  		[2,3],
  		[1,2],
  		[]
	 */
	
	public static List<List<Integer>> subsets(int[] nums) {
	    List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums);
	    backtrack(list, new ArrayList<>(), nums, 0);
	    
	    return list;
	}

	private static void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
//		System.out.println("list " + list);
//		System.out.println("tempList " + tempList);
//		System.out.println("s " + " (" + tempList + ") " + start);
		
		list.add(new ArrayList<>(tempList));
//		System.out.println("\tlist " + list);

	    for(int i = start; i < nums.length; i++){
	    	

	    	
	        tempList.add(nums[i]);
	        
			System.out.println("backtrack (" + list + ") *** (" + tempList + ") " + (i+1));

	        
	        backtrack(list, tempList, nums, i + 1);
		    System.out.println("\tbefore " + tempList + " " + i);

	        tempList.remove(tempList.size() - 1);
		    System.out.println("\tafter " + tempList);

	    }
	    System.out.println("\t\t ret " + list + " *** " + tempList);

	}
	
	public static void main(String[] args) {
		int[] nums = {4,5,6};
		
		List<List<Integer>> set = subsets(nums);
		
		System.out.print(set);
	}

}
