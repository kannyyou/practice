package com.changhun.quiz.facebook;

import java.util.Arrays;

/** Given an array of integers: 
1. rearrange the array such that all non-zero members appear on the left of the array (order is not important) 
2. return the number of non-zero members 

e.g. [1,2,0,5,3,0,4,0] => [1,2,5,3,4,0,0,0] and return 5. The non-zero array members can be in any order.
*/
public class NonZeroMember {
	
	public static int findNonZeroMember(int [] input) {
		int j = input.length-1;
		int i = 0;
		int nonZero = 0;
		while (i < input.length) {
			if ( input[i] == 0) {

				while(i < j) {
					if (input[j] != 0) {
						swap(input, i, j);
						nonZero ++;
						break;
					}
					
					j--;

				}
			} else {
				nonZero ++;
			}
		
			i++;
			
		}
		
		System.out.println(Arrays.toString(input));
		return nonZero;
	}
	
	public static void swap(int[] sourceArr, int idx1, int idx2) {

        int temp = sourceArr[idx1];
        sourceArr[idx1] = sourceArr[idx2];
        sourceArr[idx2] = temp;
    }
	
	public static void main(String[] args) {
		int [] input = {1,2,0,5,3,0,4,0}; 
		
		System.out.println(findNonZeroMember(input));
	}
}
