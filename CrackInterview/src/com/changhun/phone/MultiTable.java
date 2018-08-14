package com.changhun.phone;

/*
 * Print out the grade-school multiplication table up to 12x12
 */
public class MultiTable {
    public static void multiTables ( int max ) {
    	for (int i = 1; i<=max; i++) {
    		for (int j=1; j<=max; j++) {
    			System.out.print(String.format("%4d", i*j));
    			
    		}
    		System.out.println();
    	}
    }

    public static void main(String[] args) {
		multiTables(12);
	}
    
}
