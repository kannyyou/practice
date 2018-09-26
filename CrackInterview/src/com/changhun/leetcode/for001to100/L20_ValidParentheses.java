package com.changhun.leetcode.for001to100;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true

LinkedIn 
Easy


 * @author changhun
 *
 */
public class L20_ValidParentheses {
	
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char c: s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '{') 
				stack.push('}');
			else if (c == '[') 
				stack.push(']');
			else if (stack.isEmpty())
				return false;
			else {
				char outC = stack.pop();
				System.out.println(c);
				if (c != outC) return false; 
			}
			
//			else if (stack.isEmpty() || stack.pop() != c)
//				return false;	

		}
		return stack.isEmpty();
	}
	
	public static boolean isValid2(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char c: s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '{') 
				stack.push('}');
			else if (c == '[') 
				stack.push(']');
			else if (stack.isEmpty())
				return false;
			else if (stack.isEmpty() || stack.pop() != c)
				return false;	

		}
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		System.out.println(isValid("()"));
		System.out.println(isValid("()[]{}"));
		System.out.println(isValid("(}"));
		System.out.println(isValid("([)]"));
		System.out.println(isValid("{[]}"));
		System.out.println(isValid("(([{}]))"));


	}
	
}
