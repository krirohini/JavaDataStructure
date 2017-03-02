package com.javatest.string;

public class test3 {
	public static void main(String[] args) {
//		String str = "aabcccccaaaaaaaaaaaaaaaa";
		String str = "abcd";
		String compStr = compressString(str);
		System.out.println(compStr); 
	}

	private static String compressString(String str) {
		int newSize = countCharInCompressedString(str);
		if( newSize > str.length()) {
			return str; 
		}
		
		char[] newCharArray = new char[newSize];
		int index = 0;
		int count = 1; 
		char last = str.charAt(0);
		for( int i = 1 ; i < str.length() ; i ++) {
			if(last == str.charAt(i)) {
				count++;
			} else { 
				index = setChar(newCharArray, index, count, last);
				
				count = 1; 
				last = str.charAt(i);
			}
		}
		
		index = setChar(newCharArray, index, count, last);
		
		
		return String.valueOf(newCharArray);
	}

	private static int setChar(char[] newCharArray, int index, int count, char last) {
		newCharArray[index++] = last;
		char[] countStr = String.valueOf(count).toCharArray();
		for(char ch : countStr) { 
			newCharArray[index++] = ch;
		}
		return index;
	}

	private static int countCharInCompressedString(String str) {
		int size = 0; 
		int count = 1;
		char last = str.charAt(0);
		for( int i = 1; i < str.length(); i++) {
			if(last == str.charAt(i)) {
				count++;
			} else {
				size = size + 1 + String.valueOf(count).length();
				count = 1;
				last = str.charAt(i);
			}
		}
		size = size + 1 + String.valueOf(count).length();
		return size;
	}
	
	
}
