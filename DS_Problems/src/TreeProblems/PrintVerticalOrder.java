package TreeProblems;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

import Tree.GetRoot;
import Tree.TreeNode;

public class PrintVerticalOrder {

	// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/submissions/
	public static void main(String[] args) {
		TreeNode root = GetRoot.getRoot();
		System.out.println(new PrintVerticalOrder().verticalTraversal(root));
	}

	public List<List<Integer>> verticalTraversal(TreeNode root) {
		TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
		recurse(root, map, 0, 1);
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Collection<TreeMap<Integer, List<Integer>>> values = map.values();
		for (TreeMap<Integer, List<Integer>> m : values) {
			Collection<List<Integer>> values2 = m.values();
			List<Integer> newList = new ArrayList<Integer>();
			for (List<Integer> ll : values2) {
				Collections.sort(ll);
				for (int t : ll)
					newList.add(t);
			}
			list.add(newList);
		}
		return list;
	}

	private void recurse(TreeNode root, TreeMap<Integer, TreeMap<Integer, List<Integer>>> map, int distance,
			int level) {
		if (root == null)
			return;
		if (!map.containsKey(distance))
			map.put(distance, new TreeMap<>());
		if (map.containsKey(distance) && !map.get(distance).containsKey(level))
			map.get(distance).put(level, new ArrayList<>());
		map.get(distance).get(level).add(root.val);
		recurse(root.left, map, distance - 1, level + 1);
		recurse(root.right, map, distance + 1, level + 1);
	}
}
