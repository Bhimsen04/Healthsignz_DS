package Tries;

public class MaxXORofTwoNumbersArray3 {

	// https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
	class Tries {
		int data;
		Tries[] children;

		public Tries(int data) {
			this.data = data;
			children = new Tries[2];
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
					if (temp.children[0] == null)
						temp.children[0] = new Tries(0);
					temp = temp.children[0];
				} else {
					if (temp.children[1] == null)
						temp.children[1] = new Tries(1);
					temp = temp.children[1];
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
					if (temp.children[1] != null) {
						curr += 1 << j;
						temp = temp.children[1];
					} else
						temp = temp.children[0];

				} else {
					if (temp.children[0] != null) {
						curr += 1 << j;
						temp = temp.children[0];
					} else
						temp = temp.children[1];
				}
			}
			max = Math.max(curr, max);
		}
		return max;
	}

	public static void main(String[] args) {
		int[] arr = { 8, 10, 2 };
		System.out.println(new MaxXORofTwoNumbersArray3().findMaximumXOR(arr));
	}

}
