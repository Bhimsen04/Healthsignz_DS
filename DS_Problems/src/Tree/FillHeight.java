package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FillHeight {

	class Node {
		int val;
		Node left, right;
		int height;

		Node(int val) {
			this.val = val;
		}
	}

	public static int fillHeight(Node root) {
		if (root == null)
			return -1;
		int leftHeight = fillHeight(root.left);
		int rightHeight = fillHeight(root.right);
		return root.height = Math.max(leftHeight, rightHeight) + 1;
	}

	public Node getRoot() {
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);
		root.left.right = new Node(50);
		root.right.left = new Node(60);
		root.right.left.right = new Node(70);
		return root;
	}

	private static List<List<String>> levelOrder(Node root) {
		List<List<String>> list = new ArrayList<>();
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		queue.add(null);
		while (!queue.isEmpty()) {
			List<String> list2 = new ArrayList<>();
			while (queue.peek() != null) {
				Node temp = queue.poll();
				list2.add(temp.val + "," + temp.height);
				if (temp.left != null)
					queue.add(temp.left);
				if (temp.right != null)
					queue.add(temp.right);
			}
			queue.poll();
			list.add(list2);
			if (!queue.isEmpty())
				queue.add(null);
		}
		return list;
	}

	public static void main(String[] args) {
		Node root = new FillHeight().getRoot();
		fillHeight(root);
		System.out.println(levelOrder(root));
	}
}
