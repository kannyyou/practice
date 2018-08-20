package com.changhun.apple.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


public class HeapLargetstK {		
	public static class MaxHeapComparator implements Comparator<Integer> {
	    public int compare(Integer x, Integer y) {
	        return y - x;
	    }
	}
	
	public static int largestK(int[] array, int k) {
		if (k <= 0 || k > array.length) {
			throw new IllegalArgumentException();
		}
		
		PriorityQueue<Integer> heap = getKMaxHeap(array, k);
		
		return heap.poll();
	}
	

	/* Create max heap of largest k elements. */	
	public static PriorityQueue<Integer> getKMaxHeap(int[] array, int k) {
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k);
		for (int a : array) {
			if (heap.size() < k) { // If space remaining
				heap.add(a);
			} else if (a > heap.peek()) { // If full and top is largest				
				heap.poll(); // remove smallest
				heap.add(a); // insert new element
			}
		}
		return heap;
	}	

	public static void main(String[] args) {
		int[] array = {1, 5, 2, 9, 1, 11, 6, 13, 15};

		System.out.println(largestK(array,5));
		
	}
	
}
