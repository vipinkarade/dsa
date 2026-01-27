package linkedList;

public class FindDuplicateInteger
{
	static void main()
	{
		int[] nums = {1,2,3,2,2};
//		int[] nums = {3,3,3,3,3};
		System.out.println(findDuplicate2(nums));
	}

	private static int findDuplicate(int[] nums)
	{
		for (int i = 0; i < nums.length; i++)
		{
			int currElement = nums[i];
			int currIndex = i + 1;
			int currAbs = nums[i] > 0 ? nums[i] : nums[i] * (-1);
			if (currIndex == currElement)
				nums[i] *= -1;
			else if (nums[currAbs - 1] < 0)
			{
				return currAbs;
			}
			else
			{
				nums[currAbs - 1] *= -1;
			}
		}
		return -1;
	}

	private static int findDuplicate2(int[] nums)
	{
		int slow = 0, fast = 0;

		while (true)
		{
			slow = nums[slow];
			fast = nums[nums[fast]];

			if (slow == fast)
				break;
		}

		int slow2 = 0;
		while (true)
		{
			slow = nums[slow];
			slow2 = nums[slow2];

			if (slow == slow2)
				break;
		}
		return slow;
	}
}
