package HashingStrings;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Longest_Palindromic_Substring {

	// https://leetcode.com/problems/longest-palindromic-substring/
	long p = 2, M = 1000000007;
	long[] forwardHash, backwardHash, powerArr;

	public static void main(String[] args) {
		String s1 = "baa";
		Longest_Palindromic_Substring lps = new Longest_Palindromic_Substring();
		System.out.println(lps.longestPalindrome(s1));
	}

	public String longestPalindrome(String str) {
		if (str.length() == 1)
			return str;
		str = createDelimiterString(str);
		forwardHash = new long[str.length()];
		backwardHash = new long[str.length()];
		powerArr = new long[str.length()];
		hashing(str, forwardHash, backwardHash, powerArr);
		String biggestPalindrome = "";
		for (int i = 1; i < str.length() - 1; i++) {
			String result = binarySearch(i, 0, Math.min(i, str.length() - i - 1), str);
			if (result.length() > biggestPalindrome.length())
				biggestPalindrome = result;
		}
		return biggestPalindrome.replace("$", "");
	}

	private String binarySearch(int centre, int min, int max, String str) {
		int mid = 0;
		String result = "";
		while (min <= max) {
			mid = (min + max) / 2;
			int d1 = mid == 0 ? centre - max : centre - mid;
			int d2 = mid == 0 ? centre + mid + 1 : centre + mid;
			long forwardHashSum = (forwardHash[d2] - (d1 <= 0 ? 0 : forwardHash[d1 - 1]) + M) % M;
			long backwardHashSum = (backwardHash[d1] - (d2 >= str.length() - 1 ? 0 : backwardHash[d2 + 1]) + M) % M;

			if (d1 - 0 > (str.length() - 1 - d2)) {
				int m1 = str.length() - d2 - 1;
				int m2 = str.length() - (d2 - d1) - m1 - 1;
				long powerValue = powerArr[m2 - m1 - 1];
				if (forwardHashSum == (backwardHashSum * powerValue) % M) {
					min = mid + 1;
					if ((max + min + 1) > result.length())
						result = str.substring(d1, d2 + 1);
				} else
					max = mid - 1;
			} else if ((str.length() - 1 - d2) > d1) {
				int m1 = str.length() - d2 - 1;
				int m2 = str.length() - (d2 - d1) - m1 - 1;
				long powerValue = powerArr[m1 - m2 - 1];
				if ((forwardHashSum * powerValue) % M == backwardHashSum) {
					min = mid + 1;
					if ((max + min + 1) > result.length())
						result = str.substring(d1, d2 + 1);
				} else
					max = mid - 1;
			} else {
				if (forwardHashSum == backwardHashSum) {
					min = mid + 1;
					if ((d2 - d1 + 1) > result.length())
						result = str.substring(d1, d2 + 1);
				} else
					max = mid - 1;
			}

		}
		return result;
	}

	private String createDelimiterString(String str) {
		str = Arrays.stream(str.split("")).collect(Collectors.joining("$"));
		return "$" + str + "$";
	}

	private void hashing(String str, long[] forwardHash, long[] backwardHash, long[] powerArr) {
		long pow = 1;
		int len = str.length();
		for (int i = 0, j = len - 1; i < len; i++, j--) {
			pow = (pow * p) % M;
			forwardHash[i] = i == 0 ? ((str.charAt(i) * pow) % M)
					: (forwardHash[i - 1] + (str.charAt(i) * pow) % M) % M;
			backwardHash[j] = j == len - 1 ? ((str.charAt(len - 1) * pow) % M)
					: (backwardHash[j + 1] + (str.charAt(j) * pow) % M) % M;
			powerArr[i] = pow;
		}
	}
}
