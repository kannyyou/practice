package com.changhun.leetcode.for201to300;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string that contains only digits 0-9 and a target value, 
 * return all possibilities to add binary operators (not unary) +, -, or * 
 * between the digits so they evaluate to the target value.

Example 1:

Input: num = "123", target = 6
Output: ["1+2+3", "1*2*3"] 
Example 2:

Input: num = "232", target = 8
Output: ["2*3+2", "2+3*2"]
Example 3:

Input: num = "105", target = 5
Output: ["1*0+5","10-5"]
Example 4:

Input: num = "00", target = 0
Output: ["0+0", "0-0", "0*0"]
Example 5:

Input: num = "3456237490", target = 9191
Output: []

LinkedIn

Hard to understand --;

 * @author changhun
 *
 */
public class L282_ExpressionAddOperators {
	
	public static class AddOperator {
		public ArrayList<String> answer;
		public String digits;
		public long target;
		
	    public List<String> addOperators(String num, int target) {
	        if (num.length() == 0) {
	            return new ArrayList<String>();
	          }

	          this.target = target;
	          this.digits = num;
	          this.answer = new ArrayList<String>();
	          this.recurse(0, 0, new StringBuilder(), 0);
	          return this.answer;
	    }
	    
	    public void recurse(int index, long value, StringBuilder ops, long previousValue) {
	    	
	    	System.out.println("index = " + index + ", value = " + value + " ops = " + ops.toString() + " prevValue=" + previousValue);
	    	
	    	String nums = this.digits;
	    	
	    	if (index == nums.length()) {
	    		if (value == this.target) {
	    			System.out.println("\t" + ops.toString());
	    			this.answer.add(ops.toString());
	    		}
	    	}
	    	
	        long currentVal = 0;
	        String currentValRep = null;
	        int length = nums.length();
	    	
	        // Consider all operands
	        for (int i = index; i < length; i++) {
	            // Operand
	            currentVal = currentVal * 10 + Character.getNumericValue(nums.charAt(i));
	            currentValRep = Long.toString(currentVal);
	            
	            // If this is the first index, simply recurse.
	            if (index == 0) {
	                System.out.println("first ");

	                this.recurse(
	                        i + 1,
	                        currentVal,
	                        new StringBuilder(ops.toString()).append(currentValRep),
	                        currentVal);
	                
	            } else {
	                long v = value - previousValue;
	                
	                System.out.println("v = " + v + " value =" + value + " prevVal =" + previousValue);
	                
	                // Constructing a new String builder takes O(1) and the append takes ammortized O(1).
	                // MULTIPLY
	                this.recurse(
	                    i + 1,
	                    v + (previousValue * currentVal),
	                    new StringBuilder(ops.toString()).append('*').append(currentValRep),
	                    previousValue * currentVal);
	                
	                // ADD
	                this.recurse(
	                    i + 1,
	                    value + currentVal,
	                    new StringBuilder(ops.toString()).append('+').append(currentValRep),
	                    currentVal);
	                
	                // SUBTRACT
	                this.recurse(
	                    i + 1,
	                    value - currentVal,
	                    new StringBuilder(ops.toString()).append('-').append(currentValRep),
	                    - currentVal);
	            }
	            
	            if (nums.charAt(index) == '0') {
	                break;
	            }
	        }
	    }
	}
	
	public static void main(String[] args) {
		AddOperator addOperator = new AddOperator();
		System.out.println(addOperator.addOperators("123", 6));
	}
}
