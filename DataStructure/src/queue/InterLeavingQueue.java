package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InterLeavingQueue {
	
	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(11);
		q.add(12);
		q.add(13);
		q.add(14);
		q.add(15);
		q.add(16);
		q.add(17);
		q.add(18);
		q.add(19);
		q.add(20);
		interLeavingQueue(q);
	}

	private static void interLeavingQueue(Queue<Integer> q) {
		//Stack<Integer> s = new ArrayStack<Integer>();
	}
}
