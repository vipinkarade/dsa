package twoPointers;

public class MaxWaterContainer
{
	static void main()
	{
//		int[] heights = {1,7,2,5,4,7,3,6};
		int[] heights = {2,2,2};
		System.out.println(maxArea(heights));
	}

	private static int maxArea(int[] heights)
	{
		int l = 0;
		int r = heights.length - 1;
		int largestVolume = -1;

		while (l < r)
		{
			int shortestHeight = heights[l] > heights[r] ? heights[r] : heights[l];
			int volume = shortestHeight * (r - l);
			if (volume > largestVolume)
				largestVolume = volume;

			if (heights[l] < heights[r])
				l++;
			else
				r--;
		}
		return largestVolume;
	}
}
