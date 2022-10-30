package Stack_Queue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Sliding_window_maximum {
	// https://leetcode.com/problems/sliding-window-maximum/
	public static void main(String[] args) {
		// System.out.println(Arrays.toString(maxSlidingWindow(arr, 3)));
		Deque<Integer> deque = new LinkedList<Integer>();
		deque.add(1);
		deque.add(2);
		deque.add(3);
		deque.add(4);
		System.out.println(deque);

	}

	public static int[] maxSlidingWindow(int[] arr, int k) {
		Deque<Integer> deque = new LinkedList<Integer>();
		int[] res = new int[arr.length - k + 1];

		for (int i = 0; i < k; i++)
			deleteElementsLessThanCurrentElem_addCurrentEle(arr, deque, i);
		for (int i = k; i < arr.length; i++) {
			res[i - k] = arr[deque.peekFirst()];
			if (!deque.isEmpty() && deque.peekFirst() == i - k)
				deque.pollFirst(); // 7 , 6 , 5 , 4 , 3
			deleteElementsLessThanCurrentElem_addCurrentEle(arr, deque, i);
		}
		res[arr.length - k] = arr[deque.peekFirst()];
		return res;
	}

	private static void deleteElementsLessThanCurrentElem_addCurrentEle(int[] arr, Deque<Integer> deque, int i) {
		while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()])
			deque.pollLast();
		deque.add(i);
	}

	public static void bruteForce(int[] arr, int k) {
		int[] ans = new int[arr.length - k + 1];
		for (int i = 0; i < ans.length; i++) {
			int max = arr[i];
			for (int j = i + 1; j < i + k; j++)
				max = Math.max(max, arr[j]);
			ans[i] = max;
		}
		System.out.println(Arrays.toString(ans));
	}
}
