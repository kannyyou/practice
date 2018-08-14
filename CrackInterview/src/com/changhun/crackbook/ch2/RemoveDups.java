package com.changhun.crackbook.ch2;

import java.util.HashSet;

/**
 * Write code to remove duplicates from an unsorted linked list
 * 
 * Follow up 
 * 
 * How would you solve this problem if a temporary buffer is not allowed.
 * 
 * @author changhun
 *
 */
public class RemoveDups {
	
	public static class LinkedListNode {
		LinkedListNode next = null;
		int data;
		
		public LinkedListNode(int d) {
			data = d;
		}
		
		void appendToTail(int d) {
			LinkedListNode end = new LinkedListNode(d);
			LinkedListNode n = this;
			while(n.next != null) {
				n = n.next;
			}
			n.next = end;
		}
		
		LinkedListNode deleteMNode(int d) {
			LinkedListNode n = this;
			
			if (n.data == d) {
				return n.next;
			}
			while(n.next != null) {
				if (n.next.data == d) {
					n.next = n.next.next;
					return n;
				}
				n = n.next;
			}
			return n;
		}
	}
	
	
	
	public static void deleteDups(LinkedListNode n) {
		HashSet<Integer> set = new HashSet<Integer>();
		LinkedListNode prev = null;
		
		while(n != null) {
			if (set.contains(n.data)) {
				prev.next = n.next;
		
			} else {
				set.add(n.data);
				prev = n;
			}
			n = n.next;
		}
		
	}
	
	public static void deleteDup2(LinkedListNode n) {
		LinkedListNode cur = n;
		while (cur != null) {
			LinkedListNode runner = cur;
			while (runner.next != null) {
				if (runner.next.data == cur.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
					
				}
			}
			cur = cur.next;
		}
	}
	
	
	public static void main(String[] args) {
		
	}
}
