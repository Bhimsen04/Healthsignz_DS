package BST;

import Tree.GetRoot;
import Tree.LevelOrder;
import Tree.TreeNode;

public class BST {
	public static void main(String[] args) {
		TreeNode root = GetRoot.getRoot();
		BST bst = new BST();
		bst.insertIntoBST(root, 5);
		bst.insertIntoBST(root, 9);
		bst.insertIntoBST(root, 8);
		bst.insertIntoBST(root, 7);
		System.out.println(LevelOrder.levelOrder(root));

	}

	// https://leetcode.com/problems/insert-into-a-binary-search-tree/submissions/
	public TreeNode insertIntoBST(TreeNode root, int val) {

		if (root == null)
			return new TreeNode(val);
		else if (val <= root.val)
			root.left = insertIntoBST(root.left, val);
		else if (val > root.val)
			root.right = insertIntoBST(root.right, val);
		return root;
	}

	// https://leetcode.com/problems/delete-node-in-a-bst/
	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null)
			return null;
		else if (key < root.val)
			root.left = deleteNode(root.left, key);
		else if (key > root.val)
			root.right = deleteNode(root.right, key);
		else {
			if (root.right == null)
				return root.left;
			else if (root.left == null)
				return root.right;
			else {
				// TreeNode maxValueLeftTree = root.left; // predecessor
				// while (maxValueLeftTree != null && maxValueLeftTree.right != null) {
				// maxValueLeftTree = maxValueLeftTree.right;
				// }
				// root.val = maxValueLeftTree.val;
				// root.left = deleteNode(root.left, maxValueLeftTree.val);
				TreeNode minValueRightTree = root.right; // successor
				while (minValueRightTree != null && minValueRightTree.left != null)
					minValueRightTree = minValueRightTree.left;
				root.val = minValueRightTree.val;
				root.right = deleteNode(root.right, minValueRightTree.val);
			}

		}
		return root;
	}

	public TreeNode searchBST(TreeNode root, int val) {
		if (root == null)
			return null;
		else if (val == root.val)
			return root;
		else if (val < root.val)
			root = searchBST(root.left, val);
		else if (val > root.val)
			root = searchBST(root.right, val);
		return root;
	}
}
