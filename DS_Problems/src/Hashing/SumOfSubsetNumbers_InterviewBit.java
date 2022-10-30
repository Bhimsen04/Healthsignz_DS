package Hashing;

import java.util.HashSet;

public class SumOfSubsetNumbers_InterviewBit {

	// https://www.interviewbit.com/problems/subset-sum-problem/
	// Giving TLE or Java heap space
	public static void main(String[] args) {
		int[] arr = { 68, 35, 1, 70, 25, 79, 59, 63, 65, 6, 46 };
		int N = arr.length;
		int[] ar1 = getAllSubsets(arr, 0, N / 2);
		int[] ar2 = getAllSubsets(arr, N / 2, N);
		HashSet<Integer> set = convertAr2ToHashset(ar2);
		System.out.println(checkTwoSumArray(ar1, set, 36));
	}

	private static int[] getAllSubsets(int[] arr, int l, int h) {
		int size = 1 << (h - l);
		int ar[] = new int[size];
		for (int j = 0; j < size; j++) {
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

	private static int checkTwoSumArray(int[] arr, HashSet<Integer> set, int k) {
		for (int ar : arr)
			if (set.contains(k - ar))
				return 1;
		return 0;
	}

	private static HashSet<Integer> convertAr2ToHashset(int[] ar2) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int ar : ar2)
			set.add(ar);
		return set;
	}

}
