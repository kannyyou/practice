package Q4_04_Check_Balanced;

import CtCILibrary.AssortedMethods;
import CtCILibrary.TreeNode;

/**
 * Check Balanced : Implement a function to check if a binary tree is balanced.
 * For the purposes of this question, a balanced tree is defined to be a tree 
 * such that the heights of two subtrees of any node never differ by more than one.
 * 
 * @author changhun
 *
 */
public class QuestionBrute {
	
	public static int getHeight(TreeNode root) {
		if (root == null) {
			return -1;
		}
		System.out.println("* tree");
		root.print();
		System.out.println("** hight");
		System.out.println(Math.max(getHeight(root.left), getHeight(root.right)) + 1);
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}
		
	public static boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		int heightDiff = getHeight(root.left) - getHeight(root.right);
		if (Math.abs(heightDiff) > 1) {
			return false;
		}
		else {
			return isBalanced(root.left) && isBalanced(root.right);
		}
	}
	
	public static void main(String[] args) {
		// Create balanced tree
//		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] array = {1, 2, 3, 4, 5};

		TreeNode root = TreeNode.createMinimalBST(array);
		root.print();
		System.out.println("Root? " + root.data);
		System.out.println("Is balanced? " + isBalanced(root));
		
//		// Could be balanced, actually, but it's very unlikely...
//		TreeNode unbalanced = new TreeNode(10);
//		for (int i = 0; i < 10; i++) {
//			unbalanced.insertInOrder(AssortedMethods.randomIntInRange(0, 100));
//		}
//		unbalanced.print();
//
//		System.out.println("Root? " + unbalanced.data);
//		System.out.println("Is balanced? " + isBalanced(unbalanced));
	}

}
