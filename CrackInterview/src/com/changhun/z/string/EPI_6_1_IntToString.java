package com.changhun.z.string;

public class EPI_6_1_IntToString {
	public static String intToString(int x) {
		boolean isNegative = false;
		if (x < 0) {
			isNegative = true;
		}

		StringBuilder s = new StringBuilder();
		do {
			s.append((char)('0' + Math.abs(x % 10)));
			x /= 10;
		} while (x != 0);

		// Adds the negative sign back if isNegative.
		return s.append(isNegative ? "-" : "").reverse().toString();
	}
	
	public static void main(String[] args) {
		System.out.println(intToString(12345));
	}
}
