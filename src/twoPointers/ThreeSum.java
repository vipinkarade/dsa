package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum
{
	static void main()
	{
		//		int[] nums = {-1,0,1,2,-1,-4};
		//		int[] nums = {0,1,1};
		int[] nums = { 0, 0, 0 };
		System.out.println(threeSum(nums));
	}

	private static List<List<Integer>> threeSum(int[] nums)
	{
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < nums.length - 2; i++)
		{
			int firstNum = nums[i];
			for (int j = i + 1; j < nums.length - 1; j++)
			{
				int secondNum = nums[j];
				int target = -firstNum - secondNum;
				int pointer = j + 1;
				while (pointer <= nums.length - 1)
				{
					if (nums[pointer++] == target)
					{
						List<Integer> subResult = new ArrayList<>();
						subResult.add(firstNum);
						subResult.add(secondNum);
						subResult.add(target);
						subResult = subResult.stream().sorted().toList();
						if (result.contains(subResult))
							break;
						result.add(subResult);
						break;
					}
				}
			}
		}
		return result;
	}

	private static List<List<Integer>> threeSum1(int[] nums)
	{
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++)
		{
			int firstNum = nums[i];
			int l = i + 1;
			int r = nums.length - 1;

			while (l < r)
			{
				int sum = firstNum + nums[l] + nums[r];
				if (sum == 0)
				{
					List<Integer> subList = new ArrayList<>();
					subList.add(firstNum);
					subList.add(nums[l]);
					subList.add(nums[r]);
					if (!result.contains(subList))
						result.add(subList);
				}

				if (sum > 0)
					r--;
				else
					l++;
			}
		}
		return result;
	}
}
