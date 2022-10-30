package Interviews.Amazon;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostTwoDistinctCharacters {
	
	//https://www.lintcode.com/problem/longest-substring-with-at-most-two-distinct-characters/
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstringTwoDistinct("cacabbbbaaamn"));
	}
	
	
	public static int lengthOfLongestSubstringTwoDistinct(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int begin = 0, end = 0;
		int counter = 0;
		int maxLen = 0;

		while (end < s.length()) {
			char cEnd = s.charAt(end);
			map.put(cEnd, map.getOrDefault(cEnd, 0) + 1);
			if (map.get(cEnd) == 1) {
				counter++;
			}
			end++;
			while (counter > 2) {
				char cBegin = s.charAt(begin);
				map.put(cBegin, map.get(cBegin) - 1);
				if (map.get(cBegin) == 0) {
					counter--;
				}
				begin++;
			}
			maxLen = Math.max(maxLen, end - begin);
		}

		return maxLen;
	}
}
