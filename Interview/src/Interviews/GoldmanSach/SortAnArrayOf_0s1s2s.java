package Interviews.GoldmanSach;

import java.util.Arrays;

public class SortAnArrayOf_0s1s2s {
	static void sortArr(int arr[], int n) {
		int i, cnt0 = 0, cnt1 = 0, cnt2 = 0;
		for (i = 0; i < n; i++) {
			switch (arr[i]) {
			case 0:
				cnt0++;
				break;
			case 1:
				cnt1++;
				break;
			case 2:
				cnt2++;
				break;
			}
		}
		i = 0;
		while (cnt0 > 0) {
			arr[i++] = 0;
			cnt0--;
		}
		while (cnt1 > 0) {
			arr[i++] = 1;
			cnt1--;
		}
		while (cnt2 > 0) {
			arr[i++] = 2;
			cnt2--;
		}
		System.out.println(Arrays.toString(arr));
	}

	public static void main(String[] args) {
		int arr[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
		int n = arr.length;
		// sortArr(arr, n);

		sortArr2(arr, n); // best soluntion
	}

	private static void sortArr2(int[] arr, int n) {
		int i = 0, start = 0, end = n - 1;
		while (i <= end) {
			if (arr[i] == 2) {
				swap(arr, i, end);
				end--;
			} else if (arr[i] == 1)
				i++;
			else {
				swap(arr, i, start);
				start++;
				i++;
			}
		}
		System.out.println(Arrays.toString(arr));
	}

	private static void swap(int[] arr, int i, int end) {
		int temp = arr[i];
		arr[i] = arr[end];
		arr[end] = temp;

	}
}
