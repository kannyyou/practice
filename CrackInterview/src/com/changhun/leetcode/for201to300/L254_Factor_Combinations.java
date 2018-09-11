package com.changhun.leetcode.for201to300;

import java.util.ArrayList;
import java.util.List;

/**
Numbers can be regarded as product of its factors. For example,

8 = 2 x 2 x 2;
  = 2 x 4.
Write a function that takes an integer n and return all possible combinations of its factors.

Note:

You may assume that n is always positive.
Factors should be greater than 1 and less than n.
Example 1:

Input: 1
Output: []

Example 2:

Input: 37
Output:[]

Example 3:

Input: 12
Output:
[
  [2, 6],
  [2, 2, 3],
  [3, 4]
]
Example 4:

Input: 32
Output:
[
  [2, 16],
  [2, 2, 8],
  [2, 2, 2, 4],
  [2, 2, 2, 2, 2],
  [2, 4, 4],
  [4, 8]
]


LinkedIn
Medium

 * @author changhun
 *
 */
public class L254_Factor_Combinations {
	public static class Solution1 {
	    public static List<List<Integer>> getFactors(int n) {
	        List<List<Integer>> result = new ArrayList<List<Integer>>();
	        factorCombination(result, new ArrayList<Integer>(), n, 2);
	        return result;
	    }
	    
	    public static void factorCombination(List<List<Integer>> result, List<Integer> templist, int n, int start) {
//			System.out.println("call " + templist.toString() + " " + n + " " + start );

	    	if (n <= 1) { //it should be fine with n == 1
	    		if (templist.size() > 1) {
//	    			System.out.println("add");
	    			result.add(new ArrayList<Integer>(templist));
	    		}
	    		return;
	    	}
	    	
	    	for (int i = start; i <= n; i++) {
	    		if (n % i == 0) {
//	    			System.out.println("add " +i);
	    			templist.add(i);
	    			factorCombination(result, templist, n/i, i);
	    			templist.remove(templist.size()-1);
//	    			System.out.println("remove");

	    		}
	    	}
	    }
	}
	
	public static void main(String[] args) {
//		System.out.println(Solution1.getFactors(1).toString());
//		System.out.println(Solution1.getFactors(2).toString());
		System.out.println(Solution1.getFactors(4).toString());
		System.out.println(Solution1.getFactors(12).toString());
		System.out.println(Solution1.getFactors(32).toString());

	}
}
