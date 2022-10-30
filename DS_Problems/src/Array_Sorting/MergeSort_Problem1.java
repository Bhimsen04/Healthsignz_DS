package Array_Sorting;

public class MergeSort_Problem1 {

	// https://www.hackerrank.com/challenges/ctci-merge-sort/problem
	static long ans = 0;

	public static void main(String[] args) {
		int[] arr = { 1, 1, 1, 2, 2 };
		System.out.println(mergeSort(arr, 0, arr.length - 1));
	}

	public static long mergeSort(int[] arr, int l, int h) {
		if (l == h)
			return 0;
		int mid = (l + h) / 2;
		mergeSort(arr, l, mid);
		mergeSort(arr, mid + 1, h);
		ans += mergeProcess(arr, l, mid, h);
		return ans;
	}

	private static long mergeProcess(int[] arr, int l, int m, int h) {
		int i = l, j = m + 1, g = 0;
		long inverionsCount = 0;
		int temp[] = new int[h - l + 1];
		while (i <= m && j <= h)
			if (arr[i] <= arr[j])
				temp[g++] = arr[i++];
			else {
				temp[g++] = arr[j++];
				inverionsCount += m + 1 - i;
			}
		while (i <= m)
			temp[g++] = arr[i++];
		while (j <= h)
			temp[g++] = arr[j++];
		i = 0;
		while (i < temp.length) {
			arr[l + i] = temp[i++];
		}
		return inverionsCount;
	}
}
