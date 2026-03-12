package oneDDP;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak
{
	static void main()
	{

	}

	private static boolean wordBreak(String s, List<String> wordDict)
	{
		Map<Integer, Boolean> map = new HashMap<>();
		return matchChars(s, wordDict, 0, map);
	}

	private static boolean matchChars(String s, List<String> wordDict, int index, Map<Integer, Boolean> map)
	{
		if (map.get(index) != null)
			return map.get(index);

		if (index == s.length())
			return true;

		for (String word : wordDict)
		{
			if (s.length() - index >= word.length() && s.substring(index, index + word.length()).equals(word))
			{
				if (matchChars(s, wordDict, index + word.length(), map))
					return true;
				map.put(index + word.length(), false);
			}
		}
		map.put(index, false);
		return false;
	}
}
