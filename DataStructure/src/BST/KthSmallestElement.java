package BST;

public class KthSmallestElement {

	static int count = 0;

	public static void main(String[] args) {
		BinarySearchTreeNode root = TreeStructure.treeStructure();
		inOrder(root);
		BinarySearchTreeNode res = KthSmallestElement_IstWay(root, 5);
		System.out.println();
		System.out.println(res.data);
//		for (int i = 1; i < 8; i++) {
//			count = 0;
//			KthSmallestElement_IIndWay(root, i);
//		}

	}

	private static void KthSmallestElement_IIndWay(BinarySearchTreeNode root, int k) {
		if (root.left != null)
			KthSmallestElement_IIndWay(root.left, k);
		count++;
		if (count == k) {
			System.out.println(root.data);
			return;
		}
		if (root.right != null)
			KthSmallestElement_IIndWay(root.right, k);
	}

	private static BinarySearchTreeNode KthSmallestElement_IstWay(BinarySearchTreeNode root, int k) {
		if (root == null)
			return null;
		BinarySearchTreeNode left = KthSmallestElement_IstWay(root.left, k);
		if (left != null)
			return left;
		if (++count == k)
			return root;
		return KthSmallestElement_IstWay(root.right, k);
	}

	private static void inOrder(BinarySearchTreeNode root) {
		if (root == null)
			return;
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}
}
