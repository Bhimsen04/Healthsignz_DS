package Array_Sorting;

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

	private static void mergeSort(int[] arr, int l, int h) {

		if (l == h)
			return;
		int m = (l + h) / 2;
		mergeSort(arr, l, m);
		mergeSort(arr, m + 1, h);
		mergeProcess(arr, l, m, h);

	}

	private static void mergeProcess(int[] arr, int l, int m, int h) {
		int[] temp = new int[h - l + 1];
		int i = l;
		int j = m + 1;
		int g = 0;
		while (i <= m && j <= h) {
			if (arr[i] < arr[j])
				temp[g++] = arr[i++];
			else
				temp[g++] = arr[j++];
		}
		while (i <= m)
			temp[g++] = arr[i++];
		while (j <= h)
			temp[g++] = arr[j++];
		i = 0;
		while (i < h - l + 1)
			arr[l + i] = temp[i++];
	}

}
