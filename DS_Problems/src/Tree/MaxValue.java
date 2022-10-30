package Tree;

public class MaxValue {
	public static void main(String[] args) {
		System.out.println(maxValue(GetRoot.getRoot()));
	}

	public static int maxValue(TreeNode root) {
		if (root == null)
			return Integer.MIN_VALUE;
		int leftValue = maxValue(root.left);
		int rightValue = maxValue(root.right);
		return Math.max(Math.max(leftValue, rightValue), root.val);
	}

}
