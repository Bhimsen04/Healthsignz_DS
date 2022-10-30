package Tree;

public class RootToLeafPaths {

	public static void main(String[] args) {
		BinaryTreeNode root = TreeStructure.treeStructure();
		int[] path = new int[256];
		root_leafPath(root, path, 0);

	}

	private static void root_leafPath(BinaryTreeNode root, int[] path, int pathLen) {
		if (root == null)
			return;
		path[pathLen++] = root.data;
		if (root.left == null && root.right == null) {
			for (int i = 0; i < pathLen; i++) {
				System.out.print(path[i] + " ");
			}
			System.out.println();
		} else {
			root_leafPath(root.left, path, pathLen);
			root_leafPath(root.right, path, pathLen);
		}
	}
}
