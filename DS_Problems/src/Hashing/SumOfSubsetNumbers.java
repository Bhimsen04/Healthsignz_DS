package Hashing;

import java.util.HashSet;

public class SumOfSubsetNumbers {

	public static void main(String[] args) {
		int[] arr = { 5, 3, -2, 8, 4, 7 };
		int N = arr.length;
		int[] ar1 = getAllSubsets(arr, 0, N / 2);
		int[] ar2 = getAllSubsets(arr, N / 2, N);
		HashSet<Integer> set = convertAr2ToHashset(ar2);
		System.out.println(checkTwoSumArray(ar1, set, 24));
	}

	private static int[] getAllSubsets(int[] arr, int l, int h) {
		int ar[] = new int[1 << (h - l)];
		for (int j = 0; j < (1 << (h - l)); j++) {
			int sum = 0, p = j, i = l;
			while (p > 0) {
				if ((p & 1) == 1)
					sum += arr[i];
				p >>= 1;
				i++;
			}
			ar[j] = sum;
		}
		return ar;
	}

	private static boolean checkTwoSumArray(int[] arr, HashSet<Integer> set, int k) {
		for (int ar : arr)
			if (set.contains(k - ar))
				return true;
		return false;
	}

	private static HashSet<Integer> convertAr2ToHashset(int[] ar2) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int ar : ar2)
			set.add(ar);
		return set;
	}

}
