package com.changhun.leetcode.for101to200;

import java.util.ArrayDeque;
import java.util.Deque;

/**
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Note:

Division between two integers should truncate toward zero.
The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
Example 1:

Input: ["2", "1", "+", "3", "*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Example 2:

Input: ["4", "13", "5", "/", "+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
Example 3:

Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
Output: 22
Explanation: 
  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22

LinkedIn

 * @author changhun
 *
 */
public class L150_ReversePolishNotation {
	public static int evalRPN(String[] tokens) {
		if (tokens == null || tokens.length == 0) {
			return -1;
		}
		
		int first;
		int second;
		final Deque<Integer> stack = new ArrayDeque<>();
		
		for (String token : tokens) {
			switch (token) {
				case "+":
					stack.push(stack.pop() + stack.pop());
					break;
					
				case "-":
					stack.push(stack.pop() - stack.pop());
					break;
					
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    first = stack.pop();
                    second = stack.pop();

                    stack.push(second / first);
                    break;
                
                default:
                	stack.push(Integer.parseInt(token));
                    break;
			}
		}
		return stack.pop();
	}

	public static void main(String[] args) {
		String [] first = {"2", "1", "+", "3", "*"};
		System.out.println(evalRPN(first));
		
		String [] second = {"4", "13", "5", "/", "+"};
		System.out.println(evalRPN(second));

		String [] third = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
		System.out.println(evalRPN(third));
		
	}
	
	

}
