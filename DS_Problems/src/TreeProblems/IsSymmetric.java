package TreeProblems;

import java.util.LinkedList;
import java.util.Queue;

import Tree.TreeNode;

public class IsSymmetric {

	// https://leetcode.com/problems/symmetric-tree/submissions/
	public boolean isSymmetric(TreeNode root) {
		// return isSymmetric(root, root);
		return isSymmetricIteratively(root);
	}

	public boolean isSymmetricIteratively(TreeNode root) {
		if (root == null)
			return true;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root.left);
		queue.add(root.right);
		while (!queue.isEmpty()) {
			TreeNode tempLeft = queue.poll();
			TreeNode tempRight = queue.poll();
			if (tempLeft == null && tempRight == null)
				continue;
			if ((tempLeft == null || tempRight == null) || (tempLeft.val != tempRight.val))
				return false;
			queue.add(tempLeft.left);
			queue.add(tempRight.right);
			queue.add(tempLeft.right);
			queue.add(tempRight.left);

		}
		return true;
	}

	public boolean isSymmetric(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null)
			return true;
		else if (root1 == null || root2 == null)
			return false;
		return root1.val == root2.val && isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
	}
}
