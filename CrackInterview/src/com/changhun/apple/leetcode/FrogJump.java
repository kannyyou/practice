package com.changhun.apple.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * A frog is crossing a river. 
 * The river is divided into x units and at each unit there may or may not exist a stone. 
 * The frog can jump on a stone, but it must not jump into the water.
 * 
 * Given a list of stones' positions (in units) in sorted ascending order, 
 * determine if the frog is able to cross the river by landing on the last stone. 
 * Initially, the frog is on the first stone and assume the first jump must be 1 unit.
 * 
 * If the frog's last jump was k units, then its next jump must be either k - 1, k, or k + 1 units. 
 * Note that the frog can only jump in the forward direction.
 * 
 * Note:
 * 
 * The number of stones is ≥ 2 and is < 1,100.
 * Each stone's position will be a non-negative integer < 231.
 * The first stone's position is always 0.
 * 
 * Example 1:
 * 
 * [0,1,3,5,6,8,12,17]
 * 
 * There are a total of 8 stones.
 * The first stone at the 0th unit, second stone at the 1st unit,
 * third stone at the 3rd unit, and so on...
 * The last stone at the 17th unit.
 * 
 * Return true. The frog can jump to the last stone by jumping 
 * 1 unit to the 2nd stone, then 2 units to the 3rd stone, then 
 * 2 units to the 4th stone, then 3 units to the 6th stone, 
 * 4 units to the 7th stone, and 5 units to the 8th stone.
 * 
 * Example 2:
 * 
 * [0,1,2,3,4,8,9,11]
 * 
 * Return false. There is no way to jump to the last stone as the gap between the 5th and 6th stone is too large.

Algorithm

In the DP Approach, we make use of a hashmap mapmap which contains key:valuekey:value pairs 
such that keykey refers to the position at which a stone is present and valuevalue is a set 
containing the jumpsizejumpsize which can lead to the current stone position. 
We start by making a hashmap whose keykeys are all the positions at which a stone is present and the valuevalues 
are all empty except position 0 whose value contains 0. 
Then, we start traversing the elements(positions) of the given stone array in sequential order. 
For the currentPositioncurrentPosition, for every possible jumpsizejumpsize in the valuevalue set, 
we check if currentPosition + newjumpsizecurrentPosition+newjumpsize exists in the mapmap, 
where newjumpsizenewjumpsize can be either jumpsize-1jumpsize−1, jumpsizejumpsize, jumpsize+1jumpsize+1. 
If so, we append the corresponding valuevalue set with newjumpsizenewjumpsize. We continue in the same manner. 
If at the end, the valuevalue set corresponding to the last position is non-empty, we conclude that reaching the end is possible, 
otherwise, it isn't.

For more understanding see this animation-


 */
public class FrogJump {
	
	/**
	 * Brute Force 
	 * 
	 * In the brute force approach, we make use of a recursive function canCrossBF 
	 * which takes the given stone array, the current position and the current 
	 * jumpsize as input arguments. 
	 * We start with currentPosition = 0 and jumpsize = 0. 
	 * Then for every function call, we start from the currentPosition and 
	 * check if there lies a stone at (currentPostion + newjumpsize), 
	 * where, the newjumpsize could be jumpsize, jumpsize+1 or jumpsize-1. 
	 * In order to check whether a stone exists at the specified positions, 
	 * we check the elements of the array in a linear manner. 
	 * If a stone exists at any of these positions, we call the recursive function again 
	 * with the same stone array, the currentPosition and the newjumpsize as the parameters. 
	 * If we are able to reach the end of the stone array through any of these calls, 
	 * we return true to indicate the possibility of reaching the end.
	 *  
	 * @param stones
	 * @return
	 */
    public static boolean canCrossBF(int[] stones) {
        return can_CrossBF(stones, 0, 0);
    }
    public static boolean can_CrossBF(int[] stones, int ind, int jumpsize) {
        for (int i = ind + 1; i < stones.length; i++) {
            int step = stones[i] - stones[ind];
            
            System.out.println(ind + " " + i + " " + step);
            if (step >= jumpsize - 1 && step <= jumpsize + 1) {
                if (can_CrossBF(stones, i, step)) {
                    return true;
                }
            }
        }
        return ind == stones.length - 1;
    }
	
    
    /**
     * In the previous brute force approach, we need to find if a stone exists at 
     * (currentPosition + new jumpsize), where newjumpsize could be either of jumpsize-1, jumpsize or jumpsize+1. 
     * But in order to check if a stone exists at the specified location, 
     * we searched the given array in linearly. 
     * To optimize this, we can use binary search to look for the element in the given array since it is sorted. 
     * Rest of the method remains the same.
     * 
     * @param stones
     * @return
     */
	
