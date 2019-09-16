package com.changhun.linkedin.array_string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced 
with another character while preserving the order of characters. 
No two characters may map to the same character but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
Note:
You may assume both s and t have the same length.


 * @author changhun
 *
 */
public class L205_IsomorphicString {
	public static class Solution1 {
	    public static boolean isIsomorphic(String s, String t) {
	        Map<Character,Character> map = new HashMap<>(); //(s, t)
	        Set<Character> set = new HashSet<>(); //unique for t
	        if(s==null) return true;
	        for(int i=0;i<s.length();i++){
	            if(map.containsKey(s.charAt(i))){
	                if(map.get(s.charAt(i))!=t.charAt(i)) return false;
	            } else{
	                if(set.contains(t.charAt(i))) return false;
	                map.put(s.charAt(i),t.charAt(i));
	                set.add(t.charAt(i));
	            }
	        }
	        return true;
	    }
	}
	
	
	public static class Solution2 {
	    public static boolean isIsomorphic(String s1, String s2) {
	        int[] m = new int[512];	// ascii = 256 * 2
	        for (int i = 0; i < s1.length(); i++) {
	            if (m[s1.charAt(i)] != m[s2.charAt(i)+256]) return false;
	            m[s1.charAt(i)] = m[s2.charAt(i)+256] = i+1;
	        }
	        return true;
	    }
	}

	
	public static void main(String[] args) {
		System.out.println(Solution1.isIsomorphic("egg", "add"));
		System.out.println(Solution1.isIsomorphic("foo", "bar"));
		System.out.println(Solution1.isIsomorphic("paper", "title"));

		
		System.out.println(Solution2.isIsomorphic("egg", "add"));
		System.out.println(Solution2.isIsomorphic("foo", "bar"));
		System.out.println(Solution2.isIsomorphic("paper", "title"));

	}
}
