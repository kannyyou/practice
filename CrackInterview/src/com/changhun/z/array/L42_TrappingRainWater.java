package com.changhun.z.array;

import java.util.Stack;

/**
 * 
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 * compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6

Intuit
Hard

 * @author changhun
 *
 */
public class L42_TrappingRainWater {
	/**
Approach 1: Brute force
Intuition

Do as directed in question. For each element in the array, we find the maximum level of water
 it can trap after the rain, which is equal to the minimum of maximum height of bars on both the sides minus its own height.

Algorithm

Initialize ans = 0 
Iterate the array from left to right:
Initialize max_left=0 and max_right=0
Iterate from the current element to the beginning of array updating:
max_left=max(max_left,height[𝑗])
Iterate from the current element to the end of array updating:
max_right=max(max_right,height[𝑗])
Add min(max_left,max_right)−height[𝑖] to ans

Time complexity: O(n^2)
 For each element of array, we iterate the left and right parts.

Space complexity: O(1) extra space. 

	 * @author changhun
	 *
	 */
	public static class Solution1 {
		public static int trap(int[] height) {
		    int ans = 0;
		    int size = height.length;
		    for (int i = 1; i < size - 1; i++) {
		        int max_left = 0, max_right = 0;
		        for (int j = i; j >= 0; j--) { //Search the left part for max bar size
		            max_left = Math.max(max_left, height[j]);
		        }
		        for (int j = i; j < size; j++) { //Search the right part for max bar size
		            max_right = Math.max(max_right, height[j]);
		        }
		        ans += Math.min(max_left, max_right) - height[i];
		    }
		    return ans;
		}
	}
	
	/**
	
	In brute force, we iterate over the left and right parts again and again just to find the highest bar size upto that index. 
	But, this could be stored. Voila, dynamic programming.

The concept is illustrated as shown:

	 Algorithm

Find maximum height of bar from the left end upto an index i in the array left_max.
Find maximum height of bar from the right end upto an index i in the array right_max.
Iterate over the \text{height}height array and update ans:
Add min(max_left[𝑖],max_right[𝑖])−height[𝑖] to ans

	 
	 Time complexity: O(n).

We store the maximum heights upto a point using 2 iterations of O(n) each.
We finally update ans using the stored values in O(n).
Space complexity: O(n) extra space.

Additional O(n) space for left_max and right_max arrays than in Approach 1. 

	 
	 * 
	 * 
	 * @author changhun
	 *
	 */
	public static class Solution2 {
		public static int trap(int[] height) {
			if(height == null)
				return 0;
		    int ans = 0;
		    int size = height.length;
		    int[] left_max = new int[size];
		    int[] right_max = new int[size];

		    left_max[0] = height[0];
		    for (int i = 1; i < size; i++) {
		        left_max[i] = Math.max(height[i], left_max[i - 1]);
		    }
		    right_max[size - 1] = height[size - 1];
		    for (int i = size - 2; i >= 0; i--) {
		        right_max[i] = Math.max(height[i], right_max[i + 1]);
		    }
		    for (int i = 1; i < size - 1; i++) {
		        ans += Math.min(left_max[i], right_max[i]) - height[i];
		    }
		    return ans;
		}
	}
	
	/**
Approach 3: Using stacks
Intuition

Instead of storing the largest bar upto an index as in Approach 2,
 we can use stack to keep track of the bars that are bounded by longer bars and hence, may store water. 
 Using the stack, we can do the calculations in only one iteration.

We keep a stack and iterate over the array. We add the index of the bar to the stack 
if bar is smaller than or equal to the bar at top of stack, which means that the current bar is bounded by the previous bar in the stack. 
If we found a bar longer than that at the top, we are sure that the bar at the top of the stack is bounded by the current bar 
and a previous bar in the stack, hence, we can pop it and add resulting trapped water to \text{ans}ans.

Algorithm

Use stack to store the indices of the bars.
Iterate the array:
	While stack is not empty and height[current]>height[st.top()]
	It means that the stack element can be popped. Pop the top element as top.
	Find the distance between the current element and the element at top of stack, which is to be filled. 
		distance=current−st.top()−1
	Find the bounded height 
		bounded_height = min(height[current], height[st.top()])−height[top]
	Add resulting trapped water to answer ans += distance∗bounded_height
Push current index to top of the stack
Move current to the next position
	 
Time complexity: O(n).
Single iteration of O(n) in which each bar can be touched at most twice(due to insertion and deletion from stack) 
and insertion and deletion from stack takes O(1) time.
Space complexity: O(n). Stack can take upto O(n) space in case of stairs-like or flat structure. 


	 * @author changhun
	 *
	 */
	public static class Solution3 {
		public static int trap(int[] height) {
		    int ans = 0, current = 0;
		    Stack<Integer> st = new Stack<Integer>();
		    
		    while (current < height.length) {
		        while (!st.empty() && height[current] > height[st.peek()]) {
		            int top = st.peek();
		            st.pop();
		            if (st.empty())
		                break;
		            int distance = current - st.peek() - 1;
		            int bounded_height = Math.min(height[current], height[st.peek()]) - height[top];
		            ans += distance * bounded_height;
		        }
		        st.push(current++);
		    }
		    return ans;
		}
	}
	
	public static class Solution4 {
		public static int trap(int[] height) {
		    int left = 0, right = height.length - 1;
		    int ans = 0;
		    int left_max = 0, right_max = 0;
		    while (left < right) {
		        if (height[left] < height[right]) {
		        	if (height[left] >= left_max) {
		        		left_max = height[left];
		        	} else {
		        		ans += (left_max - height[left]);
		        	}
		            left++;
		        }
		        else {
		        	if (height[right] >= right_max) {
		        		right_max = height[right];
		        		
		        	} else {
		        		ans += (right_max - height[right]);
		        	}
		            right--;
		        }
		    }
		    return ans;
		}
	}
	
	public static void main(String[] args) {
		int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(Solution1.trap(heights));
		System.out.println(Solution2.trap(heights));
		System.out.println(Solution3.trap(heights));
		System.out.println(Solution4.trap(heights));

	}
}
