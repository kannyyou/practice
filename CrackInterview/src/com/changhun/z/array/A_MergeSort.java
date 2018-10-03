package com.changhun.z.array;

import java.util.Arrays;

public class A_MergeSort {
	/**
	 * Time Complexity: Sorting arrays on different machines. 
	 * Merge Sort is a recursive algorithm and time complexity can be expressed 
	 * as following recurrence relation.
	T(n) = 2T(n/2) + Theta(n)
The above recurrence can be solved either using Recurrence 
Tree method or Master method. 
It falls in case II of Master Method and solution of the recurrence is Theta(nLogn).
Time complexity of Merge Sort is Theta(nLogn) in all 3 cases 
(worst, average and best) as merge sort always divides the array in two halves 
and take linear time to merge two halves.

Auxiliary Space: O(n)

Algorithmic Paradigm: Divide and Conquer



	 * @author changhun
	 *
	 */
	public static class Solution1 {
		public static void mergeSort(int [] nums) {
			mergeSort(nums, 0, nums.length-1); 
		}
		
		private static void mergeSort(int [] nums, int left, int right) {
			if (right > left) {
				int mid = (left + right) /2 ;
				mergeSort(nums, left, mid); 
				mergeSort(nums, mid+1, right); 

				merge(nums, left, mid, right);
			}			
		}
		
		private static void merge(int[] nums, int left, int mid, int right) {
		    int n1 = mid - left + 1; 
	        int n2 = right - mid; 
			
	        /* Create temp arrays */
	        int [] leftNums = new int[n1]; 
	        int [] rightNums = new int[n2]; 
	        
	        /*Copy data to temp arrays*/
	        for (int i=0; i<n1; ++i) 
	        	leftNums[i] = nums[left + i]; 
	        
	        for (int j=0; j<n2; ++j) 
	            rightNums[j] = nums[mid + 1 + j]; 
	        
	        /* Merge the temp arrays */
	        
	        // Initial indexes of first and second subarrays 
	        int i = 0, j = 0; 
	  
	        // Initial index of merged subarry array 
	        int k = left; 
	        while (i < n1 && j < n2)  { 
	            if (leftNums[i] <= rightNums[j]) { 
	                nums[k] = leftNums[i]; 
	                i++; 
	            
	            } else { 
	                nums[k] = rightNums[j]; 
	                j++; 
	            } 
	            k++; 
	        } 
	  
	        /* Copy remaining elements of L[] if any */
	        while (i < n1) 
	        { 
	            nums[k] = leftNums[i]; 
	            i++; 
	            k++; 
	        } 
	  
	        /* Copy remaining elements of R[] if any */
	        while (j < n2) { 
	            nums[k] = rightNums[j]; 
	            j++; 
	            k++; 
	        } 
	        
		}
		
		
		
	}
	public static void main(String[] args) {
		int[] numbers = { 3, 8, 7, 5, 2, 1, 9, 6, 4 };
		System.out.println("MergeSort By Recursive Method");
		Solution1.mergeSort(numbers);
		System.out.println(Arrays.toString(numbers));
	}
}
