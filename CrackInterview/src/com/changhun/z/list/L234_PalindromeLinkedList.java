package com.changhun.z.list;

import com.changhun.z.list.L2_AddTwoNumsInList.ListNode;

/**
 * Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?

 * @author changhun
 *
 */
public class L234_PalindromeLinkedList {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	 
	public static class Solution1 {
		public static boolean isPalindrome(ListNode head) {
		    ListNode fast = head;
		    ListNode slow = head;

		    while(fast != null && fast.next != null) {
		        fast = fast.next.next;
		        slow = slow.next;
		    }
		    if(fast != null) slow = slow.next;
		    
		    slow = reverse(slow);
		    while(slow != null && head.val == slow.val) {
		        head = head.next;
		        slow = slow.next;
		    }
		    return slow == null;
		}

		private static ListNode reverse(ListNode head) {
		    ListNode prev = null;
		    while(head != null) {
		        ListNode next = head.next;
		        head.next = prev;
		        prev = head;
		        head = next;
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

	}
	
	 public static void main(String[] args) {
		 ListNode headA = new ListNode(1);
		 ListNode headA2 = new ListNode(2);
		 ListNode headA3 = new ListNode(2);
		 ListNode headA4 = new ListNode(1);
		 
		 headA.next = headA2;
		 headA2.next = headA3;
		 headA3.next = headA4;
		 headA4.next = null;
		 		 
		 ListNode headB = new ListNode(1);
		 ListNode headB2 = new ListNode(2);
		 
		 headB.next = headB2;
		 
		 Solution1.print(headA);
		 Solution1.print(headB);
	 }
}
