package com.changhun.apple.nested_iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

class NestedIteratorList<T> {
    private int iterIndex = 0;
    private LinkedList<Iterator<T>> iterlist;
    
    public NestedIteratorList(LinkedList<Iterator<T>> iterlist) {
        this.iterlist = iterlist;

    }  
    
    public T next() throws NoSuchElementException {
    	
    	if (!hasNext()) throw new NoSuchElementException();
    	
    	int curIndex = this.iterIndex % iterlist.size();   	
    	T val = iterlist.get(curIndex).next();   	
   	
    	if (!this.iterlist.get(curIndex).hasNext()) {
    		this.iterlist.remove(curIndex);
    	}
    	
    	this.iterIndex ++;  
    	return val;

    }
   
    
    public boolean hasNext(){
        return this.iterlist.size() != 0;
    }
    
    
    
    public static void main(String[] args) {
    	
    	 
    	Integer[] array1 = {1, 2, 3, 9};
    	Integer[] array2 = {4, 5};
    	Integer[] array3 = {6, 7, 8, 11};
    
    	Iterator<Integer> it1 = Arrays.asList(array1).iterator();
    	Iterator<Integer> it2 = Arrays.asList(array2).iterator();
    	Iterator<Integer> it3 = Arrays.asList(array3).iterator();
    	
    	
    	LinkedList<Iterator> iterlist = new LinkedList<Iterator>();
    	iterlist.add(it1);
    	iterlist.add(it2);
    	iterlist.add(it3);

    	NestedIteratorList<Integer> nia = new NestedIteratorList(iterlist);
    	
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