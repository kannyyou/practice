package Q3_03_Stack_of_Plates;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class SetOfStacks {
	ArrayList<Stack> stacks = new ArrayList<Stack>();
	public int capacity;
	
	public SetOfStacks(int capacity) { 
		this.capacity = capacity; 
	}
	
	private Stack getLastStack() {
		if (stacks.size() == 0) {
			return null;
		}
		System.out.println("\tReturn stack " + (stacks.size() -1));
		return stacks.get(stacks.size() - 1);
	}
	
	public void push(int v) {
		Stack last = getLastStack();
		if (last != null && !last.isFull()) { // add to last
			last.push(v);
		} else { // must create new stack
			Stack stack = new Stack(capacity);
			stack.push(v);
			stacks.add(stack);
		}
	}
	
	public int pop() {
		Stack last = getLastStack();
		if (last == null) throw new EmptyStackException();
		int v = last.pop();
		if (last.size == 0) {
			stacks.remove(stacks.size() - 1);
		}
		return v;
	}
	
	public int popAt(int index) {
		System.out.println("\tPop from " + index);
		return leftShift(index, true);
	}
	
	public int leftShift(int index, boolean removeTop) {
		Stack stack = stacks.get(index);
		int removed_item;
		if (removeTop) removed_item = stack.pop();
		else removed_item = stack.removeBottom();
		if (stack.isEmpty()) {
			stacks.remove(index);
		} else if (stacks.size() > index + 1) {
			int v = leftShift(index + 1, false);
			stack.push(v);
		}
		return removed_item;
	}
	
	public boolean isEmpty() {
		Stack last = getLastStack();
		return last == null || last.isEmpty();
	}
	
	public static void main(String[] args) {
		int capacity_per_substack = 5;
		SetOfStacks set = new SetOfStacks(capacity_per_substack);
		for (int i = 0; i < 34; i++) {
			set.push(i);
			System.out.println(set.stacks.size());
		}
		
		System.out.println("Popped at " + set.popAt(0));
		System.out.println("Popped at " + set.popAt(0));
		System.out.println("Popped at " + set.popAt(0));
		System.out.println("Popped at " + set.popAt(0));
		System.out.println("Popped at " + set.popAt(0));

		for (int i = 0; i < 35; i++) {
			System.out.println("Popped " + set.pop());
			System.out.println(set.stacks.size());

		}		
	}
}
