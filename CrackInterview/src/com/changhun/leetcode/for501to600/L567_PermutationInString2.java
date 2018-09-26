package com.changhun.leetcode.for501to600;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 
A permutation, also called an “arrangement number” or “order,” 
is a rearrangement of the elements of an ordered list S 
into a one-to-one correspondence with S itself. A string of length n has n! permutation.
Source: Mathword(http://mathworld.wolfram.com/Permutation.html)

Below are the permutations of string ABC.
ABC ACB BAC BCA CBA CAB

 * @author changhun
 *
 */
public class L567_PermutationInString2 {
	public static class Solution1 {	

	    /** 
	     * permutation function 
	     * @param str string to calculate permutation for 
	     * @param l starting index 
	     * @param r end index 
	     */
	    private static void permute(Set<String> set , String str, int l, int r) { 
	        
	    	if (l == r) {
	            set.add(str); 

	    	} else { 
	            for (int i = l; i <= r; i++) 
	            { 
	                str = swap(str,l,i); 
	                permute(set, str, l+1, r); 
	                str = swap(str,l,i);                
	            } 
	        } 
	    	
	    } 
	    
	    
	    /** 
	     * Swap Characters at position 
	     * @param a string value 
	     * @param i position 1 
	     * @param j position 2 
	     * @return swapped string 
	     */
	    public static String swap(String a, int i, int j) { 
	        char temp; 
	        char[] charArray = a.toCharArray(); 
	        temp = charArray[i] ; 
	        charArray[i] = charArray[j]; 
	        charArray[j] = temp;         
	        return String.valueOf(charArray); 
	    } 
	    
	    public static Set<String> permute(String a) {
	        Set<String> set = new HashSet<String>();

	    	permute(set, a, 0, a.length()-1);
	    	return set;
	    }
	    
	    
	    /**
	     * Count permutation of substring in the given string.
	     * @param st
	     * @param sub
	     * @return
	     */
	    public static int findCountPermutation(String st, String sub) {
	    	Set<String> set = permute(sub);
	    	int count = 0;
	    	for(String s: set) {
	    		if (st.contains(s)) 
	    			count ++;
	    	}
	    	return count;
	    	
	    }
	    
	    
	}
	
	public static void main(String[] args) {		
		System.out.println(Solution1.permute("abc"));
		
		System.out.println(Solution1.findCountPermutation("abcxyzcba", "abc"));

	}
}
