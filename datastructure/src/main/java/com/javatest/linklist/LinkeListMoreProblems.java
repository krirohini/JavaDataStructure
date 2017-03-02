package com.javatest.linklist;

import java.util.HashSet;
import java.util.Set;

import com.javatest.linklist.MyLinkedList.Node;

public class LinkeListMoreProblems extends MyLinkedList {
	
	/**
	 * 2.1 Write code to remove duplicates from an unsorted linked list.
FOLLOW UP
How would you solve this problem if a temporary buffer is not allowed?
	 */
	/**
	 *  store first Unique elelent in Set when duplicate found then delete it
	 *  keep runner or previous node  
	 */
	public  Node deleteDups( Node head)
	{
		// list is empty or has one element
		if(head == null || head.next == null) { 
			return head;
		}
		Set<Integer> set = new HashSet<>();
		Node cur = head; 
		Node prev = null;

		while(cur != null) {
			if(set.contains(cur.data)) { 
				// delete duplicate
				prev.next = cur.next;
				
			} else {
				set.add(cur.data);
				prev = cur;
			}
			cur = cur.next;
		}
		return head;
	}
	
	public  Node deleteDupsNoBuffer( Node head) {
		// list is empty or has one element
		if(head == null || head.next == null) { 
			return head;
		}

		Node cur = head; 
		while( cur != null) {
			Node runner = cur; 
			while( runner.next != null ) {
				if(cur.data == runner.next.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}

			}
			cur = cur.next;
		}

		return head; 
	}
	
	/**
	 * 2.2 Implement an algorithm to find the nth to last element of a singly linked list.
	 */
	
	public Node findNthFromLast( Node head, int n) {
		if(null == head || n <1) {
			return null;
		}
		
		Node slow = head; 
		Node fast = head;
		
		for(int i = 0 ; i < n-1 ; i++) {
			if(fast == null) {
				return null;
			}
			fast = fast.next;
		}
		
		while(fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
		
	}
	
	/**
	 * 2.3 Implement an algorithm to delete a node in the middle of a single linked list, given only access to that node.
		EXAMPLE
		Input: the node ‘c’ from the linked list a->b->c->d->e
		Result: nothing is returned, but the new linked list looks like a->b->d->e
		The solution:  to this is to simply copy the data from the next node 
		into this node and then delete the next node.
		Limitation : can not be solved if the node to be deleted is the last node in the linked list.
	 */
	public void deleteNode(Node node) {
		if(node == null || node.next != null) {
			return;
		}
		node.data = node.next.data;
		node.next = node.next.next;		
		return; 
	}
/**
 2.4 You have two numbers represented by a linked list, where each node contains a single digit. 
 The digits are stored in reverse order, such that the 1’s digit is at the head of the list. 
 Write a function that adds the two numbers and returns the sum as a linked list.
EXAMPLE
Input: (3 -> 1 -> 5), (5 -> 9 -> 2)
Output: 8 -> 0 -> 8
 */
	public Node addLists(Node l1, Node l2) {
		
		if(null == l1 && null == l2) {
			return null;
		}
		
		int carry = 0; 
		Node prev = new Node(0); // dummy node
		Node head = prev; 
		
		while ( null != l1 || null != l2) {
			//calculate sum
			int sum = carry; 
			sum += (l1 != null) ? l1.data : 0; 
			sum += (l2 != null) ? l2.data : 0;
			carry = (sum >= 10) ? 1 :0; 
			sum = sum %10;
			
			Node temp = new Node(sum); 
			
			// add new node to end of list 
			/*if(prev != null) {
				prev.next = temp; 
			} else {
				head = temp;
			}*/
			// optimization using dummy node 
			prev.next = temp; 
			
			// Increment prev
			prev = prev.next;
			// increment both the list pointers 
			l1 = (null != l1) ? l1.next : l1;
			l2 = (null != l2) ? l2.next : l2;
			
		}
		
		
		return head.next;
	}
/**
2.5 Given a circular linked list, implement an algorithm which returns node at the beginning of the loop.
DEFINITION
Circular linked list: A (corrupt) linked list in which a node’s next pointer points to an earlier node,
 so as to make a loop in the linked list.
EXAMPLE
Input: A -> B -> C -> D -> E -> C [the same C as earlier]
Output: C
*/
	
	public Node findBeginning(Node head) {
		
		if(head == null) {
			return null;
		}
		Node slow = head; 
		Node fast = head; 
		// Find meeting point
		while(fast.next != null) {
			slow = slow.next; 
			fast = fast.next.next; 
			if(slow == fast ) {
				break;
			}
		}
		// Error check - there is no meeting point, and therefore no loop
		if(fast.next == null) {
			return null;
		}
		/** 
		 * Move slow to Head. Keep fast at Meeting Point. 
		 * Each are k steps from the Loop Start. If they move at the same pace, they must
		* meet at Loop Start. 
		*/
		slow = head; 
		
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		
		return slow;
	}
	
	public static void main(String[] args) {
		LinkeListMoreProblems list = new LinkeListMoreProblems();
		Node head = list.buildOneTwoThree();
		head = deleteDupsNoBufferTest(list, head);
		
		head = list.pushAtEnd(head, 4);
		head = list.pushAtEnd(head, 5);
		head = list.pushAtEnd(head, 6);
		head = list.pushAtEnd(head, 7);
		list.print(head);
		
		Node nth = list.findNthFromLast(head,3);
		System.out.println("nth node from last is " + nth.data);
		
		list.deleteNode(nth);
		list.print(head);
		addListsTest();
		
		
	}

	private static Node deleteDupsNoBufferTest(LinkeListMoreProblems list, Node head) {
		head = list.pushAtEnd(head, 2);
		head = list.pushAtEnd(head, 3);
		head = list.pushAtEnd(head, 1);
		head = list.pushAtEnd(head, 1);
		list.print(head);
//		head = deleteDups(head);
		head = list.deleteDupsNoBuffer(head);
		list.print(head);
		return head;
	}
	
	private static void addListsTest() {
		MyLinkedList list1 = new MyLinkedList();
		Node head1 = list1.pushAtEnd(null, 3);
		head1 = list1.pushAtEnd(head1, 1);
		head1 = list1.pushAtEnd(head1, 5);
		head1 = list1.pushAtEnd(head1, 5);
		System.out.println("number List 1");
		list1.print(head1);
		MyLinkedList list2 = new MyLinkedList();
		Node head2 = list2.pushAtEnd(null, 5);
		head2 = list2.pushAtEnd(head2, 9);
		head2 = list2.pushAtEnd(head2, 5);
		System.out.println("number List 2");
		list2.print(head2);
		
		LinkeListMoreProblems newList = new LinkeListMoreProblems();
		Node newHead = newList.addLists(head1, head2);
		System.out.println("Sum List ");
		newList.print(newHead);
		
	}
	
}
