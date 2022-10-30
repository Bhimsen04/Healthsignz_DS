package Recursion;

public class Permutation {

	// https://leetcode.com/problems/permutations/
	public static void main(String[] args) {
		String str = "DOG";
		Permutation permutation = new Permutation();
		permutation.permute(str, 0, str.length());
	}

	private void permute(String str, int l, int r) {

		if (l == r)
			System.out.println(str);
		else
			for (int i = l; i < r; i++) {
				str = swap(str, l, i);
				permute(str, l + 1, r);
				str = swap(str, l, i);
			}
	}

	private String swap(String str, int l, int r) {
		char[] arr = str.toCharArray();
		char temp = arr[l];
		arr[l] = arr[r];
		arr[r] = temp;
		return new String(arr);
	}

}
