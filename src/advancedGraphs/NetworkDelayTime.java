package advancedGraphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class NetworkDelayTime
{
	static void main()
	{
		int[][] times = new int[][]{{1,2,1},{2,3,1},{1,4,4},{3,4,1}};
		int n = 4;
		int k = 1;
		System.out.println(networkDelayTime(times, n, k));
	}

	private static int networkDelayTime(int[][] times, int n, int k)
	{
		Map<Integer, List<int[]>> map = new HashMap<>();
		for(int[] time : times)
		{
			map.computeIfAbsent(time[0], key -> new ArrayList<>()).add(new int[]{time[1], time[2]});
		}

		Set<Integer> visited = new HashSet<>();
		PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt((int[] a) -> a[0]));
		visited.add(k);
		heap.add(new int[]{0, k});
		int[] result;
		int finalTime = -1;
		while(!heap.isEmpty())
		{
			int[] curr = heap.poll();
			if (heap.isEmpty())
			{
				for (int[] time : map.get(curr[1]))
				{
					heap.add(new int[]{curr[0] + time[1], time[0]});
					visited.add(time[0]);
				}
			}
			else if (map.get(curr[1]) == null)
				finalTime = Math.max(finalTime, curr[0]);
			else
			{
				for (int[] time : map.get(curr[1]))
				{
					if (heap.peek()[1] == time[0] && curr[0] + time[1] <= heap.peek()[0])
					{
						heap.poll();
						if (visited.size() == n)
							return Math.max(finalTime, curr[0] + time[1]);
					}
					heap.add(new int[]{curr[0] + time[1], time[0]});
					visited.add(time[0]);
				}
			}
		}
		return finalTime;
	}
}
