package Tree;

import java.util.ArrayList;
import java.util.HashMap;

public class VerticalSum {
	// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
	public static void main(String[] args) {
		BinaryTreeNode root = TreeStructure.treeStructure();
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		verticalTraversal(map, root, 0);
		System.out.println(map);

		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		verticalSum(hash, root, 0);
		System.out.println(hash);
	}

	private static void verticalTraversal(HashMap<Integer, ArrayList<Integer>> map, BinaryTreeNode root, int c) {
		if (root.left != null)
			verticalTraversal(map, root.left, c - 1);
		if (root.right != null)
			verticalTraversal(map, root.right, c + 1);
		ArrayList<Integer> list = new ArrayList<>();
		if (map.containsKey(c))
			list = map.get(c);
		list.add(root.getData());
		map.put(c, list);

	}

	private static void verticalSum(HashMap<Integer, Integer> hash, BinaryTreeNode root, int c) {
		if (root.left != null)
			verticalSum(hash, root.left, c - 1);
		if (root.right != null)
			verticalSum(hash, root.right, c + 1);
		int data = 0;
		if (hash.containsKey(c))
			data = hash.get(c);
		hash.put(c, root.getData() + data);

	}

}