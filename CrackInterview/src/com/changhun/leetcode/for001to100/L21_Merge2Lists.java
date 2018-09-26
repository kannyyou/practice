package com.changhun.leetcode.for001to100;


/**
 *Merge two sorted linked lists and return it as a new list. 
 *The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4

pinterest
Intuit
easy


 * @author changhun
 *
 */
public class L21_Merge2Lists {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public static void print(ListNode node) {
		while (node != null) {
			System.out.print(node.val); 
			if (node.next != null)
				System.out.print(" -> ");
			node = node.next;
		}
		System.out.println();
	}
	
	/**
	 * Recursion
	 *
	 Time complexity : O(n + m)
Because each recursive call increments the pointer to l1 or l2 by one 
(approaching the dangling null at the end of each list), 
there will be exactly one call to mergeTwoLists per element in each list. 
Therefore, the time complexity is linear in the combined size of the lists.

Space complexity : O(n + m)

The first call to mergeTwoLists does not return until the ends of both l1 and l2 have been reached, 
so n + m stack frames consume O(n + m) space.


	 * @author changhun
	 *
	 */
	public static class Solution1 {
	    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	        if (l1 == null) {
	        	return l2;
	        
	        } else if (l2 == null) {
	        	return l1;
	        
	        } else if (l1.val < l2.val) {
	        	l1.next = mergeTwoLists(l1.next, l2);
	        	return l1;
	        	
	        } else {
	        	l2.next = mergeTwoLists(l1, l2.next);
	        	return l2;
	        	
	        }       	        
	    }
	}
	
	public static class Solution2 {
	    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	        // maintain an unchanging reference to node ahead of the return node.
	        ListNode prehead = new ListNode(-1);

	        ListNode prev = prehead;
	        while (l1 != null && l2 != null) {
	            if (l1.val <= l2.val) {
	                prev.next = l1;
	                l1 = l1.next;
	            } else {
	                prev.next = l2;
	                l2 = l2.next;
	            }
	            prev = prev.next;
	        }

	        // exactly one of l1 and l2 can be non-null at this point, so connect
	        // the non-null list to the end of the merged list.
	        prev.next = l1 == null ? l2 : l1;

	        return prehead.next;
	    }
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
						
//		print(Solution1.mergeTwoLists(l1, l2));
		print(Solution2.mergeTwoLists(l1, l2));

	}
}
