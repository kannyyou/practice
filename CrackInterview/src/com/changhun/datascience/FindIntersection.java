package com.changhun.datascience;

public class FindIntersection {
	public static void findIntersecton(int[] array1, int[] array2) {
		int size1 = array1.length;
		int size2 = array2.length;
		
		int i = 0;
		int j = 0;
		
		while (i < size1 && j < size2) {
			if (array1[i] < array2[j]) {
				i++;
				//only 1 advance
				
			} else if (array1[i] > array2[j]) {
				j++;
				//only 2 advance
				
			} else {
				// equal
				System.out.print(array2[j++] + " ");
				i++;
			}			
		}	
	}
	
	public static void main(String[] args) {
	     int arr1[] = {1, 2, 4, 5, 6};
	     int arr2[] = {2, 3, 5, 7};
	     findIntersecton(arr1, arr2);	
	}
}
