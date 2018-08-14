package com.changhun.datastructure.tree;

import java.util.Iterator;

import com.changhun.datastructure.list.Position;

public interface Tree<E> extends Iterable<E> {
	
	/**
	 * returns the position of the root of the tree.
	 * null if empty
	 * @return
	 */
	Position<E> root();
	Position<E> parent(Position<E> p) throws IllegalArgumentException;
	Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException;
	
	int numChildren(Position<E> p) throws IllegalArgumentException;
	boolean isInternal(Position<E> p) throws IllegalArgumentException;
	boolean isExternal(Position<E> p) throws IllegalArgumentException;
	boolean isRoot(Position<E> p) throws IllegalArgumentException;

	int size();
	boolean isEmpty();
	Iterator<E> iterator();
	Iterable<Position<E>> positions();
	
}
