package com.changhun.datascience;

public class FindMissingNumber {
	//You are given a list of n-1 integers and these integers are in the range of 1 to n. 
	//There are no duplicates in list. One of the integers is missing in the list. 
	//Write an efficient code to find the missing integer.
	
	public static int findMissing(int [] array) {
		int size = array.length;
		int total = (size+1)*(size+2) / 2 ;
		
		for (int i=0; i<size; i++) {
			total -= array[i];
		}
		
		return total;
	}
	
	/**
	 * 
	 * Let's suppose we have 1, 2, 4 
	 * 
	 * X1 = 1 ^ 2 ^ 4
	 * X2 = 1 ^ 2 ^ 3 ^ 4
	 * X1 ^ X2 	= (1 ^ 2 ^ 4) ^ (1 ^ 2 ^ 3 ^ 4)
	 * 			= (1 ^ 1) ^ ( 2 ^ 2) ^ 3 ^ (4 ^ 4) 
	 * 			= 0 ^ 0 ^ 3 ^ 0
	 * 			= 3 
	 * 
	 * @param array
	 * @return
	 */
	public static int findMissingXOR(int [] array) {
		int size = array.length;

		int i;
		int x1 = array[0]; 
		//System.out.println(0 + " " + x1);

		int x2 = 1; 
	         
		/* For xor of all the elements in array */
		for (i = 1; i< size; i++) {
			x1 = x1 ^ array[i];
			//System.out.println(i + " " + x1);
		}
	    System.out.println(" ");       
	    /* For xor of all the elements from 1 to n+1 */        
	    for ( i = 2; i <= size + 1; i++) {
	    	x2 = x2^i;          

			//System.out.println(i + " " + x2);

	    }
	         
	    return (x1^x2);
	}
	
	public static void main(String[] args) {
		int a[] = {1, 2, 3, 4,6};
		System.out.println(findMissing(a));
		System.out.println(findMissingXOR(a));


	}
}
