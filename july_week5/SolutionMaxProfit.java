package july_week5;

import java.util.HashMap;
import java.util.Map;

public class SolutionMaxProfit {

	public int maxProfit(int[] prices) {
		Map<String, Integer> map = new HashMap<>();;
		int profit = maxProfit(prices, 0, 0, map);
		System.out.println(profit);
		return profit;

	}

	public int maxProfit(int[] prices, int buyOrSell, int i, Map<String, Integer> map) {

		if (i >= prices.length) {
			return 0;
		}

		if(map.containsKey(i + "dp" + buyOrSell))
			return map.get(i + "dp" + buyOrSell);
					
		int profit = 0;
		if (buyOrSell == 0) { // buy
			int buy = maxProfit(prices, 1, i + 1, map) - prices[i];
			int noBuy = maxProfit(prices, 0, i + 1, map);
			profit = Math.max(buy, noBuy);
		}
		else { // sell
			int sell = maxProfit(prices, 0, i + 2, map) + prices[i];
			int noSell = maxProfit(prices, 1, i + 1, map);
			profit = Math.max(sell, noSell);
		}
		map.put(i + "dp" + buyOrSell, profit);
		return profit;

	}

	public static void main(String[] args) {
		SolutionMaxProfit sol = new SolutionMaxProfit();
		sol.maxProfit(new int[] { 1, 2, 3, 0, 2 });
	}

}
