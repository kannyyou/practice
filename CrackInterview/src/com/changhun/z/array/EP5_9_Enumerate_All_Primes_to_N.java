package com.changhun.z.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a number n, print all primes smaller than or equal to n. It is also given that n is a small number.

Example:

Input : n =10
Output : 2 3 5 7 

Input : n = 20 
Output: 2 3 5 7 11 13 17 19
The sieve of Eratosthenes is one of the most efficient ways to find all primes smaller than n when n is smaller than 10 million or so (Ref Wiki).


1. Create a list of consecutive integers from 2 to n: (2, 3, 4, …, n).
2. Initially, let p equal 2, the first prime number.
3. Starting from p2, count up in increments of p and mark each of these numbers greater 
than or equal to p2 itself in the list. These numbers will be p(p+1), p(p+2), p(p+3), etc..
4. Find the first number greater than p in the list that is not marked. 
If there was no such number, stop. Otherwise, let p now equal this number (which is the next prime), and repeat from step 3.


 * @author changhun
 *
 */
public class EP5_9_Enumerate_All_Primes_to_N {
	public static class Solution1 {
		public static List<Integer> generatePrime(int n) {
			List<Integer> primes = new ArrayList<>();			
			List<Boolean> isPrime = new ArrayList<>(Collections.nCopies(n+1, true));
			
			isPrime.set(0, false);
			isPrime.set(1, false);
			
			for (int p = 2; p <= n; p++) {
				if (isPrime.get(p)) {
					primes.add(p);
					
					for (int i = p; i <= n; i += p) {
						isPrime.set(i, false);
					}
				}
			}
			
			return primes;
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println(Solution1.generatePrime(10));

	}
}
