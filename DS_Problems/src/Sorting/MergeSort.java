package Sorting;

import java.util.Scanner;

public class MergeSort {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int i = 0;
		while (i < n)
			arr[i++] = sc.nextInt();
		sc.close();
		mergeSort(arr, 0, n - 1);
		StringBuilder sb = new StringBuilder("[");
		for (int arV : arr)
			sb.append(arV + ",");
		System.out.println(sb.replace(sb.length() - 1, sb.length(), "]"));
	}

	private static void mergeSort(int[] arr, int L, int R) {
		if (L == R)
			return;
		int mid = (L + R) / 2;
		mergeSort(arr, L, mid);
		mergeSort(arr, mid + 1, R);
		mergeProcess(arr, L, R);
	}

	private static void mergeProcess(int[] arr, int L, int R) {
		int M = (L + R) / 2;
		int[] temp = new int[R - L + 1];
		int a = L, b = M + 1, i = 0;
		while (a <= M && b <= R) {
			if (arr[a] < arr[b]) {
				temp[i++] = arr[a++];
			} else {
				temp[i++] = arr[b++];
			}
		}

		while (a <= M) {
			temp[i++] = arr[a++];
		}
		while (b <= R) {
			temp[i++] = arr[b++];
		}
		i = 0;
		while (i < R - L + 1)
			arr[L + i] = temp[i++];
	}
}
