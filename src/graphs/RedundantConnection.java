package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class RedundantConnection
{
	static void main()
	{
		int[][] edges = new int[][]{
			{1,2},
			{1,3},
			{3,4},
			{2,4},
		};
		System.out.println(Arrays.toString(findRedundantConnection(edges)));
	}

	private static int[] findRedundantConnection(int[][] edges)
	{
		Map<Integer, List<Integer>> map = new HashMap<>();
		HashSet<Integer> elementsInCycle = new HashSet<>();
		for (int[] edge : edges)
		{
			map.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
			map.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
		}

		isElementInCycle(map, elementsInCycle, edges[0][0], edges[0][0]);


		int[] result = new int[2];
		for (int i = edges.length - 1; i >=0; i--)
		{
			if (elementsInCycle.contains(edges[i][0]) && elementsInCycle.contains(edges[i][1]))
				return edges[i];
		}
		return result;
	}

	private static boolean isElementInCycle(Map<Integer, List<Integer>> map, HashSet<Integer> visited, int element, int parent)
	{
		visited.add(element);
		for (int neighbor : map.get(element))
		{
			if (neighbor != parent)
			{
				if (visited.contains(neighbor))
					return true;
				if (isElementInCycle(map, visited, neighbor, element))
					return true;
			}
		}
		visited.remove(element);
		return false;
	}
}
