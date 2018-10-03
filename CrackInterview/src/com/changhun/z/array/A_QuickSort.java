package com.changhun.z.array;

import java.util.Arrays;

public class A_QuickSort {
	public static class Solution1 {
		public static void quickSort(int [] nums) {
			quickSort(nums, 0, nums.length-1);			
		}
		
		
		/* The main function that implements QuickSort() 
	      arr[] --> Array to be sorted, 
	      low  --> Starting index, 
	      high  --> Ending index */
	    private static void quickSort(int [] nums,  int left, int right) { 
	        if (left < right) { 
	            /* pi is partitioning index, arr[pi] is  
	              now at right place */
	            int pi = partition(nums, left, right); 
	  
	            // Recursively sort elements before 
	            // partition and after partition 
	            quickSort(nums, left, pi-1); 
	            quickSort(nums, pi+1, right); 
	        } 
	    } 
	    
	    /* This function takes last element as pivot, 
	       places the pivot element at its correct 
	       position in sorted array, and places all 
	       smaller (smaller than pivot) to left of 
	       pivot and all greater elements to right 
	       of pivot */
	    private static int partition(int [] nums, int left, int right) {
	    	int pivot = nums[right];
	    	int idx = (left-1);
	    	
	    	for (int i = left; i<right; i++) {
	            // If current element is smaller than or 
	            // equal to pivot 
	            if (nums[i] <= pivot) { 
	                idx ++; 
	  
	                // swap nums[i] and nums[j] 
	                int temp = nums[idx]; 
	                nums[idx] = nums[i]; 
	                nums[i] = temp; 
	            } 
	    	}
	        // swap arr[i+1] and arr[high] (or pivot) 
            int temp = nums[idx+1]; 
            nums[idx+1] = nums[right]; 
            nums[right] = temp; 
            
            return idx+1;
	    }
	    
	    public static void main(String args[]) { 
			int[] nums = { 3, 8, 7, 5, 2, 1, 9, 6, 4 };
	  
	        Solution1.quickSort(nums);
	        System.out.println("sorted array"); 
	        System.out.println(Arrays.toString(nums)); 
	    }     
	    
	}
}
