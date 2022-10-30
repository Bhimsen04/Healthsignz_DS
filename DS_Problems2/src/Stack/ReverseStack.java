package Stack;

import java.util.Stack;

public class ReverseStack {
	// https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list-in-reverse/problem
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		System.out.println(s);
		reverseStack(s);
		System.out.println(s);
	}

	public static void reverseStack(Stack<Integer> s) {
		if (s.isEmpty())
			return;
		int temp = (int) s.pop();
		reverseStack(s);
		insertAtBottom(s, temp);
	}

	public static void insertAtBottom(Stack<Integer> s, int m) {
		if (s.isEmpty()) {
			s.push(m);
			return;
		}
		int temp = (int) s.pop();
		insertAtBottom(s, m);
		s.push(temp);
	}
}
