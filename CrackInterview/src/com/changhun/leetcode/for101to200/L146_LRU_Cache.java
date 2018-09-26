package com.changhun.leetcode.for101to200;

import java.util.HashMap;

/**

Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. 
When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 ); // capacity  

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4


 * @author changhun
 *
 */
public class L146_LRU_Cache {
	public static class LinkedListNode {
		private LinkedListNode next;
		public int key;
		public String value;
		public LinkedListNode(int k, String v) {
			key = k;
			value = v;
		}
		
		public String printForward() {
			String data = "(" + key + "," + value + ")";
			if (next != null) {
				return data + "->" + next.printForward();
			} else {
				return data;
			}
		}
	}
	
	public static class LRUCache {
		private int maxCacheSize;
		private HashMap<Integer, LinkedListNode> map = new HashMap<Integer, LinkedListNode>();
		private LinkedListNode listHead = null;
		private LinkedListNode listTail = null;
		
		public LRUCache(int maxSize) {
			this.maxCacheSize = maxSize;
		}
		
		public String getValue(int key) {
			LinkedListNode node = map.get(key);
			if (node == null) return null;
			
			//move to head
			if (node != listHead) {
				removeFromLinkedList(node);
				insertAtFrontOfLinkedList(node);
			}
			return node.value;
		}
		
		private void removeFromLinkedList(LinkedListNode prev) {
			if (prev == null) return;
			
			if (prev.next == null) return;
			
			if (prev.next.next != null) {
				prev.next = prev.next.next;
			}
			
			if (prev.next == listTail) {
				listTail = prev;
			}
		}
		
		private void insertAtFrontOfLinkedList(LinkedListNode node) {
			if (listHead == null) {
				listHead = node;
				listTail = node;
			} else {
				node.next = listHead;
				listHead = node;
			}
		}

		private boolean removeKey(int key) {
			LinkedListNode node = map.get(key);
			removeFromLinkedList(node);
			map.remove(key);
			return true;
		}
		
		public void setKeyValue(int key, String value) {
			removeKey(key); 
			/* If full, remove least recently used item from cache. */
			if (map.size() >= maxCacheSize && listTail != null) {
				removeKey(listTail.key);
			}
			
			/* Insert new node. */
			LinkedListNode node = new LinkedListNode(key, value);
			insertAtFrontOfLinkedList(node);
			map.put(key, listHead);
		}
 
	}
}
