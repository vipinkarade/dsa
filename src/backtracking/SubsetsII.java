package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII
{
	static void main()
	{

	}

	private static List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		int size = 1 << nums.length;
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> sub;
		boolean duplicateFound = false;
		for (int i = 0; i < size; i++)
		{
			sub = new ArrayList<Integer>();
			for (int j = 0; j < nums.length; j++)
			{
				if ((i & 1 << j) > 0)
					sub.add(nums[j]);
				else if (j < nums.length - 1 && nums[j] == nums[j + 1] && (i & 1 << j+1) > 0)
				{
					duplicateFound = true;
					break;
				}
			}

			if (duplicateFound)
				duplicateFound = false;
			else
				result.add(sub);
		}
		return result;
	}
}
