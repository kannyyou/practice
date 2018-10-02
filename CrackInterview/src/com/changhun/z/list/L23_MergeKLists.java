package com.changhun.z.list;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6

Hard

pinterest


 * @author changhun
 *
 */
public class L23_MergeKLists {
	
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
	
	public static class ListNodeComparator implements Comparator<ListNode> {
		@Override
		public int compare(ListNode o1, ListNode o2) {
          if (o1.val<o2.val)
        	  return -1;
          else if (o1.val==o2.val)
        	  return 0;
          else 
        	  return 1;
		}		
	}
	
	public static class Solution {
	    public static ListNode mergeKLists(List<ListNode> lists) {
	        if (lists==null || lists.size()==0) return null;
	        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.size(), new ListNodeComparator());
	        
	        ListNode dummy = new ListNode(0);
	        ListNode tail=dummy;
	        
	        for (ListNode node:lists)
	            if (node!=null)
	                queue.add(node);
	        
	        while (!queue.isEmpty()) {
	            tail.next=queue.poll();
	            tail=tail.next;
	            
	            if (tail.next!=null)
	                queue.add(tail.next);
	        }
	        return dummy.next;
	    }

	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(5);
		
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		
		ListNode l3 = new ListNode(2);
		l3.next = new ListNode(6);
		
		List<ListNode> list = new ArrayList<ListNode>();
		list.add(l1);
		list.add(l2);
		list.add(l3);
						
//		print(Solution1.mergeTwoLists(l1, l2));
		print(Solution.mergeKLists(list));

	}
}
