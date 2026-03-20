package twoDDP;

public class TargetSum
{
	static void main()
	{

	}

	private static int findTargetSumWays(int[] nums, int target)
	{
		int sum = 0;
		for (int num : nums)
			sum += num;

		if (sum < target)
			return 0;

		int[] result = new int[2 * sum + 1];
		result[sum] = 1;

		for (int num : nums)
		{
			int[] sub = new int[2 * sum + 1];
			for (int i = 0; i < result.length; i++)
			{
				if (result[i] > 0)
				{
					sub[i + num] += result[i];
					sub[i - num] += result[i];
				}
			}
			result = sub;
		}
		return result[sum + target];
	}
}
