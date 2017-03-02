package com.javatest.recursion;

public class CountWays {

	public static void main(String[] args) {
		
//		System.out.println(countWaysRec(0));
//		System.out.println(countWaysRec(1));
//		System.out.println(countWaysRec(2));
//		System.out.println(countWaysRec(3));
		System.out.println(countWaysRec(16));
		System.out.println(countWaysDP(7));
		System.out.println(countWays(7));
	}
	
	   public static long countWays( int n) {
	        long [] ways = new long[n+1]; 
	        /*ways[0] = 0; 
	        if ( n <  ) {
	            ways[1] = 1;
	            ways[2] = 1;
	        }*/
	        
	        return countWays( n , ways);
	    }

	    public static long countWays( int n, long [] ways) {
	        
	        if(n < 0) 
	            return 0;
	        if( n == 0  )
	            return 1; 
	       
	        if(ways[n] > 0) 
	            return ways[n];
	        
	        //int total = 0;
	        
	        ways[n] = countWays(n-1, ways) + countWays(n-2, ways) + countWays(n-3, ways) ;
	        return ways[n];
	    }
	    
	 /* A child is running up a staircase with n steps, and can hop either 1 
     * step, 2 steps, or 3 steps at a time. Implement a method to count how 
     * many possible ways the child can run up the stairs.
     */
	public static long countWaysRec(int stepsLeft) { 
		if( stepsLeft < 0 ) {
			return 0;
		} 
		if (stepsLeft == 0) {
			return 1;
		}		

		return  countWaysRec(stepsLeft - 1) + 
					countWaysRec(stepsLeft - 2 ) + 
					countWaysRec(stepsLeft - 3);
	}
	// Solution using dynamic programming
	
	public static long countWaysDP(int n) {
		long[] counter = new long[100];
        return countWaysDP(n, counter);
    }
	
	public static long countWaysDP(int stepsLeft, long[] counter) { 
		if( stepsLeft < 0 ) {
			return 0;
		} 
		if (stepsLeft == 0) {
			return 1;
		} 
		if( counter[stepsLeft] > 0) {
			return counter[stepsLeft];
		} 

			counter[stepsLeft] =   
					countWaysDP(stepsLeft - 1, counter) + 
					countWaysDP(stepsLeft - 2 , counter) + 
					countWaysDP(stepsLeft - 3, counter);
			return counter[stepsLeft];
	}

}
