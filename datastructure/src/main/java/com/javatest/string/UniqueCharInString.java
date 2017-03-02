package com.javatest.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 *  What if you can not use additional data structures?
 *  Time complexity is O(n), where n is the length of the string, and space complexity is O(n).
 */

/* Implement an algorithm to determine if a string has all unique 
 * characters. What if you cannot use additional data structures?
 */
public class UniqueCharInString {

	/* Assumes that the String only has ASCII characters
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
	public static boolean IsUniqueCharInString( String str) {
		boolean [] char_set = new boolean[256];
		for(int i = 0; i < str.length(); i++) {
			int ch = str.charAt(i);
			if(char_set[ch]){
				return false; 
			} else {
				char_set[ch] = true;
			}
		}
			return true;
	}
	

    /* Time complexity: O(n)
     * Space complexity: O(n)
     */
	public static boolean IsUniqueCharInStringWithSet(String str) {
        HashSet<Character> h = new HashSet<Character>();

        for(int i = 0; i < str.length(); i++) {
            if(h.contains(str.charAt(i)))
                return false;

            h.add(str.charAt(i));
        }

        return true;
    }
	public static boolean IsUniqueCharInStringWithMap( String str) {
		
		Map <Character, Integer> map = new HashMap<Character, Integer>();
		
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
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
