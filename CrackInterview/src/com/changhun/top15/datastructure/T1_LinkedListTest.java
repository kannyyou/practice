package com.changhun.top15.datastructure;

public class T1_LinkedListTest {
	public static class Node {
		private Node next;
		private String data;
		
		public Node(String data) {
			this.data  = data;
		}
		
		public String getData() {
			return data;
		}
		
		public void setData(String data) {
			this.data = data;
		}
		
		public Node getNext() {
			return next;
		}
		
		public void setNext(Node next) {
			this.next = next;
		}
		
		public String toString() {
			return this.data;
		}
	}
	
	public static class LinkedList {
		private Node head;
		private Node tail;
		
		public LinkedList() {
			this.head = new Node("head");
			tail = head;
		}
		
		public Node head() {
			return head;
		}
		
		public void add(Node node) {
			tail.next = node;
			tail = node;
		}
	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add(new Node("a"));
		list.add(new Node("b"));
		list.add(new Node("c"));
		list.add(new Node("d"));
		list.add(new Node("e"));

		Node current = list.head;
		int length = 0;
		Node middle = list.head;
		
		while(current.getNext() != null) {
			length ++;
			
			if (length % 2 == 1) {
				middle = middle.getNext();
			}
			
			current = current.getNext();
		}	
			
		System.out.println("Length of list " + length);
		System.out.println("middle of list " + middle);

	}
	
}
