package Bit_Manipulation;

public class XBItsFollowedByYBits {

	public static void main(String[] args) {
		int x = 3;
		int y = 4;
		generate(x, y);
	}

	private static void generate(int x, int y) {
		int ans = 0;
		for (int i = y; i < x + y; i++)
			ans = ans | (1 << i);
		System.out.println(ans);
	}
}
