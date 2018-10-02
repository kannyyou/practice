package com.changhun.z.stack;

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
public class L716_MaxStack {
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
	
	public static class ModeWithMax {
	    public int value;
	    public int max;
	    public ModeWithMax(int v, int max){
	        value = v;
	        this.max = max;
	    }
	    
	    public String toString() {
	    	return value + ":" + max;
	    }
	}
	
	public static class MaxStack extends Stack<ModeWithMax> {
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void push(int value) {
	        int currentMax = super.isEmpty() ? value : peekMax();
	        super.push(new ModeWithMax(value, currentMax > value ? currentMax : value));
	    }
	       
	    public int top() {
	        return super.peek().value;
	    }
	    
	    public int peekMax() {
	        return super.peek().max;
	    }
	    
	    public int popMax() {
	    	if (this.isEmpty()) {
	    		return Integer.MIN_VALUE;
	    	} else {
	    		return pop().max;
	    	}
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
		
		System.out.println(ms.toString());
		ms.pop();
		
		System.out.println(ms.toString());
		
		ms.popMax();
		System.out.println(ms.toString());
		
		
	}
}
