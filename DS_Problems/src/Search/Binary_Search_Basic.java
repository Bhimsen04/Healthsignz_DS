package Search;

import java.util.Scanner;

public class Binary_Search_Basic {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int i = 0;
		while (i < n)
			arr[i++] = sc.nextInt();
		int element = sc.nextInt();
		sc.close();
		int result = binarySearch(arr, 0, n - 1, element);
		System.out.println(result);
	}

	private static int binarySearch(int[] arr, int start, int end, int element) {
		while (start <= end) {
			int m = (start + end) / 2;
			if (arr[m] == element)
				return m;
			else if (element < arr[m])
				end = m - 1;
			else
				start = m + 1;
		}
		return -1;
	}
}
