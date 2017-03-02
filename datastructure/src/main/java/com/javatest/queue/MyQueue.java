package com.javatest.queue;

public class MyQueue {
	
	Node first, last; 
	
	MyQueue () {
		first = null;
		last = null;
	}
	class Node {
		Integer data;
		Node next;
		
		public Node(Integer data) {
			this.data = data;
			this.next = null;
		}
	}

	public void enqueue( Integer data) {
		Node node = new Node(data);
		
		// empty Queue
		if(first == null && last == null) {
			last = node;
			first = last;
			
		} else {
			last.next = node;
			last = node;
		}
	}
	
	public Integer dequeue() {
		 
		if( first == null) {
			return null;
		} else {
			Node cur = first;
			if(first == last) {
				last = null;
			}
			first = first.next; 
			return cur.data;
		}
		
	}
	
	public void print() {
		Node cur = first; 
		
		if(first == null ) {
			System.out.println("Empty Queue");
			return; 
		}
		System.out.print("Front -> ");
		while( cur != last.next) {
			System.out.print(cur.data + "->");
			cur = cur.next;
		}
		System.out.println(" End");
	}
	
	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.print();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.print();
		System.out.println(queue.dequeue());
		queue.print();
	}
}
