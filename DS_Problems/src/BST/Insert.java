package BST;

import Tree.GetRoot;
import Tree.LevelOrder;
import Tree.TreeNode;

public class Insert {

	public static void main(String[] args) {
		TreeNode root = GetRoot.getRoot();
		Insert bst = new Insert();
		root = bst.insertIntoBST(root, 5);
		bst.insertIntoBST(root, 9);
		bst.insertIntoBST(root, 8);
		bst.insertIntoBST(root, 7);
		System.out.println(LevelOrder.levelOrder(root));

	}

	public TreeNode insertIntoBST(TreeNode root, int val) {
		if (root == null)
			root = new TreeNode(val);
		else
			insertIntoBST2(root, val);
		return root;
	}

	public void insertIntoBST2(TreeNode root, int val) {

		if (val <= root.val) {
			if (root.left == null) {
				root.left = new TreeNode(val);
				return;
			}
			insertIntoBST2(root.left, val);
		} else if (val > root.val) {
			if (root.right == null) {
				root.right = new TreeNode(val);
				return;
			}
			insertIntoBST2(root.right, val);
		}
	}
}
