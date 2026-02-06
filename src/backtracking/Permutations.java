package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations
{
	static void main()
	{
		int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
		long t1 = System.currentTimeMillis();
		permute1(nums);
		long t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);
	}

	private static List<List<Integer>> permute(int[] nums)
	{
		List<List<Integer>> result = new ArrayList<>();
		Set<Integer> allNums = new HashSet<>();
		for (int i = 0; i < nums.length; i++)
		{
			allNums.add(nums[i]);
		}

		populateResult(allNums, result, new ArrayList<Integer>());
		return result;
	}

	private static void populateResult(Set<Integer> nums, List<List<Integer>> result, List<Integer> subResult)
	{
		if (nums.size() == 0)
			result.add(new ArrayList<>(subResult));
		else
		{
			for(int num : nums)
			{
				subResult.add(num);
				Set<Integer> set = new HashSet<>(nums);
				set.remove(num);
				populateResult(set, result, subResult);
				subResult.remove((Object) num);
			}
		}
	}

	private static List<List<Integer>> permute1(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		populateResult(nums, result, new ArrayList<Integer>(), 0, 0);
		return result;
	}

	private static void populateResult(int[] nums, List<List<Integer>> result, List<Integer> subResult, int bit, int index)
	{
		if (subResult.size() == nums.length)
			result.add(new ArrayList<>(subResult));
		else if (index < nums.length)
		{
			for(int i = 0; i < nums.length; i++)
			{
				if ((bit & (1 << i)) == 0)
				{
					subResult.add(nums[i]);
					populateResult(nums, result, subResult, bit | (1 << i), index + 1);
					subResult.remove(subResult.size() - 1);
				}
			}
		}
	}
}
