package twoPointers;

public class CoinChangeII
{
	static void main()
	{

	}

	private static int change(int amount, int[] coins)
	{
		int[] result = new int[amount + 1];
		result[0] = 1;
		for (int i = coins.length - 1; i >= 0; i--)
		{
			int[] subResult = new int[amount + 1];
			subResult[0] = 1;
			for (int j = 0; j < result.length; j++)
			{
				if (j - coins[i] < 0)
					subResult[j] = result[j];
				else
					subResult[j] = result[j] + subResult[j - coins[i]];
			}
			result = subResult;
		}
		return result[amount];
	}
}
