package Q2_04_Partition;

import CtCILibrary.LinkedListNode;

public class QuestionB {

	public static LinkedListNode partition(LinkedListNode node, int x) {
		LinkedListNode beforeStart = null;
		LinkedListNode afterStart = null;
		
		/* Partition list */
		while (node != null) {
			LinkedListNode next = node.next;
			if (node.data < x) {
				/* Insert node into start of before list */
				node.next = beforeStart;
				beforeStart = node;	
			} else {
				/* Insert node into front of after list */
				node.next = afterStart;
				afterStart = node;
			}	
			node = next;
		}
		
		/* Merge before list and after list */
		if (beforeStart == null) {
			return afterStart;
		}
		
		LinkedListNode head = beforeStart;
		while (beforeStart.next != null) {
			beforeStart = beforeStart.next;
		}
		beforeStart.next = afterStart;
		return head;
	}
	
	public static void main(String[] args) {
		int[] vals = {3,5,8,5,10,2,1};
		LinkedListNode head = new LinkedListNode(vals[0], null, null);
		LinkedListNode current = head;
		for (int i = 1; i < vals.length; i++) {
			current = new LinkedListNode(vals[i], null, current);
		}
		System.out.println(head.printForward());
		
		System.out.println(head.printForward());
		
		LinkedListNode h = partition(head, 5);
		System.out.println(h.printForward());
	}

}
