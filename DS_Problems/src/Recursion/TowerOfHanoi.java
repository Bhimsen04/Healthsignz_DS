package Recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TowerOfHanoi {

	// https://www.hackerrank.com/contests/launchpad-1-winter-challenge/challenges/shift-plates/problem
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		readTOH(n, 'A', 'C', 'B');
	}

	public static void readTOH(int n, char s, char t, char d) {
		if (n == 0)
			return;
		readTOH(n - 1, s, d, t);
		System.out.println("Moving ring " + n + " from " + s + " to " + d);
		readTOH(n - 1, t, s, d);
	}
}
