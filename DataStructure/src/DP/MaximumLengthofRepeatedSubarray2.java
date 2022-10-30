package DP;

public class MaximumLengthofRepeatedSubarray2 {

	// https://leetcode.com/problems/maximum-length-of-repeated-subarray/
	public static void main(String[] args) {
		MaximumLengthofRepeatedSubarray2 repeatedSubarray = new MaximumLengthofRepeatedSubarray2();
		int[] a = { 1, 2, 3, 2, 1 };
		int[] b = { 3, 2, 1, 4, 7 };
		System.out.println(repeatedSubarray.findLength(a, b));
	}

	public int findLength(int[] a, int[] b) {

		if (a == null || b == null || a.length == 0 || b.length == 0)
			return 0;
		else if (b.length < a.length)
			findLength(b, a);

		int aLen = a.length, bLen = b.length, res = 0;
		int[][] dp = new int[aLen + 1][bLen + 1];
		int row = -1, column = -1;
		for (int i = 0; i <= aLen; i++) {
			for (int j = 0; j <= bLen; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 0;

				else if (a[i - 1] == b[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					if (res < dp[i][j]) {
						row = i;
						column = j;
						res = dp[i][j];
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		while (row > 0 && column > 0)
			sb.append(a[row-- - 1] + "" + b[column-- - 1] + " ");

		System.out.println(sb);
		return res;

	}
}
