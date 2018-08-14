package com.changhun.crackbook.ch1;

/**
 * aabcccccaaa => a2b1c5a3
 * @author changhun
 *
 */
public class CompressString {
	
	/**
	 * By concatenation
	 * 
	 * @param str
	 * @return
	 */
	public static String compressString(String str) {
		String compressedString = "";
		int countConsecutive = 0;
		
		for (int i = 0; i < str.length(); i++) {
			countConsecutive ++;
			
			// If next character is different than current, append this char to result.
			if ( (i + 1) >= str.length() || str.charAt(i) != str.charAt(i+1)) {
				compressedString += "" + str.charAt(i) + countConsecutive;
				countConsecutive = 0;
			}
		}
		return compressedString.length() < str.length() ? compressedString : str;
	}
	
	/**
	 * By concating with StringBuffer
	 * @param str
	 * @return
	 */
	public static String compressString2(String str) {
		StringBuilder compressed = new StringBuilder();
		int countConsecutive = 0;
		
		for (int i = 0; i < str.length(); i++) {
			countConsecutive ++;
			
			// If next character is different than current, append this char to result.
			if ( (i + 1) >= str.length() || str.charAt(i) != str.charAt(i+1)) {
				compressed.append(str.charAt(i));
				compressed.append(countConsecutive);
				countConsecutive = 0;
			}
		}
		return compressed.length() < str.length() ? compressed.toString() : str;
	}
	
	public static String compressString3(String str) {
		int finalLength = countCompression(str);
		if (finalLength >= str.length()) return str;
		
		StringBuilder compressed = new StringBuilder(finalLength);
		int countConsecutive = 0;
		
		for (int i = 0; i < str.length(); i++) {
			countConsecutive ++;
			
			// If next character is different than current, append this char to result.
			if ( (i + 1) >= str.length() || str.charAt(i) != str.charAt(i+1)) {
				compressed.append(str.charAt(i));
				compressed.append(countConsecutive);
				countConsecutive = 0;
			}
		}
		return compressed.toString();		
	}
	
	public static int countCompression(String str) {
		int compressedLength = 0;
		int countConsecutive = 0;
		
		for (int i = 0; i < str.length(); i++) {
			countConsecutive ++;
			
			if ( (i + 1) >= str.length() || str.charAt(i) != str.charAt(i+1)) {
				compressedLength += 1 + String.valueOf(countConsecutive).length();
				countConsecutive = 0;
			}
		}
		return compressedLength;
	}
	
	public static void main(String[] args) {
		System.out.println(compressString("aabcccccaaa"));
		System.out.println(compressString2("aabcccccaaa"));
		System.out.println(compressString3("aabcccccaaa"));

	}
}
