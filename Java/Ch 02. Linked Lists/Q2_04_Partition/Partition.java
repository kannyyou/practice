//package Q2_04_Partition;
//
//import CtCILibrary.LinkedListNode;
//
//public class Partition {
//	public static LinkedListNode partition(LinkedListNode node, int x) {
//		LinkedListNode beforeStart = null;
//		LinkedListNode beforeEnd = null;
//		LinkedListNode afterStart = null;
//		LinkedListNode afterEnd = null;
//		
//		while (node != null) {
//			LinkedListNode next = node.next;
//			node.next = null;
//			
//			if (node.data < x) {
//				if (beforeStart == null) {
//					//start
//					beforeStart = node;
//					beforeEnd = beforeStart; // null
//				} else {
//					beforeStart.next = node;
//					beforeEnd = node;
//				}
//
//			}
//		
//		}
//		 
//		
//	}
//
//}
