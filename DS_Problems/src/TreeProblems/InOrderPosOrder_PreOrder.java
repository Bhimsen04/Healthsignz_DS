package TreeProblems;

import java.util.HashMap;

import Tree.LevelOrder;
import Tree.TreeNode;

public class InOrderPosOrder_PreOrder {

	// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
	int index = 0;

	public static void main(String[] args) {
		int[] inorder = { 9, 3, 15, 20, 7 };
		int[] postorder = { 9, 15, 7, 20, 3 };
		TreeNode root = new InOrderPosOrder_PreOrder().buildTree(postorder, inorder);
		System.out.println(LevelOrder.levelOrder(root));
	}

	public TreeNode buildTree(int[] postorder, int[] inorder) {
		index = postorder.length - 1;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < inorder.length; i++)
			map.put(inorder[i], i);

		return constructBT(postorder, map, 0, postorder.length - 1);
	}

	public TreeNode constructBT(int[] postorder, HashMap<Integer, Integer> map, int start, int end) {

		if (start > end)
			return null;
		int val = postorder[index--];
		int idx = map.get(val);
		TreeNode root = new TreeNode(val);
		root.right = constructBT(postorder, map, idx + 1, end);
		root.left = constructBT(postorder, map, start, idx - 1);
		return root;
	}
}
