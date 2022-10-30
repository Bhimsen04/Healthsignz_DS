package Tree;

public class Sum {

	public static void main(String[] args) {
		System.out.println(sum(GetRoot.getRoot()));
	}

	public static int sum(TreeNode root) {
		if (root == null)
			return 0;
		return root.val + sum(root.left) + sum(root.right);
	}
}
