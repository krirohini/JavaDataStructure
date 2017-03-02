package com.javatest.stack;

public class MyStack {
	Node top;
	
	class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public void push(int data) {
		Node node = new Node(data);
		node.next = top;
		top = node;
	}
	
	public int pop () {
		if(top != null) {
			int data = top.data;
			top = top.next;
			return data;
		}
		return Integer.MIN_VALUE;
		
	}
	
	public int peek() {
		return top.data;
	}
 	
	public void print() {
 
		if(top == null) {
			System.out.println("Empty Stack");
			return;
		} else {
			System.out.print("Top ->");
		}
		Node cur = top; 
		while( cur != null) {
			System.out.print(cur.data + "->");
			cur = cur.next;
		}
		System.out.println("Bottom");
	}
	
	
	public static void main(String[] args) {
		MyStack stack = new MyStack();
		stack.print();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.print();
		stack.pop();
		stack.print();
		System.out.println(stack.peek());
		stack.print();
	}

}
