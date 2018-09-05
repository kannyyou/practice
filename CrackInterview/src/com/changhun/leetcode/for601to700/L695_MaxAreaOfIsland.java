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
Easy

 * @author changhun
 *
 */
public class L695_MaxAreaOfIsland {
   
	public static int[][] grid;
    public static boolean[][] seen;

    public static int area(int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length ||
                seen[r][c] || grid[r][c] == 0)
            return 0;
        seen[r][c] = true;
        return (1 + area(r+1, c) + area(r-1, c)
                  + area(r, c-1) + area(r, c+1));
    }

    public static int maxAreaOfIsland(int[][] grid) {
    	L695_MaxAreaOfIsland.grid = grid;
    	L695_MaxAreaOfIsland.seen = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                ans = Math.max(ans, area(r, c));
            }
        }
        return ans;
    }
    
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
    					  {0,0,0,0,0,0,0,0}};
    	
    	System.out.println(maxAreaOfIsland(area1));
    	System.out.println(maxAreaOfIsland(area2));

	}
}
