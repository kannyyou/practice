package com.changhun.datastructure.tree;

import com.changhun.datastructure.list.Position;

public interface BinaryTree<E> {
	Position<E> left(Position<E> p) throws IllegalArgumentException;

	Position<E> right(Position<E> p) throws IllegalArgumentException;

	Position<E> sibling(Position<E> p) throws IllegalArgumentException;

}
