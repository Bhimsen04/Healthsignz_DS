package Interviews.GoldmanSach;

import java.util.HashMap;
import java.util.Map;

public class UniformSubstring {
	public static void main(String[] args) {
		String str = "aabbbbbCdAA";
		char[] c = str.toCharArray();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int count = 0, start = 0, end = 0, freq = 0;
		for (int i = 0; i < c.length - 1; i++) {
			if (c[i] == c[i + 1])
				count++;
			else {
				if (!map.containsKey(c[i]))
					map.put(c[i], count);
				else if (count > map.get(c[i]))
					map.put(c[i], count);
				if (count > freq) {
					end = i;
					start = i - count;
					freq = count;
				}
				count = 0;
			}
		}
		System.out.println(start + " , " + end);
	}
}
