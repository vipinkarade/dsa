package oneDDP;

public class HouseRobberII
{
	static void main()
	{
		int[] nums = new int[]{5,1,2,6,12,7,9,3,4,10};
		System.out.println(rob(nums));
	}

	private static int rob(int[] nums)
	{
		if (nums.length < 3)
			return Math.max(nums[0], nums[nums.length - 1]);

		int first = 0, second = 0, temp;

		for (int i = 0; i < nums.length - 1; i++)
		{
			temp = Math.max(nums[i] + first, second);
			first = second;
			second = temp;
		}
		int firstMax = second;
		first = 0;
		second = 0;
		for (int i = 1; i < nums.length; i++)
		{
			temp = Math.max(nums[i] + first, second);
			first = second;
			second = temp;
		}
		return Math.max(firstMax, second);
	}
}
