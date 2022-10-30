package Tries;

public class MaxXORofTwoNumbersArray2 {

	// https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
	class Tries {
		int data;
		Tries left;
		Tries right;

		public Tries(int data) {
			this.data = data;
		}
	}

	public int findMaximumXOR(int[] nums) {
		Tries root = new Tries(0);
		insertIntoTries(nums, root);
		return getMaxOrFromTries(nums, root);
	}

	private void insertIntoTries(int[] nums, Tries root) {
		for (int i = 0; i < nums.length; i++) {
			Tries temp = root;
			int element = nums[i];
			for (int j = 31; j >= 0; j--) {
				int val = (1 << j) & element;
				if (val == 0) {
					if (temp.left == null)
						temp.left = new Tries(0);
					temp = temp.left;
				} else {
					if (temp.right == null)
						temp.right = new Tries(1);
					temp = temp.right;
				}
			}
		}
	}

	private int getMaxOrFromTries(int[] nums, Tries root) {
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			Tries temp = root;
			int curr = 0;
			int element = nums[i];
			for (int j = 31; j >= 0; j--) {
				int val = (1 << j) & element;
				if (val == 0) {
					if (temp.right != null) {
						curr += 1 << j;
						temp = temp.right;
					} else
						temp = temp.left;

				} else {
					if (temp.left != null) {
						curr += 1 << j;
						temp = temp.left;
					} else
						temp = temp.right;
				}
			}
			max = Math.max(curr, max);
		}
		return max;
	}

	public static void main(String[] args) {
		int[] arr = { 8, 10, 2 };
		System.out.println(new MaxXORofTwoNumbersArray2().findMaximumXOR(arr));
	}
}
