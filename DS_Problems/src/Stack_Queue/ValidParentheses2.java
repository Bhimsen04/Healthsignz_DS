package Stack_Queue;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses2 {
	// https://leetcode.com/problems/valid-parentheses/submissions/
	public static void main(String[] args) {
		ValidParentheses2 parentheses = new ValidParentheses2();
		System.out.println(parentheses.isValid("{[]}"));
	}

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
		for (char ch : s.toCharArray()) {
			if (map.containsKey(ch))
				stack.push(ch);
			else if (stack.isEmpty() || map.get(stack.pop()) != ch)
				return false;
		}
		return stack.isEmpty();
	}
}
