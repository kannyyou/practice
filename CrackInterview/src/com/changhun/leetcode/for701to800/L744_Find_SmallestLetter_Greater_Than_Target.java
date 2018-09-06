package com.changhun.leetcode.for701to800;

import java.util.Arrays;

/**
 * 
 * 
Given a list of sorted characters letters containing only lowercase letters, 
 given a target letter target, find the smallest element in the list that is larger than the given target.

Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.

Examples:
Input:
letters = ["c", "f", "j"]
target = "a"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "c"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "d"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "g"
Output: "j"

Input:
letters = ["c", "f", "j"]
target = "j"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "k"
Output: "c"


Note:
letters has a length in range [2, 10000].
letters consists of lowercase letters, and contains at least 2 unique letters.
target is a lowercase letter.


LinkedIn 
Easy

 * @author changhun
 *
 */
public class L744_Find_SmallestLetter_Greater_Than_Target {
    /**
     * 
     * Intuition and Algorithm

Let's scan through letters and record if we see a letter or not. 
We could do this with an array of size 26, or with a Set structure.

Then, for every next letter (starting with the letter that is one greater than the target), l
et's check if we've seen it. If we have, it must be the answer.

Time Complexity: O(N), where NN is the length of letters. We scan every element of the array.

Space Complexity: O(1), the maximum size of seen.

     * @param letters
     * @param target
     * @return
     */
	
	public static char nextGreatestLetter1(char[] letters, char target) {
        boolean[] seen = new boolean[26];
        for (char c: letters)
            seen[c - 'a'] = true;
        System.out.println(Arrays.toString(seen));
        while (true) {
            target++;
            System.out.println(target);
            if (target > 'z') target = 'a';
            if (seen[target - 'a']) return target;
        }
    }
    
	/**
	 * Intuition and Algorithm

Since letters are sorted, if we see something larger when scanning form left to right, it must be the answer. 
Otherwise, (since letters is non-empty), the answer is letters[0].

Time Complexity: O(N), where NN is the length of letters. We scan every element of the array.

Space Complexity: O(1), as we maintain only pointers.
	 * @param letters
	 * @param target
	 * @return
	 */
	
    public static char nextGreatestLetter2(char[] letters, char target) {
        for (char c: letters)
            if (c > target) return c;
        return letters[0];
    }
	
    /**
     * Like in Approach #2, we want to find something larger than target in a sorted array. 
     * This is ideal for a binary search: Let's find the rightmost position to insert target into letters so that it remains sorted.

Our binary search (a typical one) proceeds in a number of rounds. 
At each round, let's maintain the loop invariant that the answer must be in the interval [lo, hi]. Let mi = (lo + hi) / 2. 
If letters[mi] <= target, then we must insert it in the interval [mi + 1, hi]. Otherwise, we must insert it in the interval [lo, mi].

At the end, if our insertion position says to insert target into the last position letters.length, we return letters[0] instead. 
This is what the modulo operation does.

Time Complexity: O(\log N)O(logN), where NN is the length of letters. We peek only at \log NlogN elements in the array.

Space Complexity: O(1)O(1), as we maintain only pointers.
     * @param letters
     * @param target
     * @return
     */
    
    public static char nextGreatestLetter3(char[] letters, char target) {
        int lo = 0, hi = letters.length;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            System.out.println(mi + " "+ lo);
            if (letters[mi] <= target) {
            	lo = mi + 1;
                System.out.println("\t" + mi + " "+ lo);

            }
            else hi = mi;
            
            
        }
        return letters[lo % letters.length];
    }
	
    /**
     * [false, false, true, false, false, true, false, false, false, true, 
     *  a         b     c    d       e     f     g      h      i      j
      * @param args
     */
    public static void main(String[] args) {
		char [] letters1 = {'c', 'f', 'j'};
		
		System.out.println(nextGreatestLetter3(letters1, 'c'));
	}
}
