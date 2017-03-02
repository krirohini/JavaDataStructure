package com.javatest.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class StackWithMin3 extends Stack<Integer> {
	
	Stack<Integer> min;
	StackWithMin3() {
		min = new Stack<Integer> ();
	}
	
	public void push2(Integer val) {
		
		if(val <= min()) {
			min.push(val);
		}
		super.push(val);
	}
	
	public Integer pop() {
		Integer val = super.pop();
		if(val == min()) {
			min.pop();
		}
		return val;
		
	}
	
	public Integer min() {
		if(min.isEmpty()) {
			return Integer.MAX_VALUE;
		} else { 
			return min.peek();
		}
	}
	
	
	public static void main(String[] args) {
	
		StackWithMin3 stack = new StackWithMin3();
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
