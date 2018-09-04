package com.changhun.leetcode.for701to800;

import java.util.Stack;

/**
 * 
Design a max stack that supports push, pop, top, peekMax and popMax.

push(x) -- Push element x onto stack.
pop() -- Remove the element on top of the stack and return it.
top() -- Get the element on the top.
peekMax() -- Retrieve the maximum element in the stack.
popMax() -- Retrieve the maximum element in the stack, and remove it. 
If you find more than one maximum elements, only remove the top-most one.
Example 1:
MaxStack stack = new MaxStack();
stack.push(5); 
stack.push(1);
stack.push(5);
stack.top(); -> 5
stack.popMax(); -> 5
stack.top(); -> 1
stack.peekMax(); -> 5
stack.pop(); -> 1
stack.top(); -> 5
Note:
-1e7 <= x <= 1e7
Number of operations won't exceed 10000.
The last four operations won't be called when stack is empty.


LinkedIn

 * @author changhun
 *
 */
public class L716_MaxStack_twoStack {
    /** initialize your data structure here. */
	
	/**
	 * Intuition and Algorithm

		A regular stack already supports the first 3 operations, so we focus on the last two.

		For peekMax, we remember the largest value we've seen on the side. 
		For example if we add [2, 1, 5, 3, 9], we'll remember [2, 2, 5, 5, 9]. 
		This works seamlessly with pop operations, and also it's easy to compute: 
		it's just the maximum of the element we are adding and the previous maximum.

		For popMax, we know what the current maximum (peekMax) is. 
		We can pop until we find that maximum, then push the popped elements back on the stack.
		
		This is time O(N), space O(N)
	 * @author changhun
	 *
	 */
	public static class MaxStack {
		Stack<Integer> stack;
		Stack<Integer> maxStack;
		
	    public MaxStack() {
	        stack = new Stack();
	        maxStack = new Stack();
	    }
	    
	    public void push(int x) {
	        int currentMax = maxStack.isEmpty() ? x : maxStack.peek();
	        maxStack.push(currentMax > x ? currentMax : x);
	        stack.push(x);
	    }
	    
	    public int pop() {
	        maxStack.pop();	//no worry. 
	        return stack.pop();
	    }
	    
	    public int top() {
	        return stack.peek();
	    }
	    
	    public int peekMax() {
	        return maxStack.peek();
	    }
	    
	    public int popMax() {
	        int max = peekMax();
	        Stack<Integer> buffer = new Stack();
	        while (top() != max) buffer.push(pop());
	        pop();
	        while (!buffer.isEmpty()) push(buffer.pop());
	        return max;
	    }
	}
    
	///[2, 1, 5, 3, 9], we'll remember [2, 2, 5, 5, 9] 
    public static void main(String[] args) {
		MaxStack ms = new MaxStack();
		ms.push(2);
		ms.push(1);
		ms.push(5);
		ms.push(3);
		ms.push(9);
		
		System.out.println(ms.stack.toString());
		System.out.println(ms.maxStack.toString());//No worry push will take care of these later
		ms.pop();
		
		System.out.println(ms.stack.toString());
		System.out.println(ms.maxStack.toString());
		
		ms.popMax();
		System.out.println(ms.stack.toString());
		System.out.println(ms.maxStack.toString());
		
		
	}
}
