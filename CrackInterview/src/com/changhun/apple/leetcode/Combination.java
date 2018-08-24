package com.changhun.apple.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Combination {
	private static int[] getSubArray(int [] nums, int s) {
		int [] outArray = new int[nums.length - (s+1)];
		      
		for (int i=s+1; i<nums.length; i++) {
			outArray[i-(s+1)] = nums[i];
		}  
		return outArray;
	}

	public static ArrayList<ArrayList<Integer>> combine (int [] nums, int k) {
		if (k==1) {
			ArrayList<ArrayList<Integer>> outList = new ArrayList<ArrayList<Integer>>();
		      
			for (int num: nums) {
				ArrayList<Integer> each = new ArrayList<Integer>();
		        each.add(num);
		        outList.add(each);
			}  
		      
			return outList;
		}
		    
		ArrayList<ArrayList<Integer>> finalList = new ArrayList<ArrayList<Integer>>();

		for (int i =0; i< nums.length ; i++) {
		    int [] sub_array = getSubArray(nums, i);
		       
		      
		    ArrayList<Integer> firstList = new ArrayList<Integer>();
		    firstList.add(nums[i]);
		    ArrayList<ArrayList<Integer>> ret_list = combine(sub_array, k-1);           
		      
		    for (ArrayList<Integer> list : ret_list) {
		        
		    	ArrayList<Integer> each = new ArrayList();
		        each.addAll(firstList);
		        each.addAll(list);
		        
		        finalList.add(each);
		                
		      }
		}
		        
		return finalList;
		      
	}
		    
	public static void main(String[] args) {
		int [] nums = {1, 3, 4, 5};
		ArrayList<ArrayList<Integer>> outList = combine(nums, 3);
		    
		System.out.println(outList.toString());
		
	}
}



