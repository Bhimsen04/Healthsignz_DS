package Interviews.Amazon;

public class NextPalindrome {
	public static void main(String[] args) {
		System.out.println(nextSmallestPalindrome(1229)); // 23532
		// 1231 
	}

	public static int nextSmallestPalindrome(int number) {
		String result1 = "", result = "";
		String s = number + "";
		if ((s.length() & 1) == 0) {
			for (int i = 0; i < s.length() / 2; i++)
				result1 += s.charAt(i);
			result = result1;
			for (int i = result1.length() - 1; i >= 0; i--)
				result += result1.charAt(i);
		} else {
			char c = s.charAt(s.length() / 2);
			if (c == 58) {
				int no = Integer.parseInt(s.substring(0, s.length() / 2 + 1)) + 1;
				s = "" + no + s.substring(s.length() / 2 + 1, s.length());
			}
			for (int i = 0; i < s.length() / 2; i++)
				result1 += s.charAt(i);
			result = result1;
			if ((s.length() & 1) == 1) {
				result += s.charAt(s.length() / 2);
			}
			for (int i = result1.length() - 1; i >= 0; i--)
				result += result1.charAt(i);

		}
		return Integer.parseInt(result);
	}
}