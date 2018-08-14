package com.changhun.quiz.facebook;

import java.util.Arrays;

/**
 * Given an unsorted array, sort it in such a way that the first 
element is the largest value, the second element is the smallest, 
the third element is the second largest element and so on. 
[2, 4, 3, 5, 1] -> [5, 1, 4, 2, 3] 
can you do it without using extra space 
public void sortAlternate(int[] nums){}
 * @author changhun
 *
 */
public class SortAlternate {
	
	public static void sortAlternate(int[] input) {
		
		int curStart = 0 ; //after sorted
		while (curStart < input.length) {
			
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			int targetIdx = 0;
			int curIdx = curStart;

			while (curIdx < input.length) {
				if (curStart % 2 == 0) {
					//find max				
					if (input[curIdx] > max) {
						max = input[curIdx];
						targetIdx = curIdx;
					}
				} else if (curStart % 2 == 1) {
					//find min
					if (input[curIdx] < min) {
						min = input[curIdx];
						targetIdx = curIdx;
					}
				}
				curIdx ++;
			}
			
			System.out.println(curStart + " " + targetIdx);
			swap(input, targetIdx, curStart);
			System.out.println(Arrays.toString(input));

			
			curStart ++;
		}
	}
	
	private static void swap(int[] input, int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
	
	public static void main(String[] args) {
		int [] input = {2, 4, 3, 5, 1};

		System.out.println(Arrays.toString(input));

		sortAlternate(input);
		
		System.out.println(Arrays.toString(input));
	}
}
