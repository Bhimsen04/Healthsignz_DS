package HashingStrings;

public class Implement_strStr2 {

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
			pow = ((pow % M) * (p % M)) % M;
			hashPattern = (hashPattern + ((pattern.charAt(i) % M) * (pow % M)) % M) % M;
			hash_str_per_ele[i] = ((str.charAt(i) % M) * (pow % M)) % M;
			hashStr = (hashStr % M + hash_str_per_ele[i] % M) % M;
		}
		if (hashPattern == hashStr)
			return 0;
		for (int i = pattern.length(); i < str.length(); i++) {
			pow = ((pow % M) * (p % M)) % M;
			curPow = ((curPow % M) * (p % M)) % M;
			hash_str_per_ele[i] = ((str.charAt(i) % M) * (pow % M)) % M;
			hashStr = (hashStr % M + ((hash_str_per_ele[i] % M) - (hash_str_per_ele[i - pattern.length()] % M) + M) % M)
					% M;
			if ((hashPattern % M * curPow % M) % M == hashStr)
				return i - pattern.length() + 1;
		}
		return -1;
	}
}
