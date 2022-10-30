package Interviews.Blackbuck;

import java.util.PriorityQueue;

public class Connect_N_RopesWithMinimumCost {

	// Asked in Blackbuck
	public static void main(String args[]) {
		int len[] = { 4, 3, 2, 6 };
		System.out.println(
				"Total cost for connecting" + " ropes is " + new Connect_N_RopesWithMinimumCost().minCost(len));
	}

	int minCost(int arr[]) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i = 0; i < arr.length; i++)
			pq.add(arr[i]);

		int res = 0;
		while (pq.size() > 1) { // n
			int first = pq.poll(); // logn(delete)
			int second = pq.poll();
			res += first + second;
			pq.add(first + second);
		}
		return res;
	}

	// O(nLogn)

}
