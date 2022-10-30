package TreeProblems;

import Tree.TreeNode;

public class BinaryTreeMaximumPathSum {
	// https://leetcode.com/problems/binary-tree-maximum-path-sum/submissions/
	int max = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {

		helper(root);
		return max;
	}

	private int helper(TreeNode root) {
		if (root == null)
			return 0;
		int leftMax = Math.max(0, helper(root.left));
		int rightMax = Math.max(0, helper(root.right));
		int currentPathSum = leftMax + rightMax + root.val;
		max = Math.max(currentPathSum, max);
		return root.val + Math.max(leftMax, rightMax);
	}

}
