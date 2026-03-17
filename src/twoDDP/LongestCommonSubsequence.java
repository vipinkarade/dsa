package twoDDP;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubsequence
{
	static void main()
	{

	}

	private static int longestCommonSubsequence(String text1, String text2)
	{
		return getLongestLength(text1, text2, 0, 0, new HashMap<>());
	}

	private static int getLongestLength(String text1, String text2, int index1, int index2, Map<String, Integer> map)
	{
		String key = index1 + "_" + index2;
		if (map.containsKey(key))
			return map.get(key);

		if (index1 == text1.length() || index2 == text2.length())
			return 0;
		else if (text1.charAt(index1) == text2.charAt(index2))
			map.put(key, 1 + getLongestLength(text1, text2, index1 + 1, index2 + 1, map));
		else
		{
			map.put(key, Math.max(getLongestLength(text1, text2, index1, index2 + 1, map), getLongestLength(text1, text2, index1 + 1, index2, map)));
		}
		return map.get(key);
	}
}
