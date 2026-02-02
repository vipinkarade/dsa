package heapAndPriorityQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KthLargest
{
	private PriorityQueue<Integer> pq = new PriorityQueue<>();
	private int k;
	public KthLargest(int k, int[] nums) {
		this.k = k;
		for (int num : nums)
		{
			add(num);
		}
	}

	public int add(int val)
	{
		pq.add(val);
		if (pq.size() > k)
			pq.poll();
		return pq.peek();
	}

	static void main()
	{
		KthLargest a = new KthLargest(3, new int[]{1000, -1000});
		System.out.println(a.add(0));
	}
}
