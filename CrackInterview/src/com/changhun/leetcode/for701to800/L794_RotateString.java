package com.changhun.leetcode.for701to800;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * We are given two strings, A and B.

A shift on A consists of taking string A and moving the leftmost character to the rightmost position. 
For example, if A = 'abcde', then it will be 'bcdea' after one shift on A. 
Return True if and only if A can become B after some number of shifts on A.

Example 1:
Input: A = 'abcde', B = 'cdeab'
Output: true

Example 2:
Input: A = 'abcde', B = 'abced'
Output: false
 * @author changhun
 *
 */
public class L794_RotateString {
	
	/**
	 * Approach #1: Brute Force [Accepted]
Intuition

For each rotation of A, let's check if it equals B.

Algorithm

More specifically, say we rotate A by s. Then, instead of A[0], A[1], A[2], ..., we have A[s], A[s+1], A[s+2], ...; 
and we should check that A[s] == B[0], A[s+1] == B[1], A[s+2] == B[2], etc.

Complexity Analysis

Time Complexity: O(N^2), where NN is the length of A. For each rotation s, we check up to NN elements in A and B.

Space Complexity: O(1). We only use pointers to elements of A and B.
	 * @param A
	 * @param B
	 * @return
	 */
    public static boolean rotateString1(String A, String B) {
        if (A.length() != B.length())
            return false;
        if (A.length() == 0)
            return true;

        search:
            for (int s = 0; s < A.length(); ++s) {
                for (int i = 0; i < A.length(); ++i) {
                    if (A.charAt((s+i) % A.length()) != B.charAt(i))
                        continue search;
                }
                return true;
            }
        return false;
    }
    
    /**
Approach #2: Simple Check [Accepted]
Intuition and Algorithm

All rotations of A are contained in A+A. Thus, we can simply check whether B is a substring of A+A. 
We also need to check A.length == B.length, otherwise we will fail cases like A = "a", B = "aa".

Complexity Analysis

Time Complexity: O(N^2), where NN is the length of A.

Space Complexity: O(N), the space used building A+A.
     * @param A
     * @param B
     * @return
     */
    public static boolean rotateString2(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }
    
    /**
     * Approach #3: Rolling Hash [Accepted]
Intuition

Our approach comes down to quickly checking whether want to check whether B is a substring of A2 = A+A. 
Specifically, (if N = A.length) we should check whether B = A2[0:N], or B = A2[1:N+1], or B = A2[2:N+2] and so on. 
To check this, we can use a rolling hash.

Algorithm

For a string S, say hash(S) = (S[0] * P**0 + S[1] * P**1 + S[2] * P**2 + ...) % MOD, where X**Y represents exponentiation, 
and S[i] is the ASCII character code of the string at that index.

The idea is that hash(S) has output that is approximately uniformly distributed 
between [0, 1, 2, ..., MOD-1], and so if hash(S) == hash(T) it is very likely that S == T.

Now say we have a hash hash(A), and we want the hash of A[1], A[2], ..., A[N-1], A[0]. 
We can subtract A[0] from the hash, divide by P, and add A[0] * P**(N-1). (Our division is under the finite field \mathbb{F}_\text{MOD}F 
MOD
​	
  - done by multiplying by the modular inverse Pinv = pow(P, MOD-2, MOD).)
     * @param A
     * @param B
     * @return
     */
    
    public static boolean rotateString3(String A, String B) {
        if (A.equals(B)) return true;

        int MOD = 1_000_000_007;
        int P = 113;
        int Pinv = BigInteger.valueOf(P).modInverse(BigInteger.valueOf(MOD)).intValue();

        long hb = 0, power = 1;
        for (char x: B.toCharArray()) {
            hb = (hb + power * x) % MOD;
            power = power * P % MOD;
        }

        long ha = 0; power = 1;
        char[] ca = A.toCharArray();
        for (char x: ca) {
            ha = (ha + power * x) % MOD;
            power = power * P % MOD;
        }

        for (int i = 0; i < ca.length; ++i) {
            char x = ca[i];
            ha += power * x - x;
            ha %= MOD;
            ha *= Pinv;
            ha %= MOD;
            if (ha == hb && (A.substring(i+1) + A.substring(0, i+1)).equals(B))
                return true;

        }
        return false;
    }
    
