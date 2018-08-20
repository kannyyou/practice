package com.changhun.apple.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * A frog is crossing a river. The river is divided into x units and at each unit there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.

Given a list of stones' positions (in units) in sorted ascending order, determine if the frog is able to cross the river by landing on the last stone. Initially, the frog is on the first stone and assume the first jump must be 1 unit.

If the frog's last jump was k units, then its next jump must be either k - 1, k, or k + 1 units. Note that the frog can only jump in the forward direction.

Note:

The number of stones is ≥ 2 and is < 1,100.
Each stone's position will be a non-negative integer < 231.
The first stone's position is always 0.
Example 1:

[0,1,3,5,6,8,12,17]

There are a total of 8 stones.
The first stone at the 0th unit, second stone at the 1st unit,
third stone at the 3rd unit, and so on...
The last stone at the 17th unit.

Return true. The frog can jump to the last stone by jumping 
1 unit to the 2nd stone, then 2 units to the 3rd stone, then 
2 units to the 4th stone, then 3 units to the 6th stone, 
4 units to the 7th stone, and 5 units to the 8th stone.
Example 2:

[0,1,2,3,4,8,9,11]

Return false. There is no way to jump to the last stone as 
the gap between the 5th and 6th stone is too large.


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



    public static boolean canCross(int[] stones) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], new HashSet<Integer>());
        }
        map.get(0).add(0);
        for (int i = 0; i < stones.length; i++) {
            for (int k : map.get(stones[i])) {
                for (int step = k - 1; step <= k + 1; step++) {
                    if (step > 0 && map.containsKey(stones[i] + step)) {
                        map.get(stones[i] + step).add(step);
                    }
                }
            }
        }
        return map.get(stones[stones.length - 1]).size() > 0;
    }
    
    public boolean canCross2(int[] stones) {
        int[][] memo = new int[stones.length][stones.length];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return can_Cross(stones, 0, 0, memo) == 1;
    }
    public int can_Cross(int[] stones, int ind, int jumpsize, int[][] memo) {
        if (memo[ind][jumpsize] >= 0) {
            return memo[ind][jumpsize];
        }
        for (int i = ind + 1; i < stones.length; i++) {
            int gap = stones[i] - stones[ind];
            if (gap >= jumpsize - 1 && gap <= jumpsize + 1) {
                if (can_Cross(stones, i, gap, memo) == 1) {
                    memo[ind][gap] = 1;
                    return 1;
                }
            }
        }
        memo[ind][jumpsize] = (ind == stones.length - 1) ? 1 : 0;
        return memo[ind][jumpsize];
    }
    
    
    public static void main(String[] args) {
    	int [] array1 = {0,1,3,5,6,8,12,17};
    	
		System.out.println(canCross(array1));
		
    	int [] array2 = {0,1,2,3,4,8,9,11};
    	
		System.out.println(canCross(array2));
	}
    
}
