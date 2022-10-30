package HashingStrings;

public class Longest_Palindromic_Substring2 {

	// Its more optimized
	// https://leetcode.com/problems/longest-palindromic-substring/
	long p = 53, M = 1000000007;
	long[] forwardHash, backwardHash, powerArr;

	public static void main(String[] args) {
		String s1 = "baa";
		Longest_Palindromic_Substring2 lps = new Longest_Palindromic_Substring2();
		System.out.println(lps.longestPalindrome(s1));
	}

	public String longestPalindrome(String str) {
		if (str.length() == 1)
			return str;
		str = createDelimiterString(str);
		forwardHash = new long[str.length()];
		backwardHash = new long[str.length()];
		powerArr = new long[str.length() + 1];
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

			int forwardHashNumbersLeft = str.length() - d2 - 1;
			int backwardHashNumbersLeft = str.length() - (str.length() - d1);

			boolean isValid = false;
			if (forwardHashNumbersLeft < backwardHashNumbersLeft) {
				long powerValue = powerArr[backwardHashNumbersLeft - forwardHashNumbersLeft];
				if (forwardHashSum == (backwardHashSum * powerValue) % M)
					isValid = true;

			} else if (backwardHashNumbersLeft < forwardHashNumbersLeft) {
				long powerValue = powerArr[forwardHashNumbersLeft - backwardHashNumbersLeft];
				if ((forwardHashSum * powerValue) % M == backwardHashSum)
					isValid = true;

			} else {
				if (forwardHashSum == backwardHashSum)
					isValid = true;
			}
			if (isValid) {
				min = mid + 1;
				if ((max + min + 1) > result.length())
					result = str.substring(d1, d2 + 1);
			} else
				max = mid - 1;
		}
		return result;
	}

	private String createDelimiterString(String str) {
		StringBuilder sb = new StringBuilder("$");
		for (int i = 0; i < str.length(); i++)
			sb.append(str.charAt(i)).append("$");
		return sb.toString();
	}

	private void hashing(String str, long[] forwardHash, long[] backwardHash, long[] powerArr) {
		long pow = 1;
		int len = str.length();
		powerArr[0] = 1;
		for (int i = 0, j = len - 1; i < len; i++, j--) {
			pow = (pow * p) % M;
			forwardHash[i] = i == 0 ? ((str.charAt(i) * pow) % M)
					: (forwardHash[i - 1] + (str.charAt(i) * pow) % M) % M;
			backwardHash[j] = j == len - 1 ? ((str.charAt(len - 1) * pow) % M)
					: (backwardHash[j + 1] + (str.charAt(j) * pow) % M) % M;
			powerArr[i + 1] = pow;
		}
	}
}
