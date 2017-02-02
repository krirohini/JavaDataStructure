package com.javatest.crackingcodinginterview.string;

public class StringRemoveDuplicates {

	/**
	 * Design an algorithm and write code to remove the duplicate characters in a string without 
	 * using any additional buffer. NOTE: One or two additional variables are fine.
	 *  An extra copy of the array is not.
		FOLLOW UP
	 *		Write the test cases for this method.
	 * 
	 */

	public static String removeDuplicateChars2(String str) { 
		
		System.out.println("before remove duplicate " + str );
		if(null == str ){
			System.out.println("return as input string is null");
			return null;
		}
		
		int length = str.length();
		if(length <2 ) {
			System.out.println("after remove duplicate " + str);
			return str;
		}
		
		boolean [] visitedSet = new boolean[256];
		char[] charArray = str.toCharArray();

		visitedSet[charArray[0]] = true;
		
		int tail =1; 
		
		for( int i = 1 ; i < length ; ++i) { 
			char charAt = charArray[i];
			if(!visitedSet[charAt]) {
				charArray[tail] = charAt;
				++tail;
				visitedSet[charAt] = true;
			} 
		}
		charArray[tail] = 0;
		
		String str2 = new String(charArray);
		System.out.println("after remove duplicate " + str2 );
		
		
		return str;
	}
	
public static String removeDuplicateChars(String str) { 
		
		System.out.println("before remove duplicate " + str );
		if(null == str ){
			System.out.println("return as input string is null");
			return null;
		}
		
		int length = str.length();
		if(length <2 ) {
			System.out.println("after remove duplicate " + str);
			return str;
		}
		
		boolean [] visitedSet = new boolean[256];
		StringBuffer strBuf = new StringBuffer();
	

//		visitedSet[str.charAt(0)] = true;
//		strBuf.append(str.charAt(0));
		
		for( int i = 0 ; i < length ; ++i) { 
			
			if(!visitedSet[str.charAt(i)]) {
				strBuf.append(str.charAt(i));
				visitedSet[str.charAt(i)] = true;
			} 
		}

		
		String str2 = strBuf.toString();
		System.out.println("after remove duplicate " + str2 );
		
		
		return str;
	}
	
	public static void main(String[] args) {
		removeDuplicateChars("aabcbdcabccdadde");
		removeDuplicateChars("");
		removeDuplicateChars(null);
		removeDuplicateChars("1");
		
		

	}
}
