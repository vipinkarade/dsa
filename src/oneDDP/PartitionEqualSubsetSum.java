package oneDDP;

public class PartitionEqualSubsetSum
{
	static void main()
	{
		int[] nums = new int[]{14,9,8,4,3,2};
		System.out.println(canPartition(nums));
	}

	private static boolean canPartition(int[] nums)
	{
		int sum = 0;
		for (int num : nums)
			sum += num;
		int target = 0;
		if (sum % 2 == 1)
			return false;
		else
			target = sum / 2;

		return createSets(nums, 0, 0, target);
	}

	private static boolean createSets(int[] nums, int index, int sum, int target)
	{
		if (index == nums.length)
			return sum == target;

		sum += nums[index];
		if (sum == target)
			return true;
		else if (sum < target)
		{
			if (createSets(nums, index + 1, sum, target))
				return true;
			else
			{
				sum -= nums[index];
				if (createSets(nums, index + 1, sum, target))
					return true;
			}
		}
		else
		{
			sum -= nums[index];
			if (createSets(nums, index + 1, sum, target))
				return true;
		}
		return false;
	}
}
