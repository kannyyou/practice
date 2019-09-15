package com.changhun.linkedin.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.changhun.z.tree.L102_BTree_LeveOrder_Traversal.Solution;
import com.changhun.z.tree.L102_BTree_LeveOrder_Traversal.Solution1;
import com.changhun.z.tree.L102_BTree_LeveOrder_Traversal.TreeNode;

public class BinaryTreeLevelOrderTraversal {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
		}
	}
	
	public static class Solution1 {
		public static List<List<Integer>> levels = new ArrayList<List<Integer>>();
		
		public static List<List<Integer>> levelOrder(TreeNode node) {
			if (node == null) return levels;
			helper(node, 0);
			return levels;
		}
		
		public static void helper(TreeNode node, int level) {
			if (levels.size() == level) {
				levels.add(new ArrayList<Integer>());
			}
			
			levels.get(level).add(node.val);
			
			if (node.left != null) helper(node.left, level+1);
			if (node.right != null) helper(node.right, level+1);

		}				
		 
	}
	
	public static class Solution2 {
		public static List<List<Integer>> levelOrder(TreeNode node) {
			List<List<Integer>> levels = new ArrayList<List<Integer>>();
			if (node == null) return levels;
			
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.add(node);
			int level = 0;
			
			while(!queue.isEmpty()) {
				// start current level

				levels.add(new ArrayList<Integer>());
				
				// # of element into current level
				int levelSize = queue.size();
				
				for (int i = 0; i < levelSize; i++) {
					TreeNode curNode = queue.remove();
					
					levels.get(level).add(curNode.val);
					
					if (curNode.left != null) queue.add(curNode.left);
					if (curNode.right != null) queue.add(curNode.right);
				}
				level ++;
			}
			return levels;
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
	
		TreeNode root2 = n1;
		root2.left = n2;
		root2.right = n3;
		root2.right.left = n4;
		root2.right.right = n5;	

		List<List<Integer>> out2 = Solution2.levelOrder(root);

		System.out.println(out2.toString());

	}
}
