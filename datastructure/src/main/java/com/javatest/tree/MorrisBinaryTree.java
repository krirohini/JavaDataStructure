package com.javatest.tree;

public class MorrisBinaryTree {
	
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
	
	// Todo:
	// http://www.geeksforgeeks.org/inorder-predecessor-successor-given-key-bst/
	
	
	private Node inOrderSuccessorWithoutParent(Node root, Node node) {
		if(null == node ) {
			return null;
		}
		 // step 1 of the above algorithm
		if(node.right!=null) { 
			return minValue(node.right);
		} else {
			 // Start from root and search for successor down the tree
			Node current = root;
			Node succ = null;
			while(current != null) {
				if(node.data < root.data) { 
					succ = current; 
					current = current.left;
				} else if(node.data > root.data) {
					succ = current; 
					current = node.right;
				} else { 
					break;
				}
				
			}
			return succ;
		}
	}
	/**
	 * Method 1 (Uses Parent Pointer) 
In this method, we assume that every node has parent pointer.

The Algorithm is divided into two cases on the basis of right subtree of the input node being empty or not.

Input: node, root // node is the node whose Inorder successor is needed.
output: succ // succ is Inorder successor of node.

1) If right subtree of node is not NULL, then succ lies in right subtree. Do following.
Go to right subtree and return the node with minimum key value in right subtree.
2) If right sbtree of node is NULL, then succ is one of the ancestors. Do following.
Travel up using the parent pointer until you see a node which is left child of it’s parent. The parent of such a node is the succ.
	 * @param root
	 * @param node
	 * @return
	 */
	private Node inOrderSuccessor(Node root, Node node) {
		if(null == node ) {
			return null;
		}
		// step 1 of the above algorithm 
		if(node.right != null) {
			return minValue(node.right);
		} else { 
			 // step 2 of the above algorithm
			Node parent = node.parent;
			while ( null != parent && node == parent.right) { 
				node = parent;
				parent = node.parent;
			}
			return parent;
		}
	}
	
	private Node inOrderPredeessor(Node root, Node node) {
		if(null == node ) {
			return null;
		}
		// step 1 of the above algorithm 
		if(node.left != null) {
			return maxValue(node.left);
		} else { 
			 // step 2 of the above algorithm
			Node parent = node.parent;
			while ( null != parent && node == parent.left) { 
				node = parent;
				parent = node.parent;
			}
			return parent;
		}
	}
	
	/* Given a non-empty binary search tree, return the minimum data  
    value found in that tree. Note that the entire tree does not need
    to be searched. */
	public Node minValue(Node node) { 
		Node cur = node; 
		/* loop down to find the leftmost leaf */
		while(cur.left != null) {
			cur = cur.left;
		}
		return cur; 
	}
	
	public Node maxValue(Node node) { 
		Node cur = node; 
		/* loop down to find the leftmost leaf */
		while(cur.right != null) {
			cur = cur.right;
		}
		return cur; 
	}
	public Node insert( Node node, int data) {
		if(node == null) {
			node = new Node(data);
			node.parent = null;
			return node; 
		}
		
		if(data <= node.data) {
			node.left = insert(node.left, data);
			node.left.parent = node;
		} else { 
			node.right = insert(node.right, data);
			node.right.parent = node;
		}
		return node;
	}
	
	public void print(Node node) {
		if(null == node ) { 
			return;
		}
		print(node.left);
		System.out.print(node.data + "=>");
		print(node.right);
		
	}
	
	// Driver program to test above functions
	public static void main(String[] args) {
		MorrisBinaryTree tree = new MorrisBinaryTree();
		Node root = null, temp = null;
		root = tree.insert(root, 20);
		root = tree.insert(root, 8);
		root = tree.insert(root, 22);
		root = tree.insert(root, 4);
		root = tree.insert(root, 12);
		root = tree.insert(root, 10);
		root = tree.insert(root, 14);
		
		tree.print(root);
		inOrderSuccessor(tree, root, root);
		inOrderPredeessor(tree, root, root);
		temp = root.left.right.right; // 14 => 20
		inOrderSuccessor(tree, root, temp);
		inOrderPredeessor(tree, root, temp);
		temp = root.left.right; // 12=>14
		inOrderSuccessor(tree, root, temp);
		inOrderPredeessor(tree, root, temp);
	}

	private static void inOrderSuccessor(MorrisBinaryTree tree, Node root, Node temp) {
		Node suc = tree.inOrderSuccessor(root, temp);
		if (suc != null) {
			System.out.println("\nInorder successor of " + temp.data + 
					" is " + suc.data);
		} else {
			System.out.println("\nInorder successor does not exist");
		}
	}

	private static void inOrderPredeessor(MorrisBinaryTree tree, Node root, Node temp) {
		Node pre = tree.inOrderPredeessor(root, temp);
		if (pre != null) {
			System.out.println("\nInorder Predeessor of " + temp.data + 
					" is " + pre.data);
		} else {
			System.out.println("\nInorder Predeessor does not exist");
		}
	}
	

}
