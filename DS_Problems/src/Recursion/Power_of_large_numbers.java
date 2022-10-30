package Recursion;

import java.util.Scanner;

public class Power_of_large_numbers {

	// https://www.hackerrank.com/challenges/power-of-large-numbers/problem
	static int m = 1000000007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = Integer.parseInt(sc.nextLine());
		while (testCases-- != 0) {
			String[] arr = sc.nextLine().split(" ");
			String s = arr[0];
			long a = 0;
			for (int i = 0; i < s.length(); i++)
				a = (((a * 10) % m) + s.charAt(i) - 48) % m;
			s = arr[1];
			long b = 0;
			for (int i = 0; i < s.length(); i++)
				b = (((b * 10) % (m - 1)) + s.charAt(i) - 48) % (m - 1);
			System.out.println(solve(a, b));
		}
		sc.close();
	}

	static long solve(long a, long b) {
		if (b == 0)
			return 1;
		long ans = solve(a, b / 2);
		long res = ((ans % m) * (ans % m)) % m;
		if ((b & 1) == 1)
			res = ((res % m) * (a % m)) % m;
		return res;

	}

}
