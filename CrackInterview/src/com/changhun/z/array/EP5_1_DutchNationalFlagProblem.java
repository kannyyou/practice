package com.changhun.z.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class EP5_1_DutchNationalFlagProblem {
	public static enum Color { RED, WHITE, BLUE }

	public static class Solution1 {

		public static void dutchFlagPartition(int pivotIndex, List<Color> A) {

		  Color pivot = A.get(pivotIndex);
		  /**
		   * Keep the following invariants during partitioning:
		   * bottom group: A.subList(0, smaller).
		   * middle group: A.subList(smaller, equal).
		   * unclassified group: A.subList(equal, larger).
		   * top group: A.subList(larger, A.size()).
		   */
		  int smaller = 0, equal = 0, larger = A.size();
		  // Keep iterating as long as there is an unclassified element.
		  while (equal < larger) {
		    // A.get(equal) is the incoming unclassified element.
		    if (A.get(equal).ordinal() < pivot.ordinal()) {
		      Collections.swap(A, smaller++, equal++);
		    } else if (A.get(equal).ordinal() == pivot.ordinal()) {
		      ++equal;
		    } else { // A.get(equal) > pivot.
		      Collections.swap(A, equal, --larger);
		    }
		  }
		}
	}
	
	
	public static void main(String[] args) {
		List nums = new ArrayList<>(Arrays.asList(Color.RED, Color.WHITE,Color.BLUE,Color.RED, Color.BLUE, Color.WHITE, Color.WHITE));
		
		Solution1.dutchFlagPartition(1, nums);
		
		System.out.println(nums.toString());
	}
}


