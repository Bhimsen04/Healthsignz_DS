package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Height {

	// https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/
	public static void main(String[] args) {
		System.out.println(height(GetRoot.getRoot()));
		System.out.println(heightIterative(GetRoot.getRoot()));
	}

	public static int height(TreeNode root) {
		if (root == null)
			return -1;
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		return Math.max(leftHeight, rightHeight) + 1;
	}

	public static int heightIterative(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		int height = -1;
		queue.add(root);
		queue.add(null);
		while (!queue.isEmpty()) {
			while (queue.peek() != null) {
				TreeNode temp = queue.poll();
				if (temp.left != null)
					queue.add(temp.left);
				if (temp.right != null)
					queue.add(temp.right);
			}
			height++;
			queue.poll();
			if (!queue.isEmpty())
				queue.add(null);
		}
		return height;
	}

}
