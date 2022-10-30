package PriorityQueue_Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class FirstKSmallerElements {

	public static void main(String[] args) {
		int[] arr = { 5, 3, 8, 1, 10, 6, 12, 9, -10 };
		int k = 3;
		PriorityQueue<Integer> pq = smallerElements(arr, k);
		System.out.println(pq);
	}

	private static PriorityQueue<Integer> smallerElements(int[] arr, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < k; i++)
			pq.offer(arr[i]);
		for (int i = k; i < arr.length; i++) {
			pq.offer(arr[i]);
			pq.poll();
		}
		return pq;
	}

}
