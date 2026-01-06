package arrayAndHashing;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence
{
	static void main()
	{
		int[] nums = {2,20,4,10,3,4,5};
//		int[] nums = {0,3,2,5,4,6,1,1};
		System.out.println(longestConsecutive(nums));
	}

	private static int longestConsecutive(int[] nums)
	{
		int longestSeq = 0;
		int smallest = Integer.MAX_VALUE;
		int highest = Integer.MIN_VALUE;
		Set<Integer> elements = new HashSet<>();
		for (int key : nums)
		{
			elements.add(key);

			if (key > highest)
				highest = key;

			if (key < smallest)
				smallest = key;
		}

		int currentSeqLength = 0;
		for (int i = smallest; i <= highest; i++)
		{
			if (elements.contains(i))
			{
				currentSeqLength++;
				if (currentSeqLength > longestSeq)
					longestSeq = currentSeqLength;
			}
			else
				currentSeqLength = 0;
		}

		return longestSeq;
	}
}
