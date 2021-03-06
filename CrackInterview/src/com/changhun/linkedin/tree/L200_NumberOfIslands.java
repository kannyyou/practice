package com.changhun.linkedin.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
 * You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3

 * @author changhun
 *
 */
public class L200_NumberOfIslands {
	/**
	 * Intuition (DFS)

Treat the 2d grid map as an undirected graph 
and there is an edge between two horizontally or vertically adjacent nodes of value '1'.

Algorithm

Linear scan the 2d grid map, if a node contains a '1', 
then it is a root node that triggers a Depth First Search. 
During DFS, every visited node should be set as '0' to mark as visited node. 
Count the number of root nodes that trigger DFS, 
this number would be the number of islands since each DFS starting at some root identifies an island.

	 * Time complexity : O(M×N) where MM is the number of rows and N is the number of columns.

		Space complexity : worst case O(M×N) in case that the grid map is filled with lands where DFS goes by M×N deep.
	

	 * @author changhun
	 *
	 */
	public static class Solution1 {
		void dfs(char[][] grid, int r, int c) {
			int nr = grid.length;
		    int nc = grid[0].length;

		    if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
		    	return;
		    }

		    grid[r][c] = '0';	//visited
		    dfs(grid, r - 1, c);
		    dfs(grid, r + 1, c);
		    dfs(grid, r, c - 1);
		    dfs(grid, r, c + 1);
		}

		public int numIslands(char[][] grid) {
			if (grid == null || grid.length == 0) {
				return 0;
		    }

		    int nr = grid.length;
		    int nc = grid[0].length;
		    int num_islands = 0;
		    for (int r = 0; r < nr; r ++) {
		    	for (int c = 0; c < nc; c ++) {
		    		if (grid[r][c] == '1') {
		    			num_islands ++;
		    			dfs(grid, r, c); //start dfs if grid = 1
		    		}
		    	}
		    }

		    return num_islands;
		}
	}
	
	public static class Solution2 {
		
		/**
		 * Linear scan the 2d grid map, if a node contains a '1', 
		 * then it is a root node that triggers a Breadth First Search. 
		 * Put it into a queue and set its value as '0' to mark as visited node. 
		 * Iteratively search the neighbors of enqueued nodes until the queue becomes empty.
		 * @param grid
		 * @return
		 */
		public int numIslands(char[][] grid) {
		    if (grid == null || grid.length == 0) {
		      return 0;
		    }

		    int nr = grid.length;
		    int nc = grid[0].length;
		    int num_islands = 0;

		    for (int r = 0; r < nr; ++r) {
		    	for (int c = 0; c < nc; ++c) {
		    		if (grid[r][c] == '1') {
		    			++num_islands;
		    			grid[r][c] = '0'; // mark as visited
		    			Queue<Integer> neighbors = new LinkedList<>();
		    			neighbors.add(r * nc + c);	// this is the key !!!
		    				
		    			while (!neighbors.isEmpty()) {
		    				int id = neighbors.remove();	
		    				int row = id / nc;
		    				int col = id % nc;
				            if (row - 1 >= 0 && grid[row-1][col] == '1') {
				            	neighbors.add((row-1) * nc + col);
				            	grid[row-1][col] = '0';
				            }
				            if (row + 1 < nr && grid[row+1][col] == '1') {
				            	neighbors.add((row+1) * nc + col);
				            	grid[row+1][col] = '0';
				            }
				            if (col - 1 >= 0 && grid[row][col-1] == '1') {
				            	neighbors.add(row * nc + col-1);
				            	grid[row][col-1] = '0';
				            }
				            if (col + 1 < nc && grid[row][col+1] == '1') {
				            	neighbors.add(row * nc + col+1);
				            	grid[row][col+1] = '0';
				            }
		    			}
		    		}
		    	}
		    }

		    return num_islands;
		}
	}
	
}
