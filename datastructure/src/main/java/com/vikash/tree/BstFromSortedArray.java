package com.vikash.tree;

import java.util.PriorityQueue;
import java.util.Queue;

public class BstFromSortedArray {

	class Node {
		private Node left; 
		private int data;
		private Node right;
		
		
		public Node getLeft() {
			return left;
		}


		public void setLeft(Node left) {
			this.left = left;
		}


		public int getData() {
			return data;
		}


		public void setData(int data) {
			this.data = data;
		}


		public Node getRight() {
			return right;
		}


		public void setRight(Node right) {
			this.right = right;
		}


		public Node(int data ) {
			this.left = null; 
			this.data = data;
			this.right = null;
		}
	}
	
	
	public void printTree(Node node) {
		if(node == null) {
			return;
		}
		printTree(node.getLeft());
		System.out.printf("%d -> ", node.getData() );
		printTree(node.getRight());
	}

	public  Node buildBstFromSortedArray(int [] array) {
		Node root = null;
	
		
		if(null == array || array.length <= 0) {
			return null;
		} 
		int length = array.length;
		 if ( length == 1) {
			root = new Node( array[0]);
			return root;
		}

		return SortedArrayToBst( array, 0 , length-1);
	}

	Node SortedArrayToBst(int [] array, int start, int end) {
		if( start > end ) {
			return null;
		}
		int mid = (start + end ) / 2; 
		Node node = new Node( array[mid]); 
		node.setLeft(   SortedArrayToBst( array, start , mid -1)) ;
		node.setRight ( SortedArrayToBst( array , mid +1 , end) ) ;
		
		return node;
	}
	
	public static void main(String[] args) {
		//int [] array = new int [] { 1 ,2,3,4,5}; 
//		int [] array = new int [] { }; 
//		BstFromSortedArray bst = new BstFromSortedArray();
////		Node root = bst.buildBstFromSortedArray(array); 
//		Node root = bst.buildBstFromSortedArray(null); 
//		bst.printTree(root);
//		
//		System.out.println("Null");
//		
//		Queue<Integer> queue = new PriorityQueue<>();
//		
		//String str = new String(); 
		//Long.parseLong("123458797897897897897897897897897897897897897");
		System.out.println(Long.parseLong("+123458797897"));
		
		
		
		
	}
	
	
	
}



