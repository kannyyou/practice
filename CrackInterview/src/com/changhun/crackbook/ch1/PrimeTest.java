package com.changhun.crackbook.ch1;

//This is the text editor interface. 
//Anything you type or change here will be seen by the other person in real time.


//implement method that prints the first 100 prime numbers
//A prime number (or a prime) is a natural number greater than 1 that has no positive divisors other than 1 and itself. 
import java.util.ArrayList;

public class PrimeTest {
	public static void printPrime() {
     
		ArrayList<Integer> primeNums = new ArrayList<Integer>();
		primeNums.add(2);

		int number = 3;
		while (primeNums.size() < 100) {
			boolean isPrime = true;
			
			for (Integer p: primeNums) {
				if (number % p == 0) {
					isPrime = false;
					break;
				}
			}
			       
			if (isPrime) {
				primeNums.add(number);
			}
         
			number +=2;
     	}   
     
     	System.out.println(primeNums.toString());
 	}
	
	public static void printPrimeNum() {
		
	}
  
 	public static void main(String[] args) {
 		printPrime();
 	}
}
