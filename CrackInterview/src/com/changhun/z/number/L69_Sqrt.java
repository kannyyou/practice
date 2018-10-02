package com.changhun.z.number;

/**
Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:

Input: 4
Output: 2
Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since 
             the decimal part is truncated, 2 is returned.
         
LinkedIn 
Easy

 * @author changhun
 *
 */
public class L69_Sqrt {
	
	// choose here
    public static int mySqrt(int x) {
        if (x == 0) {
        	return 0;
        }
        int left = 1, right = Integer.MAX_VALUE;
        
        while(true) {
        	int mid = left + (right - left)/2;
//        	System.out.print(mid + " " + left + " " + right + " ");

        	if (mid > x/mid) {
                right = mid - 1;
//            	System.out.println(" left");

        	} else {
//            	System.out.println(" right");

        		if (mid + 1 > x/(mid+1)) 
        			return mid;
        		left = mid + 1;
        	}
        }
        
    }
    
    public static int mySqrt2(int x) {
    	long r = x;
        while (r*r > x) {
        	r = (r + x/r) / 2;
//            System.out.println("\t" + r);

        }                 
        return (int) r;
    }
    public static void main(String[] args) {
		System.out.println(mySqrt(4));
		System.out.println(mySqrt(8));
		System.out.println(mySqrt(9));
		System.out.println(mySqrt(10));

		System.out.println(2 + " " + mySqrt2(4));
		System.out.println(8 + " " + mySqrt2(8));
		System.out.println(9 + " " + mySqrt2(9));
		System.out.println(108 + " " + mySqrt2(108));
		
	}
}
