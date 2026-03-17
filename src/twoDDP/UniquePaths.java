package twoDDP;

import java.util.HashMap;
import java.util.Map;

public class UniquePaths
{
	static void main()
	{

	}

	private static int uniquePaths(int m, int n)
	{
		return paths(new HashMap<>(), m, n, 0, 0);
	}

	private static int paths(Map<String, Integer> map, int m, int n, int i, int j)
	{
		if (i == m - 1 || j == n - 1)
			return 1;

		String key = i + "_" + j;
		if (!map.containsKey(key))
		{
			map.put(key, paths(map, m, n, i + 1, j) + paths(map, m, n, i, j + 1));
		}
		return map.get(key);
	}
}
