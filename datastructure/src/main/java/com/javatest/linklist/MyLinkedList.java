package com.javatest.linklist;


public class MyLinkedList {

	class Node {
		int data; 
		Node next;
		Node(int mData) {
			data = mData;
			next = null;
		}
	}
	
	public void print(Node head) {
		Node cur = head;
		while( cur != null) {
			System.out.printf( "%d -> ",cur.data);
			cur = cur.next;
		}
		System.out.println("null");
	}
	
	public int length ( Node head) {
		int count = 0; 
		Node cur = head; 
		while( cur != null) {
			count++;
			cur = cur.next;
		}
		return count;
	}
	
	//Push  on the front,
	public Node push ( Node head, int data) {
		Node tmp = new Node(data); 
		tmp.next = head;
		return tmp;
		
	}
	
	public Node pushAtEnd( Node head, int data) { 
		Node newNode = new Node(data);
		
		if( head == null) { 
			return newNode;
		}
		
		Node cur = head;
		// go to last Node
		while ( cur.next != null) { 
			cur = cur.next; 
		}
		cur.next = newNode;
		return head;
		
	}
	//Push  on the front,
	public Node pop ( Node head, Node popNode) {
		popNode = head; 
		return head.next;
	}
	
	public Node deleteNodeWithoutPrevious( Node head, int data) { 
		// special case 
		if(head == null) {
			return head;
		}
		
		if(head.data == data) {
			return head.next; // move head; 
		}
		// regular case 
		Node prev = head; 
		while(prev.next != null) {
			if(data == prev.next.data) {
				prev.next = prev.next.next;
				return head; // head did't change
			}
			prev = prev.next; 
		}
		return head;
	}
	
	//using extra pointer for previous 
	public Node deleteNode( Node head, int data) { 
		Node cur = head;
		Node prev = head; 
		if(cur.data == data) { 
			return cur.next; /* moved head*/
		}
		
		while ( cur != null) { 
			prev = cur; 
			if(cur.data == data) { 
				prev.next = cur.next; 
				return head; 
			}
			cur = cur.next; 
		}
		return head; 
	}
	
	// not very clear implementation 
	public Node clearList(Node head) {
		
		Node cur = head;
		Node next = null;
		
		while ( cur != null) {
			next = cur.next;
			cur.data = 0;
			cur = next;
		}
		return cur;
	}
	
	public Node buildOneTwoThree() {
 
		Node head = null;
		 head = push(head, 3);
		 head = push(head, 2);
		 head = push(head, 1);
		
		return head;
		
	}
	
	public Node getNth(Node head, int n) {
		
		Node cur = head;
		int counter = 1; 
		while ( cur != null ) {
			if(counter == n) {
				return cur;
			}
			cur = cur.next;
			counter++;
		}
		return null; 
	}
	
	/**
	 * 2.2 Implement an algorithm to find the nth to last element of a singly linked list.
	 */
	
	
	
	public static void main( String [] args) {
		MyLinkedList list = new MyLinkedList();
		
		basicTest(list);
		
	}

	private static void basicTest(MyLinkedList list) {
		Node head = null;
		//head = list.buildOneTwoThree();
		head = list.pushAtEnd(head, 3); 
		head = list.push(head, 2); 
		head = list.push(head, 1); 
		list.print(head);
		head = list.pushAtEnd(head, 4); 
		head = list.pushAtEnd(head, 5); 
		head = list.pushAtEnd(head, 6); 
		list.print(head);
		
		Node popNode = null;
		
		head = list.pop(head, popNode);
		list.print(head);
		///Todo :
		//.out.println("data at pop node is" + popNode.data);		
		System.out.println("list lenght is : "+ list.length(head) );
		Node nthNode = list.getNth(head, 2);
		System.out.printf("%d th node is %s", 2, (nthNode == null) ? "null" : String.valueOf(nthNode.data));
	}
	
	
}
