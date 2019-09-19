package com.changhun.linkedin.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.

LinkedIn 
Easy

 * @author changhun
 *
 */
public class L104_MaximumDepthOfBinaryTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
		public String toString() {
			return val + " ";
		}
	}
	
	/**
	 * worst O(V+E)
	 * but possibly O(H) < O(V)
	 * @param root
	 * @return
	 */
    public static int maxDepth(TreeNode root) {
        if (root==null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
    
    public static int maxDepth2(TreeNode root) {
        if (null == root) {
            return 0;
        } else {
            int i = maxDepth(root.left);
            int j = maxDepth(root.right);
            return (i < j) ? j + 1 : i + 1;
        }
    }
    
    
    /**
     * Approach 3: Iteration
Intuition

We could also convert the above recursion into iteration, with the help of the stack data structure. 
Similar with the behaviors of the function call stack, the stack data structure follows 
the pattern of FILO (First-In-Last-Out), i.e. the last element that is added to a stack would come out first.

With the help of the stack data structure, 
one could mimic the behaviors of function call stack that is involved in the recursion, 
to convert a recursive function to a function with iteration.

Algorithm

The idea is to keep the next nodes to visit in a stack. Due to the FILO behavior of stack, 
one would get the order of visit same as the one in recursion.

We start from a stack which contains the root node and the corresponding depth which is 1. 
Then we proceed to the iterations: pop the current node out of the stack and push the child nodes. 
The depth is updated at each step.

     * @param root
     * @return
     */
    public static int maxDepth3(TreeNode root) {
    	if (root == null)
    		return 0;
    	
    	Deque<TreeNode> stack = new LinkedList<TreeNode>();
    	
    	stack.push(root);
    	int count = 0;
    	
    	while (!stack.isEmpty()) {
    		int size = stack.size();
    		while (size-- > 0) {
    			TreeNode cur = stack.pop();
    			System.out.println(cur.toString());
    			if (cur.left != null)
    				stack.addLast(cur.left);
    			if (cur.right != null)
    				stack.addLast(cur.right);
    		}
    		count++;

    	}
    	return count;

    }
    
    public static void main(String[] args) {
       	TreeNode root = new TreeNode(3);
    	root.left = new TreeNode(9);
    	root.right = new TreeNode(20);
    	root.right.left = new TreeNode(15);
    	root.right.right = new TreeNode(7);
    	
    	System.out.println(maxDepth(root));
    	System.out.println(maxDepth2(root));
    	System.out.println(maxDepth3(root));

	}
}
