package com.changhun.z.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.


LinkedIn
Easy


 * @author changhun
 *
 */
public class L101_SymmetricTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	/**
	 * 
Approach 1: Recursive


A tree is symmetric if the left subtree is a mirror reflection of the right subtree.

Push an element in stack

Therefore, the question is: when are two trees a mirror reflection of each other?

Two trees are a mirror reflection of each other if:

Their two roots have the same value.
The right subtree of each tree is a mirror reflection of the left subtree of the other tree.
Push an element in stack

This is like a person looking at a mirror. The reflection in the mirror has the same head, 
but the reflection's right arm corresponds to the actual person's left arm, and vice versa.

The explanation above translates naturally to a recursive function as follows.

Time complexity : O(n). Because we traverse the entire input tree once, 
the total run time is O(n), where nn is the total number of nodes in the tree.

Space complexity : The number of recursive calls is bound by the height of the tree. 
In the worst case, the tree is linear and the height is in O(n). 
Therefore, space complexity due to recursive calls on the stack is O(n) in the worst case. 

	 * @author changhun
	 *
	 */
	public static class Solution1 {
		public static boolean isSymmetric(TreeNode root) {
		    return isMirror(root, root);
		}

		public static boolean isMirror(TreeNode t1, TreeNode t2) {
		    if (t1 == null && t2 == null) return true;
		    if (t1 == null || t2 == null) return false;
		    return (t1.val == t2.val)
		        && isMirror(t1.right, t2.left)
		        && isMirror(t1.left, t2.right);
		}
	}
	
	/**
Approach 2: Iterative
Instead of recursion, we can also use iteration with the aid of a queue. 
Each two consecutive nodes in the queue should be equal, and their subtrees a mirror of each other. 
Initially, the queue contains root and root. Then the algorithm works similarly to BFS, with some key differences. 
Each time, two nodes are extracted and their values compared. 
Then, the right and left children of the two nodes are inserted in the queue in opposite order. 
The algorithm is done when either the queue is empty, or we detect that the tree is not symmetric 
(i.e. we pull out two consecutive nodes from the queue that are unequal).

Time complexity : O(n). Because we traverse the entire input tree once, 
the total run time is O(n), where nn is the total number of nodes in the tree.

Space complexity : There is additional space required for the search queue. 
In the worst case, we have to insert O(n) nodes in the queue. Therefore, space complexity is O(n).


	 * @param root
	 * @return
	 */
	public static boolean isSymmetric(TreeNode root) {
	    Queue<TreeNode> q = new LinkedList<>();
	    q.add(root);
	    q.add(root);
	    while (!q.isEmpty()) {
	        TreeNode t1 = q.poll();
	        TreeNode t2 = q.poll();
	        if (t1 == null && t2 == null) continue;
	        if (t1 == null || t2 == null) return false;
	        if (t1.val != t2.val) return false;
	        q.add(t1.left);
	        q.add(t2.right);
	        q.add(t1.right);
	        q.add(t2.left);
	    }
	    return true;
	}
	 
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
			
		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(2);
		root2.right = new TreeNode(2);
		root2.left.right = new TreeNode(3);
		root2.right.right = new TreeNode(3);
		
		System.out.println(Solution1.isSymmetric(root));
		System.out.println(isSymmetric(root));
		
		System.out.println(Solution1.isSymmetric(root2));
		System.out.println(isSymmetric(root2));

	}
}
