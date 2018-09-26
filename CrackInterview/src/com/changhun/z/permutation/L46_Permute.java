package com.changhun.z.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

LinkedIn
Medium
 * @author changhun
 *
 */
public class L46_Permute {	
	/**
	 * First 
	 * i = 0 add 1 to templist (1)
	 * backtrack
	 * 		i = 0 skip 1
	 *  	i = 1 add nums[1] to templist (1,2)
	 *    		backtrack
	 *      		i = 0 skip
	 *      		i = 1 skip
	 *      		add nums[2] to templist (1,2,3)
	 *      			backtrack
	 *         				add templist to list
	 *      			remove templist[2]
	 *    			remove templist[1]
	 *  	i=2 add 3 templist (1,3)
	 *  		backtrack
	 *  			i=0 skip
	 *  			i=1 add nums[2] to templist (1,3,2)
	 *  				backtrack
	 *  					add templist to list
	 * 					remove
	 * 				remove
	 * 		remove
	 * i =1 add 2 to templist (2)
	 * 	
	 * 
1
	1,2
		1,2,3
	1,3
		1,3,2
2	
	2,1
		2,1,3
	2,3	
		2,3,1
3
	3,1
		3,1,2
	3,2
		3,2,1
		
	 */
	public static class Solution1 {
		public static List<List<Integer>> permute(int[] nums) {
			List<List<Integer>> list = new ArrayList<>();
			// Arrays.sort(nums); // not necessary
			backtrack(list, new ArrayList<>(), nums);
			return list;
		}
		

		private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
			if (tempList.size() == nums.length){
//				System.out.println(" add");

				list.add(new ArrayList<>(tempList));
			} else{
				for(int i = 0; i < nums.length; i++){ 
//					System.out.println(i);
					if(tempList.contains(nums[i])) continue; // element already exists, skip
					tempList.add(nums[i]);	//add each element
//					System.out.println(tempList);
					backtrack(list, tempList, nums);	//check this is the same size
//					System.out.println(" remove");

					tempList.remove(tempList.size() - 1);	//otherwise, remove
				}
			}
		} 
	}

	public static class Solution2 {
		public static List<List<Integer>> permute(int[] nums) {
			List<List<Integer>> list = new ArrayList<>();
			backtrack(list, new ArrayList<>(), nums);
			return list;
		}
		
		private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums) {
			if (tempList.size() == nums.length) {
				//ready as permutation
				list.add(new ArrayList<>(tempList));
			
			} else {
				for (int i=0; i < nums.length; i++ ) {
					if (tempList.contains(nums[i])) continue;
					tempList.add(nums[i]);	//add
					backtrack(list, tempList, nums);	//check
					tempList.remove(tempList.size() - 1); 	//remove
				}
			}					
		}
	}
	
	
	
	public static void main(String[] args) {
		int [] nums = {1,2,3};
		System.out.println(Solution1.permute(nums).toString());
		System.out.println(Solution2.permute(nums).toString());

	}
		
		
}	
