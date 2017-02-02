package com.javatest.recursion;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {
	
	private static StringBuffer insertCharAt(char first, String word, int j) {
		StringBuffer temp = new StringBuffer();
		temp.append(word.substring(0, j));
		temp.append(first);
		temp.append(word.substring(j));
		return temp;
	}
	
	//This solution takes 0(n !) time, since there are n! permutations. We cannot do better than this.
	public static List<String> getAllPermutations( String str) { 
		
		if(null == str) {
			return null; 
		}
		List<String> permutations = new ArrayList<>();
		
		if(str.length() == 0) {
			permutations.add("");
			return permutations;
		}
		
		char first = str.charAt(0);
		String reminder = str.substring(1);
		List<String> words = getAllPermutations(reminder);
		for( String word : words) {
			for( int j = 0 ; j <= word.length(); ++j) {
			StringBuffer temp = insertCharAt(first, word, j);
			permutations.add(temp.toString());
			
			}
		}
		return permutations;
	}

	

	
	/* Function to print permutations of string
	   This function takes three parameters:
	   1. String
	   2. Starting index of the string
	   3. Ending index of the string. */

	public static void getAllPermutations( char[] str, int start, int end, List<String> permutations) { 
		if(start == end ) { 
			permutations.add(String.valueOf(str));
			return ;
		} else { 
			for( int i = start; i <= end; ++i) {
				swapChars(str, start, i);
				 getAllPermutations(str, start +1, end, permutations);
				swapChars(str, start, i); //backtrack
			}
		}
		return;
	}

	private static void swapChars(char[] str, int j, int k) {
		char tmp = str[j] ;
		str[j] = str [k];
		str[k] = tmp;
	}
	
	
	public static void main(String[] args) {
		List<String> words = getAllPermutations("aac");
		System.out.println("using recurssion" + words);

		List<String> permutations = new ArrayList<>();
		getAllPermutations("aac".toCharArray(), 0, 2, permutations);
		System.out.println("using backtracking" + permutations);


	}

}
