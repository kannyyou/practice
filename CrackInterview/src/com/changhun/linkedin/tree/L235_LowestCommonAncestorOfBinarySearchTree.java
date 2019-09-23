package com.changhun.linkedin.tree;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: 
“The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants 
(where we allow a node to be a descendant of itself).”

Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]

Example 1:

Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.
Example 2:

Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 

Note:

All of the nodes' values will be unique.
p and q are different and both values will exist in the BST.
 * @author changhun
 *
 */
public class L235_LowestCommonAncestorOfBinarySearchTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	
	/**
	 * Algorithm

Start traversing the tree from the root node.
If both the nodes p and q are in the right subtree, then continue the search with right subtree starting step 1.
If both the nodes p and q are in the left subtree, then continue the search with left subtree starting step 1.
If both step 2 and step 3 are not true, this means we have found the node which is common to node p's and q's subtrees. 
and hence we return this common node as the LCA.

	 * @author changhun
	 *
	 */
	public static class Solution1 {
		public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
			// Value of current node or parent node
			int parentVal = root.val;
			
			// Value of p
			int pVal = p.val;
			
			// Value of q
			int qVal = q.val;
			
			if (pVal > parentVal && qVal > parentVal) {
				//If both p and q are greater than parent
				return lowestCommonAncestor(root.right, p, q);
			
			} else if (pVal < parentVal && qVal < parentVal) {
	            // If both p and q are lesser than parent
	            return lowestCommonAncestor(root.left, p, q);
	        
			} else {
	            // We have found the split point, i.e. the LCA node.
	            return root;
	        }
			
		}
	}
	
	public static class Solution2 {
		public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	
			// Value of p
			int pVal = p.val;
			
			// Value of q
			int qVal = q.val;
			
	        // Start from the root node of the tree
	        TreeNode node = root;

	        // Traverse the tree
			while (node != null) {
				// Value of ancetor/parent node
				int parentVal = node.val;
				
				if (pVal > parentVal && qVal > parentVal) {
					//If both p and q are greater than parent
					node = node.right;
				
				} else if (pVal < parentVal && qVal < parentVal) {
		            // If both p and q are lesser than parent
					node = node.left;
					
				} else {
		            // We have found the split point, i.e. the LCA node.
		            return node;
		        }				
			}	
			return null;
		}
	}
	
	public static void main(String[] args) {
		TreeNode r = new TreeNode(6);
		r.left = new TreeNode(2);
		r.right = new TreeNode(8);
		
		r.left.left = new TreeNode(0);
		r.left.right = new TreeNode(4);
		r.left.right.left = new TreeNode(3);
		r.left.right.right = new TreeNode(5);
		
		r.right.left = new TreeNode(7);
		r.right.right = new TreeNode(9);
		

//		Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8

		System.out.println(Solution1.lowestCommonAncestor(r, new TreeNode(2), new TreeNode(8)).val);
		System.out.println(Solution2.lowestCommonAncestor(r, new TreeNode(2), new TreeNode(8)).val);

		System.out.println(Solution1.lowestCommonAncestor(r, new TreeNode(2), new TreeNode(4)).val);
		System.out.println(Solution2.lowestCommonAncestor(r, new TreeNode(2), new TreeNode(4)).val);
		
	}
}
