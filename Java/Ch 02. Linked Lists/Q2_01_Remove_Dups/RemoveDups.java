package Q2_01_Remove_Dups;
import java.util.HashSet;
import CtCILibrary.LinkedListNode;

/**
 * Remove Dups: Write code to remove duplicates from an unsorted linked list
 * 
 * Follow uo
 * How would you solve this problem, if a temporary buffer is not allowed ?
 * @author changhun
 *
 */
public class RemoveDups {
	public static void deleteDupsWithSpace(LinkedListNode n) {
		HashSet<Integer> set = new HashSet<Integer>();
		LinkedListNode previous = null;
		while (n != null) {
			if (set.contains(n.data)) {
				previous.next = n.next;
			} else {
				set.add(n.data);
				previous = n;
			}
			n = n.next;
		}
	}
	
	public static void deleteDupsWithoutSpace(LinkedListNode head) {
		LinkedListNode current = head;
		while (current != null) {
			/* Remove all future nodes that have the same value */
			LinkedListNode runner = current;
			while (runner.next != null) { 
				if (runner.next.data == current.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		}
	}	
	
	public static void deleteDups(LinkedListNode head) {
		if (head == null) return;
		LinkedListNode previous = head;
		LinkedListNode current = previous.next;
		while (current != null) {
			// Look backwards for dups, and remove any that you see.
			LinkedListNode runner = head;
			while (runner != current) { 
				if (runner.data == current.data) {
					LinkedListNode tmp = current.next;
					previous.next = tmp;
					current = tmp;
					/* We know we can't have more than one dup preceding
					 * our element since it would have been removed 
					 * earlier. */
				    break;
				}
				runner = runner.next;
			}
			
			/* If runner == current, then we didn't find any duplicate 
			 * elements in the previous for loop.  We then need to 
			 * increment current.  
			 * If runner != current, then we must have hit the �break� 
			 * condition, in which case we found a dup and current has
			 * already been incremented.*/
			if (runner == current) {
				previous = current;
		        current = current.next;
			}
		}
	}
	
	public static void main(String[] args) {	
		LinkedListNode first = new LinkedListNode(0, null, null); 
		//AssortedMethods.randomLinkedList(1000, 0, 2);
		LinkedListNode head = first;
		LinkedListNode second = first;
		for (int i = 1; i < 8; i++) {
			second = new LinkedListNode(i % 3, null, null);
			first.setNext(second);
			second.setPrevious(first);
			first = second;
		}
		System.out.println(head.printForward());
		deleteDupsWithSpace(head);
		System.out.println(head.printForward());
		
		head = first;
		second = first;
		for (int i = 1; i < 8; i++) {
			second = new LinkedListNode(i % 3, null, null);
			first.setNext(second);
			second.setPrevious(first);
			first = second;
		}
		
		System.out.println("\n\n******************\n\n");
		System.out.println(head.printForward());
		deleteDupsWithoutSpace(head);
		System.out.println(head.printForward());
		
		head = first;
		second = first;
		for (int i = 1; i < 8; i++) {
			second = new LinkedListNode(i % 3, null, null);
			first.setNext(second);
			second.setPrevious(first);
			first = second;
		}
		
		System.out.println("\n\n******************\n\n");
		System.out.println(head.printForward());
		deleteDups(head);
		System.out.println(head.printForward());
	}
}
