package com.changhun.dsbook.test;

import com.changhun.dsbook.LinkedBinaryTree;

public class BinaryTreeTest {
	public static void main(String[] args) {
		LinkedBinaryTree<Integer> lbt = new LinkedBinaryTree<Integer>();
		
		lbt.addRoot(3);
		//lbt.addRoot(3);

		System.out.println(lbt.toString());
		
	}
}
