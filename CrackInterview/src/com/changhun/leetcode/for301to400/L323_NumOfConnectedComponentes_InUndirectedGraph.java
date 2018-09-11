package com.changhun.leetcode.for301to400;


/**
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
write a function to find the number of connected components in an undirected graph.

Example 1:

Input: n = 5 and edges = [[0, 1], [1, 2], [3, 4]]

     0          3
     |          |
     1 --- 2    4 

Output: 2
Example 2:

Input: n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]]

     0           4
     |           |
     1 --- 2 --- 3

Output:  1
Note:
You can assume that no duplicate edges will appear in edges. 
Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

LinedIn
Medium

 * @author changhun
 *
 */
public class L323_NumOfConnectedComponentes_InUndirectedGraph {


	public static class SolutionUnion {
		public static int countComponents(int n, int[][] edges) {
		    int[] roots = new int[n];
		    for(int i = 0; i < n; i++) roots[i] = i; 

		    for(int[] e : edges) {
//		    	System.out.println(e[0] + " " + e[1]);
		        int root1 = find(roots, e[0]);	//
		        int root2 = find(roots, e[1]);
		        
//		    	System.out.println("\treturn " + root1 + " " + root2);

		        if(root1 != root2) {     
//		            System.out.println("\t" +  Arrays.toString(roots));

		            roots[root1] = root2;  // union root1 and root2 are connect so n --;
//			    	System.out.println("union");
//		            System.out.println("\t " +  Arrays.toString(roots));

		            n--;
		        }
//	            System.out.println(n + " " +  Arrays.toString(roots));

		    }
		    return n;
		}
		
		/**
		 * find a source of node id.
		 * @param roots
		 * @param id
		 * @return
		 */
	    public static int find(int[] roots, int id) {
//	    	System.out.println(id + " " + Arrays.toString(roots));
	    	
	    	
	        while(roots[id] != id) {
	        	System.out.println("*** " + id + " " + roots[id]);
	        	roots[id] = roots[roots[id]];  // optional: path compression
	            id = roots[id];
	        }
//	    	System.out.println("ret " + id + " " + roots[id] + " " + Arrays.toString(roots));

	        return id;
	    }
	}

    
    public static void main(String[] args) {
		int [][] edges1 = {{0, 1}, {1, 2}, {3, 4}};
		System.out.println(SolutionUnion.countComponents(5, edges1));

		System.out.println("_____________");
		int [][] edges2 = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
		System.out.println(SolutionUnion.countComponents(5, edges2));

	}
}
