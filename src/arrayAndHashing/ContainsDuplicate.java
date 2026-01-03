package arrayAndHashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicate
{
	public static void main(String[] args)
	{
		int[] nums = {1, 2, 3, 4};
		boolean hasDuplicate = hasDuplicate2(nums);
		System.out.println(hasDuplicate);
	}

	private static boolean hasDuplicate(int[] nums)
	{
		Map<Integer, Integer> numCountMap = new HashMap<>();
		for (int i : nums)
		{
			numCountMap.put(i, numCountMap.get(i) == null ? 1 : numCountMap.get(i) + 1);
		}

		for (int key : numCountMap.keySet())
		{
			if (numCountMap.get(key) > 1)
				return true;
		}
		return false;
	}

	private static boolean hasDuplicate1(int[] nums)
	{
		Set<Integer> numsSet = new HashSet();
		for (int key : nums)
		{
			if (numsSet.contains(key))
				return true;
			numsSet.add(key);
		}
		return false;
	}

	private static boolean hasDuplicate2(int[] nums)
	{
		return Arrays.stream(nums).distinct().count() != nums.length;
	}
}
