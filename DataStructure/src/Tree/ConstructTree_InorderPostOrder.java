package Tree;

public class ConstructTree_InorderPostOrder {

	public static void main(String[] args) {
		int[] inOrder = { 4, 2, 5, 1, 3, 7 };
		int[] postOrder = { 4, 5, 2, 3, 7, 1 };
		BinaryTreeNode root = null;
		if (postOrder.length != 0 && inOrder.length == postOrder.length)
			root = buildBT(postOrder, 0, postOrder.length - 1, inOrder, 0, inOrder.length - 1);
	/*	inOrder(root);
		System.out.println();*/
		postOrder(root);
	}

	private static void postOrder(BinaryTreeNode root) {
		if (root != null) {
			inOrder(root.left);
			inOrder(root.right);
			System.out.print(root.data + " ");
		}
	}

	private static void inOrder(BinaryTreeNode root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
		}
	}

	private static BinaryTreeNode buildBT(int[] postOrder, int postStart, int postEnd, int[] inOrder, int inStart,
			int inEnd) {
		if (inStart > inEnd || postStart > postEnd)
			return null;
		int val = postOrder[postEnd];
		BinaryTreeNode curr = new BinaryTreeNode(val);
		int offset = inStart;
		for (; offset < inEnd; offset++) {
			if (inOrder[offset] == val)
				break;
		}
		curr.left = buildBT(postOrder, postStart, postStart + offset - inStart - 1, inOrder, inStart, offset - 1);
		curr.right = buildBT(postOrder, postStart + offset - inStart, postEnd - 1, inOrder, offset + 1, inEnd);
		return curr;
	}
}
