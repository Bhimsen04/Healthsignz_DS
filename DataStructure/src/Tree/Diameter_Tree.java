package Tree;

public class Diameter_Tree {
	
	private static int diameter;

	public static void main(String[] args) {
		BinaryTreeNode root = TreeStructure.treeStructure();
		diameterOfTree(root);
		System.out.println(diameter);
	}

	private static int diameterOfTree(BinaryTreeNode root) {
		int left, right;
		if (root == null)
			return 0;
		left = diameterOfTree(root.left);
		right = diameterOfTree(root.right);
		
		diameter = Math.max(diameter, 1 + left + right);
		
		return Math.max(left, right) + 1;
	}
}
