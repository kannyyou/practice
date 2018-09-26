package com.changhun.leetcode.for601to700;

/**
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) 
 * connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

Example 1:
[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
Example 2:
[[0,0,0,0,0,0,0,0]]


LinkedIn
Intuit
Easy


 * @author changhun
 *
 */
public class L695_MaxAreaOfIsland {
   
	public static class Solution1 {
	    int[][] grid;
	    boolean[][] seen;

	    public int area(int r, int c) {
	        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length ||
	                seen[r][c] || grid[r][c] == 0)
	            return 0;
	        seen[r][c] = true;
	        return (1 + area(r+1, c) + area(r-1, c)
	                  + area(r, c-1) + area(r, c+1));
	    }

	    public int maxAreaOfIsland(int[][] grid) {
	        this.grid = grid;
	        seen = new boolean[grid.length][grid[0].length];
	        int ans = 0;
	        for (int r = 0; r < grid.length; r++) {
	            for (int c = 0; c < grid[0].length; c++) {
	                ans = Math.max(ans, area(r, c));
	            }
	        }
	        return ans;
	    }
	}
	
	
	
    /**
     Approach #1: Depth-First Search (Recursive) [Accepted]
Intuition and Algorithm

We want to know the area of each connected shape in the grid, then take the maximum of these.

If we are on a land square and explore every square connected to it 4-directionally 
(and recursively squares connected to those squares, and so on), then the total number of squares explored will be the area of that connected shape.

To ensure we don't count squares in a shape more than once, let's use seen to keep track of squares we haven't visited before. 
It will also prevent us from counting the same shape more than once.

Time O(R*C)
Space O(R*C)


     * @param args
     */
    public static void main(String[] args) {
    	
    	int [][] area1 = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
    	                  {0,0,0,0,0,0,0,1,1,1,0,0,0},
    	                  {0,1,1,0,1,0,0,0,0,0,0,0,0},
    	                  {0,1,0,0,1,1,0,0,1,0,1,0,0},
    	                  {0,1,0,0,1,1,0,0,1,1,1,0,0},
    	                  {0,0,0,0,0,0,0,0,0,0,1,0,0},
    	                  {0,0,0,0,0,0,0,1,1,1,0,0,0},
    	                  {0,0,0,0,0,0,0,1,1,0,0,0,0}};
    	
    	int [][] area2 = {{0,0,0,1,0,0,0,0},
    					  {0,0,0,0,0,0,1,1}};
    	
    	Solution1 sol1 = new Solution1();

    	System.out.println(sol1.maxAreaOfIsland(area1));
    	System.out.println(sol1.maxAreaOfIsland(area2));

	}
}
