package com.changhun.leetcode.for601to700;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
Given the running logs of n functions that are executed 
in a nonpreemptive single threaded CPU, find the exclusive time of these functions.

Each function has a unique id, start from 0 to n-1. A function may be called recursively or by another function.

A log is a string has this format : function_id:start_or_end:timestamp. 
For example, "0:start:0" means function 0 starts from the very beginning of time 0. "0:end:0" means function 0 ends to the very end of time 0.

Exclusive time of a function is defined as the time spent within this function, 
the time spent by calling other functions should not be considered as this function's exclusive time. 
You should return the exclusive time of each function sorted by their function id.

Example 1:
Input:
n = 2
logs = 
["0:start:0",
 "1:start:2",
 "1:end:5",
 "0:end:6"]
Output:[3, 4]
Explanation:
Function 0 starts at time 0, then it executes 2 units of time and reaches the end of time 1. 
Now function 0 calls function 1, function 1 starts at time 2, executes 4 units of time and end at time 5.
Function 0 is running again at time 6, and also end at the time 6, thus executes 1 unit of time. 
So function 0 totally execute 2 + 1 = 3 units of time, and function 1 totally execute 4 units of time.
Note:
Input logs will be sorted by timestamp, NOT log id.
Your output should be sorted by function id, which means the 0th element of your output corresponds 
to the exclusive time of function 0.
Two functions won't start or end at the same time.
Functions could be called recursively, and will always end.
1 <= n <= 100

LinkedIn
Medium

 * @author changhun
 *
 */
public class L636_ExclusiveTimeOfFunction {
	/**
	 * 1. Push the function id of the 1st function in the logs list ont the stack.
	 * 2. Keep incrementing the exclusive time (along with the current time) corresponding 
	 * to the function on of the stack (in the res array)., 
	 * till the current time equals the start/end time corresponding to the next function in the logs list. 
	 * 3. If the next function has 'start' label, push this function's id on the stack. 
	 * Otherwise, increment the last function's exclusive time (along with the current time), 
	 * and pop the function id from the top of the stack.
	 * 4. Repeat steps 2 and 3 till all the functions in the logs list have been considered.
	 * 5. Return the resultant the exclusive time (res).
	 * 
	 * Time complexity : O(t). We increment the time till all the functions are done with the execution. 
	 * Here, t refers to the end time of the last function in the logs list.
	 * Space complexity : O(n). The stack can grow upto a depth of atmost n/2. 
	 * Here, n refers to the number of elements in the given logs list.

	 * @author changhun
	 *
	 */
	public static class Solution1 {
	    public static int[] exclusiveTime(int n, List<String> logs) {
	    	Stack<Integer> stack = new Stack<>();
	    	int[] res = new int[n];
	        String[] s = logs.get(0).split(":");
	        stack.push(Integer.parseInt(s[0]));	//add function id
	        int i = 1;
	        int time = Integer.parseInt(s[2]);
	        
	        while(i < logs.size()) {
	        	s = logs.get(i).split(":");
	            while (time < Integer.parseInt(s[2])) {
	                res[stack.peek()]++;
	                time++;
	            }
	            if (s[1].equals("start")) {
	            	stack.push(Integer.parseInt(s[0]));
	            } else {
	            	res[stack.peek()]++;
	                time++;
	                stack.pop();
	            }
	            i++;
	        }	        
	        
	    	return res;
	    }
	}
	/**
Instead of doing this incrementing step by step, we can directly use the difference 
between the next function's start/stop time and the current function's start/stop time. 
The rest of the process remains the same as in the last approach.

The following animation illustrates the process.

Time complexity : O(n). We iterate over the entire logslogs array just once. 
Here, n refers to the number of elements in the logs list.

Space complexity : The stack can grow upto a depth of atmost n/2. 
Here, n refers to the number of elements in the given logs list.

	 * @author changhun
	 *
	 */
	public static class Solution2 {
	    public static int[] exclusiveTime(int n, List<String> logs) {
	        Stack < Integer > stack = new Stack < > ();
	        int[] res = new int[n];
	        String[] s = logs.get(0).split(":");
	        stack.push(Integer.parseInt(s[0]));
	        int i = 1;
	        int prev = Integer.parseInt(s[2]);
	        
	        while (i < logs.size()) {	        	
	        	s = logs.get(i).split(":");
	        	System.out.println(s[0] + " " + s[1] + " " + s[2] + " prev=" + prev + " " + stack.toString());
	        	if (s[1].equals("start")) {
	        		if (!stack.empty()) {
	                    res[stack.peek()] += Integer.parseInt(s[2]) - prev;
	        		}
	                stack.push(Integer.parseInt(s[0]));
	                prev = Integer.parseInt(s[2]);

	        	} else {
	                res[stack.peek()] += Integer.parseInt(s[2]) - prev + 1;
	                stack.pop();
	                prev = Integer.parseInt(s[2]) + 1;
	        	}
	        	i++;
	        }
	        return res;
	    }
	}
	
	public static void main(String[] args) {
		List<String> logs = new ArrayList<>();
		logs.add("0:start:0");
		logs.add("1:start:2");
		logs.add("1:end:5");
		logs.add("0:end:6");
		
		System.out.println(Arrays.toString(Solution1.exclusiveTime(2, logs)));
		System.out.println(Arrays.toString(Solution2.exclusiveTime(2, logs)));

	}
}
