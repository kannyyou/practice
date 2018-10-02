package com.changhun.z.number;
/**
 * 
The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

 To generate a member of the sequence from the previous member, read off the digits of the previous member, 
 counting the number of digits in groups of the same digit. For example:

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
1211 is read off as "one 1, one 2, then two 1s" or 111221.
111221 is read off as "three 1s, two 2s, then one 1" or 312211.

 https://en.wikipedia.org/wiki/Look-and-say_sequence
 
 Intuit
 easy
 
 * @author changhun
 *
 */
public class L38_Count_and_Say {
	public static class Solution1 {
	    public static String countAndSay(int n) {
	    	StringBuilder curr = new StringBuilder("1");
	    	StringBuilder prev;
	    	int count;
	    	char say;
	    	for (int i=1; i<n; i++) {
	    		prev = curr;
	    		curr = new StringBuilder();
	    		count = 1;
	    		say = prev.charAt(0);
	    		
	    		for (int j=1, len=prev.length(); j<len; j++) {
	    			if (prev.charAt(j) != say) {
//	    	    		System.out.println("in\t"+count + " " + say + " " + curr.toString());
	    				curr.append(count).append(say);
	    				count = 1;
	 	        		say=prev.charAt(j);

	    			} else {
	    				count ++;
	    			}
	    		}
//	    		System.out.println("out\t"+count + " " + say + " " + curr.toString());
	    		curr.append(count).append(say);
	    	}
//    		System.out.println("last\t"+  curr.toString());
	    	return curr.toString();
	    }
	}
	
	// Java program to find n'th 
	// term in look and say sequence
	 
	public static class Solution2 {
	 
	    // Returns n'th term in 
	    // look-and-say sequence
	    public static String countAndSay(int n)
	    {
	    	// Base cases
	    	if (n == 1)     return "1";
	    	if (n == 2)     return "11";
	 
	    	// Find n'th term by generating 
	    	// all terms from 3 to n-1. 
	    	// Every term is generated 
	    	// using previous term
	     
	    	// Initialize previous term
	    	String str = "11"; 
	    	for (int i = 3; i <= n; i++) {
	    		// In below for loop, previous 
	    		// character is processed in 
	    		// current iteration. That is
	    		// why a dummy character is 
	    		// added to make sure that loop
	    		// runs one extra iteration.
	    		str += '$';
	    		int len = str.length();
	 
	    		int cnt = 1; // Initialize count 
	                     // of matching chars
	    		String tmp = ""; // Initialize i'th 
	                         // term in series
	    		char []arr = str.toCharArray();
	         
	    		// Process previous term
	    		// to find the next term
	    		for (int j = 1; j < len; j++){
	    			// If current character
	    			// does't match
	    			if (arr[j] != arr[j - 1]) {
	    				// Append count of 
	    				// str[j-1] to temp
	    				tmp += cnt + 0;
	     				// Append str[j-1]
	    				tmp += arr[j - 1];
	    				// Reset count
	    				cnt = 1;
	    			}
	 	            // If matches, then increment 
	    			// count of matching characters
	    			else cnt++;
	    		}
	 
	    		// Update str
	    		str = tmp;
	    	}
	    	return str;
	    }
	}
	 
	
	public static void main(String[] args) {
		System.out.println(1 + " " + Solution1.countAndSay(1));
		System.out.println(2 + " " + Solution1.countAndSay(2));
		System.out.println(3 + " " + Solution1.countAndSay(3));
		System.out.println(4 + " " + Solution1.countAndSay(4));
		System.out.println(5 + " " + Solution1.countAndSay(5));
		System.out.println(6 + " " + Solution1.countAndSay(6));
		System.out.println(7 + " " + Solution1.countAndSay(7));
		System.out.println(8 + " " + Solution1.countAndSay(8));
		
		System.out.println("===============");
				
		System.out.println(1 + " " + Solution2.countAndSay(1));
		System.out.println(2 + " " + Solution2.countAndSay(2));
		System.out.println(3 + " " + Solution2.countAndSay(3));
		System.out.println(4 + " " + Solution2.countAndSay(4));
		System.out.println(5 + " " + Solution2.countAndSay(5));
		System.out.println(6 + " " + Solution2.countAndSay(6));
		System.out.println(7 + " " + Solution2.countAndSay(7));
		System.out.println(8 + " " + Solution2.countAndSay(8));
	}
	
}
