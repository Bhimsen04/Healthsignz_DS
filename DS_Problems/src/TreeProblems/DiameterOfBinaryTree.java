package TreeProblems;

import Tree.TreeNode;

public class DiameterOfBinaryTree {

	int diameter = 0;

	public int diameterOfBinaryTree(TreeNode root) {
		helper(root);
		return diameter == 0 ? 0 : diameter - 1;
	}

	public int helper(TreeNode root) {
		if (root == null)
			return 0;
		int leftDiameter = helper(root.left);
		int rightDiameter = helper(root.right);
		int currentDiameter = leftDiameter + rightDiameter + 1;
		diameter = Math.max(currentDiameter, diameter);
		return 1 + Math.max(leftDiameter, rightDiameter);
	}

}
