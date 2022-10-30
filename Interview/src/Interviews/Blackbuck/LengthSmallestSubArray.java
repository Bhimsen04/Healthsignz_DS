package Interviews.Blackbuck;

public class LengthSmallestSubArray {

	// Smallest subarray with sum greater than a given value

	public static void main(String[] args) {
		System.out.println(getLengthOfSubArray(new int[] { 6, 3, 4, 5, 4, 3, 7, 9 }, 16)); //
		System.out.println(getLengthOfSubArray_optimized(new int[] { 6, 3, 4, 5, 4, 3, 7, 9 }, 16)); //
	}

	// o(n) // not working GFG
	public static int getLengthOfSubArray_optimized(int[] a, int x) {
		int mi = Integer.MAX_VALUE, i = 0, j = 0, s = 0, n = a.length - 1;
		while (i <= j && j < n) {
			while (s <= x && j < n)
				s += a[j++];

			while (s > x && i < j) {
				mi = Math.min(mi, j - i);
				s = a[i];
				i++;
			}
		}
		return mi;

	}

	// o(n*n)
	public static int getLengthOfSubArray(int[] arr, int k) {
		int length = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			int sum = 0;
			for (int j = i; j < arr.length; j++) {
				sum += arr[j];
				if (sum > k)
					length = Math.min(length, j - i + 1);

			}
		}
		return length;

	}
}
