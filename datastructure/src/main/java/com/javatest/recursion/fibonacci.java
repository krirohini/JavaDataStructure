package com.javatest.recursion;

import java.util.Scanner;

public class fibonacci {
	
	//The Fibonacci Sequence is the series of numbers: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 
	
	public static int fibonacciRecu( int num) {
		if( num ==0 ) return 0;
		if( num == 1 ) return 1;
		
		return fibonacciRecu(num -1) + fibonacciRecu(num -2);
		
	}
	
	public static int fibonacciDP(int n) {
		if( n < 0) return 0; 

		int [] fib = new int[n+1]; 
		fib[0] = 0;
		if(n > 0 ) { 
			fib[1] = 1;
		} 
		return fibonacciDP(n, fib);
	}
	public static int fibonacciDP(int n, int [] fib) {
		if( n < 0) return 0; 

		if(fib[n] > 0) return fib[n];

		fib[n]=  fibonacciDP( n-1, fib) + fibonacciDP( n-2, fib);
		return fib[n];

	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        
		for ( int i = 0 ; i <= n ; i++ ) { 
			System.out.printf("fibonacciRecu of %d is %d \n", i, fibonacciRecu(i));
			System.out.printf("fibonacciDP of %d is %d \n", i, fibonacciDP(i));
		} 
		
	}

}
