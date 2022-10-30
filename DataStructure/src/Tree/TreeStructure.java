package Tree;

public class TreeStructure {

	public static BinaryTreeNode treeStructure() {
		BinaryTreeNode binaryTreeNode = null;
		BinaryTreeNode root = new BinaryTreeNode(1);

		binaryTreeNode = new BinaryTreeNode(2);
		root.setLeft(binaryTreeNode);
		binaryTreeNode = new BinaryTreeNode(3);
		root.setRight(binaryTreeNode);

		binaryTreeNode = new BinaryTreeNode(4);
		root.getLeft().setLeft(binaryTreeNode);
		binaryTreeNode = new BinaryTreeNode(5);
		root.getLeft().setRight(binaryTreeNode);

		binaryTreeNode = new BinaryTreeNode(6);
		root.getRight().setLeft(binaryTreeNode);
		binaryTreeNode = new BinaryTreeNode(7);
		root.getRight().setRight(binaryTreeNode);

//		 binaryTreeNode = new BinaryTreeNode(8);
//		 root.getLeft().getLeft().setLeft(binaryTreeNode);
		//
		// binaryTreeNode = new BinaryTreeNode(9);
		// root.getRight().getRight().setRight(binaryTreeNode);

		Traversals.levelOrderTraversal(root);
		return root;
	}
}
