package com.javatest.queue;

import java.util.Stack;
/**
 * 3.5 Implement a MyQueue class which implements a queue using two stacks.
 */
public class QueueUsingStack<T> {
	Stack<T> s1, s2; 
	
	QueueUsingStack() {
		this.s1 = new Stack<T>();
		this.s2 = new Stack<T>();
	}
	
	public int size() {
		return (s1.size() + s2.size());
	}
	
	public void add(T value) {
		s1.push(value);
	}
	
	public T peek() {
		if(false ==s2.isEmpty()) {
			return s2.peek();
		} 
		while(false == s1.isEmpty()) {
			s2.push(s1.pop());
		}
		return s2.peek();
	}
	
	public T remove () {
		if( false ==  s2.isEmpty()) {
			return s2.pop();
		}
		
		while(false == s1.isEmpty()) {
			s2.push(s1.pop());
		}
		return s2.pop();
	}

	

	public static void main(String[] args) {
		QueueUsingStack<Integer> queue = new QueueUsingStack<>(); 
		queue.add(1);
		queue.add(2);
		queue.add(3);
		System.out.println("removed element " + queue.remove());
		System.out.println("peep element " + queue.peek());
		System.out.println("removed element " + queue.remove());
		System.out.println("removed element " + queue.remove());
	}
}
