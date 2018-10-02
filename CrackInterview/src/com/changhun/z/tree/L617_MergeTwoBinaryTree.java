package com.changhun.z.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.changhun.z.tree.L104_MaxDepthOfBTree.TreeNode;
import com.changhun.z.tree.L226_Invert_Binary_Tree.Solution1;

/**
 * Given two binary trees and imagine that when you put one of them to cover the other, 
 * some nodes of the two trees are overlapped while the others are not.

You need to merge them into a new binary tree. The merge rule is that if two nodes overlap,
 then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.

Example 1:

Input: 
	Tree 1                     Tree 2                  
          1                         2                             
         / \                       / \                            
        3   2                     1   3                        
       /                           \   \                      
      5                             4   7                  
Output: 
Merged tree:
	     3
	    / \
	   4   5
	  / \   \ 
	 5   4   7
 

Note: The merging process must start from the root nodes of both trees.

 * @author changhun
 *
 */
public class L617_MergeTwoBinaryTree {
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
		public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
			if (t1 == null) return t2;
			if (t2 == null) return t1;
			
			TreeNode merged = new TreeNode(0); 
			merged.val = t1.val + t2.val;
			merged.left = mergeTrees(t1.left, t2.left);
			merged.right = mergeTrees(t1.right, t2.right);
			
			return merged;
		}
		
		public static TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
			if (t1 == null) return t2;
			
	        Stack < TreeNode[] > stack = new Stack < > ();
	        stack.push(new TreeNode[] {t1, t2});
	        
	        while (!stack.isEmpty()) {
	        	TreeNode[] nodes = stack.pop();
	        	if (nodes[0] == null || nodes[1] == null) continue;
	        	
				nodes[0].val += nodes[1].val;
               
				if (nodes[0].left == null) {
					nodes[0].left = nodes[1].left;
				} else {
					stack.push(new TreeNode[] {nodes[0].left, nodes[1].left});

				}
				if (nodes[0].right == null) {
					nodes[0].right = nodes[1].right;
				} else {
	                stack.push(new TreeNode[] {nodes[0].right, nodes[1].right});

				}
	        	
	        }
	        return t1;

		}

		
	}
	
	public static void main(String[] args) {
       	TreeNode root1 = new TreeNode(1);
    	root1.left = new TreeNode(3);
    	root1.right = new TreeNode(2);
    	root1.left.left = new TreeNode(5);

    	
       	TreeNode root2 = new TreeNode(2);
    	root2.left = new TreeNode(1);
    	root2.right = new TreeNode(3);
    	root2.left.right = new TreeNode(4);
    	root2.right.right = new TreeNode(7);

    	printTree(root1);
    	System.out.println();
    	printTree(root2);
    	System.out.println();

    	TreeNode m1 = Solution1.mergeTrees(root1, root2);
    	
    	printTree(m1);
    	System.out.println();

    	printTree(root1);
    	System.out.println();
    	printTree(root2);
    	System.out.println();
    	
    	TreeNode m2 = Solution1.mergeTrees2(root1, root2);
    	
    	printTree(m2);

	}
}
