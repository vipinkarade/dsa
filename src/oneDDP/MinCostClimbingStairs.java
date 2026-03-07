package oneDDP;

public class MinCostClimbingStairs
{
	static void main()
	{
		int[] cost = new int[]{1, 2, 1, 2, 1, 1, 1};
		System.out.println(minCostClimbingStairs(cost));
	}

	private static int minCostClimbingStairs(int[] cost) {
		int first = cost[0];
		int second = cost[1];
		for (int i = 2; i < cost.length; i+=2)
		{
			first = Math.min(first, second) + cost[i];
			if (i + 1 != cost.length)
				second = Math.min(first, second) + cost[i + 1];
		}

		return Math.min(first, second);
	}
}
