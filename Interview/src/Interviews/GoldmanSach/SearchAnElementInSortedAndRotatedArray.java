package Interviews.GoldmanSach;

public class SearchAnElementInSortedAndRotatedArray {

	// https://leetcode.com/problems/search-in-rotated-sorted-array/
	public static void main(String args[]) {
		int arr[] = { 3, 1 };
		int i = search(arr, 1);
		if (i != -1)
			System.out.println("Index: " + i);
		else
			System.out.println("Key not found");
	}

	static int search(int nums[], int target) {
		int l = 0, h = nums.length - 1;
		while (l <= h) {
			int m = (l + h) / 2;
			if (nums[m] == target)
				return m;
			else if (nums[l] <= nums[m]) {
				if (target >= nums[l] && target < nums[m])
					h = m - 1;
				else
					l = m + 1;
			} else {
				if (target > nums[m] && target <= nums[h])
					l = m + 1;
				else
					h = m - 1;
			}
		}
		return -1;
	}

}
