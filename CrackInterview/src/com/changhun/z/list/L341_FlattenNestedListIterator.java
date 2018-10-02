package com.changhun.z.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;


/**
Given a nested list of integers, implement an iterator to flatten it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:

Input: [[1,1],2,[1,1]]
Output: [1,1,2,1,1]
Explanation: By calling next repeatedly until hasNext returns false, 
             the order of elements returned by next should be: [1,1,2,1,1].
Example 2:

Input: [1,[4,[6]]]
Output: [1,4,6]
Explanation: By calling next repeatedly until hasNext returns false, 
             the order of elements returned by next should be: [1,4,6].
             
LinkedIn
Medium

 * @author changhun
 *
 */
public class L341_FlattenNestedListIterator {
	
	public static class NestedIterator implements Iterator<Integer> {
		 private Queue<Iterator<Integer>> iterqueue;
		    
		 public NestedIterator(Queue<Iterator<Integer>> iterqueue) {
			 this.iterqueue = iterqueue;
		 }  
		    
		 public Integer next() throws NoSuchElementException {		    	
			 if (!hasNext()) throw new NoSuchElementException();
		    	  	
			 Iterator<Integer> it = iterqueue.remove();
			 Integer val = it.next();
		    	
			 if (it.hasNext()) this.iterqueue.add(it);
		    	
			 return val;
		 }		  
		    
		 public boolean hasNext(){
			 return this.iterqueue.size() != 0;
		 }
	}

    public static void main(String[] args) {
    	   	 
    	Integer[] array1 = {1, 2, 3, 9};
    	Integer[] array2 = {4, 5};
    	Integer[] array3 = {6, 7, 8, 11};
    
    	Iterator<Integer> it1 = Arrays.asList(array1).iterator();
    	Iterator<Integer> it2 = Arrays.asList(array2).iterator();
    	Iterator<Integer> it3 = Arrays.asList(array3).iterator();
    	    	
    	Queue<Iterator<Integer>> iterqueue = new LinkedList<Iterator<Integer>>();
    	iterqueue.add(it1);
    	iterqueue.add(it2);
    	iterqueue.add(it3);

    	NestedIterator nia = new NestedIterator(iterqueue);
    	
    	while (nia.hasNext()) {
    		System.out.println(nia.next());
		}    	   	

    	
	}
	    	
}
