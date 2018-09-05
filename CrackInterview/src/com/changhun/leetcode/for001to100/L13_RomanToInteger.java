package com.changhun.leetcode.for001to100;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, two is written as II in Roman numeral, just two one's added together. 
Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. 
However, the numeral for four is not IIII. Instead, the number four is written as IV. 
Because the one is before the five we subtract it making four. 
The same principle applies to the number nine, which is written as IX. 
There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

Example 1:

Input: "III"
Output: 3
Example 2:

Input: "IV"
Output: 4
Example 3:

Input: "IX"
Output: 9
Example 4:

Input: "LVIII"
Output: 58
Explanation: C = 100, L = 50, XXX = 30 and III = 3.
Example 5:

Input: "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

1-10
I, II, III, IIII, V, VI, VII, VIII, VIIII, X.

10 to 100
X, XX, XXX, XL, L, LX, LXX, LXXX, XC, C.

100 to 1000
C, CC, CCC, CD, D, DC, DCC, DCCC, CM, M.

39 = "Thirty nine" (XXX+IX) = XXXIX.
246 = "Two hundred and forty six" (CC+XL+VI) = CCXLVI.

207 = "Two hundred and seven" (CC+VII) = CCVII
1066 = "A thousand and sixty six" (M+LX+VI) = MLXVI

1776 (M+DCC+LXX+VI) = MDCCLXXVI 
1954 (M+CM+L+IV) = MCMLIV 
1990 (M+CM+XC) = MCMXC 
2014 (MM+X+IV) = MMXIV 
2018 MMXVIII.

 * @author changhun
 *
 */
public class L13_RomanToInteger {
	private static int getVal(char c){
        switch (c){
            case 'M':
                return 1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X' :
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
        }
        throw new IllegalArgumentException("unsupported character");
    }
    
    public static int romanToInt(String s) {
        int res = 0;
        if(s.length() == 0) return res;
        for (int i = 0; i < s.length() - 1; i++) {
            int cur = getVal(s.charAt(i));
            int nex = getVal(s.charAt(i+1));
            

            if(cur < nex){
                res -= cur;

                System.out.println("cur " + cur + " " + s.charAt((i)));
                System.out.println("nex " + nex + " " + s.charAt((i+1)));

                
            }else{
                res += cur;
            }
        }
        return res + getVal(s.charAt(s.length()-1)); //for next of last one
    }
    
    public static void main(String[] args) {
		System.out.println(romanToInt("MDCCLXXVI"));
		System.out.println(romanToInt("MMXIV"));

	}
}
