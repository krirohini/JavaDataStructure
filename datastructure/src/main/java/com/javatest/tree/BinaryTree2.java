package com.javatest.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class BinaryTree2 {
	
	Node root; 
	BinaryTree2() {
		root = null;
	}
	
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer( "BinaryTree [root =>" );
		if(null == root) { 
			buffer.append( "null");
			return buffer.toString();
		}
		boolean isDone = false;
		Stack<Node> stack = new Stack<>();
        Node cur = root; 
        while(!isDone) {
        	if(cur != null) {
        		stack.push(cur);
        		cur = cur.left;
        	} else if ( ! stack.isEmpty()) {
        		cur = stack.pop();
        		buffer.append(cur.data + " => ");
        		cur = cur.right;
        	}  else{ 
        		isDone = true;
        	}
        }
         buffer.append(" ] ");        
         return buffer.toString();
	}

	class Node {
		Node left; 
		Node right;
		int data;
		Node( int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	Node insert(Node node, int data) {
		// 1. If the tree is empty, return a new, single node
		if(root == null ) {
			return new Node(data);
		}
		// 2. Otherwise, recur down the tree
		if( data < node.data) {
			node.left =  insert(node.left, data);
		} else {
			node.right = insert(node.right, data);
		}
		// 3. return the (unchanged) node pointer
		return node;
	}
	
	/** 1. Build123()
	 * 
	 * @return
	 */
	public Node buildTree() {
		 root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(6);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		root.right.left = new Node(5);
		return root;
	}
	
	public void printPreOrder(Node cur) {
		if(cur ==null) {
			return;
		}
		System.out.print(cur.data + "->");
		printPreOrder(cur.left);
		
		printPreOrder(cur.right);
	}
	
	/**
	 * 5. printTree()
	 * @param cur
	 */
	
	public  void MorrisTraversal(Node root) {
		
	}
	public void printInOrderIterative () {
		System.out.print("\nRoot :");
		printInOrderIterative(root);
		System.out.println("end");
	}
	
	public void printInOrderIterative (Node root) {
		if(root ==null) {
			return;
		}
		boolean done = false; 
		Node cur = root;
		Stack<Node> stack = new Stack<>();
		
		while (!done) {
			/* Reach the left most tNode of the current tNode */
			if(cur != null) {/* place pointer to a tree node on the stack before traversing 
		        the node's left subtree */
				stack.push(cur);
				cur  = cur.left;
			} else if( !stack.isEmpty()) {
				cur = stack.pop();
				System.out.print(cur.data + "->");
				/* we have visited the node and its left subtree.
		          Now, it's right subtree's turn */
				cur = cur.right;
			} else {
				done = true;
			}
		} /* end of while */ 
	}
	public void printInOrder(Node cur) {
		if(cur ==null) {
			return;
		}
		printInOrder(cur.left);
		System.out.print(cur.data + "->");
		printInOrder(cur.right);
	}
	
	public void printInOrderRevese(Node cur) {
		if(cur ==null) {
			return;
		}
		printInOrderRevese(cur.right);
		System.out.print(cur.data + "->");
		printInOrderRevese(cur.left);
	}
	

	public  void printKthDistance(Node cur, int k) {
		if(null == cur) {
			return;
		}
		
		if(k ==0) {
			System.out.print(cur.data + " ");
			return;
		} else {
			printKthDistance(cur.left, k-1);
			printKthDistance(cur.right, k-1);
			
		}
		
		
		
		
		
	}
	
	
	private Node findKthLargestItem(Node cur, int k, int[] counter) {
		if(cur==null || counter[0] >= k){
			return null;
		}

		//Instead of Left to Right, we will traverse in Right to Left fashion because largest element 
		//are present of Right side of Root Node.
		Node node = findKthLargestItem(cur.right, k, counter);

		//If counter is not equal to K, then only increment the counter. 
		//Once counter is equal to K, it means we have found the desired largest element and no need to increment further, 
		//Take the back up of the current node as it might be the Kth largest element we are looking for.  
		//		if(counter[0] != k){
		//			counter[0]++;
		//			node = cur;
		//		}

		//This is the place where actual check is going to happen between counter and K, 
		//If counter matched K, it means we found the node and no need to find further so simply return the found node.
		if(null == node) { 
			counter[0]++;
			if(counter[0] == k){ 
				node = cur;
			}
		}
		
		if(null == node) { 
			node = findKthLargestItem(cur.left, k, counter);
		}
		return node;
	}
	/**
	 * 6. printPostorder()
	 * @param cur
	 */
	public void printPostOrder(Node cur) {
		if(cur ==null) {
			return;
		}
		
		// first recur on both subtrees
		printPostOrder(cur.left);
		printPostOrder(cur.right);
		
		// then deal with the node
		System.out.print(cur.data + "->");
	}
	
	
	/**
	 * 7. hasPathSum() Solution (Java) 
	 * Given a tree and a sum, return true if
	 * there is a path from the root down to a leaf, such that adding up all the
	 * values along the path equals the given sum.
	 * http://cslibrary.stanford.edu/110/ BinaryTrees.html 
	 * Strategy: subtract
	 * the node value from the sum when recurring down, and check to see if the
	 * sum is 0 when you run out of tree.
	 */
	public boolean hasPathSum (Node node, int sum) {
		if(node  == null) {
			// return true if we run out of tree and sum==0
			return (sum == 0); 
		} else { 
			// otherwise check both subtrees
			int subSum = sum - node.data;
			return hasPathSum(node.left, subSum) || hasPathSum(node.right, subSum);
		}
	}
	
	/**
	 * 8. printPaths()
	 *Given a binary tree, print out all of its root-to-leaf
	 * paths, one per line. Uses a recursive helper to do the work.
	 */
	public void printPaths(Node node) {
		int path[] = new int[1000];
		printPathsRecur(node, path, 0);
	}
	/**
		Recursive helper function -- given a node, and an array containing
		the path from the root node up to but not including this node,
		print out all the root-leaf paths.
	 */
	void printPathsRecur( Node node, int path[], int pathLen) {
		if(node == null) {
			return;
		} 

		// append this node to the path array
		path[pathLen] = node.data;
		pathLen++;
		// it's a leaf, so print the path that led to here
		if(null == node.left && null == node.right) {
			System.out.print("\nPath Starts ");
			for( int i = 0 ; i < pathLen ; i++) {
				System.out.print(path[i] + "->");
			}
			System.out.println("end");
		}
		else {
			// otherwise try both subtrees
			printPathsRecur(node.left, path ,pathLen);
			printPathsRecur(node.right, path, pathLen);
		}

	}
	
	public void printLevelOrderTree(Node cur) {
		if(cur ==null) {
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(cur);
		while(!queue.isEmpty() ) {
			cur = queue.poll();
			if(cur != null) {
				if(cur.left != null) 
					queue.add(cur.left);
				if(cur.right !=null)
					queue.add(cur.right);
				System.out.print(cur.data + "->");
			}
			
			
		}
	
	}
	
	/**
	* 9. mirror()
	* 	Change a tree so that the roles of the
	*left and right pointers are swapped at every node.
	*/
	public void mirror(Node node) {
		if(node == null) { return; }
		
		// do the subtrees
		mirror(node.left);
		mirror(node.right);
		
		// swap the pointers in this node
		Node temp = node.left;
		node.left = node.right;
		node.right = temp;
	}
	
	/**
	 * 2. size()
	 * @param node
	 * @return
	 */
	public int size(Node node) {
		if(node == null ) 
			return 0;
		return 1 + size(node.left) + size(node.right);
	}
	
	/**
	 * 3. maxDepth()
	 * hight of tree is same as Max Depth
	 */
	//TODO : optimize 
	public int hight( Node node) {
		if(node == null) {
			return 0;
		}
		return 1 + Math.max(hight(node.left), hight(node.right));
	}
	
	/**
	 * 4. minValue()
	 * @param node
	 * @return
	 */
	public int minValueInBst(Node node) {
		Node cur = node; 
		while ( cur.left != null) {
			cur = cur.left;
		}
		return cur.data;
	}
	
	public int maxValueInBst(Node node) {
		Node cur = node; 
		while ( cur.right != null) {
			cur = cur.right;
		}
		return cur.data;
	}
	public int minValue(Node node) {
		if(node == null) {
			return Integer.MIN_VALUE;
		}
		int lMin = minValue(node.left);
		int rMin = minValue(node.right);
		int min = node.data;
		if(Integer.MIN_VALUE != lMin) {
			min = Integer.min(lMin, min);
		}
		
		if(Integer.MIN_VALUE != rMin) {
			Integer.min(rMin, min);
		}
		return min;
	}
	
	public int maxValue(Node node) {
		if(node == null) {
			return Integer.MAX_VALUE;
		}
		int maxVal = node.data;
		
		int lMax = maxValue(node.left);
		int rMax = maxValue(node.right);
		
		if(Integer.MAX_VALUE != lMax) {
			maxVal = Integer.max(lMax, maxVal);
		}
		
		if(Integer.MAX_VALUE != rMax) {
			maxVal = Integer.max(rMax, maxVal);
		}
		return maxVal;
	}
	
	
	/**
	 * 10. 
	Changes the tree by inserting a duplicate node
	on each nodes's .left.
	 */
	public void doubleTree() {
		doubleTreeRecur(root);
	}

	/** Uses a recursive helper to recur over the tree
and insert the duplicates. 
	 */
	public void doubleTreeRecur(Node node) {
		if(null ==node) {
			return; 
		}
		// do the subtrees
		doubleTreeRecur(node.left);
		doubleTreeRecur(node.right);
		// duplicate this node to its left
		Node oldLeft = node.left;
		Node temp = new Node(node.data);
		node.left = temp; 
		node.left.left = oldLeft;

	}
	
	/**
	 * Cracking the coding interview:
	 * Q 4.7 You have two very large binary trees: T1, with millions of nodes, 
	 * and T2, with hundreds of nodes. 
	 * Create an algorithm to decide if T2 is a subtree of T1.
	 * 
	 * Solution Alternative Approach: 
	 * The treeMatch procedure visits each node in the small tree at most once and is called
	 * no more than once per node of the large tree.
	 *  Worst case runtime is at most O(n * m), where n and m are the sizes of trees T1 and T2,
	 * respectively. If k is the number of occurrences of T2’s root in T1, the
	 * worst case runtime can be characterized as O(n + k * m).
	 */
	public boolean containsTree( Node t1, Node t2) { 
		if(t2 == null) {
			return false; //sub tree will always be null
		}
		return subTree(t1, t2);
	}
	
	public boolean subTree(Node r1, Node r2) {
		
		if(r1 == null) {
			return false; // big tree empty & subtree still not found.
		}
		if(r1.data == r2.data) {
			return sameTree(r1, r2);
		}
		
		// find the root of subtree in big tree
		return (subTree(r1.left , r2) ||
				subTree(r1.right , r2));
		
	}
	
	/**
	 * 11. sameTree() Solution (Java) Compares the receiver to another tree to
	 * see if they are structurally identical.
	 */
	/*
	Compares the receiver to another tree to
	see if they are structurally identical.
	*/
	public boolean sameTree(BinaryTree2 other) {
	return( sameTree(root, other.root) );
	}
	/**
	Recursive helper -- recurs down two trees in parallel,
	checking to see if they are identical.
	*/
	public boolean sameTree(Node a, Node b) {
		// 1. both empty -> true
		// nothing left in the subtree
		if(a == null && b == null) 
			return true; 
		// big tree empty & subtree still not found
		if(a == null || b == null) 
			return false; 
		if(a.data != b.data) 
			return false; 
		return sameTree(a.left, b.left) &&
				  sameTree(a.right, b.right);
	}
	
	
	
	
	/**
	 * 14. isBST2() Solution (Java)
	Tests if a tree meets the conditions to be a
	binary search tree (BST). Uses the efficient
	recursive helper.
	*/
	public boolean checkBST() {
	return( checkBSTHealper(root, Integer.MIN_VALUE, Integer.MAX_VALUE) );
	}
	/**
	Efficient BST helper -- Given a node, and min and max values,
	recurs down the tree to verify that it is a BST, and that all
	its nodes are within the min..max range. Works in O(n) time --
	visits each node only once.
	*/

	
	private boolean checkBSTHealper(Node node, int min, int max) {
		
		if(node == null) {
			return true; 
		}

		return (node.data > min && node.data < max ) &&
				checkBSTHealper(node.left, min, node.data) && 
				checkBSTHealper(node.right, node.data, max); 
	}
	
	
	/** 
	 * Cracking coding interview 
	 * 4.1 Implement a function to check if a tree is balanced.
	 *  For the purposes of this question, 
	 *  a balanced tree is defined to be a tree such that no two leaf nodes differ 
	 *  in distance from the root by more than one.
	 * @return
	 */
	public boolean isBalancedTree () {
		int maxDepth = maxDepth(root);
		int minDepth = minDepth(root);
		return (maxDepth - minDepth) <= 1; 
	}
	
	public int maxDepth(Node node) {
		if(node == null) {
			return 0; 
		}
		return 1+ Math.max(maxDepth(node.left), maxDepth(node.right));
	}
	public int minDepth(Node node) {
		if(node == null) {
			return 0; 
		}
		return 1+ Math.min(maxDepth(node.left), maxDepth(node.right));
	}
	
	/**
	 * 
	 * @param array
	 * @return
	 */
	public  Node createMinimalBST(int array[]) {
		root=  addToTree(array, 0, array.length-1);
		return root;
	}
	
	/**
	 * Cracking coding interview 4.3 Given a sorted (increasing order) array,
	 * write an algorithm to create a binary tree with minimal height.
	 * Algorithm: 
	 * 1. Insert into the tree the middle element of the array. 
	 * 2. Insert (into the left subtree) the left subarray elements 
	 * 3. Insert (into the right subtree) the right subarray elements 4. Recurse
	 */
	public Node addToTree( int array[] , int start , int end) {
		if( start > end) {
			return null;
		}
		int mid = (start+ end) /2; 
		Node cur = new Node(array[mid]);
		cur.left = addToTree(array, start, mid-1); 
		cur.right = addToTree(array, mid+1, end);
		return cur; 
	}
	
	//TODO: 
	/**
	 * cracking the coding interview 
	 * 4.4. Given a binary search tree, design an algorithm which creates a 
	 * linked list of all the nodes at each depth 
	 * (eg, if you have a tree with depth D, you’ll have D linked lists).
	 */
	ArrayList<LinkedList<Node>> findLevelLinkList(Node root) {
		int level = 0;
		ArrayList<LinkedList<Node>> result =
				new ArrayList<LinkedList<Node>>();
		LinkedList<Node> list = new LinkedList<Node>();
		list.add(root);
		result.add(level, list);
		while (true) {
			list = new LinkedList<Node>();
			for (int i = 0; i < result.get(level).size(); i++) {
				Node n = (Node) result.get(level).get(i);
				if (n != null) {
					if(n.left != null) list.add(n.left);
					if(n.right!= null) list.add(n.right);
				}
			}
			if (list.size() > 0) {
				result.add(level + 1, list);
			} else {
				break;
			}
			level++;
		}
		return result;
	}
	
	
	/**
	 * 4.6 Design an algorithm and write code to find the first common ancestor of
	 *  two nodes in a binary tree. Avoid storing additional nodes in a data structure. 
	 *  NOTE: This is not necessarily a binary search tree.
	 */

    // This function returns pointer to LCA of two given
    // values n1 and n2.
    // v1 is set as true by this function if n1 is found
    // v2 is set as true by this function if n2 is found
    Node findLCAUtil(Node node, int n1, int n2, boolean [] found)
    {
        // Base case
        if (node == null)
            return null;
 
        // If either n1 or n2 matches with root's key, report the presence
        // by setting v1 or v2 as true and return root (Note that if a key
        // is ancestor of other, then the ancestor key becomes LCA)
        if (node.data == n1)
        {
            found[0] = true;
            return node;
        }
        if (node.data == n2)
        {
            found[1] = true;
            return node;
        }
 
        // Look for keys in left and right subtrees
        Node left_lca = findLCAUtil(node.left, n1, n2, found);
        Node right_lca = findLCAUtil(node.right, n1, n2,found);
 
        // If both of the above calls return Non-NULL, then one key
        // is present in once subtree and other is present in other,
        // So this node is the LCA
        if (left_lca != null && right_lca != null)
            return node;
 
        // Otherwise check if left subtree or right subtree is LCA
        return (left_lca != null) ? left_lca : right_lca;
    }
	// Finds lca of n1 and n2 under the subtree rooted with 'node'
    Node findLCA(int n1, int n2)
    {
        // Initialize n1 and n2 as not visited
    	boolean [] found = new boolean[] { false, false }; 
       
 
        // Find lca of n1 and n2 using the technique discussed above
        Node lca = findLCAUtil(root, n1, n2,found);
 
        // Return LCA only if both n1 and n2 are present in tree
        if (found[0] && found[1])
            return lca;
 
        // Else return NULL
        return null;
    }
 
    
	public static void main(String[] args) {
		BinaryTree2 tree = new BinaryTree2();
		
		Node root = tree.buildTree();
		System.out.println("\n print tree In order");
		tree.printInOrder(root);
		System.out.println("\n print tree pre order");
		tree.printPreOrder(root);
//		System.out.println("\n print tree post order");
//		tree.printPostOrder(root);
//		System.out.println("\n print tree Level order");
//		tree.printLevelOrderTree(root);
//		System.out.println("\n Size of tree " + tree.size(root));
//		System.out.println("\n Hight of tree " + tree.hight(root));
//		System.out.println("\n Min Value of tree " + tree.minValue(root));
//		System.out.println("\n Max Value of tree " + tree.maxValue(root));
//		System.out.println("\n Min Value of In BST tree " + tree.minValueInBst(root));
//		System.out.println("\n Max Value of in BST tree " + tree.maxValueInBst(root));
//		
		System.out.println("\n Is Bst " + tree.checkBST());
		tree.mirror(root);
		System.out.println("\n print Mirror tree");
		tree.printInOrder(root);
		System.out.println("\n has sum path " + tree.hasPathSum(root, 7) );
		
		tree.printPaths(root);
		
		tree.doubleTree();
		System.out.println("\n print Mirror tree");
		tree.printInOrder(root);
		
		System.out.println("\n create Bst From Array");
		int [] arr = new int [] { 11,12,13,14,15,16,17};
		BinaryTree2 tree2 = new BinaryTree2();
		Node root2 = tree2.createMinimalBST(arr);
		
		tree2.printInOrder(root2);
		System.out.println("vikash");
		
		tree.printInOrderRevese(root2);
		tree2.printInOrderIterative();
		System.out.println("\n Is Bst " + tree2.checkBST());
		System.out.println("\n Is balanced "+  tree2.isBalancedTree());
		tree2.findLevelLinkList(root2);
		Node lCANode = tree2.findLCA(11, 13);
		System.out.println("LCAn node of 11 and 13 is " + lCANode.data);
		 lCANode = tree2.findLCA(13, 15);
		System.out.println("LCAn node of 13 and 15 is " + lCANode.data);
		 lCANode = tree2.findLCA(17, 25);
		 if(null != lCANode)
			 System.out.println("LCAn node of 17 and 25 is " + lCANode.data);
		 
		 int []counter = new int[1];
		Node kthLarget = tree.findKthLargestItem(root2, 3, counter);
		if(kthLarget != null)
			System.out.println("Kth Largest" + kthLarget.data);
		else 
			System.out.println("No kthLarget");
		
		tree.printInOrderRevese(root2);
		System.out.println("Print kth distance");
		tree.printKthDistance(root2, 2);
		
	}
	
	
	/**
	 * 4.5 Write an algorithm to find the ‘next’ node (e.g., in-order successor) of a 
	 * given node in a binary search tree where each node has a link to its parent.
	 */
	/* Function to print spiral traversal of a tree*/
	void printLevelOrder(struct node* root)
	{
	int h = height(root);
	int i;
	/*ltr -> Left to Right. If this variable is set,
	then the given level is traverseed from left to right. */
	bool ltr = 0;
	for(i=1; i<=h; i++)
	{
	printGivenLevel(root, i, ltr);
	/*Revert ltr to traverse next level in oppposite order*/
	ltr = ~ltr;
	}
	}
	/* Print nodes at a given level */
	void printGivenLevel(struct node* root, int level, int ltr)
	{
	if(root == NULL)
	return;
	if(level == 1)
	printf("%d ", root->data);
	else if (level > 1)
	{
	if(ltr)
	{
	printGivenLevel(root->left, level-1, ltr);
	printGivenLevel(root->right, level-1, ltr);
	}
	else
	{
	printGivenLevel(root->right, level-1, ltr);
	printGivenLevel(root->left, level-1, ltr);
	}
	}
	}
	
}
