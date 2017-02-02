package com.javatest.crackingcodinginterview.string;

public class StringAtoI {

	public int atoi ( String str) throws Exception { 
		char[] charArray = str.toCharArray();
		
//		boolean bNegative = false; 
//		if(charArray[0] == '-') {
//			bNegative = true;
//		}
		
		int res  = 0; 
		for ( char c : charArray) { 
			
			
			res = res * 10 + (c - '0');
			
			if(  res < 0 ) {
				throw new Exception("out of range");
			}
		}
		
		return res;
		
	}
	public static void main(String[] args) {
		long maxValue = Long.MAX_VALUE;
		StringAtoI obj = new StringAtoI();
		long res;
		try {
			int maxValue2 = Integer.MAX_VALUE;
			System.out.printf("%d\n", maxValue2);
			res = obj.atoi("1333323332234");
			System.out.println(res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
