package com.changhun.leetcode.for201to300;

/**
Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, 
there may exist one celebrity. The definition of a celebrity is 
that all the other n - 1 people know him/her but he/she does not know any of them.

Now you want to find out who the celebrity is or verify that there is not one. 
The only thing you are allowed to do is to ask questions like: 
"Hi, A. Do you know B?" to get information of whether A knows B. 
You need to find out the celebrity (or verify there is not one) 
by asking as few questions as possible (in the asymptotic sense).

You are given a helper function bool knows(a, b) which tells you whether A knows B. 
Implement a function int findCelebrity(n), your function should minimize the number of calls to knows.

Note: There will be exactly one celebrity if he/she is in the party. 
Return the celebrity's label if there is a celebrity in the party. If there is no celebrity, return -1.

pinterest
medium

 * @author changhun
 *
 */
public class L277_Find_Celebrity {
	public static class Relation {
		public int [][] matrix;
		
		public Relation(int [][] matrix ) {
			this.matrix = matrix;
		}
		
		public boolean knows(int a, int b) {
			return (this.matrix[a][b] == 1) ? true: false;
		}
	}
	
	public static class Solution1 extends Relation {
		
		public Solution1(int[][] matrix) {
			super(matrix);
		}
		
	    public int findCelebrity(int n) {
	    	int candidate = 0;
	    	for (int i = 1; i < n; i++) {
	    		if (knows(candidate, i)) 
	    			candidate = i;
	    	}
	    	for (int i = 0; i < n; i++) {
	    		if (i != candidate && (knows(candidate, i) || !knows(i, candidate))) return -1;
	    	}
	    	return candidate;
	    }
		
	}
	
	public static class Solution2 extends Relation {
		
		public Solution2(int[][] matrix) {
			super(matrix);
		}
		
	     public int findCelebrity(int n) {
	        int x = 0;
	        for (int i = 0; i < n; ++i) if (knows(x, i)) x = i;
	        for (int i = 0; i < x; ++i) if (knows(x, i)) return -1;
	        for (int i = 0; i < n; ++i) if (!knows(i, x)) return -1;
	        return x;
	    }
	}
	
	public static void main(String[] args) {
		int [][] ppl1 = {{0, 0, 1, 0 }, {0, 0, 1, 0 }, {0, 0, 0, 0 }, {0, 0, 1, 0 } };
		int [][] ppl2 = {{0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}};
		Solution1 s1 = new Solution1(ppl1);
		System.out.println(s1.findCelebrity(4));
		s1 = new Solution1(ppl2);
		System.out.println(s1.findCelebrity(4));

		Solution2 s2 = new Solution2(ppl1);
		System.out.println(s2.findCelebrity(4));
		s2 = new Solution2(ppl2);
		System.out.println(s2.findCelebrity(4));
	}
}
