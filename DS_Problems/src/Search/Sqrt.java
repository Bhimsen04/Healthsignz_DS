package Search;

import java.util.Scanner;

public class Sqrt {

	// https://leetcode.com/problems/sqrtx/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		sc.close();
		System.out.println(mySqrt(x));

	}

	public static int mySqrt(int x) {
		if (x < 2)
			return x;
		long low = 0, high = x, mid = 0;
		while (low < high) {
			mid = (low + high) / 2;
			if (mid * mid == x)
				return (int) mid;
			else if (mid * mid > x)
				high = mid;
			else
				low = mid + 1;
		}
		return (int) low - 1;
	}
}
