package Interviews.Oyo;

import java.util.LinkedList;
import java.util.Queue;

public class DeepestLeaveSum {

	// https://leetcode.com/problems/deepest-leaves-sum/
	public int deepestLeavesSum(TreeNode root) {
		if (root == null)
			return 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		queue.add(null);
		int res = 0;
		while (!queue.isEmpty()) {
			int currentSum = 0;
			while (queue.peek() != null) {
				TreeNode temp = queue.poll();
				if (temp.left == null && temp.right == null)
					currentSum += temp.data;
				if (temp.left != null)
					queue.add(temp.left);
				if (temp.right != null)
					queue.add(temp.right);
			}
			res = currentSum;
			queue.poll();
			if (!queue.isEmpty())
				queue.add(null);
		}
		return res;
	}

	int sum = 0, max_level = Integer.MIN_VALUE;

	public int deepestLeavesSum2(TreeNode root) {
		sumOfNodesAtMaxDepth(root, 1);
		return sum;
	}

	private void sumOfNodesAtMaxDepth(TreeNode node, int level) {
		if (node == null)
			return;
		if (level > max_level) {
			sum = node.data;
			max_level = level;
		} else if (level == max_level)
			sum = sum + node.data;
		sumOfNodesAtMaxDepth(node.left, level + 1);
		sumOfNodesAtMaxDepth(node.right, level + 1);

	}
}
