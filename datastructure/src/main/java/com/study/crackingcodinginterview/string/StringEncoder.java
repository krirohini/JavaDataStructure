package com.study.crackingcodinginterview.string;

public class StringEncoder {

	
	public static String ReplaceFun(char[] str) {
		 int length = str.length;
		int spaceCount = 0, newLength, i = 0;
		for (i = 0; i < length; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}
		newLength = length + spaceCount * 2;
		char [] str2 = new char [newLength];
		//str2[newLength] = '\0';
		for (i = length - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				str2[newLength - 1] = '0';
				str2[newLength - 2] = '2';
				str2[newLength - 3] = '%';
				newLength = newLength - 3;
			} else {
				str2[newLength - 1] = str[i];
				newLength = newLength - 1;
			}
		}
		
		return String.copyValueOf(str2);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String str = "this is a new url";
		char  [] char2 = str.toCharArray();
		
		String replaceFun = ReplaceFun(char2);
		
		System.out.println(replaceFun);

	}

}
