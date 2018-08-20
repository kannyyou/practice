package com.changhun.apple.nested_iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

class NestedIteratorArray<T> {
    private int iterIndex = 0;
    private Iterator<T>[] iterArray;
    
    public NestedIteratorArray(Iterator<T>[] iterArray) {
    	this.iterArray = iterArray;

    }  
    
    public T next() {
    	for (int i=0; i < this.iterArray.length; i++) {
    		int newIterIndex = (this.iterIndex)  % this.iterArray.length; 

    		//the latter show n th iterator
			this.iterIndex ++;

    		System.out.print("i=" + i + " iterIndex = " + iterIndex + " ");

    		if (iterArray[newIterIndex].hasNext()) {
    			T val = iterArray[newIterIndex].next();

    			return val;
    		}

    	}
    	throw new NoSuchElementException();
    }
    
    public boolean hasNext(){
    	for (Iterator<T> iterator: this.iterArray) {
    		if (iterator.hasNext()) {
    			return true;
    		}
    	}
    	return false;
    }
    
    
    
    public static void main(String[] args) {
    	
    	 
    	Integer[] array1 = {1, 2, 3, 9};
    	Integer[] array2 = {4, 5};
    	Integer[] array3 = {6, 7, 8, 11};
    
    	Iterator<Integer> it1 = Arrays.asList(array1).iterator();
    	Iterator<Integer> it2 = Arrays.asList(array2).iterator();
    	Iterator<Integer> it3 = Arrays.asList(array3).iterator();
    	
    	
    	Iterator[] iterArray = {it1, it2, it3};
    	
    	NestedIteratorArray<Integer> nia = new NestedIteratorArray(iterArray);
    	
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