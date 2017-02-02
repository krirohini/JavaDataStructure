package com.javatest.recursion;

public class CountWays {

	
	public static long countWaysRec(int stepsLeft) { 
		if( stepsLeft < 0 ) {
			return 0;
		} else if (stepsLeft == 0) {
			return 1;
		} else { 
		
		return  countWaysRec(stepsLeft -1) + 
				countWaysRec(stepsLeft - 2 ) + 
				countWaysRec(stepsLeft -3);
		}
	}
	
	public static long countWaysDP(int stepsLeft, long[] counter) { 
		if( stepsLeft < 0 ) {
			return 0;
		} else if (stepsLeft == 0) {
			return 1;
		} else if( counter[stepsLeft] > 0) {
			return counter[stepsLeft];
		} else { 
		
			counter[stepsLeft] =   countWaysRec(stepsLeft -1) + 
					countWaysRec(stepsLeft - 2 ) + 
						countWaysRec(stepsLeft -3);
			return counter[stepsLeft];
		}
	}
	
	
	public static void main(String[] args) {
		long[] counter = new long[100];
//		System.out.println(countWaysRec(0));
//		System.out.println(countWaysRec(1));
//		System.out.println(countWaysRec(2));
//		System.out.println(countWaysRec(3));
		System.out.println(countWaysRec(16));
		System.out.println(countWaysDP(16, counter));
	}

}
