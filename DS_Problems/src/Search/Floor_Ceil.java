package Search;

import java.util.Scanner;

public class Floor_Ceil {
	// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt(), i = 0;
		int[] nums = new int[x];
		while (i < x)
			nums[i++] = sc.nextInt();
		int target = sc.nextInt();
		sc.close();
		int floorIdx = bs_floor(nums, nums.length - 1, target);
		int ceilIdx = bs_ceil(nums, nums.length - 1, target);
		System.out.println(floorIdx + " " + ceilIdx + " " + (ceilIdx - floorIdx + 1));
	}

	public static int bs_floor(int[] arr, int N, int searchEle) {
		int low = 0, high = N, ans = -1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (searchEle <= arr[mid]) {
				if (searchEle == arr[mid])
					ans = mid;
				high = mid - 1;
			} else
				low = mid + 1;
		}
		return ans;
	}

	public static int bs_ceil(int[] arr, int N, int searchEle) {
		int low = 0, high = N, ans = -1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (searchEle >= arr[mid]) {
				if (searchEle == arr[mid])
					ans = mid;
				low = mid + 1;
			} else
				high = mid - 1;
		}
		return ans;
	}
}
