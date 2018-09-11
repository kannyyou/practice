package com.changhun.leetcode.for001to100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L78_Subsest {
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
	
	/**
	 s = 0 []
	 s = 0, i = 0 [4]
	 	s = 1 set [4]
	 	s = 1, i = 1 [4,5]
	 		s = 2 set [4,5]
	 		s = 2 [4, 5, 6]
	 		 	s = 3 set [4,5,6]
	 		s = 2, i= 2 remove
	 	s = 1, i = 1  remove
	 	s = 1, i = 2 add [4,6]
	 			s = 3 set [4, 6]
	 			
		s = 1, i = 2 remove
	s = 0, i = 0 remove
	s = 0 , i = 1 [5]
		s = 2, i = 2 [5,6]
			s = 3 set [5,6]
		s = 2, i =2 remove
	s = 0 i =1 rmeove
	s = 0, i =2 set [6]
		s =3 [6]
		
		
	 * @param list
	 * @param tempList
	 * @param nums
	 * @param start
	 */
	private static void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
		list.add(new ArrayList<>(tempList));
		System.out.println(start + " set " + tempList.toString());
	    for(int i = start; i < nums.length; i++){
	        tempList.add(nums[i]);	        
	        System.out.println(start + " " + i + " add " + nums[i]);
	        backtrack(list, tempList, nums, i + 1);
	        tempList.remove(tempList.size() - 1);
	        System.out.println(start + " " + i + " remove");
	    }

	}
	
	public static void main(String[] args) {
		int[] nums = {4,5,6};
		
		List<List<Integer>> set = subsets(nums);
		
		System.out.print(set);
	}

}