    /**
     * Approach #4: KMP (Knuth-Morris-Pratt) [Accepted]
Intuition

As before, we want to find whether B exists in A+A. 
The KMP algorithm is a textbook algorithm that does string matching in linear time, which is faster than brute force.

Algorithm

The algorithm is broken up into two steps, building the shifts table (or failure table), and using it to find whether a match exists.

The shift table tells us about the largest prefix of B that ends here. 
More specifically, B[:shifts[i+1]] == B[i - shifts[i+1] : i] is the largest possible prefix of B ending before B[i].

To build the shift table, we use a dynamic programming approach, where all previously calculated values of shifts are correct. 
Then, left will be the end of the candidate prefix of B, 
and right will be the end of the candidate section that should match the prefix B[0], B[1], ..., B[left]. 
Call positions (left, right) "matching" if the prefix ending at B[left] matches the same length string ending at B[right]. 
The invariant in our loop will be that (left - 1, right - 1) is matching by the end of each for-block.

In a new for-block, if (left, right) is matching (ie. (left - 1, right - 1) is matching 
from before, plus B[left] == B[right]), then we know the shift (right - left) is the same number as before. 
Otherwise, when (left, right) is not matching, we need to find a shorter prefix.

Our strategy is to find a matching of (left2, right) where left2 < left, 
by finding matchings (left2 - 1, right - 1) plus checking B[left2] == B[right]. Since (left - 1, right - 1) is a matching, 
by transitivity we want to find matchings (left2 - 1, left - 1). The largest such left2 is left2 = left - shifts[left]. 
We repeatedly check these left2's in greedy order from largest to smallest.

To find a match of B in A+A with such a shift table ready, we employ a similar strategy. 
We maintain a matching (match_len - 1, i - 1), where these positions correspond 
to strings of length match_len that end at B[match_len - 1] and (A+A)[i-1] respectively.

Now when trying to find the largest length matching for (A+A) at position i, it must be at most (match_len - 1) + 1, 
where the quantity in brackets is the largest length matching to position i-1.

Again, our strategy is to find a matching (match_len2 - 1, i - 1) plus check that B[match_len2] == (A+A)[i]. 
Similar to before, if B[match_len] != (A+A)[i], then because (match_len - 1, i - 1) was a matching, 
by transitivity (match_len2 - 1, match_len - 1) must be a matching, 
of which the largest is found by match_len2 = match_len - shifts[match_len]. 
We also repeatedly check these match_len's in order from largest to smallest.

If at any point in this algorithm our match length is N, we've found B in A+A successfully.
     * 
     * @param A
     * @param B
     * @return
     */
    public static boolean rotateString4(String A, String B) {
        int N = A.length();
        if (N != B.length()) return false;
        if (N == 0) return true;

        //Compute shift table
        int[] shifts = new int[N+1];
        Arrays.fill(shifts, 1);
        int left = -1;
        for (int right = 0; right < N; ++right) {
            while (left >= 0 && (B.charAt(left) != B.charAt(right)))
                left -= shifts[left];
            shifts[right + 1] = right - left++;
        }

        //Find match of B in A+A
        int matchLen = 0;
        for (char c: (A+A).toCharArray()) {
            while (matchLen >= 0 && B.charAt(matchLen) != c)
                matchLen -= shifts[matchLen];
            if (++matchLen == N) return true;
        }

        return false;
    }
    
    public static void main(String[] args) {
    	String a = "abcde";
    	String b = "cdeab";
    	String c = "abced";
    	    			
		System.out.println(rotateString1(a,b));
		System.out.println(rotateString2(a,b));
		System.out.println(rotateString3(a,b));
		System.out.println(rotateString4(a,b));
		
		System.out.println(rotateString1(a,c));
		System.out.println(rotateString2(a,c));
		System.out.println(rotateString3(a,c));
		System.out.println(rotateString4(a,c));

	}
}
