package TreeProblems;

import Tree.GetRoot;
import Tree.TreeNode;

public class SumOfAllPaths {

	static int sum = 0;
	int M = 1000000009;

	public static void main(String[] args) {
		TreeNode root = GetRoot.getRoot();
		new SumOfAllPaths().getSum(0, root);
		System.out.println(sum);
	}

	public void getSum(int curr, TreeNode root) {
		int digits = countNoOfDigits(root.val);
		curr = (int) ((curr * Math.pow(10, digits) % M) + root.val) % M;
		if (root.left == null && root.right == null) {
			sum = (sum + curr) % M;
			return;
		}
		if (root.left != null)
			getSum(curr, root.left);
		if (root.right != null)
			getSum(curr, root.right);
	}

	public int countNoOfDigits(int num) {
		int counter = 0;
		while (num != 0) {
			counter++;
			num = num / 10;
		}
		return counter;
	}
}
