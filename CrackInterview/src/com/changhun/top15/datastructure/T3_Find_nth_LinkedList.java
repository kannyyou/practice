package com.changhun.top15.datastructure;

public class T3_Find_nth_LinkedList {
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
		
		public void print() {
			Node current = head;

			while (current.next != null) {
				
				current = current.next;
				System.out.print(current.getData() + " -> ");

			}
			System.out.println("null");
		}
	}
	
	public static LinkedList removeNthFromEnd(LinkedList list, int n) {
		LinkedList listOut = new LinkedList();
		Node current = listOut.head;
		Node jump = listOut.head;
		
		current.next = list.head.next;

		for (int i=0; i< n; i++) {
			jump = jump.next;
			
			System.out.println("J " + jump.getData());
		}

		System.out.println(jump.getData());
		System.out.println(current.getData());

		while(jump.next != null) {
			current = current.next;
			jump = jump.next;

		}
		current.next = current.next.next;
		return listOut;
	}
		
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add(new Node("a"));
		list.add(new Node("b"));
		list.add(new Node("c"));
		list.add(new Node("d"));
		list.add(new Node("e"));

		list.print();
		
		LinkedList x = removeNthFromEnd(list, 3);
		x.print();
	}
	
}
