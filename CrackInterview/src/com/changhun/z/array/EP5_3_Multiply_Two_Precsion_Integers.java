package com.changhun.z.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 193707721 -> {1,9,3,7,0,7,7,2,1}
 * *
 * -761838257281 -> {-7,6,1,8,3,8,2,5,7,2,8,7}
 * =
 * -14757395589676412927 -> {-1,4,7,5,7,3,9,5,5,8,9,6,7,6,4,1,2,9,2,7}
 * @author changhun
 *
 */
public class EP5_3_Multiply_Two_Precsion_Integers {
	public static class Solution1 {
		public static List<Integer> multiply(List<Integer> num1, List<Integer> num2) {
			final int sign = num1.get(0) *  num2.get(0) < 0 ? -1 : 1; 
			num1.set(0,  Math.abs(num1.get(0)));
			num2.set(0,  Math.abs(num2.get(0)));
			
			//99*99 = 9801
			List<Integer> result = new ArrayList<>(Collections.nCopies(num1.size() + num2.size(), 0)); 
			for (int i = num1.size() - 1; i >=0; i--) {
				for (int j = num2.size() - 1; j >=0; j--) {
					result.set(i + j + 1, result.get(i + j + 1) + num1.get(i) * num2.get(j));	// 9*9 = 81
					result.set(i + j, result.get(i + j) + result.get(i + j + 1) / 10);			// 81/10 = 8
					result.set(i + j + 1, result.get(i + j + 1) % 10);							// 81 % 10 = 1
				}
			}
			
			// Remove the leading zeros
			int firstNotZero = 0;
			while (firstNotZero < result.size() && result.get(firstNotZero) == 0) {
				firstNotZero ++;
			}
			result = result.subList(firstNotZero, result.size());
			if (result.isEmpty()) {
				return Arrays.asList(0);
			}
			// apply sign
			result.set(0,  result.get(0) * sign);
			return result;			
		}
	}
	
	public static void main(String[] args) {
		List<Integer> num1 = new ArrayList<>(Arrays.asList(1,9,3,7,0,7,7,2,1));
		List<Integer> num2 = new ArrayList<>(Arrays.asList(-7,6,1,8,3,8,2,5,7,2,8,7));
		
		List<Integer> result = Solution1.multiply(num1, num2);
		System.out.println(result.toString());
	}
}
