package com.javatest.javatutorial.datastructure;

public class LinkedListImpl {
	
	static class Node {
		int data;
		Node next=null;

		Node(int value) {
			data = value;
			next = null;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + "]";
		}
		
	}
	private Node head;
	private int length = 0; 
	
	public synchronized Node getHead() {
		return head;
	}

	private void setHead(Node head) {
		this.head = head;
	}

	public LinkedListImpl() {
		setHead(null);
	}

	public void deleteList() {
		setHead(null);
	}
	
	

	public Node push(Node node, int val) {
		Node tNode = new Node(val);
		tNode.next = node;
		return tNode;
	}
	
	// prob 3: 
	public Node pop() {
		if(head == null) {
			return null;
		}
		 
		Node firstNode = head; 
		head = head.next;
		return firstNode;
	}
	
	public void addAtBeg(int val) {
		head = push(head, val);
	}
	
	// Prob 5: 
	public void insertNth(int val, int index) {
		
		if(index == 0){
			addAtBeg(val);
		} else {
			Node prevNode = GetNth(index-1);
			Node newNode = push(prevNode.next, val);
			prevNode.next = newNode;
		}
	}

	
	//addAtEnd
	public Node append(int val) {
		Node tNode = new Node(val);
		return append(tNode);
	}
	
	public Node append(Node tNode ) {
		
		//special case head is null
		if (getHead() == null) {
			setHead(tNode);
			return tNode;
		}
		Node curNode = getHead();

		//go to last node but not null 
		while(curNode.next != null) {
			curNode = curNode.next;
		}
		
		curNode.next = tNode;
		
		return tNode;
	}
	
	public void printList() {
		if(getHead() == null) {
			System.out.println("empty list");
			return;
		}
		printListFromNode(getHead());
	}
	
	public void printListFromNode(Node curNode) {
		System.out.print("|");
		while (curNode != null) {
				System.out.print(curNode.data + "|->|");
				curNode = curNode.next;
		}
		System.out.println("null|");
	}

	// 1 — Count()
/* 
 * 	public int size() {
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
*/
	public int size() {
		int count = 0;
		for(Node curNode = getHead() ; curNode != null ; curNode= curNode.next ) {
			count ++;
		}
		return count; 
	}
	

	
	// Prob 1: 
	public int countElement(int searchFor) {
		int count = 0;
		for(Node curNode = getHead() ; curNode != null ; curNode= curNode.next ) {
			if(curNode.data == searchFor) { 
			count ++;
			}
		}
		return count; 
	}
	
	public Node searchElement( int searchFor) {
		for(Node curNode = getHead() ; curNode != null ; curNode= curNode.next ) {
			if(curNode.data == searchFor) { 
			 return curNode;
			}
		}
		return null;
	}
	
	public int searchElementIndex( int searchFor) {
		int pos = 0; 
		for(Node curNode = getHead() ; curNode != null ; curNode= curNode.next ) {
			if(curNode.data == searchFor) { 
			 return pos;
			}
			pos++;
		}
		return Integer.MIN_VALUE;
	} 
	
	// prob 2:
	
/*	
	public Node GetNth( int index) {
		
		int count = 0; // the index of the node we're currently looking at
		Node current = head;
		while (current != null) {
			if (count == index) {
				return(current);
			}
			count++;
			current = current.next;
		}
		assert(false); // if we get to this line, the caller was asking
		// for a non-existent element so we assert fail.
		return null;
	}
*/
	
	public Node GetNth( int index) {
		int curIndex  = 0; // the index of the node we're currently looking at
		for(Node curNode = head  ; curNode != null ; curNode = curNode.next ) { 
			if (curIndex == index) {
				return(curNode);
			}
			curIndex ++;

		}
		assert(false); // if we get to this line, the caller was asking
		// for a non-existent element so we assert fail.
		return null;
	}
		
	
	public static void appendList(LinkedListImpl list1, LinkedListImpl list2) { 
		list1.append(list2.getHead()); 
		list2.setHead(null);
	}
	
	// problem 6 : 
	public void sortedInsert(Node nNode) {
		//special case null list or add at begining
		if(head == null || head.data > nNode.data) { 
			nNode.next = head; 
			setHead(nNode);
		} else {
			Node curNode = head;
			while(curNode.next !=null && curNode.next.data < nNode.data ) { 
				curNode = curNode.next;
			}
			nNode.next = curNode.next;
			curNode.next = nNode;
		}
		
	}
	
	//problem 7 : InsertSort() Solution
	
	public  void convertToSortedList() {
		
		Node curNode = head; 
		head = null;
		while ( curNode != null) {
			Node next = curNode.next;
			sortedInsert(curNode);
			curNode = next;
		}
	}
	public static LinkedListImpl convertToSortedList(LinkedListImpl list) {
		LinkedListImpl newList = new LinkedListImpl();
//		for (Node curNode = head  ; curNode != null;  ) {
//		Node next = curNode.next ;
//			newList.sortedInsert(new Node(curNode.data));
//			curNode = next;
//		}
		Node curNode = list.head;
		
		while(curNode != null) {
			Node next = curNode.next;
					newList.sortedInsert(new Node(curNode.data));
			curNode = next;
		}
		return newList;
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
 
	
	public static void main(String[] args) { 
		 //basicLinkListTest();
		//sortedInsertTest();
		
		LinkedListImpl list = buildLinkListTest();
		list.printList();
//		LinkedListImpl sortedList = convertToSortedList(list);
//		sortedList.printList();
		list.convertToSortedList();
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

	private static void sortedInsertTest() {
		LinkedListImpl list = new LinkedListImpl();
		list.sortedInsert(new Node(10));
		list.sortedInsert(new Node(3));
		list.sortedInsert(new Node(5));
		list.sortedInsert(new Node(12));
		list.sortedInsert(new Node(2));
		list.sortedInsert(new Node(14));
		list.printList();
	}
	
	
	private static LinkedListImpl buildLinkListTest() {
         LinkedListImpl list = new LinkedListImpl();
		
		list.addAtBeg(13);
		list.insertNth(4, 1);
		list.append(50);
		
		list.addAtBeg(22);
		list.addAtBeg(13);
		
		
		list.insertNth(6, 5);
		return list;
	}
	private static void basicLinkListTest() {
		LinkedListImpl list = buildLinkListTest();
		list.printList();
		
		LinkedListImpl list2 = new LinkedListImpl();
		list2.append(7);
		list2.append(8);
		list2.append(8);

		
		list2.printList();
		
		appendList(list, list2);
		list.printList();
		list2.printList();
		
		System.out.println("Size of the list is " +list.size());
		System.out.println("number of 8 are " + list2.countElement(8));
		System.out.println(list2.GetNth(100));
	}
	

}
