package com.changhun.z.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
Example:

// Init an empty set.
RandomizedSet randomSet = new RandomizedSet();

// Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomSet.insert(1);

// Returns false as 2 does not exist in the set.
randomSet.remove(2);

// Inserts 2 to the set, returns true. Set now contains [1,2].
randomSet.insert(2);

// getRandom should return either 1 or 2 randomly.
randomSet.getRandom();

// Removes 1 from the set, returns true. Set now contains [2].
randomSet.remove(1);

// 2 was already in the set, so return false.
randomSet.insert(2);

// Since 2 is the only number in the set, getRandom always return 2.
randomSet.getRandom();


LinkedIn

****
ArrayList

The size, isEmpty, get, set, iterator, and listIterator operations run in constant time. 

The add operation runs in """amortized constant time""", that is, adding n elements requires O(n) time. 
All of the other operations run in linear time (roughly speaking). 
The constant factor is low compared to that for the LinkedList implementation.


remove(i) is O(N) both in the worst case and in the average case

 * @author changhun
 *
 */
public class L380_InsertDelete_GetRandom {
	public static class RandomizedSet {
		List<Integer> nums;	
		Map<Integer, Integer> locs; // Need to this for O(1), specially for remove
	    Random rand = new Random();

	    /** Initialize your data structure here. */
	    public RandomizedSet() {
	    	nums = new ArrayList<Integer>();
	    	locs = new HashMap<Integer, Integer>();	    		
	    }
	    
	    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	    //Orignally O(1) amortized constnat but add location for remove
	    public boolean insert(int val) {
	        if (locs.containsKey(val)) {
	        	return false;
	        } else {
	        	locs.put(val, nums.size());	// location of new value
	        	nums.add(val);
	        	return true;
	        }
	    }
	    
	    /** Removes a value from the set. Returns true if the set contained the specified element. */
	    public boolean remove(int val) {
	        Integer loc = locs.get(val);
	    	if (loc == null) {
	        	return false;
	        	
	        } else {
	        	if (loc < nums.size() - 1) { // if loc is not lastOne, replace with lastOne with this val;
	        		int lastOne = nums.get(nums.size()-1);
	        		nums.set(loc, lastOne);	// replace value with lastOne at loc.(so now we have two lastOne in loc and last_loc).
	                locs.put(lastOne, loc);

	        	}
	        	locs.remove(val);	// remove value from map. the one in list is removed above.
	        	nums.remove(nums.size()-1);	//remove lastOne ast last_loc
	        	return true;
	        }
	    }
	    /** Get a random element from the set. */
	    public int getRandom() {
	    	return nums.get( rand.nextInt(nums.size()));
	    }
	    
	    public String toString() {
	    	return nums.toString() + " " + locs.toString();
	    }
	}
	
	public static void main(String[] args) {
		// Init an empty set.
		RandomizedSet randomSet = new RandomizedSet();

		// Inserts 1 to the set. Returns true as 1 was inserted successfully.
		System.out.println("insert 1 " + randomSet.insert(1));
		System.out.println(randomSet.toString());

		// Returns false as 2 does not exist in the set.
		System.out.println("remove 2 " + randomSet.remove(2));
		System.out.println(randomSet.toString());

		// Inserts 2 to the set, returns true. Set now contains [1,2].
		System.out.println("insert 2 " + randomSet.insert(2));
		System.out.println(randomSet.toString());

		
		// getRandom should return either 1 or 2 randomly.
		System.out.println("getRandom " + randomSet.getRandom());

		// Removes 1 from the set, returns true. Set now contains [2].
		System.out.println("remove 1 " + randomSet.remove(1));
		System.out.println(randomSet.toString());

		// 2 was already in the set, so return false.
		System.out.println("insert 2 " + randomSet.insert(2));

		// Since 2 is the only number in the set, getRandom always return 2.
		System.out.println("getRandom " + randomSet.getRandom());
	}
}
