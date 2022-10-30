package Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix {

	// https://www.hackerrank.com/contests/code-maestros-14-04/challenges/baby-step
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		Map<Character, Integer> precedences = new HashMap<>();
		precedences.put('+', 2);
		precedences.put('-', 2);
		precedences.put('*', 3);
		precedences.put('/', 4);
		precedences.put('^', 5);
		while (t-- > 0) {
			String s = sc.next();
			Stack<Character> stack = new Stack<>();
			for (char c : s.toCharArray()) {
				if (c > 47 && c != 94)
					System.out.print(c);
				else if (c == ')') {
					while (!stack.isEmpty() && stack.peek() != '(')
						System.out.print(stack.pop());
					stack.pop();
				} else {
					if (!stack.isEmpty() && c != '(' && stack.peek() != '('
							&& precedences.get(c) <= precedences.get(stack.peek()))
						System.out.print(stack.pop());
					stack.push(c);
				}

			}
			while (!stack.isEmpty())
				System.out.print(stack.pop());
			System.out.println();
		}
		sc.close();
	}
}
