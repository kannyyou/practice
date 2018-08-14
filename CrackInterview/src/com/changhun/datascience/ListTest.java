package com.changhun.datascience;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Union and Intersection of two Linked Lists
 * Given two Linked Lists, create union and intersection lists 
 * that contain union and intersection of the elements present in the given lists. 
 * Order of elements in output lists doesn’t matter
 * 
 * Input: 
 * 	List1: 10->15->4->20
 * 	list2:  8->4->2->10
 * Output:
 * Intersection List: 4->10
 * Union List: 2->8->20->4->15->10
 * @author changhun
 *
 */
public class ListTest {

	public static LinkedList<Integer> getUnion(LinkedList<Integer> a, LinkedList<Integer> b) {
		LinkedList<Integer> addList;
		LinkedList<Integer> union = new LinkedList<Integer>();

		
		if (a.size() >= b.size()) {
			union.addAll(a);
			addList = b;
		} else {
			union.addAll(b);
			addList = a;
		}
		
		Iterator<Integer> it = addList.iterator();
		while(it.hasNext()) {
			Integer e = it.next();
			if (!union.contains(e)) {
				union.add(e);
			}
		}
		return union;
	}
	
	public static LinkedList<Integer> getIntersection(LinkedList<Integer> a, LinkedList<Integer> b) {
		LinkedList<Integer> bigList;
		LinkedList<Integer> smallList;
		LinkedList<Integer> intersection = new LinkedList<Integer>();
		
		if (a.size() >= b.size()) {
			bigList = a;
			smallList = b;
		} else {
			bigList = b;
			smallList = a;
		}
		
		Iterator<Integer> it = bigList.iterator();
		while(it.hasNext()) {
			Integer e = it.next();

			if (smallList.contains(e)) {
				intersection.add(e);
			}
		}
		return intersection;
	}

	//Care duplicate
	public static LinkedList<Integer> getHashIntersection(LinkedList<Integer> a, LinkedList<Integer> b) {
		Hashtable<Integer, Integer> hashtab = new Hashtable<Integer, Integer>();//key and frequency
		
		LinkedList<Integer> bigList;
		LinkedList<Integer> smallList;
		LinkedList<Integer> intersection = new LinkedList<Integer>();

		if (a.size() >= b.size()) {
			bigList = a;
			smallList = b;
		} else {
			bigList = b;
			smallList = a;
		}
		
		Iterator<Integer> bigIt = bigList.iterator();
		while(bigIt.hasNext()) {
			Integer e = bigIt.next();
			Integer freq = hashtab.get(e);			
			if (freq == null) {
				//never add
				hashtab.put(e, 1);
			} else {
				hashtab.put(e, freq + 1);
			}
		}
		
		Iterator<Integer> smallIt = smallList.iterator();
		while(smallIt.hasNext()) {
			Integer e = smallIt.next();
			Integer freq = hashtab.get(e);			

			if (freq != null && freq > 0) {
				//already exist
				hashtab.put(e, freq - 1); 
				intersection.add(e);
			}
		
		}

		return intersection;
	}
	
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static LinkedList<Integer> getHashSetIntersection(LinkedList<Integer> a, LinkedList<Integer> b) {
		HashSet<Integer> hashSet = new HashSet<Integer>();
		
		hashSet.addAll(a);
		
		hashSet.retainAll(b);
		
		return new LinkedList<Integer>(hashSet);
	}

	
	public static void main(String[] args) {
		LinkedList<Integer> a = new LinkedList<Integer>();
		LinkedList<Integer> b = new LinkedList<Integer>();

		a.add(10);
		a.add(15);
		a.add(4);
		a.add(20);
		
		b.add(8);
		b.add(4);
		b.add(2);
		b.add(10);
		
		LinkedList<Integer> union = getUnion(a, b);
		System.out.println(union.toString());
		
		LinkedList<Integer> intersection = getIntersection(a, b);
		System.out.println(intersection.toString());
		
		LinkedList<Integer> intersection2 = getHashIntersection(a, b);
		System.out.println(intersection2.toString());
		
		LinkedList<Integer> intersection3 = getHashSetIntersection(a, b);
		System.out.println(intersection3.toString());

	}
	
}
