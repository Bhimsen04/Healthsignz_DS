package Tree;

public class SizeOfBT {

	public static void main(String[] args) {
		BinaryTreeNode binaryTreeNode = null;
		BinaryTreeNode root = new BinaryTreeNode(100);

		binaryTreeNode = new BinaryTreeNode(200);
		root.setLeft(binaryTreeNode);
		binaryTreeNode = new BinaryTreeNode(300);
		root.setRight(binaryTreeNode);

		binaryTreeNode = new BinaryTreeNode(400);
		root.getLeft().setLeft(binaryTreeNode);
		binaryTreeNode = new BinaryTreeNode(1500);
		root.getLeft().setRight(binaryTreeNode);

		binaryTreeNode = new BinaryTreeNode(600);
		root.getRight().setLeft(binaryTreeNode);
		binaryTreeNode = new BinaryTreeNode(700);
		root.getRight().setRight(binaryTreeNode);

		int size = size(root);
		System.out.println(size);
	}

	private static int size(BinaryTreeNode root) {
		int leftCount = root.left == null ? 0 : size(root.left);
		int rightCount = root.right == null ? 0 : size(root.right);
		return leftCount + 1 + rightCount;
	}
}
