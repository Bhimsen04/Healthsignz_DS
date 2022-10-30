package Array;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

	// https://leetcode.com/problems/generate-parentheses/ 
	public List<String> generateParenthesis(int n) {
		ArrayList<String> list = new ArrayList<>();
		char[] c = new char[n * 2];
		rec(list, c, n * 2, 0, 0, 0);
		return list;
	}

	private void rec(ArrayList<String> list, char[] c, int N, int idx, int ob, int cb) {
		if (idx == N)
			list.add(new String(c));
		if (ob < N / 2) {
			c[idx] = '(';
			rec(list, c, N, idx + 1, ob + 1, cb);
		}
		if (cb < ob) {
			c[idx] = ')';
			rec(list, c, N, idx + 1, ob, cb + 1);
		}
	}

	public static void main(String[] args) {
		GenerateParentheses gp = new GenerateParentheses();
		System.out.println(gp.generateParenthesis(2));
	}
}
