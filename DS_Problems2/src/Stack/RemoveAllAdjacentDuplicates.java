package Stack;

import java.util.Arrays;

public class RemoveAllAdjacentDuplicates {

	public static void main(String[] args) {
		int[] arr = { 1, 9, 6, 8, 8, 8, 0, 1, 1, 0, 6, 5 };
		removeAdjacentDuplicates(arr);
	}

	private static void removeAdjacentDuplicates(int[] A) {
		int skipPtr = -1, i = 0;
		while (i < A.length) {
			if (skipPtr == -1 || A[skipPtr] != A[i]) {
				skipPtr++;
				A[skipPtr] = A[i];
				i++;
			} else {
				while (i < A.length && A[i] == A[skipPtr])
					i++;
				skipPtr--;
			}
		}
		for (int j = 0; j <= skipPtr; j++)
			System.out.print(A[j] + " ");

	}
}
