package Stack_Queue;

import java.util.Stack;

public class FindNearestLeftMax {

	public static int[] findNearestLeftMax(int[] height) {
		Stack<Integer> stk = new Stack<Integer>();
		int[] br = new int[height.length];
		for (int i = height.length - 1; i >= 0; i--) {
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
