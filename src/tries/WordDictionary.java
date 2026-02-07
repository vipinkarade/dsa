package tries;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary
{
	Map<Character, WordDictionary> map;
	boolean isEndOfWord;
	public WordDictionary() {
		map = new HashMap<>();
		isEndOfWord = false;
	}

	public void addWord(String word) {
		if (word.equals("#"))
			isEndOfWord = true;
		else if (word.length() == 1)
			map.computeIfAbsent(word.charAt(0), key -> new WordDictionary()).addWord("#");
		else
		{
			map.computeIfAbsent(word.charAt(0), key -> new WordDictionary()).addWord(word.substring(1));
		}
	}

	public boolean search(String word) {

		if (word.equals("#"))
			return isEndOfWord;
		else if (word.length() == 1 && word.equals("."))
		{
			for (Character c : map.keySet())
			{
				if (map.get(c).search("#"))
					return true;
			}
			return false;
		}
		else if (word.length() == 1)
			return map.computeIfAbsent(word.charAt(0), key -> new WordDictionary()).search("#");
		else if (word.substring(0, 1).equals("."))
		{
			for (Character c : map.keySet())
			{
				if (map.get(c).search(word.substring(1)))
					return true;
			}
			return false;
		}
		else
		{
			return map.get(word.charAt(0)) != null && map.get(word.charAt(0)).search(word.substring(1));
		}
	}
}
