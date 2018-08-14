package com.changhun.crackbook.ch1;

public class UFLify {
	
	public static void replaceSpaces(char[] str, int trueLength) {
		int spaceCount = 0;
		int index;
		int i = 0;
		
		for (i=0; i < trueLength; i++) {
			if (str[i] == ' ') {
				spaceCount ++;
			}
		}
		
		index = trueLength + spaceCount * 2; //length with %20;
		
		if (trueLength < str.length) str[trueLength] = '\0';	//replace space with \0;
		
		for (i=trueLength - 1; i >= 0; i--) {	//from the end
			if (str[i] == ' ') {
				str[index - 1] = '0';
				str[index - 2] = '2';
				str[index - 3] = '%';
				index -= 3;
			} else {
				str[index - 1] = str[i];
				index --;
			}
		}
		
	}
	
	public static void main(String[] args) {
		String str = "Mr John Smith    ";
		char[] chars = str.toCharArray();
		replaceSpaces(chars, 13);
		
		System.out.println(String.valueOf(chars));
	}
}
