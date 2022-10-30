package Stack_Queue;

import java.util.Stack;

public class Implement_Queue_using_Stack {

	Stack<Integer> s1;

	public Implement_Queue_using_Stack() {
		s1 = new Stack<Integer>();
	}

	public boolean empty() {
		return s1.isEmpty();
	}

	public int size() {
		return s1.size();
	}

	public void push(int x) {

		if (empty()) {
			s1.push(x);
			return;
		}
		int num = s1.pop();
		push(x);
		s1.push(num);
	}

	public int pop() {
		if (empty())
			return -1;
		return s1.pop();
	}

	public int peek() {
		if (empty())
			return -1;
		return s1.peek();
	}

	public static void main(String[] args) {
		Implement_Queue_using_Stack v = new Implement_Queue_using_Stack();
		v.push(1);
		v.push(2);
		v.push(3);
		v.push(4);
	}
}
