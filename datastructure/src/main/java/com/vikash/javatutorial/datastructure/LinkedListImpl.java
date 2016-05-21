package com.vikash.javatutorial.datastructure;


import java.util.Random;

public class LinkedListImpl {

	private Node head;
	
	static class Node {
		int data;
		Node next=null;

		Node(int value) {
			data = value;
			next = null;
		}

		public int size(Node head) {
			// TODO Auto-generated method stub
			return 0;
		}
	}
	
	public LinkedListImpl() {
		head = null;
	}

	public void addAtBeg(int num) {
		Node tNode = new Node(num);
		if (head == null) {
			head = tNode;
			return;
		} else {
			tNode.next = head;
			head = tNode;
		}
	}

	public void addAtEnd(int num) {
		Node tNode = new Node(num);
		if (head == null) {
			head = tNode;
			return;
		}
		Node curNode = head;
		while(curNode != null) {
			if(curNode.next == null) {
				curNode.next = tNode;
				return;
			}
			curNode = curNode.next;
		}
	}
	
	public void traverse() {
		if(head == null) {
			System.out.println("empty list");
			return;
		}
		Node curNode = head;
		System.out.print("|");
		while (curNode != null) {
				System.out.print(curNode.data + "|->|");
				curNode = curNode.next;
		}
		System.out.println("null|");
	}
	public int size() {
		int count = 0;
		if(head == null) {
			return count;
		}
		Node curNode = head;
		while (curNode != null) {
			//count = count++;
			count = count +1;
			curNode = curNode.next;
		}
		return count;
	}
	
	public void reverseListIterative() {
		Node preNode = null;
		Node curNode = head;
		Node nextNode = null;
		
		while(curNode != null){
			nextNode = curNode.next;
			curNode.next = preNode;
			preNode = curNode;
			curNode = nextNode;
		}
		
		head = preNode;
	}	
	public void reverseListRecurssive() {
		
		reverseUtil(head, null);
	}
	// A simple and tail recursive function to reverse
    // a linked list.  prev is passed as NULL initially.
    Node reverseUtil(Node curNode, Node preNode) {
 
        /* If last node mark it head*/
        if (curNode.next == null) {
            head = curNode;
 
            /* Update next to prev node */
            curNode.next = preNode;
            return null;
        }
 
        /* Save curr->next node for recursive call */
        Node nextNode = curNode.next;
 
        /* and update next ..*/
        curNode.next = preNode;
 
        reverseUtil(nextNode, curNode);
        return head;
    }
	
	/**
	 * There is linked list of millions of node and you do not know the length of it. 
	 * Write a function which will return a random number from the list.
	 */
	/*public int randomNode(){
			Random ran = new Random();
			int ranNode = ((Object) head).get(ran.nextInt((head).size(head)));
			return ranNode;
	}
		*/
	
	/**
	 * Given two linked lists, return the intersection of the two lists: 
	 * i.e. return a list containing only the elements that occur in both of the input lists.
	 */
	//public void commonElementsOfTwoList(Node node1, Node node2){
	public void commonElementsOfTwoList(LinkedListImpl list1, LinkedListImpl list2){
		Node comnNode;
		LinkedListImpl comnListData = new LinkedListImpl();
		if(list1 == null || list2 == null) {
			System.out.println("One of the list is Empty.");
		}else{
			//Node curNode2 = head2;
			Node curNode = head;
			Node curNode2 = head;
			
			//System.out.print("|");
			while (curNode != null) {
				while(curNode2 != null){
					if(curNode.data == curNode2.data){
						comnNode = new Node(curNode.data);
						comnListData.addAtBeg(comnNode.data);
						
							//comnNode.data = curNode.data;							
					}
					//comnNode.next=null;
				}//curNode2 = curNode2.next;
				//System.out.print(comnNode.data + "|->|");
				//curNode = curNode.next;
			}
			//System.out.println("null|");
			comnListData.traverse();
		}
			
		//return comnNode;
	}
	
	
	public static void main(String[] args) { 
		LinkedListImpl list = new LinkedListImpl();
		list.addAtBeg(5);
		list.addAtBeg(4);
		list.addAtEnd(9);
		list.traverse();
		System.out.println("Size of the list is " +list.size());
		list.reverseListIterative();
		list.traverse();
		list.reverseListRecurssive();
		list.traverse();
		
		
//		LinkedListImpl list2 = new LinkedListImpl();
//		list2.addAtBeg(5);
//		list2.addAtBeg(4);
//		list2.addAtEnd(9);
//		list2.addAtEnd(23);
//		list2.traverse();
//		System.out.println("Size of the list2 is " +list2.size());
//		//list.reverseList();
//		list.commonElementsOfTwoList(list, list2);

	}

}
