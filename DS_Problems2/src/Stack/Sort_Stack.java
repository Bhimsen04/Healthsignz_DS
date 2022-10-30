package Stack;

import java.util.Stack;

public class Sort_Stack {
	public static Stack<Integer> sort(Stack<Integer> s) {
		Stack<Integer> temp = new Stack<>();
		while (!s.isEmpty()) {
			int v = s.pop();
			while (!temp.isEmpty() && temp.peek() > v) // temp.peek() < v(descending)
				s.push(temp.pop());
			temp.push(v);
		}
		return temp;
	}

	public static void main(String[] args) {
		Stack<Integer> temp = new Stack<>();
		temp.push(3);
		temp.push(2);
		temp.push(1);
		System.out.println(sort(temp));
	}
}
