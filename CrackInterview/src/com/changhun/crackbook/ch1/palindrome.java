package com.changhun.crackbook.ch1;

public class palindrome {
	
	/**
	 * 
	 * @param phrase
	 * @return
	 */
	public static boolean isPermuationOfpalindrome1(String phrase) {
		return checkMaxOneOdd(buildCharFrequencyTable(phrase));
	}
		
	/**
	 * Check that no more than one character has an odd count
	 * @param table
	 * @return
	 */
	public static boolean checkMaxOneOdd(int[] table) {
		boolean foundOdd = false;
		
		for (int count : table) {
			if (count % 2 == 1) {
				if (foundOdd) {
					return false;	//not allow two odd
				}
				foundOdd = true;
			}
		}
		return true;
	}
	
	/**
	 * Map each character to a number ,a->0, b->1 ...
	 * @param c
	 * @return
	 */
	public static int getCharNumber(Character c) {
		
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		
		int val = Character.getNumericValue(c);
		
		if (val >= a && val <= z) {
			return val - a;
		}
		
		return -1;
	}
	
	/**
	 * Count how many times each character appears
	 * @param pharase
	 * @return
	 */
	public static int [] buildCharFrequencyTable(String phrase) {
		
		int[] table = new int [Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
		
		for (char c : phrase.toCharArray()) {
			int x = getCharNumber(c);
			if (x != -1) {
				table[x] ++;
			}
		}
		
		return table;
	}
	
	public static boolean isPermuationOfpalindrome2(String phrase) {
		int countOdd = 0;
		int[] table = new int [Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
		
		for (char c : phrase.toCharArray()) {
			int x = getCharNumber(c);
			if (x != -1) {
				table[x] ++;
				
				if (table[x] % 2 == 1) {
					countOdd ++;
				} else {
					countOdd --;
				}
			}
		}
		return countOdd <=1;
	}
	
	public static boolean isPermuationOfpalindrome3(String phrase) {
		int bitVector = createBitVector(phrase);
		return bitVector == 0 || checkExactlyOneBitSet(bitVector);
	}
	
	/**
	 * Create a bit vector for String. 
	 * For each letter with value , toggle the ith bit.
	 * @param phrase
	 * @return
	 */
	public static int createBitVector(String phrase) {
		int bitVector = 0;
		for (char c : phrase.toCharArray()) {
			int x = getCharNumber(c);
			bitVector = toggle(bitVector, x);
		}
		return bitVector;
	}
	
	
	/**
	 * Toggle index's bi in the integer.
	 * 
	 * (2 <10>, 0) => 3, (3 <11>, 0) => 2
	 * @param bitVector
	 * @param index
	 * @return
	 */
	public static int toggle(int bitVector, int index) {
		if (index < 0) return bitVector;
		
		int mask = 1 << index;
		if ((bitVector & mask) == 0) {
			bitVector |= mask;
		} else {
			bitVector &= ~mask;
		}
		
		return bitVector;
	}
	
	/**
	 * Check that exactly one bit is set by subtracting one from the integer and ANDing it with the original int; 
	 * 
	 * 2 (10) & 1 (01) = 0 
	 * 
	 * 3 (11) & 2 (10) = 1
	 * @param bitVector
	 * @return
	 */
	public static boolean checkExactlyOneBitSet(int bitVector) {
		return (bitVector & (bitVector - 1) ) == 0;
	}
	
	public static void main(String[] args) {
		
		System.out.println(isPermuationOfpalindrome1("tact coa"));
		System.out.println(isPermuationOfpalindrome2("tact coa"));
		
		System.out.println(toggle(2, 0));
		
		System.out.println(checkExactlyOneBitSet(5));
		
		System.out.println(createBitVector("abba"));
		
		System.out.println(isPermuationOfpalindrome3("tact coa"));

	}
}
