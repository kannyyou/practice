package com.changhun.z.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.changhun.z.tree.L101_SymmetricTree.TreeNode;

/**
 * Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1

 * @author changhun
 *
 */
public class L226_Invert_Binary_Tree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	/*O(N) */
	public static void printTree(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();

	    if (root == null) return;
	    
	    queue.offer(root);   
	    while (!queue.isEmpty()) {
			TreeNode current = queue.poll();
	    	System.out.print(current.val + " ");
	    	
			if (current.left != null) queue.add(current.left);
			if (current.right != null) queue.add(current.right);


	    }
	}
	
	public static class Solution1 {
		public static TreeNode invertTree(TreeNode root) {
			if (root == null) return null;
			TreeNode right = invertTree(root.right);
			TreeNode left = invertTree(root.left);
			root.left = right;
			root.right = left;
			
			return root;
		}
		
		public static TreeNode invertTree2(TreeNode root) {
			if (root == null) return null;
			Queue <TreeNode> queue = new LinkedList<TreeNode>();
			queue.add(root);
			
			while(!queue.isEmpty()) {
				TreeNode current = queue.poll();
				TreeNode temp  = current.left;
				current.left = current.right;
				current.right = temp;
				
				if (current.left != null) queue.add(current.left);
				if (current.right != null) queue.add(current.right);
			}
			
			return root;
		}

	}
	
	
    public static void main(String[] args) {
       	TreeNode root = new TreeNode(4);
    	root.left = new TreeNode(2);
    	root.right = new TreeNode(7);
    	root.left.left = new TreeNode(1);
    	root.left.right = new TreeNode(3);
    	root.right.left = new TreeNode(6);
    	root.right.right = new TreeNode(9);
    	
    	printTree(root);
    	System.out.println();
    	TreeNode invertTree = Solution1.invertTree(root);

    	printTree(invertTree);
    	
    	System.out.println();
    	printTree(root);
    	
    	TreeNode invertTree2 = Solution1.invertTree2(root);

    	System.out.println();
    	printTree(invertTree2);

	}
}
