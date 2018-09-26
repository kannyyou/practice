package com.changhun.leetcode.for001to100;

import java.util.Arrays;

/**
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.

easy

 * @author changhun
 *
 */
public class L66_PlusOne {
	public static int[] plusOne(int[] digits) {
//		System.out.println(Arrays.toString(digits));

	    int n = digits.length;
	    for(int i=n-1; i>=0; i--) {
//			System.out.println(i + " " + digits[i]);

	        if(digits[i] < 9) {
	            digits[i]++;
	            return digits;	//don't have to go further.
	        }
	        
	        digits[i] = 0;
	    }
	    
//		System.out.println(Arrays.toString(digits));
		//if we are here that means [0,0,0];
	    int[] newNumber = new int [n+1];
	    newNumber[0] = 1;
	    
	    return newNumber;
	}
	
	public static int[] plusOne2(int[] digits) {
	    for (int i = digits.length - 1; i >=0; i--) {
	        if (digits[i] < 9) {
	            digits[i] ++;
	            break;
	        } else {
	            digits[i] = 0;
	        }
	    }
	    if (digits[0] == 0) {	//that means we need to carry 1 to new digit
	        int[] res = new int[digits.length+1];
	        res[0] = 1;
	        return res;
	    }
	    return digits;
	}
	
	public static void print(int[] nums) {
		for (int num: nums) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] nums = {9,9,9};
		System.out.println(Arrays.toString(plusOne(nums)));
		System.out.println(Arrays.toString(plusOne2(nums)));

	}
}
