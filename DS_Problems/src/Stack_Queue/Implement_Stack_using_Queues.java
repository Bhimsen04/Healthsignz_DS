package Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;

public class Implement_Stack_using_Queues {

	// https://leetcode.com/problems/implement-stack-using-queues/

	Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();

	public void push(int x) {
		while (!q1.isEmpty())
			q2.add(q1.poll());
		q1.add(x);
		while (!q2.isEmpty())
			q1.add(q2.poll());

	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		if (empty())
			return -1;
		return q1.poll();

	}

	/** Get the top element. */
	public int top() {
		if (empty())
			return -1;
		return q1.peek();
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {
		return q1.isEmpty();

	}

	public static void main(String[] args) {
		Implement_Stack_using_Queues v = new Implement_Stack_using_Queues();
		v.push(1);
		v.push(2);
		v.push(3);
		v.push(4);
	}
}
