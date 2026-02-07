package tries;

import java.util.HashMap;
import java.util.Map;

public class PrefixTree
{
	Map<Character, PrefixTree> map;
	boolean isEndOfWord = false;

	public PrefixTree() {
		map = new HashMap<>();
	}

	public void insert(String word) {
		if (word.equals("#"))
			isEndOfWord = true;
		else if (word.length() == 1)
			map.computeIfAbsent(word.charAt(0), key -> new PrefixTree()).insert("#");
		else
			map.computeIfAbsent(word.charAt(0), key -> new PrefixTree()).insert(word.substring(1));
	}

	public boolean search(String word) {
		if (word.equals("#"))
			return isEndOfWord;
		else if (word.length() == 1)
			return map.computeIfAbsent(word.charAt(0), key -> new PrefixTree()).search("#");
		else
			return map.computeIfAbsent(word.charAt(0), key -> new PrefixTree()).search(word.substring(1));
	}

	public boolean startsWith(String prefix) {
		if (prefix.length() == 1)
			return map.get(prefix.charAt(0)) != null;
		else
			return map.get(prefix.charAt(0)) != null && map.get(prefix.charAt(0)).startsWith(prefix.substring(1));
	}
}
