package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class WordLadder
{
	static void main()
	{

	}

	private static int ladderLength(String beginWord, String endWord, List<String> wordList)
	{
		if (!wordList.contains(endWord))
			return 0;
		List<String> beginWordNeighbors = new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();
		for (int i = 0; i < wordList.size(); i++)
		{
			String word = wordList.get(i);
			if (beginWord.equals(word))
				continue;

			if (canWordsSwitch(beginWord, word))
				beginWordNeighbors.add(word);

			for (int j = i + 1 ; j < wordList.size(); j++)
			{
				if (beginWord.equals(wordList.get(j)))
					continue;
				if (canWordsSwitch(wordList.get(j), word))
				{
					map.computeIfAbsent(wordList.get(j), key -> new ArrayList<>()).add(word);
					map.computeIfAbsent(word, key -> new ArrayList<>()).add(wordList.get(j));
				}
			}
		}
		int result = Integer.MAX_VALUE;
		HashSet<String> visited = new HashSet<>();
		for (String neighbor : beginWordNeighbors)
		{
			if (neighbor.equals(endWord))
				return 2;
			int len = findLength(map, endWord, neighbor, new HashSet<>());
			if (len != Integer.MAX_VALUE)
				result = Math.min(result, len);
		}

		if (result == Integer.MAX_VALUE)
			return 0;

		return 1 + result;
	}

	private static int findLength(Map<String, List<String>> map, String endWord, String currWord, HashSet<String> visited)
	{
		visited.add(currWord);
		if (visited.size() > map.size())
			return Integer.MAX_VALUE;
		int result = Integer.MAX_VALUE;
		for (String word : map.get(currWord))
		{
			if (visited.contains(word))
				continue;
			if (endWord.equals(word))
				result = 1;
			int len = findLength(map, endWord, word, visited);
			if (len != Integer.MAX_VALUE)
				result = Math.min(result, len);
		}
		visited.remove(currWord);
		if (result != Integer.MAX_VALUE)
			result++;
		return result;
	}

	private static boolean canWordsSwitch(String first, String second)
	{
		boolean canWordsSwitch = false;
		for (int i = 0; i < first.length(); i++)
		{
			if (first.charAt(i) != second.charAt(i))
			{
				if (canWordsSwitch)
					return false;
				canWordsSwitch = true;
			}
		}
		return canWordsSwitch;
	}
}
