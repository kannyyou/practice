package com.changhun.leetcode.for201to300;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:

Input: 2, [[1,0]] 
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.

Intuit
Medium

 * @author changhun
 *
 */
public class L207_CourseSchedule {
	public static class Solution {
	    public static boolean canFinish(int numCourses, int[][] prerequisites) {
	        int[][] matrix = new int[numCourses][numCourses];	//i-> j
	        int[] indegree = new int[numCourses];
	        
	        for (int i=0; i< prerequisites.length; i++) {
	        	int ready = prerequisites[i][0];
	        	int pre = prerequisites[i][1];
	        	
	        	
	        	if (matrix[pre][ready] == 0) {
	        		indegree[ready] ++;	//duplicate 
	        	}
	            matrix[pre][ready] = 1;
	            
	        	//System.out.println(pre + " " + ready + " " + matrix[pre][ready] + " " + indegree[ready]);

	        }
	       
//	        for (int i=0; i<numCourses; i++) {
//		        for (int j=0; j<numCourses; j++) {
//		        	System.out.print(matrix[i][j] + " ");
//		        }
//		        System.out.println();
//	        }
//
//	        System.out.println(Arrays.toString(indegree));
	        
	        int count = 0;
	        Queue<Integer> queue = new LinkedList();
	        for (int i=0; i<indegree.length; i++) {
	            if (indegree[i] == 0) queue.offer(i);
	        }    
	        
	        while (!queue.isEmpty()) {
	            int course = queue.poll();
	            count++;
	            for (int i=0; i<numCourses; i++) {
	                if (matrix[course][i] != 0) {
//	                	System.out.println(i + " " + indegree[i]);
	                    if (--indegree[i] == 0)
	                        queue.offer(i);
	                }
	            }
	        }   
//	        System.out.println("count " + count);
	        return count == numCourses;
	    }
	}
	
	public static void main(String[] args) {
		int [][] pre1 = {{2,1},{1,0}};
		
		System.out.println(Solution.canFinish(3, pre1));
		
		System.out.println("-------------------");

		int [][] pre2 = {{2,1},{1,0}, {1,2} };
		
		System.out.println(Solution.canFinish(3, pre2));
		
		
	}
}
