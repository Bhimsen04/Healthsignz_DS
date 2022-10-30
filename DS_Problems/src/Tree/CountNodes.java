package Tree;

public class CountNodes {

	public static void main(String[] args) {
		System.out.println(countNodes(GetRoot.getRoot()));
	}

	public static int countNodes(TreeNode root) {
		if (root == null)
			return 0;
		return countNodes(root.left) + 1 + countNodes(root.right);
	}
}
