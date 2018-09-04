package com.changhun.leetcode.for201to300;
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
public class L272_ClosetBinarySearchTreeValues2 {
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
	 * 
	 * tree node child = target value < root go to left otherwise right.
	 * if child is null return root
	 * 
	 * return Math.abs(root-target) < abs( child - target) ? root : child
	 * 
	 * @param root
	 * @param target
	 * @return
	 */
	public static int closestValue(TreeNode root, double target) {
	    int rootVal = root.val;
	    TreeNode child = target < rootVal ? root.left : root.right;
	    if (child == null) return rootVal;
	    int childVal = closestValue(child, target);
	    return Math.abs(rootVal - target) < Math.abs(childVal - target) ? rootVal : childVal;
	}
	
	/**
	 * closest = root.val
	 * while root is not null
	 * 	 if |closest - target| >= | root.val - target)
	 *       closest = root.val;
	 *   root = target.left or target.right by the comparison.
	 *   
	 * @param root
	 * @param target
	 * @return
	 */
	public static int closestValue2(TreeNode root, double target) {
	    int closest = root.val;
	    while (root != null) {
	    	if (Math.abs(closest - target) >= Math.abs(root.val - target)) 
	    		closest = root.val;
	    	root = target < root.val ? root.left : root.right;
	    		
	    }	    
	    return closest;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		
		
		System.out.println(closestValue(root, 3.714286));
		System.out.println(closestValue2(root, 3.714286));

	}
}
