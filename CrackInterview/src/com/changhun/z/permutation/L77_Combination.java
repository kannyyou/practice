package com.changhun.z.permutation;

import java.util.ArrayList;
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

Apple

Medium

 * @author changhun
 *
 */
public class L77_Combination {
	public static class Solution1 {
	    public static List<List<Integer>> combine(int n, int k) {
			List<List<Integer>> combs = new ArrayList<List<Integer>>();
			combine(combs, new ArrayList<Integer>(), 1, n, k);
			return combs;
		}
		public static void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
			if(k==0) {
//				System.out.println(comb.toString());
				combs.add(new ArrayList<Integer>(comb));
				return;
			}
			for(int i=start; i<=n; i++) {
				comb.add(i);	// add current location k, 
//				System.out.println("s = " + start + " i = " + i + " k = " + k);
				combine(combs, comb, i+1, n, k-1);	// go to next location k-1
//				System.out.println("remove");
				comb.remove(comb.size()-1);	//remove current location to add next one.
			}
		}
	}
	
	
	
	
	
	public static class Solution2 {
	    public static List<List<Integer>> combine(int n, int k) {
	    	if (k == n || k == 0) {
	    		List<Integer> row = new LinkedList<>();
	    		for (int i = 1; i <= k; ++i) {
	    			row.add(i);
	    		}

	    		return new LinkedList<>(Arrays.asList(row));
	    	}
	    	
//	        System.out.println(" call comb1 " + (n-1) + " " + (k-1));

	        List<List<Integer>> result = combine(n - 1, k - 1);
	        for (List<Integer> row: result) {
				row.add(n);       	
	        }

	        result.addAll(combine(n - 1, k));        
	    	return result;
	    }
	}

	public static class Solution3 {
	    public static List<List<Integer>> combine(int n, int k) {
			List<List<Integer>> combs = new ArrayList<>();
			combine(combs, new ArrayList<>(), 1, n, k);
			return combs;
			
	    }
	    
	    private static void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
	    	if (k == 0) {
	    		combs.add(new ArrayList<Integer>(comb));
	    	} else {
	    		for (int i = start; i <= n; i++) {
	    			comb.add(i);
	    			combine(combs, comb, i+1, n, k-1);	
	    			comb.remove(comb.size() - 1);
	    		}
	    	}
	    }
	}


	
    public static void main(String[] args) {
    	List<List<Integer>> out1 = Solution1.combine(4,2);
    	System.out.println(out1.toString());

    	List<List<Integer>> out2 = Solution2.combine(4,2);
    	System.out.println(out2.toString());
    	
    	List<List<Integer>> out3 = Solution3.combine(4,2);
    	System.out.println(out3.toString());
	}
}
