package queue;

import java.util.LinkedList;
import java.util.Queue;

public class ImplStackUsingTwoQueue<T> {

	private static Queue<Integer> Q1 = new LinkedList<Integer>();
	private static Queue<Integer> Q2 = new LinkedList<Integer>();

	public static void main(String[] args) {
		push(1);
		push(2);
		push(3);
		push(4);
		push(5);
		System.out.println(pop());
		push(6);
		push(7);
		System.out.println(pop());
	}

	private static void push(int data) {
		if (Q1.isEmpty()) {
			Q2.offer(data);
		} else
			Q1.offer(data);
	}

	private static int pop() {
		int size = 0;
		if (Q1.isEmpty()) {
			size = Q2.size();
			for (int i = 0; i < size - 1; i++)
				Q1.offer(Q2.poll());
			return Q2.poll();
		} else {
			size = Q1.size();
			for (int i = 0; i < size - 1; i++)
				Q2.offer(Q1.poll());
			return Q1.poll();
		}
	}
}
