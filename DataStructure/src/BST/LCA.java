package BST;

public class LCA {

	public static void main(String[] args) {
		BinarySearchTreeNode root = TreeStructure.treeStructure();
		BinarySearchTreeNode ans = LCA(root, 10, 14);
		System.out.println(ans.getData());
	}

	private static BinarySearchTreeNode LCA(BinarySearchTreeNode root, int a, int b) {
		if (root == null)
			return null;
		if (root.data > a && root.data > b)
			return LCA(root.left, a, b);
		else if (root.data < a && root.data < b)
			return LCA(root.right, a, b);
		else
			return root;

	}
}
