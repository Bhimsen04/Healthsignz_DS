package Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class StockSpanner {

	ArrayList<Integer> list = new ArrayList<>();
	Stack<Integer> stack = new Stack<Integer>();

	// https://leetcode.com/problems/online-stock-span/
	public static void main(String[] args) {
		StockSpanner obj = new StockSpanner();

		// System.out.println(obj.next(31));
		// System.out.println(obj.next(41));
		// System.out.println(obj.next(48));
		// System.out.println(obj.next(59));
		// System.out.println(obj.next(79));
		// System.out.println(obj.next(75));
		// System.out.println(obj.next(85));

		int[] arr = { 100, 50, 60, 76, 60, 75, 85 };
		System.out.println(Arrays.toString(obj.findingSpans(arr)));

	}

	public int[] findingSpans(int[] arr) {
		int[] spans = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			while (!stack.isEmpty() && arr[stack.peek()] <= arr[i])
				stack.pop();
			if (stack.isEmpty())
				spans[i] = i + 1;
			else
				spans[i] = i - stack.peek();
			stack.push(i);
		}
		return spans;
	}

	public int next(int price) {
		int result = 0;
		while (!stack.isEmpty() && list.get(stack.peek()) <= price)
			stack.pop();
		if (stack.isEmpty())
			result = list.size() + 1;
		else
			result = list.size() - stack.peek();
		stack.push(list.size());
		list.add(price);
		return result;
	}

}