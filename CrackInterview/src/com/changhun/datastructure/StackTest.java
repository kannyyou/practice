package com.changhun.datastructure;

/**
 * Chap 6 Stack
 * @author changhun
 *
 */
public class StackTest {
	
	public static interface ChangStack<E> {
		
		int size();
		
		boolean isEmpty();
		
		void push(E e);
		
		/**
		 * return but does not remove the top element;
		 * @return
		 */
		E top();
		
		/**
		 * return and remove the top element
		 * @return
		 */
		E pop();
	}
	
	public static class ArrayStack<E> implements ChangStack<E> {
		public static final int CAPACITY = 1000;
		private E[] data; 	//generic array used for storage;
		private int t = -1;	//index of the top element in stack
		
		public ArrayStack() {this(CAPACITY);}
		
		@SuppressWarnings("unchecked")
		public ArrayStack(int capacity) {
			data = (E[]) new Object[capacity];
		}
		
		
		@Override
		public int size() {
			return (t+1);
		}

		@Override
		public boolean isEmpty() {			
			return (t == -1);
		}

		@Override
		public void push(E e) throws IllegalStateException {
			if (size() == data.length) throw new IllegalStateException("Stack is full");
			data[++t] = e;
		}

		@Override
		public E top() {
			if (isEmpty()) return null;
			return data[t];
		}

		@Override
		public E pop() {
			if (isEmpty()) return null;
			E answer = data[t];
			data[t] = null;
			t--;
			return answer;
		}
		
		public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.append("[");
			for (int i=0; i<=t; i++) {
				sb.append(data[i]);
				if (i != t) sb.append(",");
			}
			
			sb.append("]");
			return sb.toString();
		}
		
	}
	
	public static void main(String[] args) {
		ArrayStack<String> stack = new ArrayStack<String>();
		stack.push("chang");
		stack.push("woong");
		
		System.out.println(stack.toString());
		
		stack.pop();
		stack.push("zzz");
		
		System.out.println(stack.toString());
		
		
		
		
//		Stack<String> stack = new Stack<String>();
//		
//		stack.push("chang");
//		stack.push("woong");
//		
//		System.out.println(stack.toString());
//		
//		stack.pop();
//		stack.push("zzz");
//		
//		System.out.println(stack.toString());
		 


	}
}
