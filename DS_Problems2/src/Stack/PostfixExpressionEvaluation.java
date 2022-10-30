package Stack;

import java.util.Scanner;
import java.util.Stack;

public class PostfixExpressionEvaluation {

	// https://www.hackerrank.com/contests/17cs1102/challenges/8-c-postfix-expression-evaluation
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			String[] st = (sc.next() + sc.nextLine()).split(" ");
			Stack<Integer> stack = new Stack<>();
			for (String s : st) {
				if (s.equals("?"))
					break;
				char c = s.charAt(0);
				if (c < 48 || c > 57) {
					int second = stack.pop();
					int first = stack.pop();
					if (c == '+')
						stack.push(first + second);
					else if (c == '-')
						stack.push(first - second);
					else if (c == '*')
						stack.push(first * second);
					else
						stack.push(first / second);
				} else
					stack.push(Integer.parseInt(s));
			}
			System.out.println(stack.pop());
		}
		sc.close();

	}

}
