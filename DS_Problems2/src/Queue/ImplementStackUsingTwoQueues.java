package Queue;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingTwoQueues<T> {
	private Queue<T> q1 = new LinkedList<T>();
	private Queue<T> q2 = new LinkedList<T>();

	public static void main(String[] args) {

		ImplementStackUsingTwoQueues<Integer> obj = new ImplementStackUsingTwoQueues<Integer>();
		obj.push(10);
		obj.push(20);
		obj.push(30);
		obj.push(40);
		obj.push(50);
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		obj.push(60);
		obj.push(70);
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		System.out.println(obj.pop());
	}

	public void push(T data) {
		if (q1.isEmpty())
			q2.offer(data);
		else
			q1.offer(data);
	}

	public T pop() {
		try {
			int i = 0, size = 0;
			if (q1.isEmpty()) {
				size = q2.size();
				while (i++ < size - 1)
					q1.offer(q2.poll());
				return q2.poll();
			} else {
				size = q1.size();
				while (i++ < size - 1)
					q2.offer(q1.poll());
				return q1.poll();
			}

		} catch (EmptyStackException e) {
			throw new EmptyStackException();
		}
	}
}
