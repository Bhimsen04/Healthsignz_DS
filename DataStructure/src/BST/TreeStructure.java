package BST;

public class TreeStructure {

	public static BinarySearchTreeNode treeStructure() {
		BinarySearchTreeNode binaryTreeNode = null;
		BinarySearchTreeNode root = new BinarySearchTreeNode(20);

		binaryTreeNode = new BinarySearchTreeNode(8);
		root.setLeft(binaryTreeNode);
		binaryTreeNode = new BinarySearchTreeNode(22);
		root.setRight(binaryTreeNode);

		binaryTreeNode = new BinarySearchTreeNode(4);
		root.getLeft().setLeft(binaryTreeNode);
		binaryTreeNode = new BinarySearchTreeNode(12);
		root.getLeft().setRight(binaryTreeNode);

		// binaryTreeNode = new BinarySearchTreeNode(6);
		// root.getRight().setLeft(binaryTreeNode);
		// binaryTreeNode = new BinarySearchTreeNode(7);
		// root.getRight().setRight(binaryTreeNode);

		binaryTreeNode = new BinarySearchTreeNode(21);
		root.getRight().setLeft(binaryTreeNode);
		binaryTreeNode = new BinarySearchTreeNode(24);
		root.getRight().setRight(binaryTreeNode);
		// binaryTreeNode = new BinaryTreeNode(8);
		// root.getLeft().getLeft().setLeft(binaryTreeNode);
		//
		// binaryTreeNode = new BinaryTreeNode(9);
		// root.getRight().getRight().setRight(binaryTreeNode);
		return root;
	}
}
