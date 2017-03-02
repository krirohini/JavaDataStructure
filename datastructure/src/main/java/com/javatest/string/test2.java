package com.javatest.string;

public class test2 {
	
	private static String replaceSpaces(String str) {
		int length = str.length();
	     char  [] charArray = str.toCharArray();
	     int spaceCount =0 ; 
	     
	     for ( int i = 0 ; i < length; i++ ) { 
	    	 if(' ' == str.charAt(i)) {
	    		 spaceCount++; 
	    	 }
	     }
	     
	     int newLenght = length + 2* spaceCount;
	     char [] newCharArray = new char[newLenght];
	     
	     for ( int i = length-1 ; i >= 0; i-- ) {
	    	 if(' ' == str.charAt(i)) { 
	    		 newCharArray[newLenght -1] = '0';
	    		 newCharArray[newLenght -2] = '2';
	    		 newCharArray[newLenght -3] = '%';
	    		 newLenght = newLenght -3; 
	    	 } else { 
	    		 newCharArray[newLenght -1] = str.charAt(i);
	    		 newLenght = newLenght -1;  
	    	 }
	     }
		return String.valueOf(newCharArray);
	}
	
	public static void main(String[] args) {
		
//	String str = "this is a new url";
//	String replaceFun = replaceSpaces(str);
//	System.out.println(replaceFun);
		
		String str = "aabcccccaaa";
		String compStr = compressString(str);
		System.out.println(compStr); 
}

	private static String compressString(String str) {
	     
		char [] newCharArray = new char[str.length() *2];
		
		int count = 1;
		char last = str.charAt(0);
		int index = 0;
		for ( int i =1 ; i< str.length() ; i++) {
			if(last == str.charAt(i) ) {
				count++; 
			} else {
				newCharArray[index++] = last; 
				//todo
				newCharArray[index++] = Character.forDigit(count, 10);
				last = str.charAt(i);
				count = 1;
			}
		}
		newCharArray[index++] = last; 
		newCharArray[index++] = Character.forDigit(count, 10);
		
		
		
		return String.valueOf(newCharArray);
	}

}
