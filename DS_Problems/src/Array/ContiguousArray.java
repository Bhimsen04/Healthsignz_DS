package Array;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
	// https://leetcode.com/problems/contiguous-array/
	public static void main(String[] args) {
		int[] ar = { 0, 1, 0, 1, 1 };

		System.out.println(findMaxLength(ar));

	}

	public static int findMaxLength(int[] nums) {
		if (nums.length == 0)
			return 0;
		int max = 0, prefixSum = 0;
		Map<Integer, Integer> firstIndexMap = new HashMap<>();
		firstIndexMap.put(0, -1);
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0)
				nums[i] = -1;
			prefixSum += nums[i];
			System.out.print(prefixSum + " , ");
			if (!firstIndexMap.containsKey(prefixSum))
				firstIndexMap.put(prefixSum, i);
			else
				max = Math.max(max, i - firstIndexMap.get(prefixSum));
		}
		System.out.println();
		return max;
	}
}
