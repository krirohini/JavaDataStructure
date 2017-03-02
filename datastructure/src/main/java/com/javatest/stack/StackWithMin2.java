package com.javatest.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * 3.2 How would you design a stack which, in addition to push and pop, also has
 * a function min which returns the minimum element? Push, pop and min should
 * all operate in O(1) time.
 *
 */
public class StackWithMin2 extends Stack<Integer> {
	
	Stack<Integer> minStack;
	StackWithMin2 () {
		minStack = new Stack<>();
	}
	
	public Integer min() {
		if(minStack.isEmpty()) {
			return Integer.MAX_VALUE;
		}
		return minStack.peek();
	}
	public Integer pop() {
		int value = super.pop();
		if( value == min()) {
			minStack.pop();
		}
		return value;
	}
	
	public void push2(Integer value) {
		if(value <= min()) {
			minStack.push(value);
		}
		super.push(value);	
		

	}
	
	public static void main(String[] args) {
	
		StackWithMin2 stack = new StackWithMin2();
		stack.push2(12);
		stack.push2(22);
		stack.push2(11);
		stack.push2(32);
		stack.push2(2);
		
		System.out.println(Arrays.toString(stack.toArray()));
		System.out.println(stack.min());
		stack.pop();
		System.out.println(Arrays.toString(stack.toArray()));
		System.out.println(stack.min());
	}

}
