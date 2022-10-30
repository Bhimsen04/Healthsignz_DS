package Stack_Queue;

import java.util.Stack;

public class FindNearestRightMax {

	public static int[] findNearestRightMax(int[] height) {
		Stack<Integer> stk = new Stack<Integer>();
		int[] br = new int[height.length];
		for (int i = 0; i < height.length; i++) {
			while (!stk.isEmpty() && height[i] > height[stk.peek()])
				br[stk.pop()] = i;
			stk.push(i);
		}
		while (!stk.isEmpty()) {
			int pop = stk.pop();
			br[pop] = pop;
		}
		return br;
	}

}
