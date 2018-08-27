package com.changhun.leetcode.for001to100;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 * @author changhun
 *
 */
public class L77_Combination {
    public static List<List<Integer>> combine(int n, int k) {
//    	System.out.println("comb " + n + " " + k);
    	if (k == n || k == 0) {
    		List<Integer> row = new LinkedList<>();
    		for (int i = 1; i <= k; ++i) {
//    			System.out.println("add row " + i + " when n=" + n + " k=" + k);
    			row.add(i);
    		}
//    		System.out.println("row " + row);
//            System.out.println("\tret 1 " + row);

    		return new LinkedList<>(Arrays.asList(row));
    	}
    	
        System.out.println(" call comb1 " + (n-1) + " " + (k-1));

        List<List<Integer>> result = combine(n - 1, k - 1);
        for (List<Integer> row: result) {
//			System.out.println("add sub " + n + " when n=" + n + " k=" + k);

			row.add(n);
        	
//    		System.out.println("sub " + row);

        }

//        System.out.println(" call comb2 " + (n-1) + " " + k);
        result.addAll(combine(n - 1, k));
        
//        System.out.println("\tret 2 " + result);
    	return result;
    }

    public static void main(String[] args) {
    	List<List<Integer>> out = combine(4,2);
    	
    	for (List<Integer> i : out) {
    		System.out.println(i);
    	}
	}
}
