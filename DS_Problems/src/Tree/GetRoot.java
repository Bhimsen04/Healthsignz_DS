package Tree;

public class GetRoot {

	public static TreeNode getRoot() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(6);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(7);
		// root.left.left.left = new TreeNode(365434543);
		// root.left.right = new TreeNode(5);
		// root.right.left = new TreeNode(1);
		// root.right.right = new TreeNode(12);
		// // root.left.left.right = new TreeNode(80);
		// root.right.right.left = new TreeNode(2);
		return root;
	}
}
