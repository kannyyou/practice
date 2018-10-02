package com.changhun.z.number;

public class L326_PowerOfThree {
    public static boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }
        
        while (n % 3 == 0) {
            n /= 3;
        }
        
        return n == 1;

    }
    
    public static boolean isPowerOfTwo(int n) {
        if (n < 1) {
            return false;
        }
        
        while (n % 2 == 0) {
            n /= 2;
        }
        
        return n == 1;

    }
    
    public static void main(String[] args) {
		System.out.println(isPowerOfThree(81));
		System.out.println(isPowerOfTwo(8));

	}
}
