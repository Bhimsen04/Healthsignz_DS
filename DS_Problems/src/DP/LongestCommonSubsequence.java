package DP;

public class LongestCommonSubsequence {
	// https://leetcode.com/problems/longest-common-subsequence/

	public static void main(String[] args) {
		String text1 = "hofubmnylkra";
		String text2 = "pqhgxgdofcvmr";

		System.out.println(new LongestCommonSubsequence().longestCommonSubsequence(text1, text2));
	}

	public int longestCommonSubsequence(String text1, String text2) {
		if (text1 == null || text2 == null || text1.isEmpty() || text2.isEmpty())
			return 0;
		else if (text2.length() < text1.length())
			longestCommonSubsequence(text2, text1);
		char[] ch = text1.toCharArray(), ch2 = text2.toCharArray();
		return longestCommonSubsequence(ch, ch2, ch.length, ch2.length);
	}

	private int longestCommonSubsequence(char[] ch, char[] ch2, int chLen, int ch2Len) {
		int dp[][] = new int[chLen + 1][ch2Len + 1];
		for (int i = 0; i <= chLen; i++) {
			for (int j = 0; j <= ch2Len; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 0;
				else if (ch[i - 1] == ch2[j - 1])
					dp[i][j] = dp[i - 1][j - 1] + 1;
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		int res = dp[chLen][ch2Len];
		StringBuilder sb = new StringBuilder();
		while (chLen > 0 && ch2Len > 0) {
			if (dp[chLen][ch2Len] == 0)
				break;
			else if (ch[chLen - 1] == ch2[ch2Len - 1])
				sb.append(ch[chLen-- - 1] + "" + ch2[ch2Len-- - 1] + " ");
			else {
				if (dp[chLen][ch2Len - 1] > dp[chLen - 1][ch2Len])
					ch2Len--;
				else
					chLen--;
			}
		}
		System.out.println(sb);
		return res;

	}
}
