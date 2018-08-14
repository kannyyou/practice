package com.changhun.crackbook.ch1;

public class UniqueString {
	public static boolean isUnique(String str) {
		if (str.length() > 128) return false;
		
		boolean [] char_set = new boolean[128];
		
		for (int i=0; i< str.length(); i++) {
			int val = str.charAt(i);
			if (char_set[val]) {
				return true;
				
			}
			char_set[val] = true;
				
		}
		return true;
	}
	
	public static boolean isUniqueChar(String str) {
		int checker = 0;
		for (int i=0; i< str.length(); i++) {
			int val = str.charAt(i) - 'a';
			System.out.println((int) str.charAt(i) + " " + (int) 'a' + " " +  val + " " + (1<<val) + " " + (checker | (1 << val)));

			if ((checker & (1<<val)) > 0) {
				return false;
			}
			checker |= (1 << val);

		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(isUnique("ABCD"));
		
		System.out.println(isUniqueChar("AABCD"));

		System.out.println(3 << 1);	//11 -> 110
		System.out.println(3 << 2); //11 => 1100
		
		System.out.println(3 >> 1);	//11 -> 1
		System.out.println(3 >> 2); //11 -> 0
		
	}
}
