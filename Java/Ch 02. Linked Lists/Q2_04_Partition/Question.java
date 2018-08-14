package Q2_04_Partition;

import CtCILibrary.LinkedListNode;

/**
 * Partition : Write code to partition a linkded list around a value x, such that all nodes less than x come
 * before all nodes greater than or equal to x. 
 * If x is contained within the list, the values of x only need to be after the elements less than x(see below).
 * The partition element x can appear anywhere in the right partition;
 * It does not need to appear between the left and right partitions.
 * 
 * Example
 * Input : 3 > 5 > 8 > 5 > 10 > 2 > 1 (partition =5)
 * Output : 3 > 1 > 2 > 5 > 5 > 8 > 10
 * 
 * @author changhun
 *
 */
public class Question {

	public static LinkedListNode partition(LinkedListNode node, int x) {
		LinkedListNode beforeStart = null;
		LinkedListNode beforeEnd = null;
		LinkedListNode afterStart = null;
		LinkedListNode afterEnd = null;
		
		/* Partition list */
		while (node != null) {
			LinkedListNode next = node.next;
			node.next = null;
			
			System.out.println(node.data);

			if (node.data < x) {
				if (beforeStart == null) {
					beforeStart = node;
					beforeEnd = beforeStart;
					
					System.out.println(" b " + beforeStart.printForward());
					System.out.println(" b " + beforeEnd.printForward());

				} else {
					beforeEnd.next = node;
					beforeEnd = node;
					
					System.out.println(" b " + beforeStart.printForward());
					System.out.println(" b " + beforeEnd.printForward());

				}
			} else {
				if (afterStart == null) {
					afterStart = node;
					afterEnd = afterStart;
					
					System.out.println(" a " + afterStart.printForward());
					System.out.println(" a " + afterEnd.printForward());

					
				} else {
					afterEnd.next = node;
					afterEnd = node;
					
					System.out.println(" a " + afterStart.printForward());
					System.out.println(" a " + afterEnd.printForward());

				}
			}	
			node = next;
		}
		
		/* Merge before list and after list */
		if (beforeStart == null) {
			return afterStart;
		}
		
		beforeEnd.next = afterStart;
		return beforeStart;
	}
	
	public static void main(String[] args) {
		/* Create linked list */
		int[] vals = {3,5,8,5,10,2,1};
		LinkedListNode head = new LinkedListNode(vals[0], null, null);
		LinkedListNode current = head;
		for (int i = 1; i < vals.length; i++) {
			current = new LinkedListNode(vals[i], null, current);
		}
		System.out.println(head.printForward());
		
		/* Partition */
		LinkedListNode h = partition(head, 5);
		
		/* Print Result */
		System.out.println(h.printForward());
	}

}
