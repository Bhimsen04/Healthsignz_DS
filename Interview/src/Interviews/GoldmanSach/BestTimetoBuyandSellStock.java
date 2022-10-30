package Interviews.GoldmanSach;

public class BestTimetoBuyandSellStock {

	// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
	public static void main(String[] args) {
		int[] prices = { 7, 1, 5, 3, 6, 4 };
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
