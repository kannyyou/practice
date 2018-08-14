package com.changhun.datastructure.tree;

import com.changhun.datastructure.list.Position;

public class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E >{
	
	
	
	@Override
	public Position<E> left(Position<E> p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;

	}

	@Override
	public Position<E> right(Position<E> p) throws IllegalArgumentException {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public Position<E> sibling(Position<E> p) throws IllegalArgumentException {
		Position<E> parent = parent(p);
		if (parent == null) return null;
		if (p == left(parent))
			return right(parent);
		else
			return(parent);		

	}

}
