package com.changhun.datastructure.list;

public interface Position<E> {
	/**
	 * Returns the element stored at this position
	 * 
	 * @returns the stored element
	 * @throws IllegalStateException if position no longer valid
	 */
	
	E getElement() throws IllegalStateException;
}
