package com.changhun.z.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. 
 * (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]


Pinterest
Medium

 * @author changhun
 *
 */
public class L103_BTree_LeveOrder_Traversal_Zigzag {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
		}
	}
	
	/**
	 * BFS
https://leetcode.com/problems/binary-tree-level-order-traversal/discuss/33450/Java-solution-with-a-queue-used
	 * @author changhun
	 *
	 */
	public static class Solution1 {
	    public static List<List<Integer>> levelOrder(TreeNode root) {
	        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
		    Queue<TreeNode> queue = new LinkedList<TreeNode>();

		    if (root == null) return wrapList;
		    
		    queue.offer(root);   
		    boolean order = true;	// rever or not

		    while (!queue.isEmpty()) {
		    	int levelNum = queue.size();
	            List<Integer> subList = new LinkedList<Integer>();
	            
	            for (int i=0; i<levelNum; i++) {

	            	if (queue.peek().left != null) queue.offer(queue.peek().left);
	            	if (queue.peek().right != null) queue.offer(queue.peek().right);
	            	
	            	if (order) {
		                subList.add(queue.poll().val);	//remove

	            	} else {
		                subList.add(0, queue.poll().val);	//remove

	            	}
	            	
	            }
	            wrapList.add(subList);
	            order = order ? false : true;	//change order

//	            System.out.println(levelNum + " " + wrapList.toString());

		    }
		    return wrapList;
		}
	}
	
	public static void main(String[] args) {
		
		TreeNode n1 = new TreeNode(3);
		TreeNode n2 = new TreeNode(9);
		TreeNode n3 = new TreeNode(20);
		TreeNode n4 = new TreeNode(15);
		TreeNode n5 = new TreeNode(7);

		TreeNode root = n1;
		root.left = n2;
		root.right = n3;
		root.right.left = n4;
		root.right.right = n5;
		
		List<List<Integer>> out = Solution1.levelOrder(root);
		
		System.out.println(out.toString());
	
//		Solution s = new Solution();
//		out = s.levelOrder(n5);
//		System.out.println(out.toString());
	}
}
