package twoDDP;

import java.util.HashMap;
import java.util.Map;

public class BestTimeToBuyAndSellStockWithCooldown
{
	static void main()
	{

	}

	private static int maxProfit(int[] prices)
	{
		return findMax(prices, 0, -1, new HashMap<>());
	}

	private static int findMax(int[] prices, int index, int boughtAt, Map<String, Integer> map)
	{
		if (index >= prices.length)
			return 0;

		String key = index + "_" + (boughtAt == -1);
		if (map.containsKey(key))
			return map.get(key);

		int result = 0;
		if (boughtAt < 0)
			result = findMax(prices, index + 1, prices[index], map);
		else
		if (prices[index] > boughtAt)
			result = prices[index] - boughtAt + findMax(prices, index + 2, -1, map);
		result = Math.max(result, findMax(prices, index + 1, boughtAt, map));
		map.put(key, result);
		return result;
	}
}
