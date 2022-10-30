package Interviews.GoldmanSach;

public class BestTimetoBuyandSellStock {

	// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
	public static void main(String[] args) {
		int[] prices = { 3, 2, 4, 2, 5, 7, 2, 4, 9, 0, 9 };
		System.out.println(maxProfit(prices));
	}

	public static int maxProfit(int[] prices) {
		int minIndex = 0, max = Integer.MIN_VALUE;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[minIndex])
				max = Math.max(max, prices[i] - prices[minIndex]);
			else
				minIndex = i;

		}
		if (max <= 0)
			return 0;
		return max;
	}
}
