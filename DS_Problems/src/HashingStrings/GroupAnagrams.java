package HashingStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupAnagrams {

	// https://leetcode.com/problems/group-anagrams/
	public static void main(String[] args) {
		String[] str = { "eat", "tea", "tan", "ate", "nat", "bat" };
		// [["bat"],["nat","tan"],["ate","eat","tea"]]
		System.out.println(groupAnagrams(str));
		System.out.println(groupAnagrams_java8(str));
	}

	private static List<List<String>> groupAnagrams(String[] str) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (String s : str) {
			char tempArray[] = s.toCharArray();
			Arrays.sort(tempArray);
			String s1 = new String(tempArray);
			if (!map.containsKey(s1))
				map.put(s1, new ArrayList<String>());
			map.get(s1).add(s);
		}
		List<List<String>> listOfLists = new ArrayList<List<String>>();
		map.forEach((k, v) -> listOfLists.add(v));
		return listOfLists;
	}

	public static List<List<String>> groupAnagrams_java8(String[] strs) {

		List<String> list = Arrays.asList(strs);
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		list.forEach(str -> {
			List<String> al = null;
			String str1 = Arrays.stream(str.split("")).sorted().collect(Collectors.joining());
			if (!map.containsKey(str1))
				al = new ArrayList<String>();
			else
				al = map.get(str1);
			al.add(str);
			map.put(str1, al);
		});
		List<List<String>> listOfLists = new ArrayList<>();
		map.forEach((k, v) -> listOfLists.add(v));
		return listOfLists;
	}
}
