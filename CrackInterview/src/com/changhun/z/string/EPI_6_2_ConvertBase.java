package com.changhun.z.string;

/**
 * Input String input, Int base1, base2 : 
 * input representing integer based on base1,
 * convert input from base1 to base2.
 * 
 * @author changhun
 *
 */
public class EPI_6_2_ConvertBase {
	public static class Solution1 {
		public static String convertBase(String numAsString, int base1, int base2) {
			
			boolean isNegative = numAsString.startsWith("-");
			int numAsInt = numAsString.substring(isNegative ? 1:0).chars()
					.reduce(0, (x, c) -> x * base1 + (Character.isDigit(c) ? c - '0' : c - 'A' + 10));
			
			return (isNegative ? "-": "") + (numAsInt == 0 ? "0": construnctFromBase(numAsInt, base2));
		}


		
		public static String construnctFromBase(int numAsInt, int base) {
			return numAsInt == 0 
					? "" 
					: construnctFromBase(numAsInt/base, base) + (char)(numAsInt % base >=10 ? 'A' + numAsInt % base -10 : '0' + numAsInt % base);
					
		}
	}
	

	public static void main(String[] args) {

		
		System.out.println(Solution1.convertBase("1F",16, 10));
		
		
		String a = "1234";
//		a.chars().reduce(0, (x,c) -> System.out.printf(x + " " + c));
		
		
	}

}
