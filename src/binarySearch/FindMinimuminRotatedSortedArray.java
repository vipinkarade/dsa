package binarySearch;

public class FindMinimuminRotatedSortedArray
{
	static void main()
	{
//		int[] nums = {2,4,5,6,1,2};
		int[] nums = {2,2};
		System.out.println(findMin(nums));
	}

	private static int findMin(int[] nums)
	{
		int l = 0;
		int r = nums.length - 1;

		while (l <= r)
		{
			if (nums[l] < nums[r])
				return nums[l];
			else if (r == l + 1)
				return nums[r];
			else
			{
				int mid = (r + l) / 2;
				if (nums[mid] <= nums[r])
					r = mid;
				else
					l = mid + 1;
			}
		}
		return -1;
	}
}
