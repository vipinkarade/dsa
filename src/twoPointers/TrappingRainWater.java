package twoPointers;

public class TrappingRainWater
{
	static void main()
	{
		int[] height = {0,2,0,3,1,0,1,3,2,1};
		System.out.println(trap1(height));
	}

	private static int trap(int[] height) {
		int l = 0;
		int r = height.length - 1;
		int startDip = -1;
		int lastDip = -1;
		int sum = 0;
		if (r == 0)
			return sum;

		while (startDip == -1 || lastDip == -1)
		{
			if (l > r || r == 0)
				break;
			if (height[l] > height[l + 1])
				startDip = l;
			else if (startDip == -1)
				l++;

			if (height[r] > height[r - 1])
				lastDip = r;
			else if (lastDip == -1)
				r--;
		}

		int curr = startDip;
		for (int i = startDip + 1; i <= lastDip; i++)
		{
			if (height[curr] < height[i] || i == lastDip)
			{
				sum = sum + waterBetweenTwoHeights(height, curr, i);
				curr = i;
			}
		}
		return sum;

	}

	private static int waterBetweenTwoHeights(int[] height, int start, int end)
	{
		boolean isStartBigger = height[start] > height[end];

		while(true)
		{
			if (start + 1 > end)
				break;

			if (isStartBigger)
			{
				if (height[start + 1] > height[end])
					start++;
				else
					break;
			}
			else
			{
				if (height[end - 1] > height[start])
					end--;
				else
					break;
			}
		}
		int sum = isStartBigger ? height[end] * (end -start-1) : height[start] * (end -start-1);

		for (int i = start + 1; i < end; i++)
		{
			sum = sum - height[i];
		}
		return sum;
	}

	private static int trap1(int[] height)
	{
		int l = 0;
		int r = height.length - 1;
		int lHigh = height[l];
		int rHigh = height[r];

		int sum = 0;

		while(l < r)
		{
			if (lHigh < rHigh)
			{
				l++;
				int diff = lHigh - height[l];
				if (diff > 0)
					sum = sum + diff;
				else
					lHigh = lHigh - diff;
			}
			else
			{
				r--;
				int diff = rHigh - height[r];
				if (diff > 0)
					sum = sum + diff;
				else
					rHigh = rHigh - diff;
			}
		}
		return sum;
	}

}
