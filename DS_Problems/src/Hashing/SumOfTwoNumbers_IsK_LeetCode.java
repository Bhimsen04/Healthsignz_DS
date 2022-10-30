package Hashing;

import java.util.Arrays;
import java.util.HashMap;

public class SumOfTwoNumbers_IsK_LeetCode {

	// https://leetcode.com/problems/two-sum/
	public static void main(String[] args) {
		int[] arr = { 5, -7, 11, 12, -3, -4, 10, 15, 5, 7, 8 };
		System.out.println(Arrays.toString(checkIsSumK(arr, 4)));
	}

	private static int[] checkIsSumK(int[] nums, int target) {
		HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
		int[] arr = new int[2];
		for (int i = 0; i < nums.length; i++) {
			if (hs.containsKey(target - nums[i])) {
				arr[0] = i;
				arr[1] = hs.get(target - nums[i]);
				return arr;
			} else
				hs.put(nums[i], i);
		}
		return arr;
	}
}
