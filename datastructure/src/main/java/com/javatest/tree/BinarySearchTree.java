package com.javatest.tree;

import com.javatest.tree.MorrisBinaryTree.Node;

public class BinarySearchTree {
	Node root = null;
	class Node { 
		int data;
		Node left; 
		Node right;
		Node parent;
		
		Node(int data) {
			this.data = data; 
			left = right=parent = null;
		}
	}
	
	/**
	 * http://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/
	 */
	
	public Node lowestCommonAncestor (Node root, int n1, int n2) {
		if(null ==root) { 
			return null; 
		}
		// If both n1 and n2 are smaller than root, then LCA lies in left
		if(root.data > n1 && root.data > n2) {
			return lowestCommonAncestor(root.left, n1, n2); 
		} 
		// If both n1 and n2 are greater than root, then LCA lies in right
		if(root.data < n1 && root.data < n2) {
			return lowestCommonAncestor(root.right, n1, n2);
		} 
		//n1 < root.data < n2 
			return root;
	
	}
	
	public static void main(String[] args) {
		
		BinarySearchTree tree = new BinarySearchTree();
	        tree.root = tree.new Node(20);
	        tree.root.left = tree.new Node(8);
	        tree.root.right = tree.new Node(22);
	        tree.root.left.left = tree.new Node(4);
	        tree.root.left.right = tree.new Node(12);
	        tree.root.left.right.left = tree.new Node(10);
	        tree.root.left.right.right = tree.new Node(14);
	  
	        int n1 = 10, n2 = 14;
	        Node t = tree.lowestCommonAncestor(tree.root, n1, n2);
	        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);
	  
	        n1 = 14;
	        n2 = 8;
	        t = tree.lowestCommonAncestor(tree.root, n1, n2);
	        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);
	  
	        n1 = 10;
	        n2 = 22;
	        t = tree.lowestCommonAncestor(tree.root, n1, n2);
	        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

		/**
		 * LCA of 10 and 14 is 12 
		 * LCA of 14 and 8 is 8 
		 * LCA of 10 and 22 is 20
		 */
	}
}
