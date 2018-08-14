package Q2_05_Sum_Lists;

/**
 * Sum Lists: You have two numbers represented by a linked list, where each node contains a single digit.
 * The digits are stored in reverse order, such that the 1's digit is at hte head of the list.
 * Write a function that adds the two numbers and returns the sum as linked list.
 * 
 * Input (7 > 1 > 6 ) + (5 > 9 > 2). That is 617 + 295.
 * Output : 2 > 1 > 9 : 912.
 * 
 * Follow Up
 * 
 * Suppose the digits are stored in forward order. Repeat the above problem.
 * Input : (6 > 1 > 7 ) + (2 > 9 > 5). That is 617 + 295.
 * Output : 9 > 1 > 2. That's 912. 
 *
 */
import CtCILibrary.LinkedListNode;

public class QuestionA {

	private static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2, int carry) {
		if (l1 == null && l2 == null && carry == 0) {
             return null;
		}
		
		LinkedListNode result = new LinkedListNode();
		int value = carry;
		if (l1 != null) {
			value += l1.data;
		}
		if (l2 != null) {
			value += l2.data;
		}
		result.data = value % 10;
		if (l1 != null || l2 != null) {
			LinkedListNode more = addLists(l1 == null ? null : l1.next, 
										   l2 == null ? null : l2.next, 
										   value >= 10 ? 1 : 0);
			result.setNext(more);
		}
		return result;
	}
	
	public static int linkedListToInt(LinkedListNode node) {
		int value = 0;
		if (node.next != null) {
			value = 10 * linkedListToInt(node.next);
		}
		return value + node.data;
	}	
	
	public static void main(String[] args) {
		int[] vals = {7,1,6};
		LinkedListNode l1 = new LinkedListNode(vals[0], null, null);
		LinkedListNode current = l1;
		for (int i = 1; i < vals.length; i++) {
			current = new LinkedListNode(vals[i], null, current);
		}
		
		
		int[] vals2 = {5,9,2};
		LinkedListNode l2 = new LinkedListNode(vals2[0], null, null);
		current = l2;
		for (int i = 1; i < vals.length; i++) {
			current = new LinkedListNode(vals2[i], null, current);
		}
		
		
		LinkedListNode list3 = addLists(l1, l2, 0);
		
		System.out.println("  " + l1.printForward());		
		System.out.println("  " + l2.printForward());		
		System.out.println("= " + list3.printForward());	
	
		
	}
}
