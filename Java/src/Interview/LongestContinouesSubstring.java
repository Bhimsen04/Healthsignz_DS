package Interview;

import java.util.HashMap;
import java.util.Map;

public class LongestContinouesSubstring {

	public static void main(String[] args) {
		System.out.println(solve("00101001010", 2));
	}

	private static int solve(String str, int k) {
		char[] c = str.toCharArray();
		int i = 0, j = c.length - 1, count = 0;
		while (count < k && j > i) {
			if (c[i] - 48 == 1 && c[j] - 48 == 0) {
				c[i] = '0';
				c[j] = '1';
				k++;
			}
			if (c[i] - 48 == 0)
				i++;
			if (c[j] - 48 == 1)
				j--;
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 0);
		map.put(1, 0);
		int l = 0;
		while (l < c.length) {
			int n = 0;
			while (l < c.length && c[l] - 48 == 0) {
				n++;
				l++;
			}

			if (map.get(0) < n)
				map.put(0, n);

			n = 0;
			while (l < c.length && c[l] - 48 == 1) {
				n++;
				l++;
			}

			if (map.get(1) < n)
				map.put(1, n);

		}
		if (map.get(0) > map.get(1))
			return map.get(0);

		return map.get(1);
	}
}
