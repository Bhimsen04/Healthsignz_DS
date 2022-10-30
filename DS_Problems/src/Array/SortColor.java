package Array;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SortColor {

	// https://leetcode.com/problems/sort-colors/
	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 0, 2, 0, 0, 1, 0 };
		// sortColors(nums);
		// we did without extra space
		sortColors3(nums);
		for (int num : nums)
			System.out.print(num + " ");
	}

	public static void sortColors3(int[] ar) {
		int i = 0, start = 0, end = ar.length - 1;
		while (i <= end) {
			if (ar[i] == 2) {
				swap(ar, i, end);
				end--;
			} else if (ar[i] == 1)
				i++;
			else if (ar[i] == 0) {
				swap(ar, i, start);
				start++;
				i++;
			}
		}
	}

	public static void sortColors2(int[] ar) {
		// zero pointer always at greter than 0 means at 1 or 2
		// one pointer always at 2

		int zeroPointer = 0, firstPointer = 0;
		for (int i = 0; i < ar.length; i++) {

			while (zeroPointer < ar.length && ar[zeroPointer] == 0)
				zeroPointer++;

			while (firstPointer < ar.length && ar[firstPointer] <= 1)
				firstPointer++;

			if (zeroPointer < ar.length && ar[i] == 0 && i > zeroPointer)
				swap(ar, i, zeroPointer);
			else if (firstPointer < ar.length && ar[i] == 1 && i > firstPointer)
				swap(ar, i, firstPointer);

		}
		zeroPointer = firstPointer;
		while (zeroPointer < ar.length) {
			while (firstPointer < ar.length && ar[firstPointer] <= 1)
				firstPointer++;
			if (firstPointer < ar.length && ar[firstPointer] > ar[zeroPointer] && ar[firstPointer] != 1
					&& zeroPointer > firstPointer) {
				swap(ar, zeroPointer, firstPointer);
				firstPointer++;
			}
			zeroPointer++;
		}
	}

	public static void sortColors(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int n : nums) {
			if (map.containsKey(n))
				map.put(n, map.get(n) + 1);
			else
				map.put(n, 1);
		}
		Set<Integer> keys = map.keySet();
		int n = 0;
		for (int k : keys) {
			int count = map.get(k);
			while (count-- > 0)
				nums[n++] = k;
		}
	}

	public static void swap(int[] ar, int i, int j) {
		int temp = ar[i];
		ar[i] = ar[j];
		ar[j] = temp;
	}

}
