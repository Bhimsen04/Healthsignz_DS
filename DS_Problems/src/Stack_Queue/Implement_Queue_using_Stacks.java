package Stack_Queue;

import java.util.Stack;

public class Implement_Queue_using_Stacks {
	// https://leetcode.com/problems/implement-queue-using-stacks/

	Stack<Integer> s1, s2;

	public Implement_Queue_using_Stacks() {
		s1 = new Stack<Integer>();
		s2 = new Stack<Integer>();
	}

	public boolean empty() {
		return s1.isEmpty() && s2.isEmpty();
	}

	public int size() {
		return s1.size() + s2.size();
	}

	public void push(int x) {
		s1.push(x);
	}

	public int pop() {
		if (empty())
			return -1;
		if (s2.isEmpty())
			shiftElements();
		return s2.pop();
	}

	public int peek() {
		if (empty())
			return -1;
		if (s2.isEmpty())
			shiftElements();
		return s2.peek();
	}

	public void shiftElements() {
		if (s2.isEmpty() && !s1.isEmpty())
			while (!s1.isEmpty())
				s2.push(s1.pop());

	}

	public static void main(String[] args) {
		Implement_Queue_using_Stacks myQueue = new Implement_Queue_using_Stacks();
		myQueue.push(1); // queue is: [1]
		myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
		myQueue.peek(); // return 1
		myQueue.pop(); // return 1, queue is [2]
		myQueue.empty(); // return false
	}

}
