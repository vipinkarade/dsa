package oneDDP;

import java.util.HashMap;
import java.util.Map;

public class CoinChange
{
	static void main()
	{

	}

	private static int coinChange(int[] coins, int amount)
	{
		Map<Integer, Integer> map = new HashMap<>();
		int num = getCoinChange(coins, amount, map);
		return num == Integer.MAX_VALUE ? -1 : num;
	}

	private static int getCoinChange(int[] coins, int amount, Map<Integer, Integer> map)
	{
		if (amount < 0)
			return Integer.MAX_VALUE;
		else if (amount == 0)
			return 0;
		else if (map.get(amount) != null)
			return map.get(amount);
		else
		{
			int num = Integer.MAX_VALUE;
			for (int coin : coins)
			{
				int numOfCoins = getCoinChange(coins, amount - coin, map);
				if (numOfCoins < num)
					num = 1 + numOfCoins;
			}
			map.put(amount, num);
			return map.get(amount);
		}
	}
}
