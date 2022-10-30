package HashingStrings;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
	// https://leetcode.com/problems/isomorphic-strings/
	public static void main(String[] args) {
		String s = "paper";
		String t = "title";
		System.out.println(isIsomorphic(s, t));
	}

	private static boolean isIsomorphic(String s, String t) {
		Map<Integer, Integer> map = new HashMap<>();
		int s2 = 0, t2 = 0;
		for (int i = 0; i < s.length(); i++) {
			s2 = s.charAt(i);
			t2 = t.charAt(i);
			if (map.containsKey(s2)) {
				if (t2 != map.get(s2))
					return false;
			} else {
				if (map.values().contains(t2))
					return false;
				map.put(s2, t2);
			}
		}
		return true;
	}
}
