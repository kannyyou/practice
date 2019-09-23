package com.changhun.linkedin.tree;

/**
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: 
“The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]

Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
Example 2:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 

Note:

All of the nodes' values will be unique.
p and q are different and both values will exist in the binary tree.
 * @author changhun
 *
 */
public class L236_LowestCommonAncestorOfBinaryTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	
	/**
	 * Algorithm

Algorithm

Start traversing the tree from the root node.
If the current node itself is one of p or q, we would mark a variable mid as True and continue the search for the other node in the left and right branches.
If either of the left or the right branch returns True, this means one of the two nodes was found below.
If at any point in the traversal, any two of the three flags left, right or mid become True, this means we have found the lowest common ancestor for the nodes p and q.
	 * @author changhun
	 *
	 */
	public static class Solution1 {

	    private TreeNode ans;

	    public Solution1() {
	        // Variable to store LCA node.
	        this.ans = null;
	    }

	    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {

	        // If reached the end of a branch, return false.
	        if (currentNode == null) {
	            return false;
	        } else {
	        	System.out.println(currentNode.val);
	        }

	        
	        // Left Recursion. If left recursion returns true, set left = 1 else 0
	        int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;

	        // Right Recursion
	        int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;

	        // If the current node is one of p or q
	        int mid = (currentNode.val == p.val || currentNode.val == q.val) ? 1 : 0;

        	System.out.println(" left " + left);        	
        	System.out.println(" right " + right);
        	System.out.println(" mid " + mid);


	        
	        // If any two of the flags left, right or mid become True
	        if (mid + left + right >= 2) {
	        	System.out.println(" ZZZ " + currentNode.val);
	            this.ans = currentNode;
	        }

	        // Return true if any one of the three bool values is True.
	        return (mid + left + right > 0);
	    }

	    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	        // Traverse the tree
	        this.recurseTree(root, p, q);
	        return this.ans;
	    }
	}
	
//	public static class Solution2 {
//		public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//
//		}
//	}
//	
	public static void main(String[] args) {
		TreeNode r = new TreeNode(1);
		r.left = new TreeNode(2);
		r.right = new TreeNode(3);
		
//		r.left.left = new TreeNode(4);
//		r.left.right = new TreeNode(5);
//		r.left.left.left = new TreeNode(8);
//		r.left.left.right = new TreeNode(9);
//		r.left.right.left = new TreeNode(10);
//		r.left.right.right = new TreeNode(11);
//		
//		r.right.left = new TreeNode(6);
//		r.right.right = new TreeNode(7);
//		r.right.left.left = new TreeNode(12);
//		r.right.left.right = new TreeNode(13);
//		r.right.right.left = new TreeNode(14);
//		r.right.right.right = new TreeNode(15);
//		Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8

		Solution1 sol1 = new Solution1();
		TreeNode ans = sol1.lowestCommonAncestor(r, new TreeNode(2), new TreeNode(3));
		
		if (ans!= null) System.out.println(ans.val);
		
	}
}
