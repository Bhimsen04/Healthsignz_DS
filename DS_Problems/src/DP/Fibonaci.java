package DP;

import java.util.Arrays;

public class Fibonaci {

	// https://leetcode.com/problems/fibonacci-number/
	public int fib(int n) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);
		return fibc(n, dp);
	}

	public int fibc(int n, int[] dp) {
		if (n == 0)
			return 0;
		else if (n <= 2)
			return 1;
		else if (dp[n] != -1)
			return dp[n];
		return dp[n] = fibc(n - 1, dp) + fibc(n - 2, dp);
	}
}
