package com.blogspot.n00tc0d3r;

import java.util.Stack;

/**
 * http://n00tc0d3r.blogspot.com/2013/03/largest-rectangle-in-histogram.html
 *
 */

public class LargestRectangleInHistogram {

	public static int largestRect(int[] arr, int l, int r) {  
		   if (l>=r) return 0;  
		   int min = arr[l], minId = l;  
		   // find the min and its index  
		   for (int i=l+1; i<r; ++i) {  
		     if (arr[i] < min) {  
		       min = arr[i];  
		       minId = i;  
		     }  
		   }  
		   return Math.max(min*(r-l),  
		       Math.max(largestRect(arr, l, minId), largestRect(arr, minId+1, r)));  
		 }  
		   
	public static int largestRectangleArea(int[] arr) {  
		   return largestRect(arr, 0, arr.length);  
	}  
	/**
	 * In most cases, we can use Stack to replace recursions. So is here.

For each height, we need to keep track the left boundary of the corresponding rectangle (that contains this height). We know that the left boundary is the left-most height that is greater or equal to this height.
We need to calculate the area when reaching the right boundary, where the right boundary is the right-most height that is greater or equal to this height.

For example, given height = [2,1,5,6,2,3]. We have

cur  left  index  area
 0    0    0(2)    0
 1    0    1(1)   2*1
 2    2    2(5)   2*1
 3    3    3(6)   2*1
 4    2    4(2)   6*1 5*2
 5    5    5(3)
                  5*2 3*1 2*4 1*6
	 */
	public static int largestRectangleAreaStack(int[] height) {  
		int area = 0;  
		// stack to store the indices of left boundary  
		// left boundary is the last height that is not lower than the current one  
		Stack<Integer> left = new Stack<Integer>();  
		Stack<Integer> index = new Stack<Integer>();  
		int cur = 0;  
		while (cur < height.length) {  
			if (cur == 0 || height[cur] > height[index.peek()]) {  
				left.push(cur);  
				index.push(cur);  
			} else if (height[cur] < height[index.peek()]) {  
				int last;  
				do {  
					last = left.pop();  
					area = Math.max(area, height[index.pop()] * (cur - last));  
				} while (!left.isEmpty() && height[cur] < height[index.peek()]);  
				
				left.push(last);  
				index.push(cur);  
			}  
			cur++;  
		}  
		// pop out values in index and left and calculate their areas  
		while (!index.isEmpty() && !left.isEmpty()) {  
			area = Math.max(area, height[index.pop()] * (height.length - left.pop()));  
		}  

		return area;  
	}  
	
	public static int largestRectangleAreaStackOptimize(int[] height) {  
		   Stack<Integer> left = new Stack<Integer>();  
		   int cur = 0, area = 0;  
		   while (cur < height.length) {  
		     if (left.isEmpty() || height[cur] >= height[left.peek()]) {  
		       // push to stack if we hit a greater or equal height  
		       left.push(cur++);  
		     } else {  
		       int top = left.pop();  
		       // the height at left.peek() must be smaller than the current one  
		       // so, the width of the rectangle is [left.peek()+1, cur)  
		       area = Math.max(area, height[top]*(left.isEmpty() ? cur : (cur-left.peek()-1)));  
		     }  
		   }  
		   while (!left.isEmpty()) {  
		       int top = left.pop();  
		       area = Math.max(area, height[top]*(left.isEmpty() ? cur : (cur-left.peek()-1)));  
		   }  
		   return area;  
		 } 
	
	public static void main(String[] args) {

		int [] array = new int [] {2,1,5,6,2,3};
//		System.out.println("Largest Rectangle In Histogram " + largestRectangleArea(array));
//		System.out.println("Largest Rectangle In Histogram using stack " + largestRectangleAreaStack(array));
		System.out.println("Largest Rectangle In Histogram using stack optimize " + largestRectangleAreaStackOptimize(array));
	}
		 
}
