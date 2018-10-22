package com.changhun.z.array;

import java.util.Arrays;
import java.util.List;

import com.changhun.z.array.E5_5_RemoveDuplicatesList.Solution1;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Example 1:

Input: 1->2->3->3->4->4->5
Output: 1->2->5
Example 2:

Input: 1->1->1->2->3
Output: 2->3

 * @author changhun
 *
 */
public class L83_RemoveDuplicatesFromSortedList2 {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public static class Solution1 {
		public static ListNode deleteDuplicates(ListNode head) {
			//use two pointers, slow - track the node before the dup nodes, 
			// fast - to find the last node of dups.
		    ListNode dummy = new ListNode(0), fast = head, slow = dummy;
		    slow.next = fast;
		    while(fast != null) {
		    	while (fast.next != null && fast.val == fast.next.val) {
		     		fast = fast.next;    //while loop to find the last node of the dups.
		    	}
		    	if (slow.next != fast) { //duplicates detected.
		    		slow.next = fast.next; //remove the dups.
		    		fast = slow.next;     //reposition the fast pointer.
		    	} else { //no dup, move down both pointer.
		    		slow = slow.next;
		    		fast = fast.next;
		    	}
		    	
		    }
		    return dummy.next;
		} 
	}
	
	public static void main(String[] args) {
		
		ListNode nodes = new ListNode(1);
		nodes.next = new ListNode(1);
		nodes.next.next = new ListNode(2);
		
		System.out.println(Solution1.deleteDuplicates(nodes));
	}
}
