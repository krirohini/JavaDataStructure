package com.javatest.mystack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 3.6 Write a program to sort a stack in ascending order. 
 * You should not make any assumptions about how the stack is implemented. 
 * The following are the only functions that should be used to write this program: 
 * push | pop | peek | isEmpty.
 *
 */
public class SortStack {
	public static Stack<Integer> sort(Stack<Integer> source) {
		Stack<Integer> sorted = new Stack<>();
		while(!source.isEmpty()) { 
			Integer val = source.pop();
			while(!sorted.isEmpty() && val < sorted.peek()) {
				source.push(sorted.pop());
			}
			sorted.push(val);
		}
		
		return sorted; 
	}
	
	public static void main(String[] args) {
		Stack<Integer> unSorted = new Stack<>();
		unSorted.push(24);
		unSorted.push(2);
		unSorted.push(4);
		unSorted.push(40);
		System.out.println("UnSorted stack" + Arrays.toString(unSorted.toArray()));
		Stack<Integer> sorted = sort(unSorted);
		System.out.println("Sorted stack" + Arrays.toString(sorted.toArray()));
	}
}
