package binarySearch;

public class SearchRotatedSortedArray
{
	static void main()
	{
		int[] nums = {3,4,5,6,1,2};
		int target = 1;
		System.out.println(search(nums, target));
	}

	private static int search(int[] nums, int target)
	{
		int l = 0, r = nums.length - 1;

		while (l <= r)
		{
			int mid = (r + l) / 2;
			if (nums[mid] == target)
				return mid;

			if (nums[l] > nums[r])
			{
				if ((nums[l] > nums[mid] && (target >= nums[l] || target < nums[mid])) || (nums[l] < nums[mid] && target < nums[mid] && target >= nums[l]))
					r = mid - 1;
				else
					l = mid + 1;
			}
			else
			{
				if (nums[mid] > target)
					r = mid - 1;
				else
					l = mid + 1;
			}
		}

		return -1;
	}
}
