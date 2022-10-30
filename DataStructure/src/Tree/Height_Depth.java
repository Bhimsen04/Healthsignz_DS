package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Height_Depth {

	public static void main(String[] args) {
		// Height_Depth tree = new Height_Depth();

		// BinaryTreeNode root = new BinaryTreeNode(1);
		// root.left = new BinaryTreeNode(2);
		// root.right = new BinaryTreeNode(3);
		// root.left.left = new BinaryTreeNode(4);
		// root.left.right = new BinaryTreeNode(5);
		// root.right.left = new BinaryTreeNode(6);
		// root.right.right = new BinaryTreeNode(7);

		BinaryTreeNode binaryTreeNode = null;
		BinaryTreeNode root = new BinaryTreeNode(100);

		binaryTreeNode = new BinaryTreeNode(200);
		root.setLeft(binaryTreeNode);
		binaryTreeNode = new BinaryTreeNode(300);
		root.setRight(binaryTreeNode);

		binaryTreeNode = new BinaryTreeNode(400);
		root.getLeft().setLeft(binaryTreeNode);
		binaryTreeNode = new BinaryTreeNode(500);
		root.getLeft().setRight(binaryTreeNode);

		binaryTreeNode = new BinaryTreeNode(600);
		root.getRight().setLeft(binaryTreeNode);
		binaryTreeNode = new BinaryTreeNode(700);
		root.getRight().setRight(binaryTreeNode);
		
		binaryTreeNode = new BinaryTreeNode(800);
		root.getLeft().getLeft().setRight(binaryTreeNode);

		Traversals.levelOrderTraversal(root);
		System.out.println("Height of tree is : " + nonRecursive_LevelOrder_Queue(root));
		System.out.println("Height of tree is : " + maxDepth(root));
		System.out.println("Height of tree is : " + nonRecursive_PostOrder_Stack(root));

	}

	private static int nonRecursive_PostOrder_Stack(BinaryTreeNode root) {
		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		s.push(root);
		BinaryTreeNode prev = null;
		int maxDepth = 0;
		while (!s.isEmpty()) {
			BinaryTreeNode curr = s.peek();
			if (prev == null || prev.left == curr || prev.right == curr) {
				if (curr.left != null) {
					s.push(curr.left);
				} else if (curr.right != null) {
					s.push(curr.right);
				}
			} else if (curr.left == prev) {
				if (curr.right != null) {
					s.push(curr.right);
				}
			} else {
				s.pop();
			}
			prev = curr;
			if (s.size() > maxDepth)
				maxDepth = s.size();
		}
		return maxDepth;
	}

	private static int nonRecursive_LevelOrder_Queue(BinaryTreeNode root) {

		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		q.offer(null);
		int count = 1;
		while (!q.isEmpty()) {
			BinaryTreeNode currentNode = q.poll();
			if (currentNode != null) {
				// if (currentNode.left == null && currentNode.right == null)
				// return count;
				if (currentNode.left != null)
					q.offer(currentNode.left);
				if (currentNode.right != null)
					q.offer(currentNode.right);

			} else {
				if (!q.isEmpty()) {
					count++;
					q.offer(null);
				}
			}
		}
		return count;
	}

	static int maxDepth(BinaryTreeNode node) {
		if (node == null)
			return 0;
		else {
			/* compute the depth of each subtree */
			int lDepth = maxDepth(node.left);
			int rDepth = maxDepth(node.right);

			/* use the larger one */
			if (lDepth > rDepth)
				return (lDepth + 1);
			else
				return (rDepth + 1);
		}
	}

}
