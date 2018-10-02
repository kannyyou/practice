package com.changhun.z.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * Given a binary tree, collect a tree's nodes as if you were doing this: 
 * Collect and remove all leaves, repeat until the tree is empty.

Example:

Input: [1,2,3,4,5]
  
          1
         / \
        2   3
       / \     
      4   5    

Output: [[4,5,3],[2],[1]]
 

Explanation:

1. Removing the leaves [4,5,3] would result in this tree:

          1
         / 
        2          
 

2. Now removing the leaf [2] would result in this tree:

          1          
 

3. Now removing the leaf [1] would result in the empty tree:

          []      
          
LinkedIn

Medium
 * @author changhun
 *
 */
public class L366_FindLeavesFromBinaryTree {
	public static class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	 
	 
	public static List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> listLeaves = new ArrayList<List<Integer>>();
		List<Integer> leaves = new ArrayList<Integer>();
		
		while (root != null) {
			System.out.println(root == null ? 1:0);
			
			boolean ret = removeLeaves(root, leaves);
			System.out.println("* ZZZ " + ret);
			if (ret) {
				System.out.println("* root = null");

				root = null; 
			}
			
			System.out.println("* added " + (root != null ? root.val:null));

			listLeaves.add(leaves);
	        leaves = new ArrayList<Integer>();
		}
		
		return listLeaves;
	}
	
	/***
	 * 
	 * 1 -> no leave, go to left removeLeaves(2, leaves)
	 * 2 -> no leave, go to left removeLeaves(4, leaves)
	 * 4 -> leave, add value (4's left==right == null back to 2 and call 5)
	 * 5 (2's right), leave, add value, (5's left==right == null back to 1 and call 3)
	 * 3 (1's right) leave add value. back to 1 and left is not null so return as false.
	 * 
	 * back to while because 2's (left.null == null && right.null = null) but root is not null;
	 *  
	 * call 1
	 * call 2
	 * back to 1 and return to while because 1's (left.null == null && right.null = null) is not null
	 * 
	 * call 1
	 * now back to while as true because because 1's (left.null == null && right.null = null)  so root is true
	 *
	 * @param node
	 * @param leaves
	 * @return
	 */
	public static boolean removeLeaves(TreeNode node, List<Integer> leaves) {
		System.out.println("call " + node.val + " " + leaves.toString());
		if (node.left == null && node.right == null) {
			leaves.add(node.val);
			System.out.println("* root " + leaves.toString());
			return true;
		}
		 
		if (node.left != null) {
			System.out.println("* AAA");

			if (removeLeaves(node.left, leaves))  node.left = null;
		}
		 
		if (node.right != null) {
			System.out.println("* BBB");
			if (removeLeaves(node.right, leaves)) node.right = null;
		}
		return false;
		 
	 }
	 
	 public static void main(String[] args) {
		 TreeNode root = new TreeNode(1);
		 root.left = new TreeNode(2);
		 root.right = new TreeNode(3);
		 root.left.left = new TreeNode(4);
		 root.left.right = new TreeNode(5);
		
			
		 System.out.println(findLeaves(root).toString());

	}
}
