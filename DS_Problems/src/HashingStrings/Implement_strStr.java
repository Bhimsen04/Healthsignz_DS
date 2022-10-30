package HashingStrings;

public class Implement_strStr {

	//Rabin_karp_Algo
	public static void main(String[] args) {
		String haystack = "aaaaa", needle = "bba";
		System.out.println(strStr(haystack, needle));
	}

	public static int strStr(String haystack, String needle) {
		if (needle.isEmpty())
			return 0;
		for (int i = 0; i <= haystack.length() - needle.length(); i++) {
			int j = 0;
			if (haystack.charAt(i) == needle.charAt(j)) {
				if (haystack.substring(i, i + needle.length()).equals(needle)) {
					return i;
				}
			}
		}
		return -1;
	}
}
