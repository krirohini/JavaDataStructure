package com.blogspot.n00tc0d3r;

import java.util.Stack;

/**
 * http://n00tc0d3r.blogspot.com/2013/06/trapping-rain-water.html?view=flipcard
 * 
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * 
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In
 * this case, 6 units of rain water (blue section) are being trapped. Solution
 * 
 * What we can get from the given example? 
 * First, we need to skip initial zeros
 * if exist any since there is not left boundary to trap the water for those
 * buckets. Then, an intuitive idea is, starting from the first positive bar,
 * Mark it as left and move forward current to next bar. If current < left,
 * calculate the difference, store it in a temporary sum, and move forward to
 * next bar; Otherwise, add the temporary sum to the total volume, and continue
 * to step 1. But this will fail the case of [2, 1, 0, 1], where the expected
 * result is 1 but 0 will be returned from the above procedure. A fix is when we
 * hit the end of the given array and if left is not current, go backwards to
 * calculate the volume until we hit left.
 */
public class TrappingRainWater {
	private int getVolume(int[] arr, boolean isForward, int end, int []boundary) {  
		// skip zeros , for both forward and backward  
		int cur = (isForward ? 0 : arr.length -1);  

		while (cur != end && arr[cur] == 0) {  
			cur += (isForward ? 1 : -1);  
		}  

		// calculate trapped volume  
		int vol = 0, left = cur;  
		for (int i=cur, tempSum=0; i!=end; i+=(isForward ? 1 : -1)) {  
			if (arr[i] >= arr[left]) {  
				vol += tempSum;  
				// reset  
				tempSum = 0;  
				left = i;  
			} else {  
				tempSum += (arr[left] - arr[i]);  
			}  
		}  
		boundary[0] = left;  
		return vol;  
	}  

	public int trap(int[] arr) {  
		int[] boundary = new int[1];  
		//int boundary = 0; it will not work as value of boundry will not change inside function call  
		int vol = getVolume(arr, true, arr.length, boundary);  
		vol += getVolume(arr, false, boundary[0]-1, boundary);  

		return vol;  
	}  
	
	/*
	 * Solution - Stack
	 * 
	 * This problem is similar to the problem of finding Largest Rectangle in
	 * Histogram.
	 *  So, we can use a similar strategy here: Use Stack to store the
	 * index of a bar; If the current one is smaller then the top of the stack,
	 * push it to stack; Otherwise, pop up the top until stack is empty or top
	 * is greater than the current one, add up the volume, push the current one
	 * to stack. The tricky part is what is the volume to be added each time
	 * when we pop up a value from the stack.
	 */
	
	public int trapStack(int[] A) {  
		   // skip zeros  
		   int cur = 0;  
		   while (cur < A.length && A[cur] == 0) ++cur;  
		   
		   // check each one  
		   int vol = 0;  
		   Stack<Integer> stack = new Stack<Integer>();  
		   while (cur < A.length) {  
		     while (!stack.isEmpty() && A[cur] >= A[stack.peek()]) {  
		       int b = stack.pop();  
		       if (stack.isEmpty()) break;  
		       vol += ((cur - stack.peek() - 1) * (Math.min(A[cur], A[stack.peek()]) - A[b]));  
		     }  
		     stack.push(cur);  
		     ++cur;  
		   }  
		   
		   return vol;  
		 }
	public static void main(String[] args) {
		TrappingRainWater trw = new TrappingRainWater();
		//int [] array = new int [] {0,1,0,2,1,0,1,3,2,1,2,1};
		int [] array = new int [] {2,1,0,1,2};
		//System.out.println("trap: volumn is  " + trw.trap(array));
		System.out.println("trapStack: volumn is " + trw.trapStack(array));
	}
}
