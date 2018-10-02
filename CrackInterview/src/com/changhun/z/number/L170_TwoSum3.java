package com.changhun.z.number;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 
Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

Example 1:

add(1); add(3); add(5);
find(4) -> true
find(7) -> false
Example 2:

add(3); add(1); add(2);
find(3) -> true
find(6) -> false


LinkedIn
 * @author changhun
 *
 */
public class L170_TwoSum3 {
	/**
	 * Your TwoSum object will be instantiated and called as such:
	 * TwoSum obj = new TwoSum();
	 * obj.add(number);
	 * boolean param_2 = obj.find(value);
	 */
	public static class TwoSum {
		Map<Integer, Integer> map;

	    /** Initialize your data structure here. */
	    public TwoSum() {
	        map = new HashMap<Integer,Integer>();
	    }
	    
	    /** Add the number to an internal data structure.. */
	    public void add(int number) { 
	    	Integer eVal = map.get(number);
	    	if (eVal == null) {
	    		map.put(number,  1);
	    	} else {
	    		map.put(number, eVal + 1);	//if the same value exists, add 1 more.
	    	}	        
	    }
	    
	    /** Find if there exists any pair of numbers which sum is equal to the value. */
	    public boolean find(int target) {
		    Iterator<Integer> it = map.keySet().iterator();
		    while (it.hasNext()) {
		    	int num1 = it.next();
		    	int num2 = target - num1;
		    	
		    	Integer count = map.get(num2);
		    	
		    	if (count != null && (num1 != num2 || count > 2)) return true;
		    	
		    }
		    return false;
	    }
	}
	
	public static void main(String[] args) {
		TwoSum ts = new TwoSum();
		
		ts.add(1);
		ts.add(3);
		ts.add(5);

		System.out.println(4 + " " + ts.find(4));
		System.out.println(7 + " " + ts.find(7));

		ts = new TwoSum();
		ts.add(3);
		ts.add(1);
		ts.add(2);
		
		System.out.println(3 + " " + ts.find(3));
		System.out.println(6 + " " + ts.find(6));

	}

}
