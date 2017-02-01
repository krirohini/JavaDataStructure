package com.vikash.array;

public class ArrayGroup {
	
	public static char [] groupArray( char [] charArray) {
		
		if( null == charArray) {
			throw new IllegalArgumentException("Input array is null");
		}
		int length = charArray.length;
		if(length == 0 || length == 1) {
			return charArray;
		}
		
		int start =0;
		int end = length -1; 
		
		while( start <= end) {
			while (charArray[start] == 'H' ) {
				start++;
			}
			
			while (charArray[end] == 'C') {
				end--;
			}
			if(start < end) {
				char temp = charArray[start]; 
				charArray[start] = charArray[end];
				charArray[end] = temp;
			}
		}
		
		return charArray;
		
	}

	public static void main( String [] args) {

		char[] resArray = groupArray("".toCharArray());
		System.out.println("out put for empty Array"); 
		System.out.println(resArray);
		 resArray = groupArray("H".toCharArray());
		System.out.println("out put for Array [H]" ) ; 
		System.out.println( resArray);
		 resArray = groupArray("C".toCharArray());
		System.out.println("out put for Array [C]" ) ; 
		System.out.println( resArray);
		 resArray = groupArray("HCHCHCHCHCHH".toCharArray());
		System.out.println("out put for Array [HCHCHCHCHCHH] : " ) ; 
		System.out.println( resArray);
	}
}
