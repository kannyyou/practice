package com.changhun.leetcode.for101to200;

import java.util.Arrays;

/**
Compare two version numbers version1 and version2.
If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", 
it is the fifth second-level revision of the second first-level revision.

Example 1:

Input: version1 = "0.1", version2 = "1.1"
Output: -1
Example 2:

Input: version1 = "1.0.1", version2 = "1"
Output: 1
Example 3:

Input: version1 = "7.5.2.4", version2 = "7.5.3"
Output: -1

Intuit
Medium

Question num is Int ?

 * @author changhun
 *
 */
public class L165_CompareVersionNumbers {
	/**
	 * This code assumes that next level is zero if no mo levels in shorter version number. And than compare levels.
	 * @author changhun
	 *
	 */
	public static class Solution1 {
		public static int compareVersion(String version1, String version2) {
		    String[] levels1 = version1.split("\\.");
		    String[] levels2 = version2.split("\\.");
		    
//		    System.out.println(Arrays.toString(levels1) + " " + Arrays.toString(levels2));
		    int length = Math.max(levels1.length, levels2.length);
		    for (int i=0; i<length; i++) {
		    	Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
		    	Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
		    	
//		    	System.out.println(v1 + " " + v2);

		    	int compare = v1.compareTo(v2);
		    	if (compare != 0) {
		    		return compare;
		    	}
		    }
		    
		    return 0;
		}
	}
	
	public static class Solution2 {
		public static int compareVersion(String version1, String version2) {
		    int temp1 = 0,temp2 = 0;
		    int len1 = version1.length(),len2 = version2.length();
		    int i = 0,j = 0;
		    while(i<len1 || j<len2) {
		        temp1 = 0;
		        temp2 = 0;
		        while(i<len1 && version1.charAt(i) != '.') {
		            temp1 = temp1*10 + version1.charAt(i++)-'0';
		            
		        }
		        while(j<len2 && version2.charAt(j) != '.') {
		            temp2 = temp2*10 + version2.charAt(j++)-'0';
		            
		        }
		        if(temp1>temp2) return 1;
		        else if(temp1<temp2) return -1;
		        else {
		            i++;
		            j++;
		            
		        }
		        
		    }
		    return 0;
		    
		}
	}
	public static void main(String[] args) {
		System.out.println(Solution1.compareVersion("1.0.1", "1"));
		System.out.println(Solution1.compareVersion("44443", "44444"));

		System.out.println(Solution2.compareVersion("1.0.1", "1"));
		System.out.println(Solution2.compareVersion("44443", "44444"));

	}
}
