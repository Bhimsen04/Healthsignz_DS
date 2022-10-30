package Sorting;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Quicksort_2_Sorting {

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int i = 0;
		while (i < n)
			arr[i++] = sc.nextInt();
		quickSort(0, n - 1, arr);
		sc.close();
	}

	public static void quickSort(int start, int end, int[] arr) {
		if (start >= end)
			return;
		int pIdx = partition(arr, start, end);
		quickSort(start, pIdx - 1, arr);
		quickSort(pIdx + 1, end, arr);
		for (int i = start; i < end; i++)
			System.out.print(arr[i] + " ");
		System.out.println(arr[end]);
	}

	public static int partition(int[] arr, int start, int end) {
		int i = 0;
		int pivot = arr[start];
		int pIdx = 0;
		ArrayList<Integer> lesser = new ArrayList<Integer>();
		ArrayList<Integer> greater = new ArrayList<Integer>();
		for (i = start; i <= end; i++) {
			if (arr[i] < pivot)
				lesser.add(arr[i]);
			else if (arr[i] > pivot)
				greater.add(arr[i]);
		}
		for (i = 0; i < lesser.size(); i++)
			arr[i + start] = lesser.get(i);
		arr[i + start] = pivot;
		pIdx = i + start;
		for (i = 0; i < greater.size(); i++)
			arr[i + start + lesser.size() + 1] = greater.get(i);
		return pIdx;
	}
}
