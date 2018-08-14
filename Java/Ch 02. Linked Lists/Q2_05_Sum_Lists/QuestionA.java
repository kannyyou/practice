package Q2_05_Sum_Lists;


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
