package com.changhun.datastructure;

public interface ChangList<E> {
	int size();
	
	boolean isEmpty();
	
	//return but not remove.
	E get(int i) throws IndexOutOfBoundsException;
	
	//Replace the element at index i with e, and return the replaced element;
	//E set(int i, E e) throws IndexOutOfBoundsException;

	//insert element e to be at index i, and shifting all subsequent elements later.
	void add(int i, E e) throws IndexOutOfBoundsException;
	
	void add(E e);
	
	//Remove/return the element at index i, shifting subsequent elements earlier
	E remove(int i) throws IndexOutOfBoundsException;
	
	
}
