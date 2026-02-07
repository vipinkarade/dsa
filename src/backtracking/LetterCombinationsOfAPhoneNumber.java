package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber
{
	static void main()
	{

	}

	private static List<String> letterCombinations(String digits)
	{
		Map<String, List<String>> map = new HashMap<>();
		map.put("2", List.of("a", "b", "c"));
		map.put("3", List.of("d", "e", "f"));
		map.put("4", List.of("g", "h", "i"));
		map.put("5", List.of("j", "k", "l"));
		map.put("6", List.of("m", "n", "o"));
		map.put("7", List.of("p", "q", "r", "s"));
		map.put("8", List.of("t", "u", "v"));
		map.put("9", List.of("w", "x", "y", "z"));
		return getResult(map, digits, 0);
	}

	private static List<String> getResult(Map<String, List<String>> map, String digits, int index)
	{
		if (index >= digits.length())
			return new ArrayList<>();
		else if (index == digits.length() - 1)
			return map.get(digits.substring(index, index + 1));
		else
		{
			List<String> result = new ArrayList<>();
			List<String> subResult = getResult(map, digits, index + 1);
			for (String in : map.get(digits.substring(index, index + 1)))
			{
				for (String sub : subResult)
				{
					result.add(in + sub);
				}
			}
			return result;
		}
	}
}
