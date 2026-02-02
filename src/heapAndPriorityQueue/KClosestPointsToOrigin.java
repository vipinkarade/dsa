package heapAndPriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.function.Function;

public class KClosestPointsToOrigin
{
	static void main()
	{
		int[][] points = new int[][]{{1,2},{2,2}};
	}

	private int[][] kClosest(int[][] points, int k)
	{
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing((a) -> -a[0]*a[0] - a[1]*a[1]));
		for (int[] point : points)
		{
			pq.add(point);
			if (pq.size() > k)
				pq.poll();
		}

		int[][] result = new int[pq.size()][2];
		int count = 0;
		while (!pq.isEmpty())
		{
			result[count] = pq.poll();
			count++;
		}
		return result;
	}

	class Point implements Comparable
	{
		int x;
		int y;
		public Point(int x, int y)
		{
			this.x = x;
			this.y = y;
		}

		public int getDistance()
		{
			return x * x + y * y;
		}

		@Override
		public int compareTo(Object o)
		{
			return Integer.compare(((Point) o).getDistance(), getDistance());
		}
	}
}
