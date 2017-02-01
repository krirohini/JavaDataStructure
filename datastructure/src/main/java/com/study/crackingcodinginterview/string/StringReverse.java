package com.study.crackingcodinginterview.string;

public class StringReverse {

	public static String reverseString( String str) {
		if(null == str ) 
			return null;
		int length = str.length();
		if( length == 0 || length == 1) 
			return str; 
		
		StringBuffer strBuf = new StringBuffer();
		for( int i = str.length()-1; i >=0 ; i--) {
			strBuf.append(str.charAt(i));
		}
		return strBuf.toString();
		
	}
	
	public static void main(String[] args) {
		
		String str = "abcd"; 
		System.out.printf("String %s  : reverse String %s \n", str, reverseString(str));
		
		str = null; 
		System.out.printf("String %s  : reverse String %s \n", str, reverseString(str));
		str = ""; 
		System.out.printf("String %s  : reverse String %s \n", str, reverseString(str));
		
		
		
	}
}
