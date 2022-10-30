package Tree;

import java.util.ArrayList;
import java.util.List;

public class DeepestNode {
	static int maxLevel = -1;
	static List<Integer> res = new ArrayList<>();

	public static void main(String[] args) {

		BinaryTreeNode binaryTreeNode = null;
		BinaryTreeNode root = new BinaryTreeNode(100);

		binaryTreeNode = new BinaryTreeNode(200);
		root.setLeft(binaryTreeNode);
		binaryTreeNode = new BinaryTreeNode(300);
		root.setRight(binaryTreeNode);

		binaryTreeNode = new BinaryTreeNode(400);
		root.getLeft().setLeft(binaryTreeNode);
		binaryTreeNode = new BinaryTreeNode(500);
		root.getLeft().setRight(binaryTreeNode);

		binaryTreeNode = new BinaryTreeNode(600);
		root.getRight().setLeft(binaryTreeNode);
		binaryTreeNode = new BinaryTreeNode(700);
		root.getRight().setRight(binaryTreeNode);

		// binaryTreeNode = new BinaryTreeNode(800);
		// root.getLeft().getLeft().setLeft(binaryTreeNode);

		Traversals.levelOrderTraversal(root);
		deepestNode(root, 0);
		System.out.println(res);
	}

	// maxLevel : keeps track of maximum level seen so far.
	// res : Value of deepest node so far.
	// level : Level of root
	static void deepestNode(BinaryTreeNode root, int level) {
		if (root != null) {

			// Update level and resue
			if (level > maxLevel) {
				res.clear();
				res.add(root.data);
				maxLevel = level;
			} else if (level == maxLevel) {
				res.add(root.data);
			}

			deepestNode(root.left, ++level);

			deepestNode(root.right, level);
		}
	}
}
