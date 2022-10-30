package Queue;

import java.util.EmptyStackException;
import java.util.Stack;

public class ImplementQueueUsingTwoStacks<T> {

	private Stack<T> s1 = new Stack<T>();
	private Stack<T> s2 = new Stack<T>();

	public static void main(String[] args) {

		ImplementQueueUsingTwoStacks<Integer> obj = new ImplementQueueUsingTwoStacks<Integer>();
		obj.enQueue(10);
		obj.enQueue(20);
		obj.enQueue(30);
		// obj.enQueue(40);
		// obj.enQueue(50);
		System.out.println(obj.deQueue());
		System.out.println(obj.deQueue());
		System.out.println(obj.deQueue());
		obj.enQueue(60);
		// obj.enQueue(70);
		System.out.println(obj.deQueue());
		System.out.println(obj.deQueue());
	}

	public void enQueue(T data) {
		s1.push(data);
	}

	public T deQueue() {
		try {
			if (s2.isEmpty())
				while (!s1.isEmpty())
					s2.push(s1.pop());
			return s2.pop();
		} catch (EmptyStackException e) {
			throw new EmptyStackException();
		}
	}
}
