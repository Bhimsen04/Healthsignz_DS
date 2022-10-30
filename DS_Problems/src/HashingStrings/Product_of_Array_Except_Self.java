package HashingStrings;

import java.util.Arrays;

public class Product_of_Array_Except_Self {

	// https://leetcode.com/problems/product-of-array-except-self/
	public static void main(String[] args) {
		int[] ar = { 1, 2, 3, 4 };
		
		// 1 2 6 24
		// 24 24 12 4
		System.out.println(Arrays.toString(productExceptSelf(ar)));
	}

	public static int[] productExceptSelf(int[] nums) {
		int[] prefix = new int[nums.length];
		int[] suffix = new int[nums.length];
		prefix[0] = 1;
		suffix[nums.length - 1] = 1;
		for (int i = 0; i < suffix.length - 1; i++) {
			prefix[i + 1] = prefix[i] * nums[i];
			suffix[nums.length - i - 2] = suffix[nums.length - i - 1] * nums[nums.length - i - 1];
		}
		for (int i = 0; i < prefix.length; i++)
			nums[i] = prefix[i] * suffix[i];
		return nums;
	}
}
