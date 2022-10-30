package TreeProblems;

import java.util.TreeMap;

import Tree.GetRoot;
import Tree.TreeNode;

public class TopView {
	// https://www.hackerrank.com/challenges/tree-top-view/problem
	public static void main(String[] args) {
		topView(GetRoot.getRoot());
	}

	public static void topView(TreeNode root) {
		TreeMap<Integer, Integer> map1 = new TreeMap<>();
		TreeMap<Integer, Integer> map2 = new TreeMap<>();
		topView(root, map1, map2, 0, 1);
		for (int val : map1.values())
			System.out.print(val + " ");

	}

	private static void topView(TreeNode root, TreeMap<Integer, Integer> dist_val, TreeMap<Integer, Integer> dist_lvl,
			int distance, int level) {
		if (root == null)
			return;
		if ((!dist_lvl.containsKey(distance)) || (level < dist_lvl.get(distance))) {
			dist_val.put(distance, root.val);
			dist_lvl.put(distance, level);
		}
		topView(root.left, dist_val, dist_lvl, distance - 1, level + 1);
		topView(root.right, dist_val, dist_lvl, distance + 1, level + 1);
	}
}