    public static boolean canCrossBF2(int[] stones) {
        return can_CrossBF2(stones, 0, 0);
    }
    public static boolean can_CrossBF2(int[] stones, int ind, int jumpsize) {
        if (ind == stones.length - 1) {
            return true;
        }
        int ind1 = Arrays.binarySearch(stones, ind + 1, stones.length, stones[ind] + jumpsize);
        if (ind1 >= 0 && can_CrossBF2(stones, ind1, jumpsize)) {
            return true;
        }
        int ind2 = Arrays.binarySearch(stones, ind + 1, stones.length, stones[ind] + jumpsize - 1);
        if (ind2 >= 0 && can_CrossBF2(stones, ind2, jumpsize - 1)) {
            return true;
        }
        int ind3 = Arrays.binarySearch(stones, ind + 1, stones.length, stones[ind] + jumpsize + 1);
        if (ind3 >= 0 && can_CrossBF2(stones, ind3, jumpsize + 1)) {
            return true;
        }
        return false;
    }
    
    /**
     * Using Memorization
     * 
     * Another problem with above approaches is that we can make the same function calls coming through different paths 
     * e.g. For a given currentIndex , we can call the recursive function canCross with the jumpsize, say n. 
     * This n could be resulting from previous jumpsize being n-1,n or n+1. 
     * Thus, many redundant function calls could be made prolonging the running time. 
     * This redundancy can be removed by making use of memorization. We make use of a 2-d memo array, 
     * initialized by -1s, to store the result returned from a function call for a particular currentIndex 
     * and jumpsize. If the same currentIndex and jumpsize happens is encountered again, 
     * we can return the result directly using the memo array. This helps to prune the search tree to a great extent.
     * 
     * 
     */
	
    public static boolean canCrossBF3(int[] stones) {
        int[][] memo = new int[stones.length][stones.length];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return can_CrossBF3(stones, 0, 0, memo) == 1;
    }
    public static int can_CrossBF3(int[] stones, int ind, int jumpsize, int[][] memo) {
        if (memo[ind][jumpsize] >= 0) {
            return memo[ind][jumpsize];
        }
        for (int i = ind + 1; i < stones.length; i++) {
            int gap = stones[i] - stones[ind];
            if (gap >= jumpsize - 1 && gap <= jumpsize + 1) {
                if (can_CrossBF3(stones, i, gap, memo) == 1) {
                    memo[ind][gap] = 1;
                    return 1;
                }
            }
        }
        memo[ind][jumpsize] = (ind == stones.length - 1) ? 1 : 0;
        return memo[ind][jumpsize];
    }
    
