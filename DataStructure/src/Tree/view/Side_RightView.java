package Tree.view;

import java.util.LinkedList;
import java.util.Queue;

import Tree.BinaryTreeNode;
import Tree.TreeStructure;

public class Side_RightView {

	static int max_level = 0;

	public static void main(String[] args) {
		BinaryTreeNode root = TreeStructure.treeStructure();
		rightView(root);
		System.out.println();
		rightViewByRecursion(root, 1);
	}

	private static void rightViewByRecursion(BinaryTreeNode root, int level) {
		if (root == null)
			return;
		if (max_level < level) {
			System.out.print(root.data + " ");
			max_level = level;
		}
		rightViewByRecursion(root.right, ++level);
		rightViewByRecursion(root.left, level);
	}

	private static void rightView(BinaryTreeNode root) {
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		q.offer(null);
		while (!q.isEmpty()) {
			BinaryTreeNode tmp = q.poll();
			if (tmp != null) {
				if (q.peek() == null)
					System.out.print(tmp.data + " ");
				if (tmp.left != null)
					q.offer(tmp.left);
				if (tmp.right != null)
					q.offer(tmp.right);
			} else {
				if (!q.isEmpty()) {
					q.offer(null);
				}
			}
		}

	}

}
