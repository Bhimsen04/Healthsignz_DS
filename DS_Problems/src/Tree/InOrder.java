package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrder {
	// https://leetcode.com/problems/binary-tree-inorder-traversal/
	List<Integer> list = new ArrayList<Integer>();

	public List<Integer> inorderTraversal_Recursive(TreeNode root) {
		if (root == null)
			return list;
		inorderTraversal_Recursive(root.left);
		list.add(root.val);
		return inorderTraversal_Recursive(root.right);
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		while (!stack.isEmpty() || root != null) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			list.add(root.val);
			root = root.right;
		}
		return list;
	}

	public static void main(String[] args) {
		TreeNode root = GetRoot.getRoot();
		System.out.println(new InOrder().inorderTraversal_Recursive(root));
		System.out.println(new InOrder().inorderTraversal(root));
	}

}
