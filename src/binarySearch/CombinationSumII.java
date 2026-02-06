package binarySearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSumII
{
	static void main()
	{
		int[] nums = new int[]{2, 4, 7, 9, 10, 12, 13, 15, 16};
		int target = 87;
		System.out.println(combinationSum2(nums, target));
	}

	private static List<List<Integer>> combinationSum2(int[] candidates, int target)
	{
		Set<List<Integer>> result = new HashSet<>();
		populateResult(candidates, target, 0, result, new ArrayList<Integer>());
		return new ArrayList<>(result);
	}

	private static void populateResult(int[] nums, int target, int index, Set<List<Integer>> result, List<Integer> subResult)
	{
		if (target == 0)
			result.add(new ArrayList<>(subResult.stream().sorted().toList()));
		else if (index >= nums.length || target < 0)
			return;
		else
		{
			subResult.add(nums[index]);
			populateResult(nums, target - nums[index], index + 1, result, subResult);
			subResult.remove(subResult.size() - 1);
			populateResult(nums, target, index + 1, result, subResult);
		}
	}
}
