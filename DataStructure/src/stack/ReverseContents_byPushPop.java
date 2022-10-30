package stack;

import java.util.Stack;

public class ReverseContents_byPushPop {
	static Stack<Integer> stack = null;

	public static void main(String[] args) {
		stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		reverseStack(stack);
		getBothStackElements(stack);
	}

	private static void reverseStack(Stack<Integer> stack) {
		if (stack.isEmpty())
			return;
		int temp = stack.pop();
		reverseStack(stack);
		insertAtBottom(stack, temp);
	}

	private static void insertAtBottom(Stack<Integer> stack, int data) {
		if (stack.isEmpty()) {
			stack.push(data);
			return;
		}
		int temp = stack.pop();
		insertAtBottom(stack, data);
		stack.push(temp);
	}
	
	private static void getBothStackElements(Stack<Integer> stack) {
		System.out.println("\nStack elements :- ");
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + ",");
		}
	}
}
