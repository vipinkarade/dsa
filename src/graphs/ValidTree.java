package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class ValidTree
{
	static void main()
	{

	}

	private static boolean validTree(int n, int[][] edges) {
		if (edges.length == 0)
			return n == 1;
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int[] edge : edges)
		{
			if (edge[0] == edge[1])
				return false;
			map.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
			map.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
		}
		HashSet<Integer> visited = new HashSet<Integer>();
		return isValidTree(map, visited, edges[0][0], edges[0][0]) && visited.size() == map.size();
	}

	private static boolean isValidTree(Map<Integer, List<Integer>> map, HashSet<Integer> visited, int element, int parent)
	{
		visited.add(element);

		for (int neighbor : map.get(element))
		{
			if (neighbor != parent)
			{
				if (visited.contains(neighbor) || !isValidTree(map, visited, neighbor, element))
					return false;
			}
		}

		return true;
	}
}
