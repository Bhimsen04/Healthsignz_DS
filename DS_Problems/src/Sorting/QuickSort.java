package Sorting;

import java.util.Scanner;

public class QuickSort {

	// https://leetcode.com/problems/sort-an-array/
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		int i = 0;
		while (i < n)
			nums[i++] = sc.nextInt();
		quickSort(0, n - 1, nums);
		// System.out.println(Arrays.toString(arr));
		sc.close();
	}

	private static void quickSort(int start, int end, int[] arr) {
		if (start >= end)
			return;
		int pIdx = partition(start, end, arr);
		quickSort(start, pIdx - 1, arr);
		quickSort(pIdx + 1, end, arr);
	}

	private static int partition(int start, int end, int[] arr) {
		int pInx = start;
		int pivot = arr[end];
		for (int i = start; i <= end; i++) {
			if (arr[i] <= pivot) {
				int temp = arr[i];
				arr[i] = arr[pInx];
				arr[pInx++] = temp;
			}
		}
		return pInx - 1;
	}
}
