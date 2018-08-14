package com.changhun.leetcode.for001to100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
Follow up: Recursive solution is trivial, could you do it iteratively?
 * @author changhun
 *
 */
public class L94_BTree_Inorder_Traversal {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
		}
	}
	
	
	public static List<Integer> inorderTraversal(TreeNode root) {
	    List<Integer> list = new ArrayList<Integer>();

	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    TreeNode cur = root;

	    while (cur != null | !stack.empty()) {
	    	while (cur != null) {
	    		stack.add(cur);
	    		cur = cur.left;
	    	}
	    	cur = stack.pop();
	    	list.add(cur.val);
	    	cur = cur.right;
	    }
	    
	    return list;
	}
	
	public class Solution1 {
	    public List < Integer > inorderTraversal(TreeNode root) {
	        List < Integer > res = new ArrayList < > ();
	        Stack < TreeNode > stack = new Stack < > ();
	        TreeNode curr = root;
	        while (curr != null || !stack.isEmpty()) {
	            while (curr != null) {
	                stack.push(curr);
	                curr = curr.left;
	            }
	            curr = stack.pop();
	            res.add(curr.val);
	            curr = curr.right;
	        }
	        return res;
	    }
	}
	
	public class Solution2 {
	    public List < Integer > inorderTraversal(TreeNode root) {
	        List < Integer > res = new ArrayList < > ();
	        Stack < TreeNode > stack = new Stack < > ();
	        TreeNode curr = root;
	        while (curr != null || !stack.isEmpty()) {
	            while (curr != null) {
	                stack.push(curr);
	                curr = curr.left;
	            }
	            curr = stack.pop();
	            res.add(curr.val);
	            curr = curr.right;
	        }
	        return res;
	    }
	}
	
	public static void main(String[] args) {
		
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);

		n5.left = n3;
		n5.right = n6;
		n3.left = n2;
		n3.right = n4;
		n2.left = n1;
		
		
		List<Integer> out = inorderTraversal(n5);
		
		System.out.println(out.toString());
		


	}
}
