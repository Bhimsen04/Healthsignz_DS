package Tree.view;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;
import java.util.Map.Entry;

import Tree.BinaryTreeNode;
import Tree.TreeStructure;
import Tree.view.TopView.Pair;

public class BottomView {

	static class Pair {
		int first, second;

		Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}

	static TreeMap<Integer, Pair> m = new TreeMap<>();

	// It is level order traversal + vertical order traversal
	public static void main(String[] args) {
		BinaryTreeNode root = TreeStructure.treeStructure();
		bottomView(root);
		System.out.println();
		bottomViewByRecursion(root, 0, 0);
		for (Entry<Integer, Pair> e : m.entrySet())
			System.out.print(e.getValue().first + " ");
	}

	private static void bottomViewByRecursion(BinaryTreeNode root, int d, int l) {
		if (root == null)
			return;
		if (m.get(d) == null)
			m.put(d, new Pair(root.data, l));
		else if (m.get(d).second <= l) // dought here must or not
			m.put(d, new Pair(root.data, l));
		bottomViewByRecursion(root.left, d - 1, l++);
		bottomViewByRecursion(root.right, d + 1, l);
	}

	private static void bottomView(BinaryTreeNode root) {
		class QueueObj {
			BinaryTreeNode node;
			int hd;

			QueueObj(BinaryTreeNode node, int hd) {
				this.node = node;
				this.hd = hd;
			}
		}
		Queue<QueueObj> q = new LinkedList<QueueObj>();
		HashMap<Integer, Integer> map = new HashMap<>();
		q.offer(new QueueObj(root, 0));
		while (!q.isEmpty()) {
			QueueObj temp = q.poll();
			// if (!map.containsKey(temp.hd))
			map.put(temp.hd, temp.node.data);
			if (temp.node.left != null)
				q.offer(new QueueObj(temp.node.left, temp.hd - 1));
			if (temp.node.right != null)
				q.offer(new QueueObj(temp.node.right, temp.hd + 1));
		}
		for (Entry<Integer, Integer> e : map.entrySet()) {
			System.out.print(e.getValue() + " ");
		}
	}
}
