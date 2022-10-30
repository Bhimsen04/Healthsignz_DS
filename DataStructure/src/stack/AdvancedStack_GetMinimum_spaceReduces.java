package stack;

import java.util.Stack;

public class AdvancedStack_GetMinimum_spaceReduces {

	static Stack<Integer> elementStack = null;
	static Stack<Integer> minStack = null;

	public static void main(String[] args) {
		AdvancedStack_GetMinimum_spaceReduces stack = new AdvancedStack_GetMinimum_spaceReduces();
		elementStack = new Stack<Integer>();
		minStack = new Stack<Integer>();
		stack.push(2);
		stack.push(6);
		stack.push(4);
		stack.push(1);
		stack.push(5);
		stack.push(1);
		stack.pop();
		stack.pop();
		stack.pop();
		stack.getMinimumElement();
		stack.getBothStackElements();
	}

	public void push(int data) {
		elementStack.push(data);
		if (minStack.isEmpty() || minStack.peek() >= data)
			minStack.push(data);
	}

	public void pop() {
		if (!elementStack.isEmpty()) {
			System.out.println("Deleted element :- " + elementStack.peek());
			if(elementStack.peek() == minStack.peek())
				minStack.pop();
			elementStack.pop();
		}
	}

	public void getMinimumElement() {
		if (!minStack.isEmpty())
			System.out.println("minimum element :- " + minStack.peek());
	}

	public void getBothStackElements() {
		System.out.println("elementStack elements :- ");
		while (!elementStack.isEmpty()) {
			System.out.print(elementStack.pop() + ",");
		}
		System.out.println("\nminStack elements :- ");
		while (!minStack.isEmpty()) {
			System.out.print(minStack.pop() + ",");
		}
	}

}
