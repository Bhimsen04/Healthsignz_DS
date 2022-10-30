package TreeProblems;

import java.util.ArrayList;
import java.util.List;

import Tree.GetRoot;
import Tree.TreeNode;

public class FindPathBetweenTwoNodes {

	public static void main(String[] args) {
		TreeNode root = GetRoot.getRoot();
		List<TreeNode> l1 = new ArrayList<>();
		List<TreeNode> l2 = new ArrayList<>();
		findPath(root, 9, l1);
		findPath(root, 10, l2);

	}

	private static void findPath(TreeNode root, int val, List<TreeNode> list) {
		if (root == null) {
			list = new ArrayList<>();
		}

		findPath(root.left, val, list);
	}
}
