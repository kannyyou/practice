package com.changhun.crackbook.ch1;

public class OneEditAway {
	
	
	public static boolean oneEditReplace(String str1, String str2) {
		boolean foundDifference = false;
		for (int i=0; i < str1.length(); i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				if (foundDifference) {
					//2nd foundDifference ?
					return false;
				}
				foundDifference = true;
			}
		}
		return true;
	}
	
	public static boolean oneEditInsert(String str1, String str2) {
		int index1 = 0;
		int index2 = 0;
		
		while(index2 < str2.length() && index1 < str1.length()) {
			System.out.println(str1.charAt(index1) + " " + str2.charAt(index2));
			if (str1.charAt(index1) != str2.charAt(index2)) {
				if (index1 != index2) {
					return false;
				}
				index2++;
			} else {
				index1++;
				index2++;
			}
		}
		return true;
	}
	
	public static boolean oneEditAway(String first, String second) {
		if (first.length() == second.length()) {
			return oneEditReplace(first, second);
		} else if (first.length() + 1 == second.length()) {
			return oneEditInsert(first, second);
		} else if (first.length() == second.length() + 1) {
			return oneEditInsert(second, first);
		}
		return false;
	}
	
	public static boolean oneEditAway2(String first, String second) {
		if (Math.abs(first.length() - second.length()) > 1) {
			return false;			
		}
		
		String shorter = first.length() < second.length() ? first : second;
		String longer = first.length() < second.length() ? second : first;
		
		int index1 = 0;
		int index2 = 0;
		boolean foundDifference = false;
		
		while (index2 < shorter.length() && index2 < longer.length()) {
			if (shorter.charAt(index1) != longer.charAt(index2)) {
				if (foundDifference) return false;
				foundDifference = true;
				
				if (shorter.length() == longer.length()) {
					index1++;
				}
			} else {
				index1++;
			}
			index2 ++;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(oneEditAway("palo", "palx"));
		System.out.println(oneEditAway2("palo", "palx"));
		
	}
	
}
