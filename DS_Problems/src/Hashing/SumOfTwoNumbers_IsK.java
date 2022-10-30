package Hashing;

import java.util.HashSet;

public class SumOfTwoNumbers_IsK {
	public static void main(String[] args) {
		int[] arr = { 5, -7, 11, 12, -3, -4, 10, 15, 5, 7, 8 };
		System.out.println(checkIsSumK(arr, 11));
	}

	private static boolean checkIsSumK(int[] nums, int target) {
		HashSet<Integer> hs = new HashSet<Integer>();
		for (int ar : nums) {
			if (hs.contains(target - ar))
				return true;
			else
				hs.add(ar);
		}
		return false;

	}
}
