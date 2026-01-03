package arrayAndHashing;

import java.util.HashMap;
import java.util.Map;

public class TwoSums
{
	static void main()
	{
		int[] nums = {1,2,4};
		int target = 5;
		int[] twoSums = twoSum1(nums, target);
		System.out.println(twoSums[0] + " " + twoSums[1]);
	}

	private static int[] twoSum(int[] nums, int target)
	{
		Map<Integer, Integer> numToIndex = new HashMap<>();
		for (int i = 0; i< nums.length; i++)
		{
			if (numToIndex.get(nums[i]) == null)
				numToIndex.put(nums[i], i);
		}

		for (int i = 0; i < nums.length; i++)
		{
			int currentNum = nums[i];
			int toFind = target - currentNum;
			if (numToIndex.get(toFind) == null)
				continue;
			else if (numToIndex.get(toFind).equals(i))
				continue;
			else
			{
				int[] result = new int[2];
				result[0] = i < numToIndex.get(toFind) ? i : numToIndex.get(toFind);
				result[1] = i > numToIndex.get(toFind) ? i : numToIndex.get(toFind);
				return result;
			}
		}
		return null;
	}

	private static int[] twoSum1(int[] nums, int target)
	{
		Map<Integer, Integer> numsToIndex = new HashMap<>();

		for (int i = 0; i < nums.length; i++)
		{
			int toFind = target - nums[i];
			if (numsToIndex.get(toFind) != null)
			{
				return new int[]{numsToIndex.get(toFind), i};
			}
			else
			{
				numsToIndex.put(nums[i], i);
			}
		}
		return null;
	}
}
