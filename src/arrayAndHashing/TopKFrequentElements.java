package arrayAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TopKFrequentElements
{
	static void main()
	{
		int[] nums = { 7, 7 };
		int k = 1;
		System.out.println(Arrays.toString(topKFrequent1(nums, k)));
	}

	private static int[] topKFrequent(int[] nums, int k)
	{
		Map<Integer, Integer> counts = new HashMap<>();
		for (int i = 0; i < nums.length; i++)
		{
			counts.put(nums[i], counts.getOrDefault(nums[i], 0) + 1);
		}
		return getInts(k, counts);
	}

	private static int[] getInts(int k, Map<Integer, Integer> counts)
	{
		if (counts.keySet().size() == k)
			return getCountsAsResult(counts);
		else
		{
			removeLowestCountElements(counts);
			return getInts(k, counts);
		}
	}

	private static void removeLowestCountElements(Map<Integer, Integer> counts)
	{
		int lowestCount = Integer.MAX_VALUE;
		Set<Integer> integers = new HashSet<>(counts.keySet());
		for (int key : integers)
		{
			if (counts.get(key) < lowestCount)
				lowestCount = counts.get(key).intValue();
		}

		for (int key : integers)
		{
			if (counts.get(key).intValue() == lowestCount)
				counts.remove(key);
		}
	}

	private static int[] getCountsAsResult(Map<Integer, Integer> counts)
	{
		int size = counts.size();
		int[] result = new int[size];
		int i = 0;
		for (int key : counts.keySet())
		{
			result[i] = key;
			i++;
		}
		return result;
	}

	/*
	* The most optimal solution
	* */

	private static int[] topKFrequent1(int[] nums, int k)
	{
		Map<Integer, Integer> elementToCountMap = new HashMap<>();
		for (int num : nums)
		{
			elementToCountMap.put(num, elementToCountMap.getOrDefault(num, 0) + 1);
		}

		ArrayList<Integer>[] frequencies = new ArrayList[nums.length];

		for (int key : elementToCountMap.keySet())
		{
			int count = elementToCountMap.get(key) - 1;
			if (frequencies[count] == null)
				frequencies[count] = new ArrayList<>();
			frequencies[count].add(key);
		}

		int[] result = new int[k];
		int index = 0;
		for (int i = frequencies.length - 1; i >=0; i--)
		{
			ArrayList<Integer> elements = frequencies[i];
			if (elements == null || elements.isEmpty())
				continue;
			for (int element : elements)
			{
				result[index++] = element;
				if (index == k)
					return result;
			}
		}
		return result;
	}
}
