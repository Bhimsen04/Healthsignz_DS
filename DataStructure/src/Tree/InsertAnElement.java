package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class InsertAnElement {
	public static void main(String[] args) {
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

		// insertInBinaryTree_LevelOrder(root, 800);
		// insertInBinaryTree_LevelOrder(root, 900);
		// insertInBinaryTree_LevelOrder(root, 1000);
		// insertInBinaryTree_LevelOrder(root, 1100);
		// insertInBinaryTree_LevelOrder(root, 1200);
		// insertInBinaryTree_LevelOrder(root, 1300);
		// insertInBinaryTree_LevelOrder(root, 1400);
		// insertInBinaryTree_LevelOrder(root, 1500);
		// insertInBinaryTree_LevelOrder(root, 1600);
//		insertInBinaryTree_recursive(root, 800);
//		insertInBinaryTree_recursive(root, 900);
//		insertInBinaryTree_recursive(root, 1900);
//		insertInBinaryTree_recursive(root, 1100);
//		insertInBinaryTree_recursive(root, 1200);
//		insertInBinaryTree_recursive(root, 1300);
		Traversals.levelOrderTraversal(root);
	}

	private static void insertInBinaryTree_recursive(BinaryTreeNode root, int data) {
		// Ist way
		if (root.data >= data) {
			if (root.left == null) {
				root.setLeft(new BinaryTreeNode(data));
			} else {
				insertInBinaryTree_recursive(root.left, data);
			}
		} else {
			if (root.right == null) {
				root.setRight(new BinaryTreeNode(data));
			} else {
				insertInBinaryTree_recursive(root.right, data);
			}
		}

		// IInd way

		if (root.left == null) {
			root.setLeft(new BinaryTreeNode(data));
		} else if (root.right == null) {
			root.setRight(new BinaryTreeNode(data));
		} else {
			insertInBinaryTree_recursive(root.left, data);
		}

	}

	private static void insertInBinaryTree_LevelOrder(BinaryTreeNode root, int data) {
		if (root == null)
			return;
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			BinaryTreeNode temp = queue.poll();
			if (temp.left == null) {
				temp.setLeft(new BinaryTreeNode(data));
				return;
			} else {
				queue.offer(temp.left);
			}
			if (temp.right == null) {
				temp.setRight(new BinaryTreeNode(data));
				return;
			} else {
				queue.offer(temp.right);
			}
		}
	}

}
