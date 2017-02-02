package com.javatest.recursion;

public class fibonacci {
	
	//The Fibonacci Sequence is the series of numbers: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 
	
	public static int fibonacciRecu( int num) {
		if( num ==0 ) return 0;
		if( num == 1 ) return 1;
		
		return fibonacciRecu(num -1) + fibonacciRecu(num -2);
		
	}
	
	public static int max = 100;
	public static int [] fib = new int[max];
	
	public static int fibonacciDP( int num) {
		if( num ==0 ) return 0;
		if( num == 1 ) return 1;
		if(fib[num ] != 0 ) return fib[num];
		return fibonacciRecu(num -1) + fibonacciRecu(num -2);
		
	}
	
	public static void main(String[] args) {
		
//		System.out.println(fibonacciRecu(0));
//		System.out.println(fibonacciRecu(1));
//		System.out.println(fibonacciRecu(2));
//		System.out.println(fibonacciRecu(3));
//		System.out.println(fibonacciRecu(4));
//		System.out.println(fibonacciRecu(5));
//		System.out.println(fibonacciRecu(45));
		
//		System.out.println(fibonacciDP(0));
//		System.out.println(fibonacciDP(1));
//		System.out.println(fibonacciDP(2));
//		System.out.println(fibonacciDP(3));
//		System.out.println(fibonacciDP(4));
//		System.out.println(fibonacciDP(5));
		System.out.println(fibonacciDP(45));
		
	}

}
