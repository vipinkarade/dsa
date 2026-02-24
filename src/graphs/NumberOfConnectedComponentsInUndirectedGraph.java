package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class NumberOfConnectedComponentsInUndirectedGraph
{
	static void main()
	{

	}

	private static int countComponents(int n, int[][] edges) {
		if (edges.length == 0)
			return 0;
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int[] edge : edges)
		{
			map.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
			map.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
		}

		int element = edges[0][0];
		HashSet<Integer> visited = new HashSet<>();
		int result = 0;
		for (int[] edge : edges)
		{
			if (!visited.contains(edge[0]))
			{
				result++;
				iterate(map, visited, edge[0]);
			}
		}
		return result + n - visited.size();
	}

	private static void iterate(Map<Integer, List<Integer>> map, HashSet<Integer> visited, int element)
	{
		visited.add(element);
		for(int neighbor : map.get(element))
		{
			if (!visited.contains(neighbor))
				iterate(map, visited, neighbor);
		}
	}
}
