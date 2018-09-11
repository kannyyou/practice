package com.changhun.leetcode.for101to200;


/**
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling 
 * (a left node that shares the same parent node) or empty, 
 * flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. 
 * Return the new root.

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
public class L156_BTree_UpsideDown {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public static class Solution1 {
		public static TreeNode upsideDownBinaryTree(TreeNode root) {
	    	System.out.println("call " + root.val);
	        if (root == null || root.left == null) {
	        	return root;
	        }
	        
	        TreeNode newRoot = upsideDownBinaryTree(root.left);
	        System.out.println(root.val);
	        System.out.println(root.right.val);

	        //Think root.left is root now but why ?
	        System.out.println("root.left " + root.left.val);

	        root.left.left = root.right;
	        root.left.right = root;
	        root.left = null;
	        root.right = null;
	        System.out.println("nr " + newRoot.val);
	        return newRoot;
	    }
	}
    
	public static class Solution2 {
		public static TreeNode upsideDownBinaryTree(TreeNode root) {
			if (root == null) {
				return root;
			}
			return upsideDownBinaryTree(root, root.left, root.right);
		}

		public static TreeNode upsideDownBinaryTree(TreeNode root , TreeNode rootLeft, TreeNode rootRight) {
		    if (rootLeft == null && rootRight == null) {
		        return root;
		    }
		    TreeNode newRoot = upsideDownBinaryTree(rootLeft , rootLeft.left, rootLeft.right);
		    rootLeft.left = rootRight;
		    rootLeft.right = root;
		    root.left = null;
		    root.right = null;
		    return newRoot;   
		}
	}
    
	public static class Solution3 {
		public static TreeNode upsideDownBinaryTree(TreeNode root) {
		    TreeNode curr = root;
		    TreeNode next = null;
		    TreeNode temp = null;
		    TreeNode prev = null;
		    
	        System.out.println(curr.val);

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
    
    public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right =  new TreeNode(5);
		
		TreeNode newRoot = Solution3.upsideDownBinaryTree(root);
		
		System.out.println(newRoot.val);
		System.out.println(newRoot.left.val);
		System.out.println(newRoot.right.val);
		System.out.println(newRoot.right.left.val);
		System.out.println(newRoot.right.right.val);

	}
  
}
