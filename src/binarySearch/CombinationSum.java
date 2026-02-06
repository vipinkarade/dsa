package binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum
{
	static void main()
	{

	}

	private static List<List<Integer>> combinationSum(int[] nums, int target)
	{
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);

		populateResult(nums, 0, target, result, new ArrayList<>());
		return result;
	}

	private static void populateResult(int[] nums, int index, int target, List<List<Integer>> result, List<Integer> subResult)
	{
		if (target == 0)
			result.add(new ArrayList(subResult));
		else if (index == nums.length || target < 0)
			return;
		else
		{
			for (int i = 0; i <= target/nums[index]; i++)
			{
				if (i > 0)
					subResult.add(nums[index]);
				populateResult(nums, index + 1, target - nums[index] * i, result, new ArrayList<>(subResult));
			}
		}
	}
}
