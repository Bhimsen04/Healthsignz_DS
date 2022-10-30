package HashingStrings;

public class Rabin_karp_Algo {

	public static void main(String[] args) {
		// https://www.interviewbit.com/problems/implement-strstr/
		// https://leetcode.com/problems/implement-strstr/
		String str = "mississippi", pattern = "ssi";
		System.out.println(countPattern(str, pattern));
	}

	private static long countPattern(String str, String pattern) {
		long p = 53, pow = 1, curPow = 1, hashPattern = 0, hashStr = 0, M = 1000000007, count = 0;
		long[] hash_str_per_ele = new long[str.length()];
		for (int i = 0; i < pattern.length() && i < str.length(); i++) {
			pow = ((pow % M) * (p % M)) % M;
			hashPattern = (hashPattern + ((pattern.charAt(i) % M) * (pow % M)) % M) % M;
			hash_str_per_ele[i] = ((str.charAt(i) % M) * (pow % M)) % M;
			hashStr = (hashStr % M + hash_str_per_ele[i] % M) % M;
		}
		if (hashPattern == hashStr)
			count++;
		for (int i = pattern.length(); i < str.length(); i++) {
			pow = ((pow % M) * (p % M)) % M;
			curPow = ((curPow % M) * (p % M)) % M;
			hash_str_per_ele[i] = ((str.charAt(i) % M) * (pow % M)) % M;
			hashStr = (hashStr % M + ((hash_str_per_ele[i] % M) - (hash_str_per_ele[i - pattern.length()] % M) + M) % M)
					% M;
			if ((hashPattern % M * curPow % M) % M == hashStr)
				count++;
		}
		return count;
	}
}
