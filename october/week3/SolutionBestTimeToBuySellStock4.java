package october.week3;

public class SolutionBestTimeToBuySellStock4 {

	public int maxProfit(int k, int[] prices) {

		return 0;
	}

	private int recur(int[] prices, int i, String buyOrSell, int k) {
		if (i >= prices.length)
			return 0;
		if (k == 0)
			return 0;

		int profit1 = 0;
		int profit2 = 0;
		if (buyOrSell == "buy") {
			profit1 = -prices[i] + recur(prices, i + 1, "sell", k - 1);
			profit2 = recur(prices, i + 1, "buy", k);
			return Math.max(profit1, profit2);
		} else {
			profit1 = prices[i] + recur(prices, i + 1, "buy", k - 1);
			profit2 = recur(prices, i + 1, "sell", k);
			return Math.max(profit1, profit2);
		}

	}

	public static void main(String[] args) {
		SolutionBestTimeToBuySellStock4 sol = new SolutionBestTimeToBuySellStock4();
		System.out.println(sol.maxProfit(2, new int[] { 2, 4, 1 }));
	}

}
