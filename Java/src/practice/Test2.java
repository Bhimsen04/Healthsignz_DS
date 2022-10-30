package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test2 {
	static List<String> list = new ArrayList<>();

	public static void main(String[] args) {

		int workHours = 24;
		int dayHours = 4;
		String pattern = "08??840";

		// int workHours = 3;
		// int dayHours = 8;
		// String pattern = "??2??00";

		// int workHours = 56;
		// int dayHours = 8;
		// String pattern = "??8????";

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
		char[] arr = new char[emptySpace];
		Arrays.fill(arr, '0');
		int sumNeeded = workHours - total;

		int index = 0;
		recurse(arr, index, sumNeeded, dayHours, emptySpace);

		for (int i = 0; i < list.size(); i++) {
			char[] ar = list.get(i).toCharArray();
			char[] patternArr = pattern.toCharArray();
			int j = 0;
			for (int k = 0; k < patternArr.length; k++)
				if (patternArr[k] == '?')
					patternArr[k] = ar[j++];
			result.add(new String(patternArr));
		}
		Collections.sort(result);
		return result;
	}

	private static void recurse(char[] arr, int index, int sumNeeded, int dayHours, int emptySpace) {
		if (sumNeeded == 0) {
			list.add(new String(arr));
			return;
		}
		if (index >= arr.length)
			return;
		for (int i = dayHours; i >= 0; i--) {
			if (i <= sumNeeded) {
				arr[index] = (char) ('0' + i);
				recurse(arr, index + 1, sumNeeded - i, dayHours, emptySpace);
			}
		}

	}
}