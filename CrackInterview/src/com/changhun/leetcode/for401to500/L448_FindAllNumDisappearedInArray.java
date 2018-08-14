package com.changhun.leetcode.for401to500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]
 * @author changhun
 *
 */
public class L448_FindAllNumDisappearedInArray {
	public static List<Integer> findDisappearedNumbers(Integer[] nums) {

		
		List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < nums.length; i ++) {
        	System.out.println(i + " " + (nums[i]-1)  + " % " + n + " " + ((nums[i]-1) % n) + " " + (nums[(nums[i]-1) % n] + n ) ); 
        	nums[(nums[i]-1) % n] += n;
        	
        }
        
        
        List<Integer> list = Arrays.asList(nums);
        
        System.out.println(list);
        
        for (int i = 0; i < nums.length; i ++) 
        	if (nums[i] <= n) res.add(i+1);
        return res;
    }
	
	public static List<Integer> findDisappearedNumbers2(int[] nums) {
	        List<Integer> ret = new ArrayList<Integer>();
	        
	        for(int i = 0; i < nums.length; i++) {
	            int val = Math.abs(nums[i]) - 1;
	            System.out.println(i + " " + nums[i] + " " + val);
	            if(nums[val] > 0) {           		            	
	                nums[val] = -nums[val];
	            }
	        }
	        
	        for(int i = 0; i < nums.length; i++) {	        	
	        	if(nums[i] > 0) {
	                ret.add(i+1);
	            }
	        }
	        return ret;
	    }
	
	
	public static void main(String[] args) {
		Integer[] nums = {4,3,2,7,8,2,3,1};
		
		int[] nums2 = {4,3,2,7,8,2,3,1};

		
		//System.out.println(findDisappearedNumbers(nums));

		System.out.println(findDisappearedNumbers2(nums2));

		System.out.println(3 % 8);
	}
}
