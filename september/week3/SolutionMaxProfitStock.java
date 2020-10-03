package september.week3;

public class SolutionMaxProfitStock {

	public int maxProfit(int[] prices) {

		// 7, 1, 5, 3, 6, 4
		int max = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < prices.length; i++) {
			min = Math.min(min, prices[i]);
			max = Math.max(max, prices[i] - min);
		}
		return max;

	}

	private int recur(int[] prices, int index, int profit, String status) {

		if (index >= prices.length)
			return profit;

		int buy = 0;
		int sell = 0;

		if (status.equals("buy")) {
			int picked = recur(prices, index + 1, profit - prices[index], "sell");
			int notPicked = recur(prices, index + 1, profit, "buy");
			buy = Math.max(picked, notPicked);
		} else {
			int picked = recur(prices, index + 1, profit + prices[index], "buy");
			int notPicked = recur(prices, index + 1, profit, "sell");
			sell = Math.max(picked, notPicked);
		}
		return Math.max(buy, sell);

	}

	public static void main(String[] args) {
		SolutionMaxProfitStock sol = new SolutionMaxProfitStock();
		System.out.println(sol.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
	}

}
