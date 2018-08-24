package Q16_25_LRU_Cache;

import java.util.HashMap;

/**
 * LRU Cache:
 * Design and build a "least recentlh used" cache, which evicts the least recently used item.
 * The cache should map from keys to values (allowing you to insert and retrieve a value 
 * associated with a particular key) and be initilizaed with a max size.
 * When it is full, it should evict the least recently used item. 
 * You can assume the key are integers and the values are strings.
 * 
 * @author changhun
 *
 */
public class CacheSingle {			
	private int maxCacheSize;
	private HashMap<Integer, LinkedListNode> map = new HashMap<Integer, LinkedListNode>();
	private LinkedListNode listHead = null;
	public LinkedListNode listTail = null;
	
	
	public CacheSingle(int maxSize) {
		maxCacheSize = maxSize;
	}
	
	/* Get value for key and mark as most recently used. */
	public String getValue(int key) {
		LinkedListNode item = map.get(key);
		if (item == null) {
			return null;
		}
		
		/* Move to front of list to mark as most recently used. */
		if (item != listHead) { 
			removeFromLinkedList(item);
			insertAtFrontOfLinkedList(item);
		}
		return item.value;
	}
	
	/* Remove node from linked list. */
	/** our ndoe is prev.next*/
	private void removeFromLinkedList(LinkedListNode prev) {
		if (prev == null) {
			return;
		}
		if (prev.next == null) {
			return;
		}
		if (prev.next.next != null) {
			prev.next = prev.next.next;
		}
		if (prev.next == listTail) {
			listTail = prev;
		}
	}
	
	/* Insert node at front of linked list. */
	private void insertAtFrontOfLinkedList(LinkedListNode node) {
		if (listHead == null) {
			listHead = node;
			listTail = node;
		} else {
			node.next = listHead;
			listHead = node;
		}
	}
	
	/* Remove key, value pair from cache, deleting from hash table
	 * and linked list. */
	public boolean removeKey(int key) {
		LinkedListNode node = map.get(key);
		removeFromLinkedList(node);
		map.remove(key);
		return true;
	}
	
	/* Put key, value pair in cache. Removes old value for key if
	 * necessary. Inserts pair into linked list and hash table.*/
	public void setKeyValue(int key, String value) {
		/* Remove if already there. */
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
	
	public String getCacheAsString() {
		if (listHead == null) return "";
		return listHead.printForward();
	}
	
	private class LinkedListNode {
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
}
