package com.changhun.z.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
public class L66_EP_52_PlusOne {
	public static class Solution1 {
		public static int[] plusOne(int[] digits) {
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
	}
	
	/**
	 * EP5.2
	 * @author changhun
	 *
	 */
	public static class Solution2 {
		public static List<Integer> plusOne(List<Integer> digits) {
			int n = digits.size() - 1;
			digits.set(n, digits.get(n) + 1);
			for (int i = n; i > 0 && digits.get(i) == 10; i--) {
				digits.set(i, 0);
				digits.set(i-1, digits.get(i-1) + 1);
			}
			
			if (digits.get(0) == 10) {
				// There is a carry-out, so we need one more digitto store the result.
				// A slick way to do this is to append a 0 at the end of the array.
				// and update the first entry to 1.
				digits.set(0, 1);
				digits.add(0);
			}
			return digits;
		}
	}	
	
	public static void print(int[] nums) {
		for (int num: nums) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] nums = {9,9,9};
		List<Integer> listNums = new ArrayList<>(Arrays.asList(9,9,9));
		System.out.println(Arrays.toString(Solution1.plusOne(nums)));
		System.out.println(Solution2.plusOne(listNums).toString());

	}
}
