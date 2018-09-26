package com.changhun.leetcode.for501to600;

import java.util.Arrays;

/**
 * 
Given two strings s1 and s2, write a function to return true 
if s2 contains the permutation of s1. In other words, 
one of the first string's permutations is the substring of the second string.
Example 1:
Input:s1 = "ab" s2 = "eidbaooo"
Output:True
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:
Input:s1= "ab" s2 = "eidboaoo"
Output: False
Note:
The input strings only contain lower case letters.
The length of both given strings is in range [1, 10,000].



 * @author changhun
 *
 */
public class L567_PermutationInString {
    
	/**
	 * Using sorting
	 * 
	 * The idea behind this approach is that one string will be a permutation of another 
	 * string only if both of them contain the same characters the same number of times. 
	 * One string xx is a permutation of other string y 
	 * only if sorted(x)=sorted(y).
	 * 
	 * @author changhun
	 *
	 */
	public static class Solution1 {
	    public static boolean checkInclusion(String s1, String s2) {
	        s1 = sort(s1);
	        for (int i = 0; i <= s2.length() - s1.length(); i++) {
	        	//compare s1 to substring of s2.
	            if (s1.equals(sort(s2.substring(i, i + s1.length()))))
	                return true;
	        }
	        return false;
	    }
	    public static String sort(String s) {
	        char[] t = s.toCharArray();
	        Arrays.sort(t);
	        return new String(t);
	    }
	}
	
	public static class Solution2 {
	    public static boolean checkInclusion(String s1, String s2) {
	        if (s1.length() > s2.length())
	            return false;
	        int[] s1map = new int[26];
	        for (int i = 0; i < s1.length(); i++)
	            s1map[s1.charAt(i) - 'a']++;
	        //add s1map
	             
	        for (int i = 0; i <= s2.length() - s1.length(); i++) {
	            int[] s2map = new int[26];
	            for (int j = 0; j < s1.length(); j++) {
	                s2map[s2.charAt(i + j) - 'a']++;
	            }
	            if (matches(s1map, s2map))
	                return true;
	        }
	        return false;
	    }
	    public static  boolean matches(int[] s1map, int[] s2map) {
	        for (int i = 0; i < 26; i++) {
	            if (s1map[i] != s2map[i])
	                return false;
	        }
	        return true;
	    }
	}
	
	public static class Solution3 {
	    public static boolean checkInclusion(String s1, String s2) {
	        if (s1.length() > s2.length())
	            return false;
	        //alphabet map for 
	        // instead of sorting, use char map to compare.
	        int[] s1map = new int[26];	
	        int[] s2map = new int[26];
	        
	        
	        //s1 
	        for (int i = 0; i < s1.length(); i++) {
	            s1map[s1.charAt(i) - 'a']++;
	            s2map[s2.charAt(i) - 'a']++;
	        }

  
	        
	        for (int i = 0; i < s2.length() - s1.length(); i++) {
//	        	System.out.println(s2.charAt(i));
//	        	
//	        	System.out.println("\t" + Arrays.toString(s1map));
//	        	System.out.println("\t" + Arrays.toString(s2map));

	        	
	        	if (matches(s1map, s2map))
	                return true;
	            s2map[s2.charAt(i + s1.length()) - 'a']++;
	            s2map[s2.charAt(i) - 'a']--;
	        }
	        
//        	System.out.println(Arrays.toString(s1map));
//        	System.out.println(Arrays.toString(s2map));

	        return matches(s1map, s2map);
	    }
	    public static boolean matches(int[] s1map, int[] s2map) {
	        for (int i = 0; i < 26; i++) {
	            if (s1map[i] != s2map[i])
	                return false;
	        }
	        return true;
	    }

		
	}
	
	
	

	public static void main(String[] args) {
		System.out.println(Solution1.checkInclusion("kw", "abwktvws"));
		System.out.println(Solution2.checkInclusion("kw", "abwktvws"));
	
		System.out.println(Solution3.checkInclusion("kw", "abwktvws"));
	}
}
