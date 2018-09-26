package com.changhun.leetcode.for101to200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
Seen this

LinkedIn
Medium

 * @author changhun
 *
 */
public class L102_BTree_LeveOrder_Traversal {
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
		    while (!queue.isEmpty()) {
		    	int levelNum = queue.size();
	            List<Integer> subList = new LinkedList<Integer>();
	            
	            for (int i=0; i<levelNum; i++) {
	            	if (queue.peek().left != null) queue.offer(queue.peek().left);
	            	if (queue.peek().right != null) queue.offer(queue.peek().right);
	                subList.add(queue.poll().val);	//remove
	            }
	            wrapList.add(subList);
	            System.out.println(levelNum + " " + wrapList.toString());

		    }
		    return wrapList;
		}
	}
	
	/**
	 * DFS
	 * @author changhun
	 *
	 */
	
	public static class Solution {
		List<List<Integer>> lst=new ArrayList<List<Integer>>();
	    public List<List<Integer>> levelOrder(TreeNode root) {
	        travel(root,0);
	        return lst;
	    }

	    private void travel(TreeNode node,int level){    	
	    	if(node==null) return;
	    	addToList(node.val, level);
	    	travel(node.left,level+1);
	    	travel(node.right,level+1);
	    }

	    private void addToList(int val, int level){
	    	List<Integer> levelList;
	    	if ( level+1 > lst.size()){
	    	 	levelList=new LinkedList<Integer>();
	    	 	lst.add(levelList);	 	
	    	} else {
	    		levelList=lst.get(level);
	    	}
	    	levelList.add(val);   	
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
	
		Solution s = new Solution();
		out = s.levelOrder(n5);
		System.out.println(out.toString());
	}
}
