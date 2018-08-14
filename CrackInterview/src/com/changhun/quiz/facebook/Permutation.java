package com.changhun.quiz.facebook;


/**
 * A "derangement" of a sequence is a permutation where no element appears in its original position. 
 * For example ECABD is a derangement of ABCDE, given a string, may contain duplicate char, please out put all the derangement

 * @author changhun
 *
 */
public class Permutation {
	
	public static void permutation(String str) { 
	    permutation("", str, str); 
	}

	private static void permutation(String prefix, String str, String base) {
	    int n = str.length();
	    if (n == 0) {
	       	if (!prefix.equals(base)) {
		    	System.out.println(prefix);
        	}
	    }
	    else {
	        for (int i = 0; i < n; i++) {
	        	

	        	System.out.println("\t " + i + " " + n + " "  + prefix + str.charAt(i) + "  " + str.substring(0, i) + str.substring(i+1, n));
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), base);
	            
	            
	        }
	    }
	}
	
	
	
	public static void derangement(String str) {
		
	}
	
	public static void main(String[] args) {
		permutation("abcde");

		
		
	}
	
}
