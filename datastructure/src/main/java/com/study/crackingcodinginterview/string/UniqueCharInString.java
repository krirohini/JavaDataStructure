package com.study.crackingcodinginterview.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 *  What if you can not use additional data structures?
 *  Time complexity is O(n), where n is the length of the string, and space complexity is O(n).
 */


public class UniqueCharInString {

	public static boolean IsUniqueCharInString( String str) {
		boolean [] char_set = new boolean[256];
		for ( char ch : str.toCharArray() ) {
			if(char_set[ch]){
				return false; 
			} else {
				char_set[ch] = true;
			}
		}
			return true;
	}
	
	
	public static boolean IsUniqueCharInStringWithMap( String str) {
		
		Map <Character, Integer> map = new HashMap<Character, Integer>();
		
		for ( char ch : str.toCharArray() ) {
			if(map.get(ch) != null && map.get(ch).intValue() >= 1 ) {
				return false;	
			} else {
				map.put(ch, 1);
			}
		}
		
		return true;
		
	}
	
	public static void main(String[] args) {
		String str1 = new String("abcda");
		System.out.printf("Does String %s has unique with Map ch : %s \n", str1, Boolean.valueOf(IsUniqueCharInStringWithMap(str1)));
		System.out.printf("Does String %s has unique ch : %s \n", str1, Boolean.valueOf(IsUniqueCharInString(str1)));
	
			String str2 = new String("abcd2");
			System.out.printf("Does String %s has unique with Map ch : %s \n", str2, Boolean.valueOf(IsUniqueCharInStringWithMap(str2)));
			System.out.printf("Does String %s has unique ch : %s \n", str2, Boolean.valueOf(IsUniqueCharInString(str2)));
		
		
		
	}
}
