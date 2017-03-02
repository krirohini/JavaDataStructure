package com.spyrant.algorithm;
//Fibonacci Series using Recursion
class fibonacci
{
    static int fib(int n)
    {
    if (n <= 1)
       return n;
    return fib(n-1) + fib(n-2);
    }
    
    static int fibIterative(int n)
    {
      int a = 0, b = 1;
      if( n == 0)
        return a;
      for (int i = 2; i <= n; i++)
      {
         int c = a + b;
         a = b;
         b = c;
      }
      return b;
    }
    
    static int fibDP(int n)
    {
    	if( n <= 1) {
    		return n;
    	}
    	/* Declare an array to store Fibonacci numbers. */
    	int f[] = new int[n+1];
    	int i;

    	/* 0th and 1st number of the series are 0 and 1*/
    	f[0] = 0;
    	f[1] = 1;

    	for (i = 2; i <= n; i++)
    	{
    		/* Add the previous 2 numbers in the series
         and store it */
    		f[i] = f[i-1] + f[i-2];
    	}

    	return f[n];
    }
      
    public static void main (String args[])
    {
    	int n = 9;
    	for ( int i = 0; i <= 9 ; i++) {
    		System.out.println("fib for i " + i + " is: " + fibIterative(i));
    	}
    }
}
