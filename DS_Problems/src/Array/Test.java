package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Test {
	// Input : arr[] = {1, 5, 7, -1, 5}, sum = 6
	// Output : 3 Pairs with sum 6 are (1, 5), (7, -1) & (1, 5)

	public static void main(String[] args) {
		int arr[] = { 1, 5, 5, 7, -1 };
		int sum = 6;
		findPairs(arr, sum);
	}

	public static void findPairs(int[] arr, int sum) {

		HashSet<Integer> set = new HashSet<>();
		List<int[]> list = new ArrayList<>();
		for (int m : arr) {
			if (set.contains(sum - m)) {
				int[] ar = new int[2];
				ar[0] = sum - m;
				ar[1] = m;
				list.add(ar);
			}
			set.add(m);
		}
		for (int[] l : list)
			System.out.println(Arrays.toString(l));
	}
}
