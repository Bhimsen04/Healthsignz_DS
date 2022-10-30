package Bit_Manipulation;

public class Number_of_1_Bits {
	// https://www.interviewbit.com/problems/number-of-1-bits/
	public static void main(String[] args) {
		
		System.out.println(numSetBits(00000000000000000000000000001011));
	}

	public static int numSetBits(long a) {
		int counter = 0;
		while (a > 0) {
			a = a & a - 1;
			counter++;
		}
		return counter;
	}
}
