package PriorityQueue_Heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfSubArray {

	public static void main(String[] args) {
		int[] arr = { 5, 1, 3, 2, 8, 10, 4, 12, 18 };
		// [5, 1, 3, 2, 3, 3, 4, 4, 5]
		System.out.println(Arrays.toString(median(arr)));
	}

	public static int[] median(int[] arr) {
		int[] ans = new int[arr.length];
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < arr.length; i++) {
			if (maxHeap.isEmpty() || arr[i] < maxHeap.peek())
				maxHeap.offer(arr[i]);
			else
				minHeap.offer(arr[i]);
			balance(minHeap, maxHeap);
			ans[i] = maxHeap.peek();
		}
		return ans;
	}

	private static void balance(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
		if (maxHeap.size() - minHeap.size() == -1)
			maxHeap.offer(minHeap.poll());
		else if (maxHeap.size() - minHeap.size() > 1)
			minHeap.offer(maxHeap.poll());
	}
}
