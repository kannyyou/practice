package com.changhun.apple.nested_iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

class NestedIteratorQueue<T> {
    private Queue<Iterator<T>> iterqueue;
    
    public NestedIteratorQueue(Queue<Iterator<T>> iterqueue) {
        this.iterqueue = iterqueue;

    }  
    
    public T next() throws NoSuchElementException {
    	
    	if (!hasNext()) throw new NoSuchElementException();
    	  	
    	Iterator<T> it = iterqueue.remove();
    	
    	T val = it.next();
    	
    	if (it.hasNext()) this.iterqueue.add(it);
    	
    	return val;

    }
   
    
    public boolean hasNext(){
        return this.iterqueue.size() != 0;
    }
    
    
    
    public static void main(String[] args) {
    	
    	 
    	Integer[] array1 = {1, 2, 3, 9};
    	Integer[] array2 = {4, 5};
    	Integer[] array3 = {6, 7, 8, 11};
    
    	Iterator<Integer> it1 = Arrays.asList(array1).iterator();
    	Iterator<Integer> it2 = Arrays.asList(array2).iterator();
    	Iterator<Integer> it3 = Arrays.asList(array3).iterator();
    	
    	
    	Queue<Iterator> iterqueue = new LinkedList<Iterator>();
    	iterqueue.add(it1);
    	iterqueue.add(it2);
    	iterqueue.add(it3);

    	NestedIteratorQueue<Integer> nia = new NestedIteratorQueue(iterqueue);
    	
    	while (nia.hasNext()) {
    		System.out.println(nia.next());
		}
    	
    	

    	
	}
    
    
    
    
    
    
    
    
    
//    public NestedIteratorArray(Iterator<T>[] iterlist) {
//        this.iterlist = iterlist;
//    }
//    
//    public T next() throws NoSuchElementException {
//        for(int i = 0; i < this.iterlist.length; i++) {
//            int new_iter_index = this.iter_index + i % this.iterlist.length;
//            if(iterlist[new_iter_index].hasNext()) {
//                T val = iterlist[new_iter_index].next();
//                iter_index = new_iter_index + 1 % this.iterlist.length;
//                return val;
//            }
//        }
//        throw new NoSuchElementException();
//    }
//    
//    public boolean hasNext() {
//        for(int i = 0; i < this.iterlist.length; i++) {
//            if(iterlist[i].hasNext()) {
//                return true;
//            }
//        }
//        return false;
//    }
//    

}