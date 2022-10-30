package Recursion;

public class Fibonacci {
	public static void main(String[] args) {
		System.out.println(fib(8));
	}

	private static int fib(int n) {
		if (n <= 2)
			return 1;
		return fib(n - 1) + fib(n - 2);
	}
}
