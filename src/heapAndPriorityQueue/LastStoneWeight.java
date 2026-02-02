package heapAndPriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight
{
	static void main()
	{
		int[] stones = new int[]{2,3,6,2,4};
		System.out.println(lastStoneWeight(stones));
	}

	private static int lastStoneWeight(int[] stones)
	{
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		for (int stone : stones)
			pq.add(stone);

		while (pq.size() > 1)
		{
			int result = Math.abs(pq.poll() - pq.poll());
			if (result > 0)
				pq.add(result);
		}
		return pq.isEmpty() ? 0 : pq.poll();
	}
}
