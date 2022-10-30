package Tree.view;

import java.util.LinkedList;
import java.util.Queue;

import Tree.BinaryTreeNode;
import Tree.TreeStructure;

public class Side_LeftView {
	static int max_level = 0;

	public static void main(String[] args) {
		BinaryTreeNode root = TreeStructure.treeStructure();
		leftView(root);
		System.out.println();
		leftViewByRecursion(root, 1);
	}

	private static void leftViewByRecursion(BinaryTreeNode root, int level) {
		if (root == null)
			return;
		if (max_level < level) {
			System.out.print(root.data + " ");
			max_level = level;
		}
		leftViewByRecursion(root.left, ++level);
		leftViewByRecursion(root.right, level);
	}

	private static void leftView(BinaryTreeNode root) {
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		q.offer(null);
		boolean flag = true;
		while (!q.isEmpty()) {
			BinaryTreeNode tmp = q.poll();
			if (tmp != null) {
				if (flag)
					System.out.print(tmp.data + " ");
				flag = false;
				if (tmp.left != null)
					q.offer(tmp.left);
				if (tmp.right != null)
					q.offer(tmp.right);
			} else {
				if (!q.isEmpty()) {
					q.offer(null);
					flag = true;
				}
			}
		}

	}
}
