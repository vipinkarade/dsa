package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CourseSchedule
{
	static void main()
	{
		int[][] prerequisites = new int[][]{
			{1,4},
			{2,4},
			{3,1},
			{3,2}
		};
		System.out.println(canFinish(5, prerequisites));
	}

	private static boolean canFinish(int numCourses, int[][] prerequisites)
	{
		if (prerequisites.length == 0)
			return true;

		Map<Integer, List<Integer>> map = new HashMap<>();

		for (int[] courses : prerequisites)
		{
			map.computeIfAbsent(courses[0], key -> new ArrayList<>()).add(courses[1]);
		}

		Set<Integer> completed = new HashSet<>();
		Set<Integer> cannotComplete = new HashSet<>();
		for (Integer course : map.keySet())
		{
			completedCourse(course, map, completed, course, cannotComplete);
			if (completed.size() >= numCourses)
				return true;
		}
		return completed.containsAll(map.keySet());
	}

	private static void completedCourse(int course, Map<Integer, List<Integer>> map, Set<Integer> completed, int parentCourse,
		Set<Integer> cannotComplete)
	{
		if (cannotComplete.contains(course))
			return;

		if (!completed.contains(course))
		{
			if (map.get(course) != null)
			{
				for (Integer preReq : map.get(course))
				{
					if (parentCourse == preReq)
					{
						cannotComplete.add(parentCourse);
						return;
					}
					completedCourse(preReq, map, completed, parentCourse, cannotComplete);
					if (!completed.contains(preReq))
					{
						cannotComplete.add(preReq);
						return;
					}
				}
			}
			completed.add(course);
		}
	}
}
