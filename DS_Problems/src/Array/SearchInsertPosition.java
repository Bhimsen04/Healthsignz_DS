package Array;

public class SearchInsertPosition {
	// https://leetcode.com/problems/search-insert-position/
	public static void main(String[] args) {

		int[] nums = { 1, 3, 5, 6 };
		int target = 7;
		System.out.println(searchInsert(nums, target));
		System.out.println(searchInsert_bs(nums, target));

	}

	public static int searchInsert_bs(int[] nums, int target) {
		int low = 0, high = nums.length - 1;
		while (low <= high) {
			int middle = (low + high) / 2;
			if (nums[middle] == target)
				return middle;
			else if (nums[middle] > target)
				high = middle - 1;
			else if (nums[middle] < target)
				low = middle + 1;
		}
		return low;
	}

	public static int searchInsert(int[] nums, int target) {

		int i = 0;
		for (; i < nums.length; i++) {
			if (nums[i] >= target)
				return i;
		}
		return i;
	}
}
