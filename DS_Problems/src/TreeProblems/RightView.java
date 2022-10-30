package TreeProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Tree.GetRoot;
import Tree.TreeNode;

public class RightView {

	// https://leetcode.com/problems/binary-tree-right-side-view/
	public static void main(String[] args) {
		System.out.println(new RightView().rightSideView(GetRoot.getRoot()));
	}

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null)
			return list;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		while (!queue.isEmpty()) {
			int result = 0;
			while (queue.peek() != null) {
				TreeNode temp = queue.poll();
				if (temp.left != null)
					queue.add(temp.left);
				if (temp.right != null)
					queue.add(temp.right);
				result = temp.val;
			}
			list.add(result);
			queue.poll();
			if (!queue.isEmpty())
				queue.add(null);
		}
		return list;
	}
}
