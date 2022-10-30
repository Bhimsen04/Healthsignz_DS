package Tree;

public class Diameter_Tree2 {

	static int diameter = 0;

	public static void main(String[] args) {
		BinaryTreeNode root = TreeStructure.treeStructure();
		System.out.println("Diameter is " + diameter(root));
	}

	static class A {
		int ans = Integer.MIN_VALUE;
	}

	/* Function to find height of a tree */
	static int height(BinaryTreeNode root, A a) {
		if (root == null)
			return 0;

		int left_height = height(root.left, a);

		int right_height = height(root.right, a);

		a.ans = Math.max(a.ans, 1 + left_height + right_height);

		return 1 + Math.max(left_height, right_height);
	}

	/*
	 * Computes the diameter of binary tree with given root.
	 */
	static int diameter(BinaryTreeNode root) {
		if (root == null)
			return 0;

		// This will store the final answer
		A a = new A();
		int height_of_tree = height(root, a);
		System.out.println("Height is " + height_of_tree);
		return a.ans;
	}

}
