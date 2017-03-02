package com.ideserve.array;

import java.util.Arrays;

public class MaxSubarraySum {
	
	/**
	 * http://www.ideserve.co.in/learn/maximum-subarray-sum Given an array of
	 * unordered positive and negative integers, find the maximum subarray sum
	 * in the array. 
	 * For example: Array: {2, -9, 5, 1, -4, 6, 0, -7, 8}
	 *  Output:
	 * Maximum subarray sum is 9
	 * 
	 * @param args
	 */
	
	
	public static void main(String[] args) {
      //  int[] input = {2, -9, 5, 1, -4, 6, 0, -7, 8, 0 , -1};
        int[] input = {2, -9, 5, 1, -4, 6, 0, -9, 8, 0 , -1};
        System.out.println(Arrays.toString(input));
        System.out.println("Maximum subarray sum is " + findMaxSubarraySum(input));
        
    }

	private static int findMaxSubarraySum(int[] input) {
		
		
		int curSum = 0; 
		int maxSum = 0; 
		int startIndex = 0 , endIndex =0; 
				
		
		boolean hasAllNegativeNumbers = true;
	    int maxNegativeSum = Integer.MIN_VALUE;
		
		for ( int i =0 ; i < input.length ; i++) { 
			
			if(hasAllNegativeNumbers && input[i] >= 0) {
				hasAllNegativeNumbers = false;
			} else if(hasAllNegativeNumbers && input[i] < 0 && maxNegativeSum < input[i]) {
				maxNegativeSum = input[i];
			}
			
				curSum = curSum + input[i];  
				if(curSum < 0 ) { 
					curSum = 0;
					startIndex = i+1;
					
				}
				
				if(maxSum < curSum) {
					maxSum = curSum;
					endIndex = i;
				}
			
		}
		
		System.out.println("Start index" + startIndex );
		System.out.println("End index" + endIndex );
		
		 return hasAllNegativeNumbers ? maxNegativeSum : maxSum;
	}

}
