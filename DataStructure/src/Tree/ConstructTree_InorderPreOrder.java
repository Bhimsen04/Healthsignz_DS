package Tree;

public class ConstructTree_InorderPreOrder {

	public static void main(String[] args) {
		int[] inOrder = { 4, 2, 5, 1, 3, 7 };
		int[] preOrder = { 1, 2, 4, 5, 3, 7 };
		BinaryTreeNode root = null;
		if (preOrder.length != 0 && inOrder.length == preOrder.length)
			root = buildBT(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
		inOrder(root);
		System.out.println();
		preOrder(root);
	}

	private static void preOrder(BinaryTreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		inOrder(root.left);
		inOrder(root.right);
	}

	private static void inOrder(BinaryTreeNode root) {
		if (root == null) {
			return;
		}
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}

	private static BinaryTreeNode buildBT(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart,
			int inEnd) {
		if (inStart > inEnd || preStart > preEnd)
			return null;
		int val = preOrder[preStart];
		BinaryTreeNode curr = new BinaryTreeNode(val);
		int offset = inStart;
		for (; offset < inEnd; offset++) {
			if (inOrder[offset] == val)
				break;
		}
		curr.left = buildBT(preOrder, preStart + 1, preStart + offset - inStart, inOrder, inStart, offset - 1);
		curr.right = buildBT(preOrder, preStart + offset - inStart + 1, preEnd, inOrder, offset + 1, inEnd);
		return curr;
	}
}