    /**
     * We can optimize the above memorization approach, if we make use of Binary Search to find 
     * if a stone exists at currentPostion + newjumpsize instead of searching linearly.
     * 
     * @param stones
     * @return
     */
    public static boolean canCrossBF4(int[] stones) {
        int[][] memo = new int[stones.length][stones.length];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return can_CrossBF4(stones, 0, 0, memo) == 1;
    }
    public static int can_CrossBF4(int[] stones, int ind, int jumpsize, int[][] memo) {
        if (memo[ind][jumpsize] >= 0) {
            return memo[ind][jumpsize];
        }
        int ind1 = Arrays.binarySearch(stones, ind + 1, stones.length, stones[ind] + jumpsize);
        if (ind1 >= 0 && can_CrossBF4(stones, ind1, jumpsize, memo) == 1) {
            memo[ind][jumpsize] = 1;
            return 1;
        }
        int ind2 = Arrays.binarySearch(stones, ind + 1, stones.length, stones[ind] + jumpsize - 1);
        if (ind2 >= 0 && can_CrossBF4(stones, ind2, jumpsize - 1, memo) == 1) {
            memo[ind][jumpsize - 1] = 1;
            return 1;
        }
        int ind3 = Arrays.binarySearch(stones, ind + 1, stones.length, stones[ind] + jumpsize + 1);
        if (ind3 >= 0 && can_CrossBF4(stones, ind3, jumpsize + 1, memo) == 1) {
            memo[ind][jumpsize + 1] = 1;
            return 1;
        }
        memo[ind][jumpsize] = ((ind == stones.length - 1) ? 1 : 0);
        return memo[ind][jumpsize];
    }
    
    
	/**
	 * In the DP Approach, we make use of a hashmap map which contains key:value pairs 
	 * such that key refers to the position at which a stone is present and 
	 * value is a set containing the jumpsize which can lead to the current stone position. 
	 * We start by making a hashmap whose keys are all the positions at which a stone is present 
	 * and the values are all empty except position 0 whose value contains 0. 
	 * 
	 * Then, we start traversing the elements(positions) of the given stone array in sequential order. 
	 * 
	 * For the currentPosition, for every possible jumpsize in the value set, 
	 * we check if currentPosition + newjumpsize exists in the map, 
	 * 
	 * where newjumpsize can be either jumpsize-1, jumpsize , jumpsize+1. 
	 * 
	 * If so, we append the corresponding value set with newjumpsize. 
	 * We continue in the same manner. If at the end, the value set 
	 * corresponding to the last position is non-empty, we conclude 
	 * that reaching the end is possible, otherwise, it isn't.
	 * 
	 * @param stones
	 * @return
	 */
    public static boolean canCross(int[] stones) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], new HashSet<Integer>());
        }
        map.get(0).add(0);
        for (int i = 0; i < stones.length; i++) {
            for (int k : map.get(stones[i])) {
            	System.out.println(stones[i] + " " + k);
                for (int step = k - 1; step <= k + 1; step++) {
                    if (step > 0 && map.containsKey(stones[i] + step)) {
                        map.get(stones[i] + step).add(step);
                    	System.out.println("\t " + (stones[i] + step) + " " + step);

                    }
                }
            }
        }
        System.out.println(map.toString());
        return map.get(stones[stones.length - 1]).size() > 0;
    }
    
    
    
//    public boolean canCross2(int[] stones) {
//        int[][] memo = new int[stones.length][stones.length];
//        for (int[] row : memo) {
//            Arrays.fill(row, -1);
//        }
//        return can_Cross(stones, 0, 0, memo) == 1;
//    }
//    public int can_Cross(int[] stones, int ind, int jumpsize, int[][] memo) {
//        if (memo[ind][jumpsize] >= 0) {
//            return memo[ind][jumpsize];
//        }
//        for (int i = ind + 1; i < stones.length; i++) {
//            int gap = stones[i] - stones[ind];
//            if (gap >= jumpsize - 1 && gap <= jumpsize + 1) {
//                if (can_Cross(stones, i, gap, memo) == 1) {
//                    memo[ind][gap] = 1;
//                    return 1;
//                }
//            }
//        }
//        memo[ind][jumpsize] = (ind == stones.length - 1) ? 1 : 0;
//        return memo[ind][jumpsize];
//    }
    
    
    public static void main(String[] args) {
    	int [] array1 = {0,1,3,5,6,8,12,17};
    	
		System.out.println(canCrossBF(array1));
		System.out.println(canCrossBF2(array1));
		System.out.println(canCrossBF3(array1));

		System.out.println(canCross(array1));

    	int [] array2 = {0,1,2,3,4,8,9,11};
    	
		System.out.println(canCrossBF(array2));
		System.out.println(canCrossBF2(array2));
		System.out.println(canCrossBF3(array2));
		System.out.println(canCross(array2));

	}
    
}
