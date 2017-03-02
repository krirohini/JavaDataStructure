package com.javatest.string;

import java.util.Scanner;

/**
* URL: http://www.careercup.com/question?id=7449675
* Problem Description:
* Compress a given string "aabbbccc" to "a2b3c3"
* constraint: in-place compression, no extra space to be used
* assumption : output size will not exceed input size..
* ex input:"abb" -> "a1b2" buffer overflow.. such inputs will not be given.
*/

public class StringCompression {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
	//	String str = "aabcccccaaaaaaaaaaaaaaaa";
//		String str = "abcd";
		String compStr = compressString(str);
		System.out.println(compStr); 
	}
	
	

    public static String compressUsingBuffer(String str) {
        if(str.length() < 1)
            return str;

        StringBuilder buffer = new StringBuilder();

        char last = str.charAt(0);
        int count = 1;

        for(int i = 1; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(ch == last) {
                count++;
            } else {
                buffer.append(last);
                buffer.append(count);
                last = ch;
                count = 1;
            }
        }

        buffer.append(last);
        buffer.append(count);
        String newStr = buffer.toString();
        return str.length() <= newStr.length() ? str : newStr;
    }
    
//	The runtime is 0(p + k*2), where p is the size of the original string and k is the number
//	of character sequences.

	private static String compressString(String str) {
		if (str == null)
        {
            throw new IllegalArgumentException("str");
        
        }

		int newSize = countCompression(str);
		System.out.println(newSize);
		// cannot compress
		if(newSize > str.length()) { 
			return str;
		}
		
		char [] buffer = new char[newSize];
		int index = 0;
		char last = str.charAt(0);
		int count = 1; 
		 
		for(int i = 1 ; i <str.length() ; i ++) {
			if(last == str.charAt(i)) { // Found repeated character
				count++;
			} else{ 
				/* Update the repeated character count */
				index = setchar(buffer, last, count, index);
				last = str.charAt(i);
				count = 1;
			}
		}
		/* Update string with the last set of repeated characters. */
		index = setchar(buffer, last, count, index);
		
		return String.valueOf(buffer);
	}

	private static int setchar(char[] buffer, char last, int count, int index) {
		buffer[index++] = last;
		char [] numStr = String.valueOf(count).toCharArray();
		for ( char ch : numStr) {
			buffer[index++] = ch;
		}
		return index;
	}
	
	static int countCompression(String str) {
		int size = 0; 
		int count = 1;
		char last = str.charAt(0);
		for( int i = 1 ; i < str.length(); i++) {
			if(last == str.charAt(i) ) {
				count++; 
			} else {
				last = str.charAt(i); 
				size = size + 1 + String.valueOf(count).length();
				count = 1;
			}
		}
		size = size + 1 + String.valueOf(count).length();
		return size;
	}
}
