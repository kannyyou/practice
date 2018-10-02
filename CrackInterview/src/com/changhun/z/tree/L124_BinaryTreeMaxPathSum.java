package com.changhun.z.tree;
/**
 * Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node 
in the tree along the parent-child connections. 
The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6
Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42


Here's my ideas:

A path from start to end, goes up on the tree for 0 or more steps, 
hen goes down for 0 or more steps. Once it goes down, it can't go up. 
Each path has a highest node, which is also the lowest common ancestor of all other nodes on the path.
A recursive method maxPathDown(TreeNode node) 
(1) computes the maximum path sum with highest node is the input node, update maximum if necessary 
(2) returns the maximum sum of the path that can be extended to input node's parent.
Code:


intuit 
hard

 * @author changhun
 *
 */
public class L124_BinaryTreeMaxPathSum {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
    static int maxValue;
    
    public static int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }
    
    private static int maxPathDown(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        maxValue = Math.max(maxValue, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
    
    public static void main(String[] args) {
    	TreeNode root = new TreeNode(-10);
    	root.left = new TreeNode(9);
    	root.right = new TreeNode(20);
    	root.right.left = new TreeNode(15);
    	root.right.right = new TreeNode(7);

    	System.out.println(maxPathSum(root));
    	
    	
	}

}
