package BST;

import DLL.DLLNode;

public class SLL_BST {

	static DLLNode head;

	public static void main(String[] args) {
		SLL_BST llist = new SLL_BST();

		/*
		 * Let us create a sorted linked list to test the functions Created linked list
		 * will be 7->6->5->4->3->2->1
		 */
		

		llist.push(7);
		llist.push(6);
		llist.push(5);
		llist.push(4);
		llist.push(3);
		llist.push(2);
		llist.push(1);

		//System.out.println("Given Linked List ");
		//llist.printList(head);

		/* Convert List to BST */  // from leaves to root(botton up approach)
		BinarySearchTreeNode root = llist.sortedListToBST();
		System.out.println("Pre-Order Traversal of constructed BST ");
		llist.preOrder(root);
	}

	BinarySearchTreeNode sortedListToBST() {
		/* Count the number of nodes in Linked List */
		int n = countNodes(head);

		/* Construct BST */
		return sortedListToBSTRecur(n);
	}

	/*
	 * The main function that constructs balanced BST and returns root of it. n -->
	 * No. of nodes in the Doubly Linked List
	 */
	BinarySearchTreeNode sortedListToBSTRecur(int n) {
		/* Base Case */
		if (n <= 0)
			return null;

		/* Recursively construct the left subtree */
		BinarySearchTreeNode left = sortedListToBSTRecur(n / 2);

		/*
		 * head_ref now refers to middle node, make middle node as root of BST
		 */
		BinarySearchTreeNode root = new BinarySearchTreeNode(head.getData());

		// Set pointer to left subtree
		root.left = left;

		/*
		 * Change head pointer of Linked List for parent recursive calls
		 */
		head = head.getNext();

		/*
		 * Recursively construct the right subtree and link it with root. The number of
		 * nodes in right subtree is total nodes - nodes in left subtree - 1 (for root)
		 */
		root.right = sortedListToBSTRecur(n - n / 2 - 1);

		return root;
	}

	int countNodes(DLLNode head) {
		int count = 0;
		DLLNode temp = head;
		while (temp != null) {
			temp = temp.getNext();
			count++;
		}
		return count;
	}

	void push(int new_data) {
		/* allocate node */
		DLLNode new_node = new DLLNode(new_data);
		/*
		 * since we are adding at the beginning, prev is always NULL
		 */
		new_node.setPrev(null);

		/* link the old list off the new node */
		new_node.setNext(head);

		/* change prev of head node to new node */
		if (head != null)
			head.setPrev(new_node);

		/* move the head to point to the new node */
		head = new_node;
	}

	void preOrder(BinarySearchTreeNode node) {
		if (node == null)
			return;
		System.out.print(node.getData() + " ");
		preOrder(node.getLeft());
		preOrder(node.getRight());
	}
}
