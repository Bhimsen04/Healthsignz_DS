package PriorityQueue_Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class K_SortedArray {
	public static void main(String[] args) {
		int[] arr = { 5, 3, 8, 1, 10, 6, 12, 9 };
		System.out.println(Arrays.toString(findKSorted(arr, 3)));

	}

	private static int[] findKSorted(int[] arr, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < k + 1; i++)
			pq.offer(arr[i]);
		int idx = 0;
		for (int i = k + 1; i < arr.length; i++) {
			arr[idx++] = pq.poll();
			pq.offer(arr[i]);
		}
		while (!pq.isEmpty())
			arr[idx++] = pq.poll();
		return arr;
	}
}
