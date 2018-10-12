package com.changhun.z.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Input : [3,3,1,0,2,0,1]
 * Output : win
 * 
 * Input : [3,2,0,0,2,0,1]
 * Output : no win
 * 
 * Each array represents the maximum you can advance from that position in one move.
 * 
 * Determine if the array can reach the end
 * 
 * @author changhun
 *
 */
public class EP5_4_CanReachEnd {
	public static class Solution1 {
		public static boolean canReachEnd(List<Integer> maxAdvanceSteps) {
			int furthestReachSoFar = 0;
			int lastIndex = maxAdvanceSteps.size()-1;
			for (int i = 0; i <= furthestReachSoFar && furthestReachSoFar < lastIndex; i++) {
//				System.out.println(i + " " + furthestReachSoFar);

				furthestReachSoFar = Math.max(furthestReachSoFar,  i + maxAdvanceSteps.get(i));
				System.out.println(i + " " + furthestReachSoFar);

			}
			return furthestReachSoFar >= lastIndex;
		}
	}
	
	public static void main(String[] args) {
		List<Integer> num1 = new ArrayList<>(Arrays.asList(3,3,1,0,2,0,1));
		List<Integer> num2 = new ArrayList<>(Arrays.asList(3,2,0,0,2,0,1));

		System.out.println(Solution1.canReachEnd(num1));
		System.out.println(Solution1.canReachEnd(num2));

	}
}

