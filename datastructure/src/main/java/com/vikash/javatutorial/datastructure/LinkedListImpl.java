package com.vikash.javatutorial.datastructure;


import java.util.Random;

public class LinkedListImpl {

	private Node head;
	//private Node intersectNode;
	
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
	
	public Node getHead() {
		return head;
	}

	private void setHead(Node head) {
		this.head = head;
	}

	public LinkedListImpl() {
		setHead(null);
	}

	public void addAtBeg(int num) {
		Node tNode = new Node(num);
		if (getHead() == null) {
			setHead(tNode);
			return;
		} else {
			tNode.next = getHead();
			setHead(tNode);
		}
	}

	public Node addAtEnd(int num) {
		Node tNode = new Node(num);
		if (getHead() == null) {
			setHead(tNode);
			return tNode;
		}
		Node curNode = getHead();
		while(curNode != null) {
			if(curNode.next == null) {
				curNode.next = tNode;
				return tNode;
			}
			curNode = curNode.next;
		}
		return null;
	}
	
	public void printList() {
		if(getHead() == null) {
			System.out.println("empty list");
			return;
		}
		Node curNode = getHead();
		System.out.print("|");
		while (curNode != null) {
				System.out.print(curNode.data + "|->|");
				curNode = curNode.next;
		}
		System.out.println("null|");
	}
	public int size() {
		int count = 0;
		if(getHead() == null) {
			return count;
		}
		Node curNode = getHead();
		while (curNode != null) {
			//count = count++;
			count = count +1;
			curNode = curNode.next;
		}
		return count;
	}
	
	public void reverseListIterative() {
		Node preNode = null;
		Node curNode = getHead();
		Node nextNode = null;
		
		while(curNode != null){
			nextNode = curNode.next;
			curNode.next = preNode;
			preNode = curNode;
			curNode = nextNode;
		}
		
		setHead(preNode);
	}	
	public void reverseListRecurssive() {
		
		reverseUtil(getHead(), null);
	}
	// A simple and tail recursive function to reverse
    // a linked list.  prev is passed as NULL initially.
    Node reverseUtil(Node curNode, Node preNode) {
 
        /* If last node mark it head*/
        if (curNode.next == null) {
            setHead(curNode);
 
            /* Update next to prev node */
            curNode.next = preNode;
            return null;
        }
 
        /* Save curr->next node for recursive call */
        Node nextNode = curNode.next;
 
        /* and update next ..*/
        curNode.next = preNode;
 
        reverseUtil(nextNode, curNode);
        return getHead();
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
    public Node intersectTwoList(LinkedListImpl list1, LinkedListImpl list2){  	
    	int szL1 = list1.size();
    	int szL2 = list2.size();
    	
    	Node point1 = list1.getHead() ;
    	Node point2 = list2.getHead();
    	    	
    	if(szL1 == 0 || szL2 == 0){
    		System.out.println("List Can't Intersect, One of the list is Empty");
    		return null;
    	}else if(point1 == point2){
    		System.out.println("Both Lists are same");
    		return point1;
    	}else if(szL1 > szL2){
    		int count = szL1 - szL2;
    		while(count != 0){
    			point1 = point1.next;
    			count = count - 1;
    		}
       	}else {
    		int count = szL2 - szL1;
    		while(count != 0){
    			point2 = point2.next;
    			count = count - 1;
    		}
       	}	
    	
    	while( point1 != null && point2 != null){
    		if( point1 == point2){
    			System.out.println("This is intersection Node");
    			return point1;
    		}
    		point1 = point1.next;
    		point2 = point2.next;
    	}
    	
    	System.out.println("List Doesnot Intersect");    	
    	return null;
    }
    
	
    
    //Common Data of given two lists
    //public void commonElementsOfTwoList(Node node1, Node node2){
	public void commonElementsOfTwoList(LinkedListImpl list1, LinkedListImpl list2){
		Node comnNode;
		LinkedListImpl comnListData = new LinkedListImpl();
		if(list1 == null || list2 == null) {
			System.out.println("One of the list is Empty.");
		}else{
			//Node curNode2 = head2;
			Node curNode = getHead();
			Node curNode2 = getHead();
			
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
			comnListData.printList();
		}
			
		//return comnNode;
	}
	
	
	public static void main(String[] args) { 
		LinkedListImpl list = new LinkedListImpl();
		list.addAtBeg(4);
		list.addAtBeg(3);
		Node intersectNode = list.addAtEnd(5);
		
		list.addAtBeg(2);
		list.addAtBeg(1);
		list.addAtEnd(6);
		list.addAtEnd(7);
		list.addAtEnd(8);

		
		list.printList();
		System.out.println("Size of the list is " +list.size());
//		list.reverseListIterative();
//		list.printList();
//		list.reverseListRecurssive();
//		list.printList();
		
		
		LinkedListImpl list2 = new LinkedListImpl();
		
		list2.addAtBeg(12);
		list2.addAtBeg(11);
		Node prevNode = list2.addAtEnd(13);
		prevNode.next = intersectNode;
		
		list2.printList();
		System.out.println("Size of the list2 is " +list2.size());
//		list.commonElementsOfTwoList(list, list2);
//
//		LinkedListImpl listIntersect = new LinkedListImpl();
//		listIntersect.intersectTwoList(list, list2);
	}

}
