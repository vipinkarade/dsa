package twoDDP;

public class CoinChangeII
{
	static void main()
	{

	}

	private static int change(int amount, int[] coins)
	{
		int[] result = new int[amount + 1];
		result[0] = 1;

		for(int coin : coins)
		{
			for (int i = 1; i < result.length; i++)
			{
				if (i - coin >= 0 && result[i - coin] > 0)
					result[i]++;
			}
		}
		int ans = 0;
		for (int res : result)
			ans += res;
		return ans;
	}
}
