package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {

	// https://leetcode.com/problems/binary-tree-level-order-traversal/
	public static void main(String[] args) {
		System.out.println(levelOrder(GetRoot.getRoot()));
	}

	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		if (root == null)
			return list;
		Queue<TreeNode> q1 = new LinkedList<TreeNode>();
		Queue<TreeNode> q2 = new LinkedList<TreeNode>();
		q1.add(root);
		while (!q1.isEmpty()) {
			List<Integer> list2 = new ArrayList<>();
			while (q1.peek() != null) {
				TreeNode temp = q1.poll();
				list2.add(temp.val);
				if (temp.left != null)
					q2.add(temp.left);
				if (temp.right != null)
					q2.add(temp.right);
			}
			list.add(list2);
			if (q1.isEmpty() && !q2.isEmpty()) {
				q1 = q2;
				q2 = new LinkedList<TreeNode>();
			}
		}
		return list;
	}

	public static List<List<Integer>> levelOrder2(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		if (root == null)
			return list;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		queue.add(null);
		while (!queue.isEmpty()) {
			List<Integer> list2 = new ArrayList<>();
			while (queue.peek() != null) {
				TreeNode temp = queue.poll();
				list2.add(temp.val);
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
}
