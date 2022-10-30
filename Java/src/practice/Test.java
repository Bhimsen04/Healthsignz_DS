package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
	static List<int[]> list = new ArrayList<>();

	public static void main(String[] args) {

		int workHours = 24;
		int dayHours = 4;
		String pattern = "08??840";
		List<String> list = findSchedules(workHours, dayHours, pattern);
		System.out.println(list);
	}

	private static List<String> findSchedules(int workHours, int dayHours, String pattern) {

		List<String> result = new ArrayList<>();
		int total = 0;
		int emptySpace = 0;
		List<Integer> emptySpaces = new ArrayList<>();
		for (int i = 0; i < pattern.length(); i++) {
			if (pattern.charAt(i) != '?')
				total += Integer.parseInt(pattern.charAt(i) + "");
			else {
				emptySpace++;
				emptySpaces.add(i);
			}
		}
		int[] arr = new int[emptySpace];
		int sumNeeded = workHours - total;

		int index = 0;
		recurse(arr, index, sumNeeded, dayHours, emptySpace);

		for (int i = 0; i < list.size(); i++) {
			int[] ar = list.get(i);
			int j = 0;
			for (int es : emptySpaces)
				pattern = pattern.substring(0, es) + ar[j++] + pattern.substring(es + 1);
			result.add(pattern);
		}
		Collections.sort(result);
		return result;
	}

	private static void recurse(int[] arr, int index, int sumNeeded, int dayHours, int emptySpace) {
		if (sumNeeded == 0) {
			// System.out.println(Arrays.toString(arr));
			list.add(arr);
			arr = new int[emptySpace];
			return;
		}
		if (index >= arr.length)
			return;
		for (int i = dayHours; i >= 0; i--) {
			if (i <= sumNeeded) {
				arr[index] = i;
				recurse(arr, index + 1, sumNeeded - i, dayHours, emptySpace);
			}
		}

	}
}
