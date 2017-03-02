package com.javatest.string;

import java.util.Arrays;
/* Given two strings, write a method to decide if one is a permutation of 
 * the other */

public class StringAnagram {
	static void isAnagram(String s1, String s2) {
		boolean status = isAnagramUsingSort(s1,s2);
		//Output
		if(status) {
			System.out.println(s1+" and "+s2+" are anagrams");
		} else { 
			System.out.println(s1+" and "+s2+" are not anagrams");
		}
	}

	/* Time complexity: O(n lg n)
	 * Space complexity: O(n)
	 */
	static boolean isAnagramUsingSort(String s1, String s2) {
		if(s1 == null || s2 == null) {
			throw new IllegalArgumentException("String can't be null"); 
		} 
		
		//Removing all white spaces from s1 and s2
		String copyOfs1 = s1.replaceAll("\\s", "");
		String copyOfs2 = s2.replaceAll("\\s", "");

		if(copyOfs1.length() != copyOfs2.length()) {
			//Setting status as false if copyOfs1 and copyOfs2 doesn't have same length
			return false;
		} 

		//Changing the case of characters of both copyOfs1 and copyOfs2 and converting them to char array
		char[] s1Array = copyOfs1.toLowerCase().toCharArray();
		char[] s2Array = copyOfs2.toLowerCase().toCharArray();

		//Sorting both s1Array and s2Array
		Arrays.sort(s1Array);
		Arrays.sort(s2Array);
		//Checking whether s1Array and s2Array are equal
		return Arrays.equals(s1Array, s2Array);
	}

	public static void isAnagramUsingMap(String s1, String s2) {

		boolean status = isAnagramUsingMap2(s1,s2);
		if (status) {
			System.out.println(s1 + " and " + s2 + " are anagrams");
		} else {
			System.out.println(s1 + " and " + s2 + " are not anagrams");
		}
	}

	public static boolean isAnagramUsingMap2(String s1, String s2) {

		if(s1 == null || s2 == null) {
			throw new IllegalArgumentException("String can't be null"); 
		} 

		// normalize string , remove spaces and make lower case
		//Removing white spaces from s1 and s2 and converting case to lower case
		String s1Copy = s1.replaceAll("\\s", "").toLowerCase();
		String s2Copy = s2.replaceAll("\\s", "").toLowerCase();

		if (s1Copy.length() != s2Copy.length()) {
			return false;
		} 

		int[] countArray = new int[256];
		for( int i = 0 ; i < s1Copy.length(); i++) { 
			char ch = s1Copy.charAt(i);
			countArray[ch]++;
		}

		for( int i = 0 ; i < s2Copy.length(); i++) { 
			char ch = s2Copy.charAt(i);
			if (--countArray[ch] < 0) {
				return false;
			}
		}
		return true;
	}

	public static boolean isAnagramEfficient(String s1, String s2) {
		if(s1 == null || s2 == null) {
			throw new IllegalArgumentException("String can't be null"); 
		} 

		// normalize string , remove spaces and make lower case
		//Removing white spaces from s1 and s2 and converting case to lower case
		String s1Copy = s1.replaceAll("\\s", "").toLowerCase();
		String s2Copy = s2.replaceAll("\\s", "").toLowerCase();

		if (s1Copy.length() != s2Copy.length()) {
			return false;
		} 

		int[] letters = new int[256];
		int num_unique_chars = 0;
		int num_completed_t = 0;

		for( int i = 0 ; i < s1Copy.length(); i++) {  // count number of each char in s.
			int ch = (int) s1Copy.charAt(i);
			if (letters[ch] == 0) {
				++num_unique_chars;
			}
			++letters[ch];
		}

		for( int i = 0 ; i < s2Copy.length(); i++) { 
			int ch = (int) s2Copy.charAt(i);
			if (letters[ch] == 0) { // Found more of char c in t than in s.
				return false;
			}
			--letters[ch];
			if (letters[ch] == 0) {
				++num_completed_t;
				if (num_completed_t == num_unique_chars) {
					// it’s a match if t has been processed completely
					return ( i == s2Copy.length() - 1);
				}
			}
		}
		return false;
	}


	public static void main(String[] args)
	{
		isAnagram("Mother In Law", "Hitler Woman");

		isAnagram("keEp", "peeK");

		isAnagram("SiLeNt CAT", "LisTen AcT");

		isAnagram("Debit Card", "Bad Credit");

		isAnagram("School MASTER", "The ClassROOM");

		isAnagram("DORMITORY", "Dirty Room");

		isAnagram("ASTRONOMERS", "NO MORE STARS");

		isAnagram("Toss", "Shot");

		isAnagram("joy", "enjoy");
	}
}
