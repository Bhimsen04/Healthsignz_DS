package Tree;

import java.util.Stack;

public class PostOrderTraversal {

	static class Node_Stack {
		BinaryTreeNode node;
		boolean processed;

		Node_Stack(BinaryTreeNode node, boolean processed) {
			this.node = node;
			this.processed = processed;
		}
	}

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
		binaryTreeNode = new BinaryTreeNode(800);
		root.getRight().getLeft().setLeft(binaryTreeNode);
		binaryTreeNode = new BinaryTreeNode(900);
		root.getRight().getRight().setRight(binaryTreeNode);

		//traverse(root);
		
		String today = "2020-06-06";
		StringBuilder s = new StringBuilder(today);
		s.replace(8, 10, "11");
		System.out.println(s.toString());
		
	}

	static void traverse(BinaryTreeNode root) {
		Stack<Node_Stack> stack = new Stack<>();

		stack.push(new Node_Stack(root, false));

		while (!stack.isEmpty()) {
			Node_Stack element = stack.pop();

			if (element.processed == false) {
				stack.push(new Node_Stack(element.node, true));
				if (element.node.right != null) {
					stack.push(new Node_Stack(element.node.right, false));
				}

				if (element.node.left != null) {
					stack.push(new Node_Stack(element.node.left, false));
				}

			} else {
				System.out.print(element.node.data + " ");
			}
		}

	}

}
