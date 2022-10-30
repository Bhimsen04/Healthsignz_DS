package Search;

import java.util.Scanner;

public class Binary_Search_Basic_Recursion2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int i = 0;
		while (i < n)
			arr[i++] = sc.nextInt();
		int element = sc.nextInt();
		sc.close();
		boolean result = binarySearch(arr, 0, n - 1, element);
		System.out.println(result);
	}

	private static boolean binarySearch(int[] arr, int start, int end, int element) {
		if (start <= end) {
			int m = (start + end) / 2;
			if (arr[m] == element)
				return true;
			else if (element < arr[m])
				return binarySearch(arr, start, m - 1, element);
			else
				return binarySearch(arr, m + 1, end, element);
		}
		return false;
	}

}
