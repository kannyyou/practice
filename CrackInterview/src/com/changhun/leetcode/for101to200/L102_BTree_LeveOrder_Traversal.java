package com.changhun.leetcode.for101to200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
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
            System.out.println(levelNum + " " + queue.toString());

	    }
	    return wrapList;
	}
	
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
		
		
		List<List<Integer>> out = levelOrder(n5);
		
		System.out.println(out.toString());
	
		Solution s = new Solution();
		out = s.levelOrder(n5);
		System.out.println(out.toString());
	}
}
