package com.changhun.z.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Dutch national flag sorting problem
For this problem, your goal is to sort an array of 0, 1 and 2's but you must do this in place, 
in linear time and without any extra space (such as creating an extra array). 
This is called the Dutch national flag sorting problem. 
For example, if the input array is [2,0,0,1,2,1] then your program should output [0,0,1,1,2,2] 
and the algorithm should run in O(n) time.

 * @author changhun
 *
 */

public class EP5_1_DutchNationalFlagProblem {
	public static enum Color { RED, WHITE, BLUE }
	
	/**
	 * 
	 * (1) Create a low pointer at the beginning of the array and a high pointer at the end of the array.
	 * (2) Create a mid pointer that starts at the beginning of the array and iterates through each element.
	 * (3) If the element at arr[mid] is a 2, then swap arr[mid] and arr[high] and decrease the high pointer by 1.
	 * (4) If the element at arr[mid] is a 0, then swap arr[mid] and arr[low] and increase the low and mid pointers by 1.
	 * (5) If the element at arr[mid] is a 1, don't swap anything and just increase the mid pointer by 1.
	 * 
	 * @author changhun
	 *
	 */
	public static class Solution1 {

		public static void dutchFlagPartition(int pivotIndex, List<Color> input) {

		  Color pivot = input.get(pivotIndex);
		  /**
		   * Keep the following invariants during partitioning:
		   * bottom group: A.subList(0, smaller).
		   * middle group: A.subList(smaller, equal).
		   * unclassified group: A.subList(equal, larger).
		   * top group: A.subList(larger, A.size()).
		   */
		  int smaller = 0, equal = 0, larger = input.size();
		  // Keep iterating as long as there is an unclassified element.
		  while (equal < larger) {
		    // A.get(equal) is the incoming unclassified element.
		    if (input.get(equal).ordinal() < pivot.ordinal()) {
		      Collections.swap(input, smaller++, equal++);
		    } else if (input.get(equal).ordinal() == pivot.ordinal()) {
		      equal ++ ;
		    } else { // A.get(equal) > pivot.
		      Collections.swap(input, equal, larger --);
		    }
		  }
		}
	}
	
	public static class Solution2 {
		public static void dutchFlagPartition(int pivotIndex, List<Color> input) {
			Color pivot = input.get(pivotIndex);
			
			//First pass: group elements smaller than pivot
			for (int i = 0; i < input.size(); i++) {
				for (int j = i + 1; j < input.size(); j++) {
					if (input.get(j).ordinal() < pivot.ordinal()) {
						Collections.swap(input, i, j);
						break;
					}
				}
			}
			
			//Second pass: group elements larger than pivot
			for (int i = input.size() - 1; i >= 0; i--) {
				for (int j = i - 1; j >= 0; j--) {
					if (input.get(j).ordinal() > pivot.ordinal()) {
						Collections.swap(input, i, j);
						break;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		List nums = new ArrayList<>(Arrays.asList(Color.RED, Color.WHITE,Color.BLUE,Color.RED, Color.BLUE, Color.WHITE, Color.WHITE));
		
		Solution2.dutchFlagPartition(1, nums);
		
		System.out.println(nums.toString());
	}
}


