package com.changhun.datastructure;

public class QueueTest {
	
	public static interface ChangQueue<E> {
		
		int size();
		
		boolean isEmpty();
		
		/** insert an element at the rear of the queue **/
		void enqueue(E e);
		
		/** return but not remove **/		
		E first();
		
		/** return and remove **/
		E dequeue();
	}
	
	public static class ArrayQueue<E> implements ChangQueue<E> {
		public static final int CAPACITY = 1000;
		private E[] data; 	//generic array used for storage;
		private int frontIndex = 0;	//index of the front element in queue
		private int sizeQueue = 0; 	//current number of element of the queue
		
		public ArrayQueue() {this(CAPACITY);}
		
		@SuppressWarnings("unchecked")
		public ArrayQueue(int capacity) {
			data = (E[]) new Object[capacity];
		}
		
		
		@Override
		public int size() {
			return sizeQueue;
		}

		@Override
		public boolean isEmpty() {
			return (sizeQueue == 0);
		}

		@Override
		public void enqueue(E e) {
			if (sizeQueue == data.length) throw new IllegalStateException("Queue is full");
			int avail = (frontIndex + sizeQueue) % data.length;
			data[avail] = e;
			sizeQueue ++;
		}

		@Override
		public E first() {
			if (isEmpty()) return null;
			return data[frontIndex];
		}

		@Override
		public E dequeue() {
			if (isEmpty()) return null;
			E answer = data[frontIndex];
			data[frontIndex] = null;
			frontIndex = (frontIndex + 1) % data.length;
			return answer;
		}
		
	}
	
	public static void main(String[] args) {
		
		ArrayQueue<String> arrayQueue = new ArrayQueue<String>();
		
		arrayQueue.enqueue("chang");
		arrayQueue.enqueue("saekyung");
		
		System.out.println(arrayQueue.first());
		
		System.out.println(arrayQueue.dequeue());
		System.out.println(arrayQueue.dequeue());
		
		arrayQueue.enqueue("woong");
		
		
	}
}
