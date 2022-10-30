package Stack_Queue;

import java.util.Stack;

public class LargestRectangleinHistogram {
	// https://leetcode.com/problems/largest-rectangle-in-histogram/
	public static void main(String[] args) {
		int[] arr = { 2, 4 };

		int maxArea = largestRectangleArea(arr);
		System.out.println(maxArea);
	}

	private static int largestRectangleArea(int[] heights) {
		Stack<Integer> stack = new Stack<Integer>();
		int maxArea = 0, i;
		for (i = 0; i < heights.length; i++) {
			while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
				int top = stack.pop(), area = 0;
				if (stack.isEmpty())
					area = heights[top] * i;
				else
					area = heights[top] * (i - stack.peek() - 1);
				maxArea = Math.max(area, maxArea);
			}
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			int top = stack.pop(), area = 0;
			if (stack.isEmpty())
				area = heights[top] * i;
			else
				area = heights[top] * (i - stack.peek() - 1);
			maxArea = Math.max(area, maxArea);
		}
		return maxArea;
	}
}
