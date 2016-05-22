package com.vikash.javatutorial.datastructure;



public class LinkedListImpl {
	
	static class Node {
		int data;
		Node next=null;

		Node(int value) {
			data = value;
			next = null;
		}
	}
	private Node head;
	
	public Node getHead() {
		return head;
	}

	private void setHead(Node head) {
		this.head = head;
	}

	public LinkedListImpl() {
		setHead(null);
	}
	
	
	Node GetNth( int index) {
		Node current = head;
		int count = 0; // the index of the node we're currently looking at
		while (current != null) {
			if (count == index) {
				return(current);
			}
			count++;
			current = current.next;
		}
		assert(true); // if we get to this line, the caller was asking
		// for a non-existent element so we assert fail.
		return null;
	}

	public Node push(Node node, int val) {
		Node tNode = new Node(val);
		tNode.next = node;
		return tNode;
	}
	
	public Node pop() {
		if(head == null) {
			return null;
		}
		 
		Node firstNode = head; 
		head = head.next;
		return firstNode;
	}
	
	public void addatBeg(int val) {
		head = push(head, val);
	}
	
	public void insertNth(int val, int index) {
		
		if(index == 0){
			addatBeg(val);
		} else {
			Node prevNode = GetNth(index-1);
			Node newNode = push(prevNode.next, val);
			prevNode.next = newNode;
		}
	}

	//addAtEnd
	public Node append(int val) {
		Node tNode = new Node(val);
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
		
//		while(curNode.next != null) {
//			curNode = curNode.next;
//		}
//		
//		curNode.next = tNode;
		
		return tNode;
	}
	
	public void printList() {
		if(getHead() == null) {
			System.out.println("empty list");
			return;
		}
		printListFromNode(getHead());
	}
	
	public void printListFromNode(Node node) {
		Node curNode = node;
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
			count = count++;
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
 
	
/*	public static void main(String[] args) { 
		LinkedListImpl list = new LinkedListImpl();
		
		list.addatBeg(3);
		list.insertNth(4, 1);
		list.printList();
		Node intersectNode = list.append(5);
		
		list.addatBeg(2);
		list.addatBeg(1);
		list.insertNth(6, 5);
		list.append(7);
		list.append(8);

		
		list.printList();
//		System.out.println("Size of the list is " +list.size());
////		list.reverseListIterative();
////		list.printList();
////		list.reverseListRecurssive();
////		list.printList();
//		
//		
//		LinkedListImpl list2 = new LinkedListImpl();
//		
//		list2.addatBeg(12);
//		list2.addatBeg(11);
//		Node prevNode = list2.append(13);
//		prevNode.next = intersectNode;
//		
//		list2.printList();
//		System.out.println("Size of the list2 is " +list2.size());
//	
//		LinkedListImpl listIntersect = new LinkedListImpl();
//		Node intersectTwoList = listIntersect.intersectTwoList(list, list2);
//		listIntersect.printListFromNode(intersectTwoList);

	}
	*/

}
