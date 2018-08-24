package com.changhun.apple.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * This is faster than sorting or heap
 * because it will return while we sorting if we get Kth number.
 * @author changhun
 *
 */

public class BinarySearchMedian {		
	public static float findMedian(int[] nums) {
        int medPos = 0;
        
		if (nums.length % 2 == 0) {
			medPos = nums.length / 2;;
        } else {
			medPos = (nums.length / 2) + 1;

        }
        
		System.out.println(nums.length + " " + medPos );
		
		int k = medPos;
        int smallest = 0, largest = nums.length - 1;
        int pivotPos = 0;
        k = nums.length - k;
        while (smallest <= largest) {
            pivotPos = partition(nums, smallest, largest);
            if (pivotPos < k) {
                smallest = pivotPos + 1;
            } else if (pivotPos > k) {
            	largest = pivotPos - 1;
            } else {
//                System.out.println(pivotPos + " " + nums[pivotPos] + " " + Arrays.toString(nums));

                break;
            }
//            System.out.println(pivotPos + " " + nums[pivotPos] + " " + Arrays.toString(nums));
        }
        
        if (nums.length % 2 == 0) {
        	return (float) (nums[pivotPos-1] + nums[pivotPos])/ 2;
        } else {
            return nums[pivotPos];

        }
        
    }
	
    private static int partition(int[] nums, int left, int right) {
    	System.out.println(left + "  " + right);
        int smallest = left, largest = right;
        int i = left + 1;	//or random
        int pivot = nums[left];
//        System.out.println(pivot);
        while (i <= largest) {
//        	System.out.println("num" + nums[i] + " " + pivot + " " + smallest + " " + largest);
            if (nums[i] < pivot) {
                swap(nums, smallest, i);
//                System.out.println("swap smallest " + i);

                smallest++;
                i++;

            } else if (nums[i] > pivot) {
                swap(nums, largest, i);
                largest--;
//                System.out.println("swap largest " + i);

            } else {
                i++;
            }
//            System.out.println("\t" + Arrays.toString(nums));

        }
        return i - 1;
    }

    
    
    
    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
	
	public static void main(String[] args) {
		int[] array = {1, 5, 2, 9, 1, 11, 6, 13, 15, 17};
		
		System.out.println(findMedian(array));
		
		
	}
	
}
