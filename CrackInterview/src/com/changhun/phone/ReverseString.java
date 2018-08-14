package com.changhun.phone;

/**
 *     public static String reverse ( String s ) {
Example output for "Madam, I'm Adam":   madA m'I ,madaM


 * @author changhun
 *
 */
public class ReverseString {
	public static String reverse ( String s ) {
		int length = s.length();
		char[] chars = s.toCharArray();
		
		for (int i = 0; i < length/2; i++) {
			char c = chars[i];
			chars[i] = chars[length-1-i];
			chars[length-1-i] = c;
		}
		
		return new String(chars);
	}
	
	public static String reverseRecursively(String str) {
		if (str.length() < 2) {
			return str;
		}
			
		return reverseRecursively(str.substring(1)) + str.charAt(0);
	}
	
	public static void main(String[] args) {
		System.out.println(reverse("Madam, I'm Adam"));
		System.out.println(reverseRecursively("Madam, I'm Adam"));
		
	}
}
