package PriorityQueue_Heap;

import java.util.PriorityQueue;

public class KthLargestElementInArray {

	// https://leetcode.com/problems/kth-largest-element-in-an-array/submissions/
	public static void main(String[] args) {
		int[] arr = { 3, 2, 3, 1, 1 , 2, 2, 4, 5, 5, 6 };
		int k = 4;
		System.out.println(findKthLargest(arr, k));
	}

	private static int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i = 0; i < k; i++)
			pq.offer(nums[i]);
		for (int i = k; i < nums.length; i++) {
			pq.offer(nums[i]);
			pq.poll();
		}
		return pq.poll();
	}

}
