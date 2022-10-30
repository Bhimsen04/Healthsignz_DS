package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrder {
	// https://leetcode.com/problems/binary-tree-preorder-traversal/
	List<Integer> list = new ArrayList<Integer>();

	public List<Integer> preorderTraversal_Recursive(TreeNode root) {
		if (root == null)
			return list;
		list.add(root.val);
		preorderTraversal_Recursive(root.left);
		return preorderTraversal_Recursive(root.right);
	}

	private List<Integer> preOrderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		while (!stack.isEmpty() || root != null) {
			while (root != null) {
				list.add(root.val);
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			root = root.right;
		}
		return list;
	}

	public static void main(String[] args) {
		TreeNode root = GetRoot.getRoot();
		System.out.println(new PreOrder().preorderTraversal_Recursive(root));
		System.out.println(new PreOrder().preOrderTraversal(root));
	}
}
