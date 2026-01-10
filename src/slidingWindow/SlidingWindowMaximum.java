package slidingWindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum
{
	static void main()
	{
		int[] nums = {1,2,1,0,4,2,6};
		int k = 3;
		System.out.println(Arrays.toString(maxSlidingWindow1(nums, k)));
	}

	private static int[] maxSlidingWindow(int[] nums, int k)
	{
		int maxInInterval = maxNumberInWindow(nums, 0, k -1);
		int[] result = new int[nums.length - k + 1];
		int index = 0;
		int l = 0;

		result[index] = maxInInterval;
		for (int r = k; r <nums.length; r++)
		{
			l++;
			index++;

			if (nums[r] >= maxInInterval)
			{
				maxInInterval = nums[r];
			}
			else if (nums[l - 1] == maxInInterval)
			{
				maxInInterval = maxNumberInWindow(nums, l , r);
			}
			result[index] = maxInInterval;
		}

		return result;
	}

	private static int maxNumberInWindow(int[] nums, int start, int end)
	{
		int max = nums[start];
		for (int i = start + 1; i <= end; i++)
		{
			max = Math.max(max, nums[i]);
		}
		return max;
	}

	private static int[] maxSlidingWindow1(int[] nums, int k)
	{
		Deque<Integer> stack = new ArrayDeque<>();
		int[] result = new int[nums.length - k + 1];

		int l = 0, index = 0;
		for (int r = 0; r < nums.length; r++)
		{
			while(stack.size() > 0 && nums[stack.getLast()] < nums[r])
				stack.removeLast();
			stack.addLast(r);

			if (r - l == k)
			{
				stack.remove(l);
				l++;
			}

			if (r - l + 1 == k)
				result[index++] = nums[stack.getFirst()];
		}
		return result;
	}
}
