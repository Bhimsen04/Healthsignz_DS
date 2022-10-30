package Adhoc_Array_2D;

public class PowerOfThree {
	// https://leetcode.com/problems/power-of-three/
	public static void main(String[] args) {
		System.out.println(new PowerOfThree().isPowerOfThree(27));
	}

	public boolean isPowerOfThree(int n) {
		if (n < 1)
			return false;

		while (n % 3 == 0)
			n /= 3;

		return n == 1;

	}
}
