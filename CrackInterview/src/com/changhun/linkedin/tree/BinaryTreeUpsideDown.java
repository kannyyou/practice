package com.changhun.linkedin.tree;

import com.changhun.linkedin.tree.BinaryTreeLevelOrderTraversal.TreeNode;

/**
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling 
 * (a left node that shares the same parent node) or empty, flip it upside down 
 * and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.

Example:

Input: [1,2,3,4,5]

    1
   / \
  2   3
 / \
4   5

Output: return the root of the binary tree [4,5,2,#,#,3,1]

   4
  / \
 5   2
    / \
   3   1  
Clarification:

Confused what [4,5,2,#,#,3,1] means? Read more below on how binary tree is serialized on OJ.

The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.

Here's an example:

   1
  / \
 2   3
    /
   4
    \
     5
The above binary tree is serialized as [1,2,3,#,#,4,#,#,5].

 * @author changhun
 *
 */
public class BinaryTreeUpsideDown {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
		}
	}
	
	public static class Solution1 {
		public static TreeNode updsideDownBinaryTree(TreeNode root) {
			if (root == null || root.left == null) return root;
			
			TreeNode newRoot = updsideDownBinaryTree(root.left);
			root.left.left = root.right;
			root.left.right = root;
			root.left = null;
			root.right = null;
			
			return newRoot;
		}
	}
	
	public static class Solution2 {
		public TreeNode upsideDownBinaryTree(TreeNode root) {
		    TreeNode curr = root;
		    TreeNode next = null;
		    TreeNode temp = null;
		    TreeNode prev = null;
		    
		    while(curr != null) {
		        next = curr.left;
		        
		        // swapping nodes now, need temp to keep the previous right child
		        curr.left = temp;
		        temp = curr.right;
		        curr.right = prev;
		        
		        prev = curr;
		        curr = next;
		    }
		    return prev;
		} 
	}

 
}
