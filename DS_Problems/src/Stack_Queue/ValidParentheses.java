package Stack_Queue;

import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		ValidParentheses parentheses = new ValidParentheses();
		System.out.println(parentheses.isValid("((())())(()))"));
	}

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char ch : s.toCharArray()) {
			if (ch == '(')
				stack.push(ch);
			else if (stack.isEmpty())
				return false;
			else
				stack.pop();
		}
		return stack.isEmpty();
	}
}
