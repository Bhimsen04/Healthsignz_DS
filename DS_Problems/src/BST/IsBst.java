package BST;

import Tree.GetRoot;
import Tree.InOrder;
import Tree.TreeNode;

public class IsBst {

	// https://leetcode.com/problems/validate-binary-search-tree/submissions/
	public static void main(String[] args) {
		TreeNode root = GetRoot.getRoot();
		System.out.println(new InOrder().inorderTraversal(root));
		System.out.println(new IsBst().isValidBST(root));
	}

	long lastValue = Integer.MIN_VALUE;

	public boolean isValidBST(TreeNode root) {
		if (root != null && root.left == null && root.right == null)
			return true;
		return isValidBST(root, true);
	}

	public boolean isValidBST(TreeNode root, boolean flag) {
		if (root == null)
			return flag;
		flag = isValidBST(root.left, flag);
		if (lastValue >= root.val)
			flag = false;
		else
			lastValue = root.val;
		flag = isValidBST(root.right, flag);
		return flag;
	}

	public boolean isValidBST(TreeNode root, int min, int max) {
		if (root == null)
			return true;
		return root.val > min && root.val < max && isValidBST(root.left, min, root.val)
				&& isValidBST(root.right, root.val, max);

	}
}
