package TreeProblems;

import Tree.GetRoot;
import Tree.TreeNode;

public class SumOfAllPaths2 {

	int M = 1000000009;

	public static void main(String[] args) {
		TreeNode root = GetRoot.getRoot();
		System.out.println(new SumOfAllPaths2().getSum(0, root));
	}

	public long getSum(long curr, TreeNode root) {
		long digits = countNoOfDigits(root.val);
		curr = (int) ((curr * Math.pow(10, digits) % M) + root.val) % M;
		if (root.left == null && root.right == null)
			return curr;
		long left = (root.left != null ? getSum(curr, root.left) : 0);
		long right = (root.right != null ? getSum(curr, root.right) : 0);
		return left + right;
	}

	public long countNoOfDigits(int num) {
		int counter = 0;
		while (num != 0) {
			counter++;
			num = num / 10;
		}
		return counter;
	}

}
