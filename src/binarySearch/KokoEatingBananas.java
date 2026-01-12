package binarySearch;

import java.util.Arrays;

public class KokoEatingBananas
{
	static void main()
	{
//		int[] piles = {25,10,23,4};
//		int h = 4;
		int[] piles = {30,11,23,4,20};
		int h = 6;
//		int[] piles = {3,6,7,11};
//		int h = 8;
		System.out.println(minEatingSpeed(piles, h));
	}

	private static int minEatingSpeed(int[] piles, int h)
	{
		int l = 1, r = Arrays.stream(piles).max().getAsInt();
		int result = 0;
		while (l <= r)
		{
			int mid = l + (r - l) / 2;

			int time = 0;
			for (int pile : piles)
			{
				int pileTime = pile % mid == 0 ? pile / mid : pile / mid + 1;
				time = time + pileTime;
			}

			if (time <= h)
			{
				result = mid;
				r = mid - 1;
			}
			else
			{
				l = mid + 1;
			}
		}
		return result;
	}
}
