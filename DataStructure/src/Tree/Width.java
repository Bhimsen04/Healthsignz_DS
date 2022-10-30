package Tree;

public class Width {

	public static void main(String[] args) {
		BinaryTreeNode root = TreeStructure.treeStructure();
		width(root);
	}

	private static void width(BinaryTreeNode root) {
		int height = height(root), level = 0;
		int count[] = new int[height];
		getMaxWithRec(root, count, level);
		int max = count[0];
		for (int i = 1; i < count.length; i++)
			if (count[i] > max)
				max = count[i];
		System.out.println("Max width :- " + max);
		count = new int[height];
		level = 0;
		getMaxSumWithRec(root, count, level);
		max = count[0];
		for (int i = 1; i < count.length; i++)
			if (count[i] > max)
				max = count[i];
		System.out.println("Max width sum :- " + max);

	}

	private static void getMaxSumWithRec(BinaryTreeNode root, int[] count, int level) {
		if (root != null) {
			count[level] += root.getData();
			getMaxSumWithRec(root.left, count, level + 1);
			getMaxSumWithRec(root.right, count, level + 1);
		}
	}

	private static void getMaxWithRec(BinaryTreeNode root, int[] count, int level) {
		if (root != null) {
			count[level]++;
			getMaxWithRec(root.left, count, level + 1);
			getMaxWithRec(root.right, count, level + 1);
		}
	}

	private static int height(BinaryTreeNode root) {
		if (root == null)
			return 0;
		int left = height(root.left);
		int right = height(root.right);
		return Math.max(left, right) + 1;
	}
}
