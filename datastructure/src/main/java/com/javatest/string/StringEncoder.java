package com.javatest.string;

public class StringEncoder {

	
	public static String replaceSpaces(char[] str) {
		 int length = str.length;
		int spaceCount = 0, newLength;
		for (int i = 0; i < length; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}
		newLength = length + spaceCount * 2;
		char [] str2 = new char [newLength];
		//str2[newLength] = '\0';
		int index = newLength -1;
		for (int i = length - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				str2[index--] = '0';
				str2[index--] = '2';
				str2[index--] = '%';
				//index = index - 3;
			} else {
				str2[index -- ] = str[i];
				//index = index - 1;
			}
		}
		
		return String.copyValueOf(str2);
		
	}
	
	public static String replaceSpaces2(char[] str) {
		 int length = str.length;
		int spaceCount = 0, newLength;
		for (int i = 0; i < length; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}
		newLength = length + spaceCount * 2;
		char [] str2 = new char [newLength];
		//str2[newLength] = '\0';
		int index = newLength -1;
		for (int i = length - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				str2[index ] = '0';
				str2[index - 1] = '2';
				str2[index - 2] = '%';
				index = index - 3;
			} else {
				str2[index ] = str[i];
				index = index - 1;
			}
		}
		
		return String.copyValueOf(str2);
		
	}
	public static void main(String[] args) {
		
		String str = "this is a new url ";
		char  [] char2 = str.toCharArray();
		
		String replaceFun = replaceSpaces(char2);
		
		System.out.println(replaceFun);

	}

}
