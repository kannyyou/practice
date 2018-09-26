package com.changhun.leetcode.for201to300;

import java.util.Stack;

/**
Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . 
The integer division should truncate toward zero.

Example 1:

Input: "3+2*2"
Output: 7
Example 2:

Input: " 3/2 "
Output: 1
Example 3:

Input: " 3+5 / 2 "
Output: 5

Intuit

medium

 * @author changhun
 *
 */
public class L227_Basic_Calculator2 {
	public static class Solution {
	    public static int calculate(String s) {
	        int len;
	        if(s==null || (len = s.length())==0) return 0;
	        Stack<Integer> stack = new Stack<Integer>();
	        int num = 0;
	        char sign = '+';
	        for(int i=0;i<len;i++){
	            if(Character.isDigit(s.charAt(i))){
	                num = num*10+s.charAt(i)-'0';
	            }
	            if((!Character.isDigit(s.charAt(i)) &&' '!=s.charAt(i)) || i==len-1){
	                if(sign=='-'){
	                    stack.push(-num);
	                }
	                if(sign=='+'){
	                    stack.push(num);
	                }
	                if(sign=='*'){
	                    stack.push(stack.pop()*num);
	                }
	                if(sign=='/'){
	                    stack.push(stack.pop()/num);
	                }
	                sign = s.charAt(i);
	                num = 0;
	            }
	        }

	        int re = 0;
	        for(int i:stack){
	            re += i;
	        }
	        return re;
	    }
	}
	
	public static void main(String[] args) {
		System.out.println(Solution.calculate("3+2"));
	}
}
