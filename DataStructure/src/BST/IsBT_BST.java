package BST;

public class IsBT_BST {
	public static void main(String[] args) {
		BinarySearchTreeNode root = TreeStructure.treeStructure();
		int minValue = Integer.MIN_VALUE;
		int maxValue = Integer.MAX_VALUE;
		boolean res = isBST(root, minValue, maxValue);
	}

	private static boolean isBST(BinarySearchTreeNode root, int minValue, int maxValue) {
		if (root == null)
			return true;
		return root.data > minValue && root.data < maxValue && isBST(root.left, minValue, root.data)
				&& isBST(root.right, root.data, maxValue);
	}
}
