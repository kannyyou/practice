package com.changhun.z.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Recursive, DP
 * 
 * 
 * 
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Different from the previous question where weight is increasing from root to leaf, 
now the weight is defined from bottom up. i.e., the leaf level integers have weight 1, 
and the root level integers have the largest weight.

Example 1:

Input: [[1,1],2,[1,1]]
Output: 8 
Explanation: Four 1's at depth 1, one 2 at depth 2.
Example 2:

Input: [1,[4,[6]]]
Output: 17 
Explanation: One 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17.

LinkedIn
Medium

 * @author changhun
 * Medium
 * LinkedIN
 */
public class L364_NestedListWeightSumRoot {
	public static interface NestedIntegerIF {
//		// Constructor initializes an empty nested list.
//		public NestedInteger();
//		
//		// Constructor initializes a single integer.
//		public NestedInteger(int value);
//		
		// @return true if this NestedInteger holds a single integer, rather than a nested list.
		public boolean isInteger();
		
		// @return the single integer that this NestedInteger holds, if it holds a single integer
		// Return null if this NestedInteger holds a nested list
		public Integer getInteger();
		
		// Set this NestedInteger to hold a single integer.
		public void setInteger(int value);
		
		// Set this NestedInteger to hold a nested list and adds a nested integer to it.
		public void add(NestedInteger ni);
		
		// @return the nested list that this NestedInteger holds, if it holds a nested list
		// Return null if this NestedInteger holds a single integer
		public List<NestedInteger> getList();
	}
	
	public static class NestedInteger implements NestedIntegerIF {
		private Integer value;
		private List<NestedInteger> list;
		
		public NestedInteger() {
			this.value = null;
			this.list = null;
		}
		
		public NestedInteger(List<NestedInteger> list) {
			this.value = null;
			this.list = list;
		}
		
		// Constructor initializes a single integer.
		public NestedInteger(int value) {
			this.value = value;
			this.list = null;
		}
		@Override
		public boolean isInteger() {
			return this.value != null;
		}

		@Override
		public Integer getInteger() {
			return this.value;
		}

		@Override
		public void setInteger(int value) {
			this.value = value;
		}

		@Override
		public void add(NestedInteger ni) {
			if (this.isInteger()) return;						
			
			if (list == null) {
				this.list = new ArrayList<NestedInteger>();
			}
			
			this.list.add(ni);	
			
		}

		@Override
		public List<NestedInteger> getList() {
			return list;
		}
		
		public String toString() {
			String rt = "";
			if (this.isInteger()) {
				rt += this.getInteger();
			} 
			if (this.list != null) {
				if (this.isInteger()) rt += ", ";
				rt += list.toString();
			}
			return rt;
		}
		
		/**
		 * While Queue is not empty 
		 * 	 for NI in nestedList
		 * 		if NI is Int, unweighted += NI
		 * 		else 
		 * 			nextLevel.addAll(ni.getList)
		 *   weighted += unweighted // it will keep adding at even next level.
		 *   nestedList = nextLevel // only for next Level 
		 * @param nestedList
		 * @return
		 */
		public static int depthSumInverse(List<NestedInteger> nestedList) {
		    int unweighted = 0, weighted = 0;
		    while (!nestedList.isEmpty()) {
		        List<NestedInteger> nextLevel = new ArrayList<>();
		        
		        for (NestedInteger ni : nestedList) {
		            if (ni.isInteger())
		                unweighted += ni.getInteger();
		            else
		                nextLevel.addAll(ni.getList());
		        }
		        weighted += unweighted;	//keep adding at even next level.
		        nestedList = nextLevel;	//replace nestedList with nextLevel
		        

		    }
		    return weighted;
		}
		
		/** 
		 * [[1,1],2,[1,1]] = 8
		 * [1,[4,[6]]] = 17
		 * @param args
		 */
		public static void main(String[] args) {
			NestedInteger a =  new NestedInteger(1);
			NestedInteger list1 = new NestedInteger();
			list1.add(a);
			list1.add(a);
			
			List<NestedInteger> ex1= new ArrayList<>();
			ex1.add(list1);
			ex1.add(new NestedInteger(2));
			ex1.add(list1);
			
			System.out.println(ex1.toString());
			System.out.println(depthSumInverse(ex1));

			List<NestedInteger> ex2= new ArrayList<>();
			ex2.add(new NestedInteger(1));	
			NestedInteger b = new NestedInteger(4);
			NestedInteger list2= new NestedInteger();
			list2.add(b);
			NestedInteger c = new NestedInteger();
			c.add(new NestedInteger(6));
			list2.add(c);
			ex2.add(list2);

			
			System.out.println(ex2.toString());		
			System.out.println(depthSumInverse(ex2));

//			
//			ex2.add(list2);
//			
			
			
		}
	}
}
