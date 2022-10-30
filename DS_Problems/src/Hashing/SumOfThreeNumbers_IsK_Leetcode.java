package Hashing;

import java.util.*;

public class SumOfThreeNumbers_IsK_Leetcode {
	public List<List<Integer>> threeSum(int[] nums) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums.length < 3)
			return result;
		Map<Integer, Integer> map = new HashMap<>();
		for (int n : nums) {
			if (map.containsKey(n))
				map.put(n, map.get(n) + 1);
			else
				map.put(n, 1);
		}

		Set<List<Integer>> set = new HashSet<>();
		for (int i = 0; i < nums.length - 2; i++) {
			int first = nums[i];
			for (int j = i + 1; j < nums.length - 1; j++) {
				List<Integer> list = new ArrayList<>();
				int second = nums[j];
				int third = first == 0 && second == 0 ? 0 : -(first + second);
				if (first == second && second == third && map.get(first) < 3)
					continue;
				else if ((first == third && map.get(first) < 2) || (second == third && map.get(second) < 2))
					continue;
				if (map.containsKey(third)) {
					list.add(first);
					list.add(second);
					list.add(third);
					Collections.sort(list);
					set.add(list);
				}
			}
		}
		result.addAll(set);
		return result;

	}
}
