package twoPointers;

import java.util.Arrays;

public class TwoIntegerSumII
{
	static void main()
	{
		int[] numbers = {1,2,3,4};
		int target = 3;
		System.out.println(Arrays.toString(twoSum(numbers, target)));
	}

	private static int[] twoSum(int[] numbers, int target)
	{
		int l = 0;
		int r = numbers.length - 1;

		while (l < r)
		{
			int firstNum = numbers[l];
			int secondNum = numbers[r];

			if (firstNum + secondNum == target)
				return new int[]{l + 1, r + 1};

			if (target > firstNum + secondNum)
				l++;
			else
				r--;


		}

		return new int[]{-1, -1};
	}
}
