package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrder {

	// https://leetcode.com/problems/binary-tree-postorder-traversal/
	List<Integer> list = new ArrayList<Integer>();

	public List<Integer> postorderTraversal_Recursive(TreeNode root) {
		if (root == null)
			return list;
		postorderTraversal_Recursive(root.left);
		postorderTraversal_Recursive(root.right);
		list.add(root.val);
		return list;
	}

	public List<Integer> postorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode last = null; // we don't want to back insert in stack during coming back 
		while (!stack.isEmpty() || root != null) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			TreeNode temp = stack.peek();
			if (temp.right != null && temp.right != last)
				root = temp.right;
			else {
				stack.pop();
				list.add(temp.val);
				last = temp;
			}

		}
		return list;
	}

	public static void main(String[] args) {
		TreeNode root = GetRoot.getRoot();
		System.out.println(new PostOrder().postorderTraversal_Recursive(root));
		System.out.println(new PostOrder().postorderTraversal(root));
	}

}
