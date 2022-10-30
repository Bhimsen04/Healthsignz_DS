package Tree;

public class FindMaxElement {

	public static void main(String[] args) {
		BinaryTreeNode binaryTreeNode = null;
		BinaryTreeNode root = new BinaryTreeNode(100);

		binaryTreeNode = new BinaryTreeNode(200);
		root.setLeft(binaryTreeNode);
		binaryTreeNode = new BinaryTreeNode(300);
		root.setRight(binaryTreeNode);

		binaryTreeNode = new BinaryTreeNode(400);
		root.getLeft().setLeft(binaryTreeNode);
		binaryTreeNode = new BinaryTreeNode(800);
		root.getLeft().setRight(binaryTreeNode);

		binaryTreeNode = new BinaryTreeNode(600);
		root.getRight().setLeft(binaryTreeNode);
		binaryTreeNode = new BinaryTreeNode(700);
		root.getRight().setRight(binaryTreeNode);

		int max = maxInBinartTree(root);
		System.out.println(max);
	}

	private static int maxInBinartTree(BinaryTreeNode root) {
		int maxValue = Integer.MIN_VALUE;
		if (root != null) {
			int leftMax = maxInBinartTree(root.left);
			int rightMax = maxInBinartTree(root.right);
			if (leftMax > rightMax)
				maxValue = leftMax;
			else
				maxValue = rightMax;
			if (root.data > maxValue)
				maxValue = root.data;
		}
		return maxValue;
	}
}
