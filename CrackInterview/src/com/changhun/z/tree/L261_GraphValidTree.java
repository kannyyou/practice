package com.changhun.z.tree;

import java.util.Arrays;

import com.changhun.z.graph_matrix.L323_NumOfConnectedComponentes_InUndirectedGraph.SolutionUnion;

/**
Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes), 
write a function to check whether these edges make up a valid tree.

Example 1:

Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
Output: true
Example 2:

Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
Output: false
Note: you can assume that no duplicate edges will appear in edges. 
Since all edges are undirected, [0,1] is the same as [1,0] and thus will not appear together in edges.
 * @author changhun
 *
 */
public class L261_GraphValidTree {
	public static class Solution {
	    public static boolean validTree(int n, int[][] edges) {
	        // initialize n isolated islands
	        int[] nums = new int[n];
	        Arrays.fill(nums, -1);
	        
	        // perform union find
	        for (int i = 0; i < edges.length; i++) {
	            int x = find(nums, edges[i][0]);
	            int y = find(nums, edges[i][1]);
	            
	            // if two vertices happen to be in the same set
	            // then there's a cycle
	            if (x == y) return false;
	            
	            // union
	            nums[x] = y;
	        }
	        System.out.println(Arrays.toString(nums));
	        return edges.length == n - 1;
	    }
	    
	    private static int find(int nums[], int i) {
	        if (nums[i] == -1) return i;
	        return find(nums, nums[i]);
	    }
	}
	
    public static void main(String[] args) {
		int [][] edges1 = {{0, 1}, {0, 2}, {0, 3}, {1,4}};
		System.out.println(Solution.validTree(5, edges1));

		System.out.println("_____________");
		int [][] edges2 = {{0, 1}, {1, 2}, {2, 3}, {1,3}, {1, 4}};
		System.out.println(Solution.validTree(5, edges2));

	}
}
