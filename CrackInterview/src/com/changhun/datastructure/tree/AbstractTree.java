package com.changhun.datastructure.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.changhun.datastructure.list.Position;

public class AbstractTree<E> implements Tree<E> { 
	public int depth(Position<E> p) {
		if (isRoot(p))
			return 0;
		else
			return 1 + depth(parent(p));
	}
	
	public int height(Position<E> p) {
		int h = 0;
		for (Position<E> c: children(p)) {
			h = Math.max(h,  1+ height(c));
		}
		return h;
	}
	
	@Override
	public Position<E> root() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position<E> parent(Position<E> p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int numChildren(Position<E> p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Returns true if Position p has one or more children.
	 *
	 * @param p    A valid Position within the tree
	 * @return true if p has at least one child, false otherwise
	 * @throws IllegalArgumentException if p is not a valid Position for this tree.
	 */	
	@Override
	public boolean isInternal(Position<E> p) throws IllegalArgumentException {
		return numChildren(p) > 0;
	}

	/**
	 * Returns true if Position p does not have any children.
	 *
	 * @param p    A valid Position within the tree
	 * @return true if p has zero children, false otherwise
	 * @throws IllegalArgumentException if p is not a valid Position for this tree.
	 */	
	@Override
	public boolean isExternal(Position<E> p) throws IllegalArgumentException {
		return numChildren(p) == 0;
	}

	/**
	 * Returns true if Position p represents the root of the tree.
	 *
	 * @param p    A valid Position within the tree
	 * @return true if p is the root of the tree, false otherwise
	 */	
	@Override
	public boolean isRoot(Position<E> p) throws IllegalArgumentException {
		return p == root(); 
	}

	/**
	 * Returns the number of nodes in the tree.
	 * @return number of nodes in the tree
	 */
	@Override
	public int size() {
	    int count=0;
	    for (Position p : positions()) count++;
	    return count;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Position<E>> positions() {
		return preorder();
	}

	/**
	 * Adds positions of the subtree rooted at Position p to the given
	 * snapshot using a preorder traversal
	 * @param p       Position serving as the root of a subtree
	 * @param snapshot  a list to which results are appended
	 */
	private void preorderSubtree(Position<E> p, List<Position<E>> snapshot) {
		snapshot.add(p);                       // for preorder, we add position p before exploring subtrees
	    for (Position<E> c : children(p))
	      preorderSubtree(c, snapshot);
	}
	  
	/**
	 * Returns an iterable collection of positions of the tree, reported in preorder.
	 * @return iterable collection of the tree's positions in preorder
	 */
	public Iterable<Position<E>> preorder() {
		List<Position<E>> snapshot = new ArrayList<>();
	    if (!isEmpty())
	      preorderSubtree(root(), snapshot);   // fill the snapshot recursively
	    return snapshot;
	}

	/**
	 * Adds positions of the subtree rooted at Position p to the given
	 * snapshot using a postorder traversal
	 * @param p       Position serving as the root of a subtree
	 * @param snapshot  a list to which results are appended
	 */
	private void postorderSubtree(Position<E> p, List<Position<E>> snapshot) {
		for (Position<E> c : children(p))
			postorderSubtree(c, snapshot);
	    snapshot.add(p);                       // for postorder, we add position p after exploring subtrees
	}

	/**
	 * Returns an iterable collection of positions of the tree, reported in postorder.
	 * @return iterable collection of the tree's positions in postorder
	 */
	public Iterable<Position<E>> postorder() {
		List<Position<E>> snapshot = new ArrayList<>();
	    if (!isEmpty())
	      postorderSubtree(root(), snapshot);   // fill the snapshot recursively
	    return snapshot;	
	}	
	

	/**
	   * Returns an iterable collection of positions of the tree in breadth-first order.
	   * @return iterable collection of the tree's positions in breadth-first order
	   */
//	public Iterable<Position<E>> breadthfirst() {
//		List<Position<E>> snapshot = new ArrayList<>();
//	    if (!isEmpty()) {
//	    	Queue<Position<E>> fringe = new LinkedQueue<>();
//	    	fringe.enqueue(root());                 // start with the root
//	    	while (!fringe.isEmpty()) {
//	    		Position<E> p = fringe.dequeue();     // remove from front of the queue
//	    		snapshot.add(p);                      // report this position
//	    		for (Position<E> c : children(p))
//	    			fringe.enqueue(c);                  // add children to back of queue
//	    	}
//	    }
//	    return snapshot;	
//	}
	
	
}