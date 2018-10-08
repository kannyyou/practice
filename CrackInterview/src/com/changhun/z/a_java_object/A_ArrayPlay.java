package com.changhun.z.a_java_object;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * binarySearch
 * copyOf
 * copyOfRange
 * equals
 * fill
 * sort
 * sort(A,cmp)
 * toString()
 * Arrays and Collections
 * @author changhun
 *
 */
public class A_ArrayPlay {
	public static class IntComparator implements Comparator<Integer>{
	    @Override
	    public int compare(Integer o1, Integer o2) {
	        return o1 > o2 ? -1 :(o1 < o2 ? 1 : 0); //Ascending

	        //return o1.age < o2.age ? -1 :(o1.age > o2.age ? 1 : 0); // Descending
	    }
	}
	
	public static void main(String[] args) {
        // sorting array
		Integer [] nums = {2,3,7,10,40}; 
        System.out.println(Arrays.binarySearch(nums, 5));
        System.out.println(Arrays.binarySearch(nums, 7));
        
        Integer [] nums_copy = Arrays.copyOf(nums, 10);
        
        System.out.println(Arrays.toString(nums_copy));
        
        Integer [] nums_copy2 = Arrays.copyOfRange(nums, 1, 3);

        System.out.println(Arrays.toString(nums_copy2));

        Integer [] nums2 = {10, 7,2, 3,12,40}; 
       
        IntComparator intComparator = new IntComparator();
        
        Arrays.sort(nums2, intComparator);

        System.out.println(Arrays.toString(nums2));

        Arrays.sort(nums2);

        
        // handling with List
        
        List<Integer> listNums = new ArrayList<>(Arrays.asList(6, 4, 3, 5, 2, 1));
        System.out.println(listNums.toString());
        
        Collections.sort(listNums, intComparator);
        System.out.println(listNums.toString());

        Collections.sort(listNums, intComparator);
        Collections.sort(listNums);

        System.out.println(listNums.toString());

        System.out.println(Collections.binarySearch(listNums, 3));
        
        Collections.shuffle(listNums);
        System.out.println(listNums.toString());
        
        
        
	}
}
