package TreeProblems;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeMap;

import Tree.GetRoot;
import Tree.TreeNode;

public class PrintVerticalOrder2 {

	public static void main(String[] args) {
		TreeNode root = GetRoot.getRoot();
		System.out.println(new PrintVerticalOrder().verticalTraversal(root));
	}

	public List<List<Integer>> verticalTraversal(TreeNode root) {
		TreeMap<Integer, List<Integer>> map = new TreeMap<>();
		recurse(root, 0, map);
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Collection<List<Integer>> values = map.values();
		for (List<Integer> l : values) {
			list.add(l);
		}
		return list;
	}

	private void recurse(TreeNode root, int distance, TreeMap<Integer, List<Integer>> map) {
		if (root == null)
			return;
		if (!map.containsKey(distance))
			map.put(distance, new ArrayList<>());
		map.get(distance).add(root.val);
		recurse(root.left, distance - 1, map);
		recurse(root.right, distance + 1, map);
	}
}
