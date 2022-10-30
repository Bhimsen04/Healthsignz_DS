package Bit_Manipulation;

public class DecimalToBinary {
	public static void main(String[] args) {
		System.out.println(getBinary(4));
	}

	private static int getBinary(int num) {
		int res = 0;
		for (int i = 31; i >= 0; i--) {
			int k = num >> i;
			if ((k & 1) > 0)
				res = res * 10 + 1;
			else
				res = res * 10 + 0;
		}
		return res;
	}
}
