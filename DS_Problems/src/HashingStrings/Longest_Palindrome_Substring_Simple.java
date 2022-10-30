package HashingStrings;

public class Longest_Palindrome_Substring_Simple {
	// https://leetcode.com/problems/longest-palindromic-substring/
	public String longestPalindrome(String s) {

		char[] ch = s.toCharArray();
		int max = 0, start = -1, end = -1;
		for (int i = 0; i < ch.length; i++) {
			int maxLengthOdd = maxLength(ch, i - 1, i + 1);
			int maxLengthEven = maxLength(ch, i, i + 1);
			if (maxLengthOdd >= maxLengthEven) {
				if (maxLengthOdd * 2 + 1 > max) {
					start = i - maxLengthOdd;
					end = i + maxLengthOdd + 1;
					max = maxLengthOdd * 2 + 1;
				}
			} else {
				if (maxLengthEven * 2 > max) {
					start = i - maxLengthEven + 1;
					end = i + maxLengthEven + 1;
					max = maxLengthEven * 2;
				}
			}

		}
		return s.substring(start, end);
	}

	private int maxLength(char[] ch, int start, int end) {

		int maxLength = 0;
		while (start >= 0 && end < ch.length) {
			if (ch[start] != ch[end])
				break;
			maxLength++;
			start--;
			end++;
		}
		return maxLength;
	}
}
