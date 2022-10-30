package String;

public class LongestPalindromicSubstring {

	// https://leetcode.com/problems/longest-palindromic-substring/

	public static void main(String[] args) {

	}

	public String longestPalindrome(String s) {

		char arr[] = s.toCharArray();
		int start = -1, last = -1, max = -1, len = 0;
		for (int i = 0; i < arr.length; i++) {
			len = maxLength(i - 1, i + 1, arr);
			if (max < 2 * len + 1) {
				max = 2 * len + 1;
				start = i - len;
				last = i + len;
			}

			len = maxLength(i, i + 1, arr);
			if (max < 2 * len) {
				max = 2 * len;
				start = i - len + 1;
				last = i + len;
			}
		}

		if (max == -1)
			return s;

		return s.substring(start, last + 1);
	}

	int maxLength(int first, int second, char[] arr) {

		int maxLen = 0;
		for (int i = first, j = second; i >= 0 && j < arr.length; i--, j++) {
			if (arr[i] != arr[j])
				break;

			maxLen++;
		}

		return maxLen;
	}
}
