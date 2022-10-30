package Tree;

public class HasPathSum {
	public static void main(String[] args) {
		BinaryTreeNode root = TreeStructure.treeStructure();
		boolean flag = hasPathSum(root, 1100);
		System.out.println(flag);

	}

	private static boolean hasPathSum(BinaryTreeNode node, int sum) {
		if (node == null)
			return false;
		if (node.left == null && node.right == null)
			return sum == node.data;
		boolean flag =  hasPathSum(node.left, sum - node.data) || hasPathSum(node.right, sum - node.data);
		return flag;
	}
}
