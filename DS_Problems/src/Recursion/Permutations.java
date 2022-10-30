package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };
		System.out.println(new Permutations().permute(nums));
	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		pemutation(res, nums, 0, nums.length);
		return res;
	}

	private void pemutation(List<List<Integer>> res, int[] nums, int l, int r) {

		if (l == r) {
			List<Integer> list = new ArrayList<Integer>();
			for (int n : nums)
				list.add(n);
			res.add(list);
		}

		for (int i = l; i < r; i++) {
			swap(nums, l, i);
			pemutation(res, nums, l + 1, r);
			swap(nums, l, i);
		}
	}

	private void swap(int[] nums, int l, int r) {
		int temp = nums[l];
		nums[l] = nums[r];
		nums[r] = temp;
	}
}
