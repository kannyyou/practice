package com.changhun.z.array;

import java.util.Arrays;
import java.util.List;

import com.changhun.z.array.E5_5_RemoveDuplicatesList.Solution1;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:

Input: 1->1->2
Output: 1->2
Example 2:

Input: 1->1->2->3->3
Output: 1->2->3


 * @author changhun
 *
 */
public class L83_RemoveDuplicatesFromSortedList {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
		
		 public String toString() {
			 if (next != null) {
				 return val + "->" + next.toString();
			 } else {
				 return ((Integer) val).toString();
			 }		
		 }
	}
	
	public static class Solution1 {
		public static ListNode deleteDuplicates(ListNode head) {
		    ListNode current = head;
		    while (current != null && current.next != null) {
		        if (current.next.val == current.val) {
		            current.next = current.next.next;
		        } else {
		            current = current.next;
		        }
		    }
		    return head;
		}
	}
	
	public static void main(String[] args) {
		
		ListNode nodes = new ListNode(1);
		nodes.next = new ListNode(1);
		nodes.next.next = new ListNode(2);
		
		System.out.println(Solution1.deleteDuplicates(nodes));
	}
}
