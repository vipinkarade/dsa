package backtracking;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Subsets
{
	static void main()
	{
		int[] nums = new int[]{1,2,3};
		System.out.println(subsets2(nums));
	}

	private static List<List<Integer>> subsets(int[] nums)
	{
		Map<Integer, Set<List<Integer>>> result = new HashMap<>();
		List<Integer> firstList = new ArrayList<>();
		for (int num : nums)
		{
			firstList.add(num);
		}
		result.put(nums.length, new HashSet<>());
		result.get(nums.length).add(firstList);
		for (int k = nums.length; k > 0; k--)
		{
			result.put(k - 1, new HashSet<>());
			for (List<Integer> next : result.get(k))
			{
				for (int i = 0; i < next.size(); i++)
				{
					List<Integer> sub = new ArrayList<>();
					for (int j = 0; j < next.size(); j++)
					{
						if (i != j)
							sub.add(next.get(j));
					}
					result.get(k-1).add(sub);
				}
			}
		}
		List<List<Integer>> finalResult = new ArrayList<>();
		for (int key : result.keySet())
		{
			finalResult.addAll(result.get(key));
		}
		return finalResult;
	}

	private static List<List<Integer>> subsets1(int[] nums)
	{
		List<List<Integer>> result = new ArrayList<>();
		populateResult(result, -1, false, new ArrayList<Integer>(), nums);
		return result;
	}

	private static void populateResult(List<List<Integer>> result, int index, boolean toAdd, List<Integer> subResult, int[] nums)
	{
		if (index == nums.length)
		{
			if (toAdd)
				result.add(new ArrayList<>(subResult));
		}
		else
		{
			if (toAdd)
				subResult.add(nums[index]);
			index++;
			populateResult(result, index, true, subResult, nums);
			if (toAdd)
				subResult.remove(subResult.size() - 1);
			populateResult(result, index, false, subResult, nums);
		}
	}

	private static List<List<Integer>> subsets2(int[] nums)
	{
		List<List<Integer>> result = new ArrayList<>();
		int sizeOfResult = (1 << nums.length);
		for (int i = 0; i < sizeOfResult; i++)
		{
			List<Integer> subResult = new ArrayList<>();
			for (int j = 0; j < nums.length; j++)
			{
				if ((i & (1 << j)) > 0)
					subResult.add(nums[j]);
			}
			result.add(subResult);
		}
		return result;
	}
}
