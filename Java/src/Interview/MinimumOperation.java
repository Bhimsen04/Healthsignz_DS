package Interview;

import java.util.Arrays;

public class MinimumOperation {
	public static void main(String[] args) {
		System.out.println(solve("0101011001011", 13));
	}

	private static int solve(String str, int k) {
		char[] c = str.toCharArray();
		int count = 0, i = 0, j = 1;
		while (i < j && j < k) {
			if (c[i] - 48 == 0 && c[j] - 48 == 1) {
				i++;
				j++;
			} else if (c[i] - 48 == 1 && c[j] - 48 == 0) {
				char temp = c[i];
				c[i] = c[j];
				c[j] = temp;
				count++;
				i++;
				j++;
			} else
				j++;
		}
		System.out.println(Arrays.toString(c));
		return count;
	}
}
