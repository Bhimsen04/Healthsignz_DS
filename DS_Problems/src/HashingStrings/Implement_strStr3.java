package HashingStrings;

public class Implement_strStr3 {

	// https://www.interviewbit.com/problems/implement-strstr/
	// https://leetcode.com/problems/implement-strstr/
	public static void main(String[] args) {
		String haystack = "ABABCAABABCAABC", needle = "ABABCAABC";
		System.out.println(strStr(haystack, needle));
	}

	public static int strStr(String str, String pattern) {
		if ((str.isEmpty() && !pattern.isEmpty()) || (pattern.length() > str.length()))
			return -1;
		else if (pattern.isEmpty())
			return 0;
		long p = 53, pow = 1, curPow = 1, hashPattern = 0, hashStr = 0, M = 1000000007;
		long[] hash_str_per_ele = new long[str.length()];
		for (int i = 0; i < pattern.length(); i++) {
			pow = (pow * p) % M;
			hashPattern = (hashPattern + (pattern.charAt(i) * pow) % M) % M;
			hash_str_per_ele[i] = ((i > 0 ? hash_str_per_ele[i - 1] : 0) + (str.charAt(i) * pow) % M) % M;
			hashStr = hash_str_per_ele[i];
		}
		if (hashPattern == hashStr)
			return 0;
		for (int i = pattern.length(); i < str.length(); i++) {
			pow = (pow * p) % M;
			curPow = (curPow * p) % M;
			hash_str_per_ele[i] = ((i > 0 ? hash_str_per_ele[i - 1] : 0) + (str.charAt(i) * pow) % M) % M;
			hashStr = hash_str_per_ele[i];
			hashStr = (hashStr - hash_str_per_ele[i - pattern.length()] + M) % M;
			if ((hashPattern * curPow) % M == hashStr)
				return i - pattern.length() + 1;
		}
		return -1;
	}
}
