package com.changhun.z.list;
/**

Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.

LinkedIn 
Easy

CrackBook Q2_7
 * @author changhun
 *
 */
public class L160_IntersectionOfTwoLinkedLists {
	 public static class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) {
			 val = x;
		     next = null;
		 }
		 
		 public String toString() {
			 if (next != null) {
				 return val + "->" + next.toString();
			 } else {
				 return ((Integer) val).toString();
			 }		
		 }
	 }
	 
	 private static int length(ListNode node) {
		 int length = 0;
		 while (node != null) {
			 node = node.next;
			 length ++;
		 }
		 return length;
	 }

	 public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		 int lenA = length(headA);
		 int lenB = length(headB);

		 while (lenA > lenB) {
			 headA = headA.next;
			 lenA--;
		 }
		 
		 while (lenA < lenB) {
			 headB = headB.next;
			 lenB--;
		 }
		 
		 while (headA != headB) {
			 headA = headA.next;
			 headB = headB.next;
		 }
		 System.out.println(headA.val);
		 return headA;
	 }
	 
	 public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
		    //boundary check
		    if(headA == null || headB == null) return null;
		    
		    ListNode a = headA;
		    ListNode b = headB;
		    
		    //if a & b have different len, then we will stop the loop after second iteration
		    while( a != b){
		    	//for the end of first iteration, we just reset the pointer to the head of another linkedlist
		        a = a == null? headB : a.next;
		        b = b == null? headA : b.next;    
		    }
		    
		    return a;
		}
	 
	 /**
	  * A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
	  * @param args
	  */
	 public static void main(String[] args) {
		 ListNode headA = new ListNode(1);
		 ListNode headA2 = new ListNode(2);
		 
		 ListNode headC1 = new ListNode(3);
		 ListNode headC2 = new ListNode(4);
		 ListNode headC3 = new ListNode(5);

		 headA.next = headA2;
		 headA2.next = headC1;
		 headC1.next = headC2;
		 headC2.next = headC3;
		 System.out.println(headA.toString());
		 
		 ListNode headB = new ListNode(7);
		 ListNode headB2 = new ListNode(8);
		 ListNode headB3 = new ListNode(9);
		 
		 headB.next = headB2;
		 headB2.next = headB3;	 
		 headB3.next = headC1;
		 
		 System.out.println(headB.toString());

		 ListNode out = getIntersectionNode(headA, headB);
		 System.out.println(out.toString());
		 
		 ListNode out2 = getIntersectionNode2(headA, headB);
		 System.out.println(out2.toString());
	 }
}
