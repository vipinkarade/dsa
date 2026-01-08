package slidingWindow;

public class BestTimeToBuyAndSellStock
{
	static void main()
	{
//		int[] prices = {10,1,5,6,7,1};
		int[] prices = {10,8,7,5,2};
		System.out.println(maxProfit(prices));
	}

	private static int maxProfit(int[] prices)
	{
		int lastDip = 0;
		int curr = 0;
		int maxSum = 0;
		while(curr < prices.length)
		{
			if (prices[lastDip] > prices[curr])
				lastDip = curr;
			else
			{
				int diff = prices[curr] - prices[lastDip];
				if (diff > maxSum)
					maxSum = diff;
			}
			curr++;
		}
		return maxSum;
	}
}
