package com.changhun.quiz.facebook;

/**
 * You have a string consisting of open and closed parentheses, but parentheses may be imbalanced. 
Make the parentheses balanced and return the new string.


 * @author changhun
 *
 */
public class BalanceParentheses {
	
	public static String balanceParentheses(String input) {
	
		
		int sizeLeft = 0;
		int sizeRight = 0;
		for (int i=0; i<input.length(); i++) {
			char c = input.charAt(i);
			
			switch(c) {
			case '(':
				sizeLeft ++;
				break;
			case ')':
				sizeRight ++;
				break;
			default:
				break;
				
			}		
		}
		
		if (sizeLeft > sizeRight) {
			for (int i=0; i< (sizeLeft-sizeRight) ; i++) {
				input += ")";
			}
		} else if (sizeLeft < sizeRight) {
			String tmp = "";
			for (int i=0; i< (sizeLeft-sizeRight) ; i++) {
				tmp += "(";
			}
			input = tmp + input;
		}
		
		return input;
		
	}
	
	public static void main(String[] args) {
		String s="((a(+b)(((())";

		s = "(((a))";
		System.out.println(balanceParentheses(s));
	}
}
