package HashingStrings;

public class Rabin_karp_Algo2 {

	// https://www.interviewbit.com/problems/implement-strstr/
	// https://leetcode.com/problems/implement-strstr/
	public static void main(String[] args) {
		String str = "AAABAAA", pattern = "AAA";
		System.out.println(countPattern(str, pattern));
	}

	private static long countPattern(String str, String pattern) {
		long p = 53, pow = 1, curPow = 1, hashPattern = 0, hashStr = 0, M = 1000000007, count = 0;
		long[] hash_str_per_ele = new long[str.length()];
		for (int i = 0; i < pattern.length() && i < str.length(); i++) {
			pow = ((pow % M) * (p % M)) % M;
			hashPattern = (hashPattern + (pattern.charAt(i) * pow) % M) % M;
			hash_str_per_ele[i] = ((i > 0 ? hash_str_per_ele[i - 1] : 0) + (str.charAt(i) * pow) % M) % M;
			hashStr = hash_str_per_ele[i];
		}
		if (hashPattern == hashStr)
			count++;
		for (int i = pattern.length(); i < str.length(); i++) {
			pow = (pow * p) % M;
			curPow = (curPow * p) % M;
			hash_str_per_ele[i] = ((i > 0 ? hash_str_per_ele[i - 1] : 0) + (str.charAt(i) * pow) % M) % M;
			hashStr = hash_str_per_ele[i];
			hashStr = (hashStr - hash_str_per_ele[i - pattern.length()] + M) % M;
			if ((hashPattern * curPow) % M == hashStr)
				count++;
		}
		return count;
	}
}
