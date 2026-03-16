package oneDDP;

import java.util.*;

public class LongestIncreasingSubsequence
{
	static void main()
	{

	}

	private static int lengthOfLIS(int[] nums)
	{
		Map<String, Integer> map = new HashMap<>();
		int min = Integer.MAX_VALUE;
		int longest = 0;
		for (int i = 0; i < nums.length; i++)
		{
			int num = nums[i];
			if (min > num)
			{
				min = num;
				longest = Math.max(longest, 1 + getMax(nums, i + 1, num, map));
			}
		}
		return longest;
	}

	private static int getMax(int[] nums, int index,  int lastElement, Map<String, Integer> map)
	{
		String key = index + "_";
		if (map.containsKey(key))
			return map.get(key);

		if (index == nums.length)
			return 0;
		else if (index == nums.length - 1)
		{
			if (nums[index] > lastElement)
				return 1;
			else
				return 0;
		}
		else
		{
			if (nums[index] > lastElement)
			{
				map.put(key, Math.max(1 + getMax(nums, index + 1, nums[index], map), getMax(nums, index + 1, lastElement, map)));
				return map.get(key);
			}
			else
			{
				map.put(key, getMax(nums, index + 1, lastElement, map));
				return map.get(key);
			}
		}
	}
}
