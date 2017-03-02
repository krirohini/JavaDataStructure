package com.javatest.string;

public class UrlShortner {

	public static void main(String[] args) {
		int n = 12345;
	    String shorturl = idToShortURL(n);
	    System.out.println("Generated short url is " +  shorturl);
	    System.out.println("Id from url is " + shortURLtoID(shorturl));
	   
	}

	private static long shortURLtoID(String shortURL) {
		
		long id = 0; // initialize result
		 
	    // A simple base conversion logic
	    for (int i=0; i < shortURL.length(); i++)
	    {
	    	shortURL.charAt(i);
	        if ('a' <= shortURL.charAt(i) && shortURL.charAt(i) <= 'z')
	          id = id*62 + shortURL.charAt(i) - 'a';
	        if ('A' <= shortURL.charAt(i) && shortURL.charAt(i) <= 'Z')
	          id = id*62 + shortURL.charAt(i) - 'A' + 26;
	        if ('0' <= shortURL.charAt(i) && shortURL.charAt(i) <= '9')
	          id = id*62 + shortURL.charAt(i) - '0' + 52;
	    }
	    return id;
	    
	
	}

	private static String idToShortURL(int n) {
		// Map to store 62 possible characters
	    String str =  "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789" ;
	    char [] map = str.toCharArray();
	    StringBuffer shorturl = new StringBuffer();
	    
	    while(n != 0) {
	    int index =	n % 62;
	    	char ch = map[index];
	    	shorturl.append(ch);
	    	n = n /62;
	    	
	    }
	    
	   return shorturl.reverse().toString();
	}
}
