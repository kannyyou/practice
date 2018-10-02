package com.changhun.z.bst;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:

Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.
Example:

Input: root = [4,2,5,1,3], target = 3.714286

    4
   / \
  2   5
 / \
1   3

Output: 4


LinkedIn

 * @author changhun
 *
 */
public class L270_ClosetBinarySearchTreeValue {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }


	}
	
	public static void printTree(TreeNode r) {
		if (r == null) return;
		System.out.print(r.val);
		
		printTree(r.left);
		printTree(r.right);

	}
	
	/**
	 * create two stack 
	 * smallStack : push value <= target
	 * bigStack : push value > target
	 * 
	 * inorder(root, target, false, smallStack) 
	 * inorder(root, target, large, bigStack)
	 * 
	 * for k numbers, find minimum differece number from each top of value.
	 * while (k--)
	 * 	 if smallStack is empty, add(bigStack.pop)
	 *   else if bigStack is empty, add(smallStack.pop)
	 *   else if (abs (smallStack.peek - target) < abs(bigStack.peek - target)), add(smallStack.pop)
	 *   else add(bigStack.pop)
	 * 
	 * @param root
	 * @param target
	 * @param k
	 * @return
	 */
	
	public static List<Integer> closestKValues(TreeNode root, double target, int k) {
		  List<Integer> res = new ArrayList<>();

		  Stack<Integer> smallStack = new Stack<>(); // predecessors
		  Stack<Integer> bigStack = new Stack<>(); // successors

		  inorder(root, target, false, smallStack);	//inorder
		  inorder(root, target, true, bigStack);	//reverse 
		  
		  while (k-- > 0) {
		    if (smallStack.isEmpty())
		      res.add(bigStack.pop());
		    else if (bigStack.isEmpty())
		      res.add(smallStack.pop());
		    else if (Math.abs(smallStack.peek() - target) < Math.abs(bigStack.peek() - target))
		      res.add(smallStack.pop());
		    else
		      res.add(bigStack.pop());
		  }
		  
		  return res;
		}
	
	// inorder traversal
	// if reverse, go to right, push(root), then go to left 
	public static void inorder(TreeNode root, double target, boolean reverse, Stack<Integer> stack) {
	  if (root == null) return;

	  inorder(reverse ? root.right : root.left, target, reverse, stack);
	  // early terminate, no need to traverse the whole tree
	  if ((reverse && root.val <= target) || (!reverse && root.val > target)) return;
	  // track the value of current node
	  stack.push(root.val);
	  System.out.println(reverse + " " + stack.toString() + " " + stack.peek());
	  inorder(reverse ? root.left : root.right, target, reverse, stack);
	}
	/**
	 * reverse (false) -> left -> left -> 1, 2, 3
	 * order (true) -> right -> root.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		
		
		System.out.println(closestKValues(root, 3.714286, 2));

	}
}
