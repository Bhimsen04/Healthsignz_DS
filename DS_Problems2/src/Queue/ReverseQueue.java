package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {
	public static void main(String[] args) {

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(10);
		queue.add(20);
		queue.add(30);
		queue.add(40);
		queue.add(50);
		reverseQueue(queue);
		System.out.println(queue);
	}

	private static Queue<Integer> reverseQueue(Queue<Integer> queue) {
		Stack<Integer> stack = new Stack<Integer>();
		while (!queue.isEmpty())
			stack.add(queue.poll());
		while (!stack.isEmpty())
			queue.add(stack.pop());
		return queue;
	}
}
