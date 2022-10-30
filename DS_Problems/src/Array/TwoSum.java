package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class TwoSum {

	// https://leetcode.com/problems/two-sum/
	public static void main(String[] args) {
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;
		List<Integer> list2 = Arrays.stream(nums).boxed().collect(Collectors.toList());
		System.out.println(list2);
		System.out.println(Arrays.toString(twoSum(nums, target)));
		System.out.println(Arrays.toString(twoSum2(nums, target)));

	}

	public static int[] twoSum2(int[] nums, int target) {
		HashSet<Integer> set = new HashSet<>();
		int[] arr = new int[2];
		for (int i = 0; i < nums.length; i++) {
			if (set.isEmpty())
				set.add(i);
			if (set.contains(target - arr[i])) {
				nums[0] = arr[i];
				nums[1] = target - arr[i];
				return arr;
			}
		}
		return arr;
	}

	public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
		int[] arr = new int[2];
		for (int i = 0; i < nums.length; i++) {
			if (hs.containsKey(target - nums[i])) {
				arr[0] = i;
				arr[1] = hs.get(target - nums[i]);
				return arr;
			} else
				hs.put(nums[i], i);
		}
		return arr;
	}
}
