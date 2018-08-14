package com.changhun.phone;

import java.io.BufferedReader;
import java.io.FileReader;

public class SumFile {
	
	public static void sumFile(String fileName) {
		try {		
			int total = 0;
	        BufferedReader in = new BufferedReader ( new FileReader ( fileName ));
	        
	        String line;
			while( (line = in.readLine()) != null) { 
				if (line != null && line.length() > 0) {
					total += Integer.parseInt(line);
					
				}
				
			}
			
			System.out.println(total);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		sumFile("/Users/changhun/Projects/Java/CrackInterview/ext/sumFile.txt");
	}

}
