package binarySearch;

public class BinarySearch
{
	static void main()
	{
		int[] nums = {-1,0,2,4,6,8};
		int target = 4;
		System.out.println(search(nums, target));

	}

	private static int search(int[] nums, int target)
	{
		int start = 0;
		int end = nums.length - 1;

		while (start <= end)
		{
			int mid = start + ((end - start) / 2);
			if (nums[mid] == target)
				return mid;
			else if (nums[mid] > target)
				end = mid - 1;
			else
				start = mid + 1;
		}

		return -1;
	}
}
