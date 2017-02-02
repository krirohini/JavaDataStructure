package com.javatest.recursion;

import java.util.ArrayList;

public class ParenthesesCombiations {


	public static void addParen(ArrayList<String> list, 
			int leftRem, int rightRem, 
			char[] str, int count) 
	{
		// Invalid 
		if (leftRem < 0 || rightRem < leftRem) { 
			return; // invalid state 
		}

		// boundry condition 
		if (leftRem == 0 && rightRem == 0) { /* no more parens left */
			String s = String.copyValueOf(str);
			list.add(s);
		} else {
			
			/* Add left paren, if there are any left parens remaining. */
			if (leftRem > 0) {
				str[count] = '(';
				addParen(list, leftRem - 1, rightRem, str, count + 1);
			}

			/* Add right paren., if expression is valid */
			if (rightRem > leftRem) {
				str[count] = ')';
				addParen(list, leftRem, rightRem - 1, str, count + 1);
			}
		}
	}

	public static ArrayList<String> generateParens(int count) {
		char[] str = new char[count*2];
		ArrayList<String> list = new ArrayList<String>();
		addParen(list, count, count, str, 0);
		return list;
	}

	public static void main(String[] args) {
		ArrayList<String> strList= generateParens(3);
		
		System.out.println(strList);

	}

}
