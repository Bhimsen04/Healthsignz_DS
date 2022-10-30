package TreeProblems;

import java.util.HashMap;

import Tree.LevelOrder;
import Tree.TreeNode;

public class InOrderPreOrder_PostOrder {

	// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
	int index = 0;

	public static void main(String[] args) {
		int[] preorder = { 3, 9, 20, 15, 7 };
		int[] inorder = { 9, 3, 15, 20, 7 };
		TreeNode root = new InOrderPreOrder_PostOrder().buildTree(preorder, inorder);
		System.out.println(LevelOrder.levelOrder(root));
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {

		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < inorder.length; i++)
			map.put(inorder[i], i);

		return constructBT(preorder, map, 0, preorder.length - 1);
	}

	public TreeNode constructBT(int[] preorder, HashMap<Integer, Integer> map, int start, int end) {

		if (start > end)
			return null;
		int val = preorder[index++];
		int idx = map.get(val);
		TreeNode root = new TreeNode(val);
		root.left = constructBT(preorder, map, start, idx - 1);
		root.right = constructBT(preorder, map, idx + 1, end);
		return root;
	}
}
