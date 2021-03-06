package Q1_04_Palindrome_Permutation;
/**
 * Palindrome Permutation: 
 * 
 * Given a string, write a function to check if it is a permutation of a Palindrome. 
 * A Palindrome is a word or phrase that is the same forwards and backwards. 
 * A permutation is a rearrangement of letters.
 * The palindrome does not need to be limited to just dictonary words.
 * 
 * Input Tact Coa
 * Output : true
 * 
 * 
 * 
 * @author changhun
 *
 */
public class Common {

	public static int getCharNumber(Character c) {
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		
		int val = Character.getNumericValue(c);
		if (a <= val && val <= z) {
			return val - a;
		}
		return -1;
	}
	
	public static int[] buildCharFrequencyTable(String phrase) {
		int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
		for (char c : phrase.toCharArray()) {
			int x = getCharNumber(c);
			if (x != -1) {
				table[x]++;
			}
		}
		return table;
	}

}
