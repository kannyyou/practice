package com.changhun.leetcode.for201to300;

/**
 * Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?

Intuit
easy

 * @author changhun
 *
 */
public class L206_ReverseLinkedList {
	/**
	 * Definition for singly-linked list.
	 */
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { 
			val = x; 
		}
	}
	 
	public static ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		
		while (curr != null) {
			ListNode nextTemp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextTemp;
		}
		return prev;
	}

	public static void print(ListNode node) {
		while (node != null) {
			System.out.print(node.val + " -> ");
			node = node.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		l1.next = l2;
		l2.next = l3;
		
		print(l1);
		
		ListNode rev = reverseList(l1);
		
		print(rev);
	}
}
