package com.changhun.z.tree;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
Serialization is the process of converting a data structure or object into a sequence of bits 
so that it can be stored in a file or memory buffer, or transmitted across a network connection link 
to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. 
There is no restriction on how your serialization/deserialization algorithm should work. 
You just need to ensure that a binary tree can be serialized to a string 
and this string can be deserialized to the original tree structure.

Example: 

You may serialize the following tree:

    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]"
Clarification: The above format is the same as how LeetCode serializes a binary tree. 
You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

Note: Do not use class member/global/static variables to store states. 
Your serialize and deserialize algorithms should be stateless.

LinkedIn
Intuit 
Hard
 * @author changhun
 *
 */
public class L297_Serialize_Deserialize_BTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	
	public static class Codec1 {
	    private static final String spliter = ",";
	    private static final String NN = "X";

	    // Encodes a tree to a single string.
	    public static String serialize(TreeNode root) {
	        StringBuilder sb = new StringBuilder();
	        buildString(root, sb);
	        return sb.toString();
	    }

	    private static void buildString(TreeNode node, StringBuilder sb) {
	        if (node == null) {
	            sb.append(NN).append(spliter);
	        } else {
	            System.out.println(node.val);

	            sb.append(node.val).append(spliter);
	            buildString(node.left, sb);
	            buildString(node.right,sb);
	        }
	    }
	    // Decodes your encoded data to tree.
	    public static TreeNode deserialize(String data) {
	        Deque<String> nodes = new LinkedList<>();
	        nodes.addAll(Arrays.asList(data.split(spliter)));
	        return buildTree(nodes);
	    }
	    
	    private static TreeNode buildTree(Deque<String> nodes) {
	        String val = nodes.remove();
	        if (val.equals(NN)) return null;
	        else {
	        	
	            System.out.println(val);

	            TreeNode node = new TreeNode(Integer.valueOf(val));
	            node.left = buildTree(nodes);
	            node.right = buildTree(nodes);
	            return node;
	        }
	    }
	}
	
	public static void main(String[] args) {
		TreeNode n = new TreeNode(1);
		n.left = new TreeNode(2);
		n.right = new TreeNode(3);
		n.left.left = new TreeNode(-4);
		n.left.right = new TreeNode(-5);
		
		n.right.left = new TreeNode(4);
		n.right.right = new TreeNode(5);
		
		String d = Codec1.serialize(n);
		System.out.println(d);
		TreeNode f = Codec1.deserialize(d);
		
		System.out.println(f.val);
		System.out.println(f.left.val);
		System.out.println(f.right.val);

		
	}
}
