package com.changhun.z.array;

public class A_BinarySearch {
	/**
	 * Input : sorted array!!!
	 * O(log n)
	 * @author changhun
	 *
	 */
	public static class Solution1 {
		public static int binarySearch(int [] nums, int target) {
			return binarySearch(nums, target, 0, nums.length-1);
		}
		
		private static int binarySearch(int [] nums, int target, int left, int right) {
			if (left > right) return -1;
			else {
				int mid = (left + right) /2 ;
				
				if (nums[mid] == target) return mid;
				
				//target < mid go to left
				if (nums[mid] > target) return binarySearch(nums, target, left, mid - 1);
				else return binarySearch(nums, target, mid + 1, right);
			}
			
		}
	}
	
	public static class Solution2 {
		public static int binarySearch(int [] nums, int target) {
			int left = 0;
			int right = nums.length -1;
			
			while (left <= right) {
				int mid = (left + right)/2;
				
				if (nums[mid] == target) return mid;
				
				//target < mid go to left
				if (nums[mid] > target) right =  mid - 1;
				else left = mid + 1;
			}
	        return -1; 
		}	
	}
	
	
    public static void main(String args[]) { 
        int [] nums = {2,3,7,10,40}; 
        int result = Solution1.binarySearch(nums, 10); 
        if (result == -1) 
            System.out.println("Element not present"); 
        else
            System.out.println("Element found at index " + result); 
        
        
        result = Solution2.binarySearch(nums, 10); 
        if (result == -1) 
            System.out.println("Element not present"); 
        else
            System.out.println("Element found at index " + result); 
    }
}
