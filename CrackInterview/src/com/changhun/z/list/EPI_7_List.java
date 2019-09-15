package com.changhun.z.list;

public class EPI_7_List {
	
	public static class ListNode<T> {
		public T data;
		public ListNode<T> next;		
		
		ListNode(T data) {
			this.data = data;
		}		
	}
	
	public static ListNode<Integer> searchList(ListNode<Integer> L, int key) {
		while (L != null && L.data != key) {
			L = L.next;
		}
		return L;
	}
	
	public static void insertAfter(ListNode<Integer> node, ListNode<Integer> newNode) {
		newNode.next = node.next;
		node.next = newNode;
	}
	
	public static void deleteList(ListNode<Integer> aNode) {
		if (aNode != null) 
			aNode.next = aNode.next.next;
	}
	
	public static void printList(ListNode<Integer> node) {
		while(node != null) {
			System.out.print(node.data);
			System.out.print(" -> ");
			node = node.next;
		}
		System.out.println("");
	}
	
	public static void main(String[] args) {
		ListNode<Integer> aList = new ListNode<Integer>(1);
		aList.next = null;
		
		printList(aList);
		
		insertAfter(aList, new ListNode<Integer>(3));
		
		printList(aList);

		
	}

}
