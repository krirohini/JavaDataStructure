package com.javatest.string;

import java.util.Arrays;

public class uniqueString {

	public static boolean uniqueString( String str) {
		boolean [] charArr = new boolean[256];
		for ( char ch : str.toCharArray()) {
			if(charArr[ch]) {
				return false;
			} else {
				charArr[ch ] = true;
			}
		}
		
		return true;
	}
	
	
	public static String reverseString(String str) {
		char [] charArray = new char[str.length()];
		
		for ( int start = 0, end = str.length() -1; start <= end ; start++, end --) {
			char tmp = str.charAt(start);
			charArray[start] = str.charAt(end);
			charArray[end] = tmp; 
		}
		
		return String.valueOf(charArray);
	}

	
	public static void isAnagram( String s1 , String s2) { 
		
		boolean status = true; 
		
		
		String s1Copy = s1.replaceAll("\\s", "").toLowerCase(); 
		String s2Copy = s2.replaceAll("\\s",  "").toLowerCase();
		
		if(s1Copy.length() != s2Copy.length()){
			status = false ;
		} else {
			
			
			int [] countArray = new int[256];
			for(char ch : s1Copy.toCharArray()) { 
				countArray[ch]++;
			}
			
			for(char ch : s2Copy.toCharArray()) {
				
				if(--countArray[ch] <0) {
					status = false ; 
					break;
				}
			}
			
		}
		
		if(status)
		{
			System.out.println(s1+" and "+s2+" are anagrams");
		}
		else
		{
			System.out.println(s1+" and "+s2+" are not anagrams");
		}

	}
	
	public static void isAnagram2( String str1 , String str2) { 
		boolean status = true; 
		String str1Copy = str1.replaceAll("\\s", "").toLowerCase();
		  
		String str2Copy = str2.replaceAll("\\s", "").toLowerCase();
		if(str1Copy.length() != str2Copy.length()) {

			status =  false; 
		} else { 

			char[] s1Array = str1Copy.toCharArray();
			char[] s2Array = str2Copy.toCharArray();

			Arrays.sort(s1Array);
			Arrays.sort(s2Array);

			status =  Arrays.equals(s1Array, s2Array);
		}

		if(status)
		{
			System.out.println(str1+" and "+str2+" are anagrams");
		}
		else
		{
			System.out.println(str1+" and "+str2+" are not anagrams");
		}


	}
	
	
	public static void main(String[] args) {
		
		String str = "abcd2";
		System.out.println(uniqueString(str));
		System.out.println(reverseString(str));
		
		// isAnagram("Mother In Law", "Hitler Woman");
		 
	        isAnagram("keEp", "peeK");
	 
	        isAnagram("SiLeNt CAT", "LisTen AcT");
	 
	        isAnagram("Debit Card", "Bad Credit");
	}
}
