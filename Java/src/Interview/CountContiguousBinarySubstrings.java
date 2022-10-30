package Interview;

public class CountContiguousBinarySubstrings {

	public static void main(String[] args) {
		System.out.println(getSubstringCount("10110010"));
		// 10110010 :- {10 , 01 , 1100 , 10 , 01 , 10}
	}

	public static int getSubstringCount(String s) {
		char[] c = s.toCharArray();
		int i = 0, result = 0, countZero = 0, countOne = 0;
		while (i < c.length) {
			countZero = 0;
			while (i < c.length && c[i] - '0' == 0) {
				countZero++;
				i++;
			}

			result += Math.min(countZero, countOne);
			countOne = 0;
			while (i < c.length && c[i] - '0' == 1) {
				countOne++;
				i++;
			}
			result += Math.min(countZero, countOne);
		}
		return result;

	}

}
