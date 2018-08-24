//package com.changhun.apple.leetcode;
//
//public class MedianBST {
//	public static int GetNodeCountBST(Node root)
//	{
//		if(root == null)
//		{
//			return 0;
//		}
//		Node currentNode = root;
//		return GetNodeCountBSTRec(currentNode);
//	}
//	private static int GetNodeCountBST(Node node)
//	{
//		if(node == null)
//		{
//			return 0;
//		}
//		return GetNodeCountBST(node.left) + 1 + GetNodeCountBST(node.right);
//	}
//	
//	public static double FindMedian(Node root, int nodeCount)
//	{
//		if(root == null || nodeCount <= 0)
//		{
//			return null;
//		}
//		Int median= 0;
//		Node currentNode = root;
//		FindMedianRec(currentNode, nodeCount, 0, out median);
//		return median;
//	}
//
//	private static int FindMedianRec(Node node, int totalCount, int nodeCount, out double median)
//	{
//		if(node == null)
//		{
//			return nodeCount;
//		}
//		
//		int leftNodeCount = FindMedianRec(node.left, totalCount, nodeCount, out median);
//		if(leftNodeCount == (TotalCount-1)/2)
//		{
//			median = node.data;
//		}
//		if(leftNodeCount == (TotalCount/2))
//		{
//			if(TotalCount % 2 == 0)
//			{
//				median = (median + (double)node.data)/2;
//			}
//		}
//		return FindMedianRec(node.right, totalCount, nodeCount + 1 + leftNodeCount, out median);
//	}
//}
