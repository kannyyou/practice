package com.changhun.top15.datastructure;

public class T2_Find_Loop_LinkedList {
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
	
	public static boolean isLoop(LinkedList list) {
		Node current = list.head;
		Node jump = list.head;
		
		while (current != null && jump != null && jump.next != null) {
			current = current.next;
			jump = jump.next.next;
			
			System.out.println(current.getData() + " " + jump.getData());
			if (current == jump) {
				System.out.println("Found loop");
				return true;
			}
		}
		return false;
	}
		
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add(new Node("a"));
		list.add(new Node("b"));
		list.add(new Node("c"));
		list.add(new Node("d"));
		list.add(new Node("e"));

        list.head.next.next.next.next.next = list.head;

		System.out.println(isLoop(list));

	}
	
}
