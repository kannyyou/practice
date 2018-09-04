package com.changhun.leetcode.for301to400;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:

Input: [[1,1],2,[1,1]]
Output: 10 
Explanation: Four 1's at depth 2, one 2 at depth 1.
Example 2:

Input: [1,[4,[6]]]
Output: 27 
Explanation: One 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 
1 + 4*2 + 6*3 = 27.

LinkedIn

 * @author changhun
 * Easy
 * LinkedIN
 */
public class L339_NestedListWeightLeaf {
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
		
	}
	
	//Solution 1
	
	public static int depthSum(List<NestedInteger> nestedList) {
	    return depthSum(nestedList, 1);
	}
	
	/**
	 * recursive :
	 * 
	 * For each ni in List<NI>:
	 * 	If ni is Integer, add ni * level;
	 * 	Else (ni is list) recursive call depthSum(ni, level+1);
	 * 
	 * 
	 * @param list
	 * @param depth
	 * @return
	 */
	public static int depthSum(List<NestedInteger> list, int depth) {
	    int sum = 0;
	    for (NestedInteger n : list) {
	        if (n.isInteger()) {
	            sum += n.getInteger() * depth;
	        } else {
	            sum += depthSum(n.getList(), depth + 1);
	        }
	    }
	    return sum;
	}
	
	//Solution 2

	/**
	 * 1. Convert nested list to Queue (linked list).
	 * 
	 * level = 1
	 * Until queue is not empty
	 * 	 For each ni in Queue
	 * 		if ni is Integer,  sum += ni * level  
	 * 		else queue.addAll(ni)
	 * 	 level ++;
	 * 	
	 * @param nestedList
	 * @return
	 */
	public static int depthSum2(List<NestedInteger> nestedList) {
	    if(nestedList == null){
	        return 0;
	    }
	    
	    int sum = 0;
	    int level = 1;
	    
	    Queue<NestedInteger> queue = new LinkedList<NestedInteger>(nestedList);
	    while(queue.size() > 0){
	        int size = queue.size();
	        for(int i = 0; i < size; i++){
	            NestedInteger ni = queue.poll();
	            
	            if(ni.isInteger()){
	                sum += ni.getInteger() * level;
	            }else{
	                queue.addAll(ni.getList());
	            }
	        }
	        level++;
	    }
	    
	    return sum;
	}

	
	/** 
	 * [[1,1],2,[1,1]] = 10
	 * [1,[4,[6]]] = 27
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
		System.out.println(depthSum(ex1));
		System.out.println(depthSum2(ex1));

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
		System.out.println(depthSum(ex2));
		System.out.println(depthSum2(ex2));

//		
//		ex2.add(list2);
//		
		
		
	}
}
