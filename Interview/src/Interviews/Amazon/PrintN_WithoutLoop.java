package Interviews.Amazon;

public class PrintN_WithoutLoop {
	static void printNos(int n) {
		if (n > 0) {
			printNos(n - 1);
			System.out.print(n + " ");
		}
		return;
	}

	static int i = 1;

	public static void main(String[] args) {

		if (i <= 10) {
			System.out.print(i++ + " ");
			main(null);
		}
	}
}
