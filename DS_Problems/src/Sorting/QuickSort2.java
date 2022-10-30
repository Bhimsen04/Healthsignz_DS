package Sorting;

import java.util.Scanner;

public class QuickSort2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int i = 0;
		while (i < n)
			arr[i++] = sc.nextInt();
		partition(arr, 0, n - 1);
		for (int arrV : arr)
			System.out.print(arrV + " ");
		sc.close();
	}

	public static void partition(int[] arr, int start, int end) {
		int pivot = arr[start];
		int pIdx = end;
		for (int i = end; i >= start; i--) {
			if (arr[i] >= pivot) {
				int temp = arr[i];
				arr[i] = arr[pIdx];
				arr[pIdx--] = temp;
			}
		}
	}
}