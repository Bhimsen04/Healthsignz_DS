package Stack_Queue;

import java.util.Arrays;
import java.util.Stack;

public class FindNearest_Left_RightMax {

	public static void main(String[] args) {
		int[] ar = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int[] NLM = findNearestLeftMax(ar);
		int[] NRM = findNearestRightMax(ar);
		System.out.println(Arrays.toString(NLM));
		System.out.println(Arrays.toString(NRM));
	}

	private static int[] findNearestLeftMax(int[] ar) {
		Stack<Integer> stack = new Stack<>();
		int[] br = new int[ar.length];
		for (int i = ar.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && ar[i] > ar[stack.peek()])
				br[stack.pop()] = ar[i];
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			int idx = stack.pop();
			br[idx] = ar[idx];
		}
		return br;
	}

	private static int[] findNearestRightMax(int[] ar) {
		Stack<Integer> stack = new Stack<>();
		int[] br = new int[ar.length];
		for (int i = 0; i < ar.length; i++) {
			while (!stack.isEmpty() && ar[i] > ar[stack.peek()])
				br[stack.pop()] = ar[i];
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			int idx = stack.pop();
			br[idx] = ar[idx];
		}
		return br;
	}
}
