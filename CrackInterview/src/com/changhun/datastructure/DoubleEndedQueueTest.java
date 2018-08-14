package com.changhun.datastructure;

public class DoubleEndedQueueTest {
	public static interface Dequeue<E> {
		
		int size();
		
		boolean isEmpty();
		
		// return first but not remove
		E first();
		
		// return last, but not remove
		E last();
		
		void addFirst(E e);
		
		void addLast(E e);
		
		E removeFirst();
		
		E removeLast();
	}
}
