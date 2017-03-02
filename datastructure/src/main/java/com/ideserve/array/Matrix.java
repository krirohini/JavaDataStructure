package com.ideserve.array;

public class Matrix {
	static int [] map = new int [10]; 

	public static void main(String[] args) {
		matrixPrint();

		map[0] = 0;
		map[1] = 1;
		for(int i = 0 ; i <10; i++) { 
			System.out.printf(" fibonacci if %d is %d and itr %d\n", i,  fibonacciDP2(i), fibonacciItr(i));
		}
	}


	public static int fibonacciItr(int n) {
		if(n == 0 || n == 1 ) return n;
		
		int a = 0, b = 1;
		int sum = a; 
		for(int i = 2; i <= n; i++) {
			sum = a + b ; 
			a = b;
			b = sum;
		}
		return sum;
	}
	
	public static int fibonacciDP2(int n) {
		 
		if(n == 0 || n == 1 ) return n;
		
		int [] arr = new int[n+1];
		arr[0] = 0 ; 
		arr[1] = 1; 
		for( int i = 2; i <= n; i++) {
			arr[i] = arr[i-1] + arr[i-2];
		}
		return arr[n];
		
	}
	
	
	
	
	
	public static int fibonacciDP(int n) {
		 
		if(n == 0 || n == 1 ) return n;
		
		int value = 0; 
		if(map[n-1] != 0 ) {
			value += map[n-1]; 
		} else {
			value += fibonacciDP(n-1);
		}
		if(map[n-2] != 0 ) {
			value += map[n-2]; 
		} else {
			value += fibonacciDP(n-2);
		}
		return value;
		
	}
	
	public static int fibonacci(int n) {
		if(n == 0 || n == 1 ) return n;
		return fibonacci(n-1) + fibonacci(n-2); 
	}


	private static void matrixPrint() {
		int [] [] matrix = new int [] [] 
				{ { 1,0,1 } ,
			{ 0,1,0 },
			{ 1,0,1} };

			for (int i = 0 ; i < 3; i++) {
				for( int j = 0; j <= i; j++) {
					System.out.print(matrix[i][j] + " ");
				}
				System.out.println("");
			}
	}
}
