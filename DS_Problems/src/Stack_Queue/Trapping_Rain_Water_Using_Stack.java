package Stack_Queue;

import java.util.Stack;

public class Trapping_Rain_Water_Using_Stack {

	// https://leetcode.com/problems/trapping-rain-water/
	public static void main(String[] args) {
		Trapping_Rain_Water_Using_Stack rain_Water = new Trapping_Rain_Water_Using_Stack();
		int[] heightOfArr = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(rain_Water.trap(heightOfArr));
	}

	public int trap(int[] arr) {
		int sum = 0;
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			int NRM_index = i;
			int NRM_height = arr[NRM_index];
			while (!st.isEmpty() && NRM_height > arr[st.peek()]) {
				int currentIndex = st.pop();
				int current_height = arr[currentIndex];
				if (st.isEmpty())
					break;
				int NLM_index = st.peek();
				int NLM_height = arr[NLM_index];

				int width = NRM_index - NLM_index - 1;
				int minimumTower = Math.min(NRM_height, NLM_height);
				int height = minimumTower - current_height;
				sum += width * height;
			}
			st.push(i);
		}
		return sum;
	}

}
