package oneDDP;

public class HouseRobber
{
	static void main()
	{

	}

	private static int rob(int[] nums)
	{
		if (nums.length == 1)
			return nums[0];

		int first = nums[0], second = nums[1], temp;
		for (int i = 2; i < nums.length; i += 2)
		{
			temp = first;
			first = first + nums[i];
			if (i < nums.length - 1)
				second = Math.max(temp, second) + nums[i + 1];
		}
		return Math.max(first, second);
	}
}
