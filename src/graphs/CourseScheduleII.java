package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CourseScheduleII
{
	static void main()
	{
		int[][] prerequisites = new int[][]{
			{0,1},
			{3,1},
			{1,3},
			{3,2}
		};
		System.out.println(Arrays.toString(findOrder(4, prerequisites)));
	}

	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		LinkedHashSet<Integer> result = new LinkedHashSet<>();
		Map<Integer, List<Integer>> map = new HashMap<>();

		for (int i = 0; i < numCourses; i++)
		{
			map.put(i, new ArrayList<>());
		}

		for (int[] preReq : prerequisites)
		{
			map.get(preReq[0]).add(preReq[1]);
		}

		for (int course = 0; course < numCourses; course++)
		{
			if (!populateResult(map, result, course, new HashSet<>()))
				return new int[0];
		}
		int[] f = new int[numCourses];
		int index = 0;
		while(!result.isEmpty())
		{
			f[index] = result.removeFirst();
			index++;
		}
		return f;
	}

	private static boolean populateResult(Map<Integer, List<Integer>> map, LinkedHashSet<Integer> result, int course, Set<Integer> visited)
	{
		if (visited.contains(course) && !result.contains(course))
			return false;
		else if (result.contains(course))
			return true;
		else if (map.get(course).isEmpty())
		{
			result.add(course);
			return true;
		}
		else
		{
			visited.add(course);
			for (Integer preReq : map.get(course))
			{
				if (!populateResult(map, result, preReq, visited))
					return false;
			}
			result.add(course);
			return true;
		}
	}
}
