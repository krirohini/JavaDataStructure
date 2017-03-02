package com.javatest.recursion;

public class febonacci {
	
	static int [] map = new int[100]; 
	static public int getFibonacci( int n) { 
		

		return fib(n);
		
		
	}
		static public int fib( int n) { 
			if(n == 0 || n == 1) { 
				map[n] = n;
				return n; 
			}
			int fib1 = (map[n-1] ==0 ) ? fib(n-1) : map[n-1];
			int fib2 = (map[n-2] ==0 ) ? fib(n-2) : map[n-2];
			int fib =  fib1 + fib2;
			map[n] = fib;
			return fib; 
		}
	
//		static public int fibIter( int n) {
//			if(n == 0 || n == 1) { 
//				return n; 
//			}
//			
//			
//			
//			
//			
//		}
		
		
	public static void main(String[] args) {
		for( int i = 0 ; i < 10; i++)
		System.out.println(getFibonacci(i));
	}
	

}
